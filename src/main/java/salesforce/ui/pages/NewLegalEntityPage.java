package salesforce.ui.pages;

import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.entities.LegalEntity;

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

    private HashMap<String, Runnable> strategyMap;
    private static final String INPUT_XPATH = "//label/span[text()='%s']/../..//input";
    private static final String DROPDOWN_XPATH = "//a[@class='%s']";
    private static final String DROPDOWN_OPTION_XPATH = "//div[@class=\"select-options\"]//a[@title='%s']";
    private static final HashMap<String, String> INPUT_FIELDS_NAMES = new HashMap<>();

    static {
        INPUT_FIELDS_NAMES.put("Name", "Name");
        INPUT_FIELDS_NAMES.put("CompanyName", "Company Name");
        INPUT_FIELDS_NAMES.put("City", "City");
        INPUT_FIELDS_NAMES.put("State", "State");
        INPUT_FIELDS_NAMES.put("PostalCode", "Postal Code");
        INPUT_FIELDS_NAMES.put("Country", "Country");
    }

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfElement(streetTxtBox);
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
                String.format(INPUT_XPATH, INPUT_FIELDS_NAMES.get(fieldName)))), value);
        return this;
    }

    /**
     * Selects an option from a dropdown menu.
     *
     * @param fieldName the name of the menu field.
     * @param option    the option to select.
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

    /**
     * Builds the legal entity map with given fields.
     *
     * @param legalEntity with given fields.
     */
    private void buildMap(final LegalEntity legalEntity) {
        strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> setInputField("Name", legalEntity.getName()));
        strategyMap.put("CompanyName", () -> setInputField("CompanyName", legalEntity.getCompanyName()));
        strategyMap.put("LegalEntityCity", () -> setInputField("City", legalEntity.getLegalEntityCity()));
        strategyMap.put("LegalEntityState", () -> setInputField("State", legalEntity.getLegalEntityState()));
        strategyMap.put("LegalEntityPostalCode", () -> setInputField("PostalCode", legalEntity.getLegalEntityPostalCode()));
        strategyMap.put("LegalEntityCountry", () -> setInputField("Country", legalEntity.getLegalEntityCountry()));
        strategyMap.put("LegalEntityStreet", () -> setStreetTxtBox(legalEntity.getLegalEntityStreet()));
        strategyMap.put("Description", () -> setDescriptionTxtBox(legalEntity.getDescription()));
        strategyMap.put("Status", () -> selectFromDropDown("select", legalEntity.getStatus()));
    }

    /**
     * Gets the name of the legal entity.
     *
     * @return a string with the name.
     */
    public String getName() {
        return String.valueOf(strategyMap.get("Name"));
    }

    /**
     * Creates a new legal entity.
     *
     * @param fields      key values from entity map.
     * @param legalEntity an entity.
     * @return a legal entity page.
     */
    public LegalEntityPage createLegalEntity(final Set<String> fields, final LegalEntity legalEntity) {
        // Componer el mapa
        buildMap(legalEntity);
        // Llenar el formulario
        fields.forEach(field -> strategyMap.get(field).run());
        return clickSaveBtn();
    }
}
