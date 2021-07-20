package salesforce.ui.pages;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Interacts with the New Legal Entity elements.
 */
public class NewLegalEntityPage extends BasePage {

    @FindBy(xpath = "//button[@title=\"Save\"]")
    private WebElement saveBtn;

    @FindBy(xpath = "//div/textarea[@placeholder=\"Street\"]")
    private WebElement streetTxtBox;

    @FindBy(xpath = "//div/textarea[@class=\" textarea\"]")
    private WebElement descriptionTxtBox;

    @FindBy(xpath = "//a[@class=\"select\"]")
    private WebElement statusDrpDwnMenu;

    @FindBy(xpath = "//div[@class=\"select-options\"]//a[@title=\"Active\"]")
    private WebElement statusOptionDrpDwnMenu;

    private static final String INPUT_XPATH = "//label/span[text()='%s']/../..//input";
    private static final String DROPDOWN_XPATH = "//a[@class='%s']";
    private static final String DROPDOWN_OPTION_XPATH = "//div[@class=\"select-options\"]//a[@title='%s']";
    private static final HashMap<String, String> inputFieldNames = new HashMap<>();

    static {
        inputFieldNames.put("name", "Name");
        inputFieldNames.put("company name", "Company Name");
        inputFieldNames.put("city", "City");
        inputFieldNames.put("state", "State");
        inputFieldNames.put("postal code", "Postal Code");
        inputFieldNames.put("country", "Country");
    }


    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfElement(saveBtn);
    }

    /**
     * Sets the inputs fields.
     *
     * @param fieldName the name field to set.
     * @param value     the value of the field.
     * @return a NewLegalEntity.
     */
    public NewLegalEntityPage setInputField(final String fieldName, final String value) {
        webElementAction.setTextInputField(driver.findElement(By.xpath(
                String.format(INPUT_XPATH, inputFieldNames.get(fieldName)))), value);
        return this;
    }

    /**
     * Selects an option from a dropdown menu.
     *
     * @param fieldName the name of the menu field.
     * @param option     the option to select.
     * @return a NewLegalEntity.
     */
    public NewLegalEntityPage selectFromDropDown(final String fieldName, final String option) {
        webElementAction.clickElement(driver.findElement(By.xpath(String.format(DROPDOWN_XPATH, fieldName))));
        webElementAction.clickElement(driver.findElement(By.xpath(String.format(DROPDOWN_OPTION_XPATH, option))));
        return this;
    }

    /**
     * Sets the street.
     *
     * @param street a String with the street.
     * @return a NewLegalEntityPage
     */
    public NewLegalEntityPage setStreetTxtBox(final String street) {
        webElementAction.setTextInputField(streetTxtBox, street);
        return this;
    }

    /**
     * Sets the description.
     *
     * @param description a String with the description.
     * @return a NewLegalEntityPage
     */
    public NewLegalEntityPage setDescriptionTxtBox(final String description) {
        webElementAction.setTextInputField(descriptionTxtBox, description);
        return this;
    }

    /**
     * Clicks the save button.
     *
     * @return A LegalEntityPage.
     */
    public LegalEntityPage clickSaveBtn() {
        webElementAction.clickElement(saveBtn);
        return new LegalEntityPage();
    }
}
