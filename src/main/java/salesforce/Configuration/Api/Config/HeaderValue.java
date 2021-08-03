/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.Configuration.Api.Config;

/**
 * Gives request format.
 */
public enum HeaderValue {
    APP_JSON("application/json"),
    APP_X_FORM("application/x-www-form-urlencoded");
    private String localValue;

    HeaderValue(final String value) {
        this.localValue = value;
    }

    public String get() {
        return localValue;
    }
}
