/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.Configuration.Api.Auth;

import core.utils.EncryptorAES;
import org.apache.http.HttpHeaders;
import salesforce.Configuration.Api.Config.Credentials;
import salesforce.Configuration.Api.Config.Endpoints;
import salesforce.Configuration.Api.Config.HeaderValue;
import salesforce.entities.Token;
import static io.restassured.RestAssured.given;
import static salesforce.Configuration.ConfigurationFile.getEnvVariables;

/**
 * Makes the authentication to the webpage.
 */
public class Authentication {

    static EncryptorAES encryptorAES;
    private static String key = "error404";

    /**
     * Gets the authentication.
     *
     * @return the authentication.
     */
    public static Token getAuth() {
        return
                given().urlEncodingEnabled(true)
                        .param(Credentials.USER.getEnumValue(),
                                getDecryptedCredentials(getEnvVariables(Credentials.USER.getEnumName())))
                        .param(Credentials.PASSWORD.getEnumValue(),
                                getDecryptedCredentials(getEnvVariables(Credentials.PASSWORD.getEnumName())))
                        .param(Credentials.SALESFORCE_CLIENT_ID.getEnumValue(),
                                getEnvVariables(Credentials.SALESFORCE_CLIENT_ID.getEnumName()))
                        .param(Credentials.SALESFORCE_CLIENT_SECRET.getEnumValue(),
                                getEnvVariables(Credentials.SALESFORCE_CLIENT_SECRET.getEnumName()))
                        .param(Credentials.GRANT_TYPE.getEnumValue(),
                                Credentials.PASSWORD.getEnumValue())
                        .header(HttpHeaders.ACCEPT, HeaderValue.APP_JSON.get())
                        .header(HttpHeaders.CONTENT_TYPE, HeaderValue.APP_X_FORM.get())
                        .log().all()
                        .when()
                        .post(Endpoints.TOKEN_URL.get())
                        .as(Token.class);
    }

    /**
     * Gets the decrypted credentials.
     *
     * @param credential a string with the credential.
     * @return the decrypted credential.
     */
    private static String getDecryptedCredentials(final String credential) {
        encryptorAES = new EncryptorAES();
        return encryptorAES.getDecryptedValue(credential, key);
    }
}
