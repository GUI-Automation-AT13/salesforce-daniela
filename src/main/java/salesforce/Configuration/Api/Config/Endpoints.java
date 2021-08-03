/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */

package salesforce.Configuration.Api.Config;

import static salesforce.Configuration.ConfigurationFile.getEnvVariables;

/**
 * Gives requested endpoint.
 */
public enum Endpoints {

    ID("id"),
    LEGAL_ENTITIES("/LegalEntity"),
    LEGAL_ENTITY(String.format("/LegalEntity/{%s%s", Endpoints.ID.get(), "}")),
    PERSONAL_URL(getEnvVariables("PERSONAL_URL")),
    BASE_URL(String.format("https://%s%s", Endpoints.PERSONAL_URL.get(), "/services/data/v52.0/sobjects")),
    TOKEN_URL("https://login.salesforce.com/services/oauth2/token");

    private String localEndpoint;

    Endpoints(final String endpoint) {
        this.localEndpoint = endpoint;
    }

    public String get() {
        return localEndpoint;
    }
}
