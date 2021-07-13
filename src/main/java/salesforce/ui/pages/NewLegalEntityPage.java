package salesforce.ui.pages;

import org.openqa.selenium.WebDriver;
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
        wait.until(ExpectedConditions.visibilityOf(saveBtn));
    }

    public NewLegalEntityPage setNameTxtBox(final String entityName) {
        nameTxtBox.sendKeys(entityName);
        return this;
    }

    public NewLegalEntityPage setCompanyNameTxtBox(final String companyName) {
        companyNameTxtBox.sendKeys(companyName);
        return this;
    }

    public NewLegalEntityPage setStreetTxtBox(final String street) {
        streetTxtBox.sendKeys(street);
        return this;
    }

    public NewLegalEntityPage setDescriptionTxtBox(final String description) {
        descriptionTxtBox.sendKeys(description);
        return this;
    }

    public NewLegalEntityPage setCityTxtBox(final String city) {
        cityTxtBox.sendKeys(city);
        return this;
    }

    public NewLegalEntityPage setStateTxtBox(final String state) {
        stateTxtBox.sendKeys(state);
        return this;
    }

    public NewLegalEntityPage setPostalCodeTxtBox(final String postalCode) {
        postalCodeTxtBox.sendKeys(postalCode);
        return this;
    }

    public NewLegalEntityPage setCountryTxtBox(final String country) {
        countryTxtBox.sendKeys(country);
        return this;
    }

    public NewLegalEntityPage setStatusDrpDwnMenu(final String statusMenu) {
        statusDrpDwnMenu.sendKeys(statusMenu);
        return this;
    }

    public NewLegalEntityPage setStatusOptionDrpDwnMenu(final String statusOption) {
        statusOptionDrpDwnMenu.sendKeys(statusOption);
        return this;
    }

    /**
     * Clicks the save button.
     *
     * @return A LegalEntityPage.
     */
    public LegalEntityPage clickSaveBtn() {
        saveBtn.click();
        return new LegalEntityPage();
    }
}
