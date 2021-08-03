/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package core.api;

import io.restassured.response.Response;

//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ApiResponse {
    private Response response;

    public ApiResponse(final Response incomingResponse) {
        this.response = incomingResponse;
    }

    /**
     * Gets the response.
     *
     * @return a Response.
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Gets the status of response.
     *
     * @return a integer that represents the status.
     */
    public int getStatusCode() {
        return response.getStatusCode();
    }

    /**
     * Transforms an ApiResponse to a T entity.
     *
     * @param cls is type of entity.
     * @param <T> is type of entity.
     * @return a T entity.
     */
    public <T> T getBody(final Class<T> cls) {
        return response.getBody().as(cls);
    }
//
//    /**
//     * Validates the schema of a respond body.
//     *
//     * @param schema is the path where is schema
//     */
//    public void validateBodySchema(final String schema) {
//        response.then().log().body().assertThat().body(matchesJsonSchemaInClasspath(schema));
//    }

    /**
     * Prints logs of respond body.
     */
    public void logBody() {
        response.then().log().body();
    }

    /**
     * Prints all logs of respond.
     */
    public void logAll() {
        response.then().log().all();
    }
}
