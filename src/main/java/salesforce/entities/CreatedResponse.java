/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */

package salesforce.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreatedResponse {
    private String id;
    private boolean success;
    private ArrayList<String> errors = new ArrayList<>();

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
     * Obtain the success state.
     *
     * @return true if is success, false otherwise.
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets the success state.
     *
     * @param newSuccess true or false.
     */
    public void setSuccess(final boolean newSuccess) {
        this.success = newSuccess;
    }

    /**
     * GEts the errors.
     *
     * @return ArrayList<String> with the errors.
     */
    public ArrayList<String> getErrors() {
        return errors;
    }

    /**
     * Sets the errors.
     *
     * @param newErrors ArrayList<String> with errors.
     */
    public void setErrors(final ArrayList<String> newErrors) {
        this.errors = newErrors;
    }
}
