package salesforce.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Interacts with the New Legal Entity elements.
 */
public class NewLegalEntityPage extends BasePage {

    @FindBy(xpath = "//label/span[text()=\"Name\"]/../..//input")
    private WebElement nameTxtBox;

    @FindBy(xpath = "//button[@title=\"Save\"]")
    private WebElement saveBtn;

    @FindBy(xpath = "//label/span[text()=\"Company Name\"]/../..//input")
    private WebElement companyNameTxtBox;

    @FindBy(xpath = "//div/textarea[@placeholder=\"Street\"]")
    private WebElement streetTxtBox;

    @FindBy(xpath = "//div/textarea[@class=\" textarea\"]")
    private WebElement descriptionTxtBox;

    @FindBy(xpath = "//label/span[text()=\"City\"]/../..//input")
    private WebElement cityTxtBox;

    @FindBy(xpath = "//label/span[text()=\"State\"]/../..//input")
    private WebElement stateTxtBox;

    @FindBy(xpath = "//label/span[text()=\"Postal Code\"]/../..//input")
    private WebElement postalCodeTxtBox;

    @FindBy(xpath = "//label/span[text()=\"Country\"]/../..//input")
    private WebElement countryTxtBox;

    @FindBy(xpath = "//a[@class=\"select\"]")
    private WebElement statusDrpDwnMenu;

    @FindBy(xpath = "//div[@class=\"select-options\"]//a[@title=\"Active\"]")
    private WebElement statusOptionDrpDwnMenu;

    public NewLegalEntityPage() {
        super();
    }

    @Override
    protected void waitForPageLoaded() {
        //wait.until(ExpectedConditions.visibilityOf(saveBtn));
        webElementAction.waitForVisibilityOfElement(saveBtn);
    }

    public NewLegalEntityPage setNameTxtBox(final String entityName) {
        webElementAction.setTextInputField(nameTxtBox, entityName);
        return this;
    }

    /**
     * Sets the companyName.
     *
     * @param companyName a String with the companyName.
     * @return a NewLegalEntityPage
     */
    public NewLegalEntityPage setCompanyNameTxtBox(final String companyName) {
        webElementAction.setTextInputField(companyNameTxtBox, companyName);
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
     * Sets the city.
     *
     * @param city a String with the city.
     * @return a NewLegalEntityPage
     */
    public NewLegalEntityPage setCityTxtBox(final String city) {
        webElementAction.setTextInputField(cityTxtBox, city);
        return this;
    }

    /**
     * Sets the state.
     *
     * @param state a String with the state.
     * @return a NewLegalEntityPage
     */
    public NewLegalEntityPage setStateTxtBox(final String state) {
        webElementAction.setTextInputField(stateTxtBox, state);
        return this;
    }

    /**
     * Sets the postalCode.
     *
     * @param postalCode a String with the postalCode.
     * @return a NewLegalEntityPage
     */
    public NewLegalEntityPage setPostalCodeTxtBox(final String postalCode) {
        webElementAction.setTextInputField(postalCodeTxtBox, postalCode);
        return this;
    }

    /**
     * Sets the country.
     *
     * @param country a String with the country.
     * @return a NewLegalEntityPage
     */
    public NewLegalEntityPage setCountryTxtBox(final String country) {
        webElementAction.setTextInputField(countryTxtBox, country);
        return this;
    }

    /**
     * Sets the statusMenu.
     *
     * @return a NewLegalEntityPage
     */
    public NewLegalEntityPage clickStatusDrpDwnMenu() {
        webElementAction.clickButton(statusDrpDwnMenu);
        return this;
    }

    /**
     * Sets the statusOption.
     *
     * @return a NewLegalEntityPage
     */
    public NewLegalEntityPage clickStatusOptionDrpDwnMenu() {
        webElementAction.clickButton(statusOptionDrpDwnMenu);
        return this;
    }

    /**
     * Clicks the save button.
     *
     * @return A LegalEntityPage.
     */
    public LegalEntityPage clickSaveBtn() {
        webElementAction.clickButton(saveBtn);
        return new LegalEntityPage();
    }
}
