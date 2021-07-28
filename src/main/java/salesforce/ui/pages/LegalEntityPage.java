package salesforce.ui.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Interacts with the Legal Entities elements.
 */
public class LegalEntityPage extends BasePage {

    @FindBy(css = ".slds-theme--success")
    private WebElement successMessage;

    @FindBy(css = "div.slds-form")
    private WebElement informationSection;

    @FindBy(css = "span.uiOutputTextArea")
    private WebElement description;

    @FindBy(xpath = "//h1//div//span[@class=\"uiOutputText\"]")
    private WebElement headerEntityName;

    @FindBy(xpath = "//div//span[text()=\"Status\"]/../..//div//span/*")
    private WebElement status;

    private static final String NAMES_XPATH = "//div/div/span[text()='%s']/../..//div//span[@class=\"uiOutputText\"]";
    private static final String ADDRESS_XPATH = "a.forceOutputAddress div:nth-child(%s)";
    private static final String HEADER_ENTITY_NAME = "//h1//div//span[@class=\"uiOutputText\"]";
    private static final HashMap<String, String> SPAN_NAMES = new HashMap<>();

    static {
        SPAN_NAMES.put("Name", "Name");
        SPAN_NAMES.put("CompanyName", "Company Name");
    }

    private static final HashMap<String, String> DIV_ADDRESS = new HashMap<>();

    static {
        DIV_ADDRESS.put("Street", "1");
        DIV_ADDRESS.put("CityStatePostalCode", "2");
        DIV_ADDRESS.put("Country", "3");
    }

    public LegalEntityPage() {
        super();
    }

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfElement(informationSection);
    }

    /**
     * Gets the success message.
     *
     * @return a String with the message.
     */
    public String getUserSuccessMessage() {
        return webElementAction.getTextOfElement(successMessage);
    }

    /**
     * Gets the entity name text.
     *
     * @return a string with the entity name text.
     */
    public String getHeaderEntityNameText() {
        return webElementAction.getTextOfElement(headerEntityName);
    }

    /**
     * Gets the entity or company name text.
     *
     * @param fieldName string with the name of the field.
     * @return a String with the entity or company name text.
     */
    public String getNamesText(final String fieldName) {
        return webElementAction.getTextOfElement(driver.findElement(By.xpath(
                String.format(NAMES_XPATH, SPAN_NAMES.get(fieldName)))));
    }

    /**
     * Gets the address text.
     *
     * @param fieldName string with the name of the field.
     * @return a String with address text.
     */
    public String getAddressNamesText(final String fieldName) {
        return webElementAction.getTextOfElement(driver.findElement(By.cssSelector(
                String.format(ADDRESS_XPATH, DIV_ADDRESS.get(fieldName)))));
    }

    /**
     * Gets the description text.
     *
     * @return a String with the description text.
     */
    public String getDescriptionText() {
        return webElementAction.getTextOfElement(description);
    }

    /**
     * Gets the status text.
     *
     * @return a String with the status text.
     */
    public String getStatusText() {
        return webElementAction.getTextOfElement(status);
    }

}
