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

    @FindBy(xpath = "//div/div/span[text()=\"Company Name\"]/../..//div//span/*")
    private WebElement companyName;

    @FindBy(css = "span.uiOutputTextArea")
    private WebElement description;

    @FindBy(xpath = "//div//span[text()=\"Status\"]/../..//div//span/*")
    private WebElement status;

    @FindBy(css = "a.forceOutputAddress div:nth-child(1)")
    private WebElement street;

    @FindBy(css = "a.forceOutputAddress div:nth-child(2)")
    private WebElement cityStatePostalCode;

    @FindBy(css = "a.forceOutputAddress div:nth-child(3)")
    private WebElement country;

    private static final String NAMES_XPATH = "//div/div/span[text()='%s']/../..//div//span[@class=\"uiOutputText\"]";
    private static final String ADDRESS_XPATH = "a.forceOutputAddress div:nth-child(%s)";
    private static final String entityName = "//h1//div//span[@class=\"uiOutputText\"][text()=\"%s\"]";
    private static final HashMap<String, String> spanNames = new HashMap<>();

    static {
        spanNames.put("name", "Name");
        spanNames.put("company name", "Company Name");
    }

    private static final HashMap<String, String> divAddress = new HashMap<>();

    static {
        divAddress.put("street", "1");
        divAddress.put("city state postalCode", "2");
        divAddress.put("country", "3");
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
     * @param nameEntity s String with the name of the entity.
     * @return a string with the entity name text.
     */
    public String getEntityNameText(final String nameEntity) {
        return webElementAction.getTextOfElement(driver.findElement(By.xpath(String.format(entityName, nameEntity))));
    }

    /**
     * Gets the entity or company name text.
     *
     * @return a String with the entity or company name text.
     */
    public String getNamesText(final String fieldName) {
        return webElementAction.getTextOfElement(driver.findElement(By.xpath(
                String.format(NAMES_XPATH, spanNames.get(fieldName)))));
    }

    /**
     * Gets the address text.
     *
     * @return a String with address text.
     */
    public String getAddressNamesText(final String fieldName) {
        return webElementAction.getTextOfElement(driver.findElement(By.cssSelector(
                String.format(ADDRESS_XPATH, divAddress.get(fieldName)))));
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
