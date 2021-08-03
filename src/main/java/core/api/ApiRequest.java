/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.api;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Keeps all data that are required to construct the request.
 */
public class ApiRequest {
    private String baseUri;
    private String endpoint;
    private String body;
    private String token;
    private Enum<ApiMethod> method;
    private List<Header> headers;
    private Map<String, String> queryParams;
    private Map<String, String> pathParams;
    private Map<String, String> params;

    public ApiRequest() {
        headers = new ArrayList<>();
        queryParams = new HashMap<>();
        pathParams = new HashMap<>();
        params = new HashMap<>();
        body = "";
    }

    /**
     * Gets the base uri.
     *
     * @return a string with the base uri.
     */
    public String getBaseUri() {
        return baseUri;
    }

    /**
     * Sets the base uri.
     *
     * @param incomingBaseUri a string with the incoming base uri.
     */
    public void setBaseUri(final String incomingBaseUri) {
        this.baseUri = incomingBaseUri;
    }

    /**
     * Gets the endpoint.
     *
     * @return a string with the endpoint.
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Sets the endpoint.
     *
     * @param incomingEndpoint a string with the incoming endpoint.
     */
    public void setEndpoint(final String incomingEndpoint) {
        this.endpoint = incomingEndpoint;
    }

    /**
     * Gets the body.
     *
     * @return a string with the body.
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets te body.
     *
     * @param incomingBody a string with the incoming body.
     */
    public void setBody(final String incomingBody) {
        this.body = incomingBody;
    }

    /**
     * Gets the token.
     *
     * @return a string with the token.
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token.
     *
     * @param incomingToken a string with the incoming token.
     */
    public void setToken(final String incomingToken) {
        this.token = incomingToken;
    }

    /**
     * Gets the method.
     *
     * @return an Enum<ApiMethod> with the method.
     */
    public Enum<ApiMethod> getMethod() {
        return method;
    }

    /**
     * Sets the method.
     *
     * @param incomingMethod an Enum<ApiMethod> with the incoming method.
     */
    public void setMethod(final Enum<ApiMethod> incomingMethod) {
        this.method = incomingMethod;
    }

    /**
     * Adds the header.
     *
     * @param header a string with the header.
     * @param value  a string with the value.
     */
    public void addHeader(final String header, final String value) {
        headers.add(new Header(header, value));
    }

    /**
     * Adds a query param.
     *
     * @param param a string with the param.
     * @param value a string with the value.
     */
    public void addQueryParam(final String param, final String value) {
        queryParams.put(param, value);
    }

    /**
     * Adds query params.
     *
     * @param newQueryParams a Map<String, String> with the QueryParams.
     */
    public void addQueryParam(final Map<String, String> newQueryParams) {
        queryParams.putAll(newQueryParams);
    }

    /**
     * Adds a path param.
     *
     * @param param a strong with the param.
     * @param value a string with the value.
     */
    public void addPathParam(final String param, final String value) {
        pathParams.put(param, value);
    }

    /**
     * Adds path params.
     *
     * @param incomingPathParams a Map<String, String> with the incoming path params.
     */
    public void addPathParam(final Map<String, String> incomingPathParams) {
        this.pathParams.putAll(incomingPathParams);
    }

    /**
     * Adds a param.
     *
     * @param param a string with the param.
     * @param value a string with the value.
     */
    public void addParam(final String param, final String value) {
        params.put(param, value);
    }

    /**
     * Adds params.
     *
     * @param incomingPathParams a Map<String, String> with the incoming path params.
     */
    public void addParam(final Map<String, String> incomingPathParams) {
        this.params.putAll(incomingPathParams);
    }

    /**
     * Gets the headers.
     *
     * @return a Headers.
     */
    public Headers getHeaders() {
        return new Headers(headers);
    }

    /**
     * Gets query params.
     *
     * @return a Map<String, String> with query params.
     */
    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    /**
     * Gets path params.
     *
     * @return a Map<String, String> with path params.
     */
    public Map<String, String> getPathParams() {
        return pathParams;
    }
}
