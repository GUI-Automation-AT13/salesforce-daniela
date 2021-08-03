/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.api;

import java.util.Map;

/**
 * Helps to build an ApiRequest entity.
 */
public class ApiRequestBuilder {
    private ApiRequest apiRequest = new ApiRequest();

    /**
     * Sets the base uri.
     *
     * @param baseUri a string with the base uri.
     * @return an ApiRequestBuilder.
     */
    public ApiRequestBuilder baseUri(final String baseUri) {
        apiRequest.setBaseUri(baseUri);
        return this;
    }

    /**
     * Sets the endpoint.
     *
     * @param endpoint a string with the endpoint.
     * @return an ApiRequestBuilder.
     */
    public ApiRequestBuilder endpoint(final String endpoint) {
        apiRequest.setEndpoint(endpoint);
        return this;
    }

    /**
     * Sets the body.
     *
     * @param body a string with the body.
     * @return an ApiRequestBuilder.
     */
    public ApiRequestBuilder body(final String body) {
        apiRequest.setBody(body);
        return this;
    }

    /**
     * Sets the token.
     *
     * @param token a string with the token.
     * @return an ApiRequestBuilder.
     */
    public ApiRequestBuilder token(final String token) {
        apiRequest.setToken(token);
        return this;
    }

    /**
     * Sets the method.
     *
     * @param method a string with the method.
     * @return an ApiRequestBuilder.
     */
    public ApiRequestBuilder method(final Enum<ApiMethod> method) {
        apiRequest.setMethod(method);
        return this;
    }

    /**
     * Adds the header.
     *
     * @param header a string with the header.
     * @param value  a string with the value.
     * @return an ApiRequestBuilder.
     */
    public ApiRequestBuilder header(final String header, final String value) {
        apiRequest.addHeader(header, value);
        return this;
    }

    /**
     * Adds the query params.
     *
     * @param param a string with the params.
     * @param value a string with the value.
     * @return an ApiRequestBuilder.
     */
    public ApiRequestBuilder queryParam(final String param, final String value) {
        apiRequest.addQueryParam(param, value);
        return this;
    }

    /**
     * Adds the path params.
     *
     * @param param a string with the params.
     * @param value a string with the value.
     * @return an ApiRequestBuilder.
     */
    public ApiRequestBuilder pathParam(final String param, final String value) {
        apiRequest.addPathParam(param, value);
        return this;
    }

    /**
     * Gets a path param.
     *
     * @param param a string with the path param.
     * @param value a long with value.
     * @return the pathParam.
     */
    public ApiRequestBuilder pathParam(final String param, final Long value) {
        return pathParam(param, value.toString());
    }

    /**
     * Adds a param.
     *
     * @param param a string with the param.
     * @param value a string with the value.
     * @return an ApiRequestBuilder.
     */
    public ApiRequestBuilder param(final String param, final String value) {
        apiRequest.addParam(param, value);
        return this;
    }

    /**
     * Adds the path params.
     *
     * @param pathParam a Map<String, String> with the path params.
     * @return an ApiRequestBuilder.
     */
    public ApiRequestBuilder pathParams(final Map<String, String> pathParam) {
        apiRequest.addPathParam(pathParam);
        return this;
    }

    /**
     * Adds the params.
     *
     * @param params a Map<String, String> with the params.
     * @return an ApiRequestBuilder.
     */
    public ApiRequestBuilder params(final Map<String, String> params) {
        apiRequest.addParam(params);
        return this;
    }

    /**
     * Builds the api request.
     *
     * @return an ApiRequest.
     */
    public ApiRequest build() {
        return apiRequest;
    }
}
