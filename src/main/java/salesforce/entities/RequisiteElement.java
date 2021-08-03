/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.entities;

/**
 * Receive required generic items.
 *
 * @param <T> generics elements.
 */
public class RequisiteElement<T> {

    private T element;
    private String id;

    /**
     * Gets the element.
     *
     * @return a T with the generic.
     */
    public T getElement() {
        return element;
    }

    /**
     * Sets the element.
     *
     * @param newElement a T.
     */
    public void setElement(final T newElement) {
        this.element = newElement;
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
}
