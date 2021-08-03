/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */

package salesforce.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Token {
//    @JsonProperty("access_token")
    public static String accessToken;
//    @JsonProperty("instance_url")
    private String instanceUrl;
//    @JsonProperty("issued_at")
    private String issuedAt;
//    @JsonProperty("token_type")
    private String tokenType;
//    @JsonProperty("id")
    private String id;
//    @JsonProperty("signature")
    private String signature;

    /**
     * Gets the access token.
     *
     * @return a string with the access token.
     */
    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Sets the access token.
     *
     * @param newAccessToken a string with the access token.
     */
    @JsonProperty("access_token")
    public void setAccessToken(final String newAccessToken) {
        this.accessToken = newAccessToken;
    }

    /**
     * Gets the instance url.
     *
     * @return a string with the instance url.
     */
    @JsonProperty("instance_url")
    public String getInstanceUrl() {
        return instanceUrl;
    }

    /**
     * Sets the instance url.
     *
     * @param newInstanceUrl a string with the url.
     */
    @JsonProperty("instance_url")
    public void setInstanceUrl(final String newInstanceUrl) {
        this.instanceUrl = newInstanceUrl;
    }

    /**
     * Gets the id.
     *
     * @return a string with the id.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param newId a string with the id.
     */
    public void setId(final String newId) {
        this.id = newId;
    }

    /**
     * Gets the token type.
     *
     * @return a string token type.
     */
    @JsonProperty("token_type")
    public String getTokenType() {
        return tokenType;
    }

    /**
     * Sets the token type.
     *
     * @param newTokenType a string with the token type.
     */
    @JsonProperty("token_type")
    public void setTokenType(final String newTokenType) {
        this.tokenType = newTokenType;
    }

    /**
     * Gets the issued at.
     *
     * @return a string with the issued at.
     */
    @JsonProperty("issued_at")
    public String getIssuedAt() {
        return issuedAt;
    }

    /**
     * Sets the issued at.
     *
     * @param newIssuedAt a string with the issued at.
     */
    @JsonProperty("issued_at")
    public void setIssuedAt(final String newIssuedAt) {
        this.issuedAt = newIssuedAt;
    }

    /**
     * Gets the signature.
     *
     * @return a string with the signature.
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Sets the signature.
     *
     * @param newSignature a string with the signature.
     */
    public void setSignature(final String newSignature) {
        this.signature = newSignature;
    }
}
