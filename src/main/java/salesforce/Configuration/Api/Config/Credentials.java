/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.Configuration.Api.Config;

import core.utils.EncryptorAES;

/**
 * Gives requested key.
 */
public enum Credentials {

    USER("USER", "username"),
    PASSWORD("PASSWORD", "password"),
    SALESFORCE_CLIENT_ID("SALESFORCE_CLIENT_ID", "client_id"),
    SALESFORCE_CLIENT_SECRET("SALESFORCE_CLIENT_SECRET", "client_secret"),
    GRANT_TYPE("password", "grant_type"),
    TOKEN_URL("TOKEN_URL", "TOKEN_URL"),
    BASE_URL("BASE_URL", "BASE_URL");

    private String localName;
    private String localValue;

    Credentials(final String name, final String value) {
        this.localName = name;
        this.localValue = value;
    }

    public String getEnumName() {
        return localName;
    }

    public String getEnumValue() {
        return localValue;
    }

}
