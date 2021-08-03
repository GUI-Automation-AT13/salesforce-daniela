package salesforce.ui.pages;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static salesforce.utils.Internationalization.translate;

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

    private final int time = 2000;

    private By headerEntityName = By.xpath("//h1//div//span[@class=\"uiOutputText\"]");
    private By descriptionCss = By.cssSelector("span.uiOutputTextArea");
    private By statusSpanXpath = By.xpath("//div//span[text()='" + translate("span.status") + "']/../..//div//span/*");

    private static final String INTERNATIONALIZED_NAME = translate("input.name");
    private static final String INTERNATIONALIZED_COMPANY_NAME = translate("input.companyname");

    private static final String NAMES_XPATH = "//div/div/span[text()='%s']/../..//div//span[@class=\"uiOutputText\"]";
    private static final String ADDRESS_XPATH = "a.forceOutputAddress div:nth-child(%s)";
    private static final String DESCRIPTION = "span.uiOutputTextArea";
    private static final HashMap<String, String> SPAN_NAMES = new HashMap<>();

    static {
        SPAN_NAMES.put("Name", INTERNATIONALIZED_NAME);
        SPAN_NAMES.put("CompanyName", INTERNATIONALIZED_COMPANY_NAME);
    }

    private static final HashMap<String, String> DIV_ADDRESS = new HashMap<>();

    static {
        DIV_ADDRESS.put("Street", "1");
        DIV_ADDRESS.put("CityStatePostalCode", "2");
        DIV_ADDRESS.put("Country", "3");
    }

    /**
     * Waits for the visibility of a web element.
     */
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
        return getSpanText(headerEntityName);
    }

    /**
     * Gets the description text.
     *
     * @return a String with the description text.
     */
    public String getDescriptionText() {
        return getSpanText(descriptionCss);
    }

    /**
     * Gets the status text.
     *
     * @return a String with the status text.
     */
    public String getStatusText() {
        return getSpanText(statusSpanXpath);
    }

    /**
     * Gets the entity or company name text.
     *
     * @param fieldName string with the name of the field.
     * @return a String with the entity or company name text.
     */
    public String getNamesText(final String fieldName) {
        return getNamesTextWithKeyMapByXpath(fieldName);
    }

    /**
     * Gets the address text.
     *
     * @param fieldName string with the name of the field.
     * @return a String with address text.
     */
    public String getAddressNamesText(final String fieldName) {
        return getAddressTextWithKeyMapByCss(fieldName);
    }

    /**
     * Builds a map from the ui.
     *
     * @return HashMap<String, String> with the entity map
     */
    public HashMap<String, String> entityMap() {
        HashMap<String, String> entityMap = new HashMap<>();
        entityMap.put("Name", getSpanFixedText(getNamesText("Name")));
        entityMap.put("CompanyName", getSpanFixedText(getNamesText("CompanyName")));
        entityMap.put("LegalEntityStreet", getAddressNamesText("Street"));
        entityMap.put("Address", getAddressNamesText("CityStatePostalCode"));
        entityMap.put("Country", getAddressNamesText("Country"));
        entityMap.put("Description", getSpanFixedText(getDescriptionText()));
        entityMap.put("Status", getSpanFixedText(getStatusText()));
        return entityMap;
    }

    /**
     * Gets the fixed text of a span.
     *
     * @param span to get text of.
     * @return null if the span is not present, span text otherwise.
     */
    private String getSpanText(final By span) {
        if (webElementAction.isElementPresent(span, time)) {
            return driver.findElement(span).getText();
        }
        return null;
    }

    /**
     * Gets the description text.
     *
     * @param spanToFixText span with text to fix.
     * @return null if the text obtained is empty, a string with the text otherwise.
     */
    private String getSpanFixedText(final String spanToFixText) {
        if (spanToFixText.isEmpty()) {
            return null;
        }
        return spanToFixText;
    }

    /**
     * Gets the text of a address with key map by css.
     *
     * @param keyMap of the map.
     * @return null if the address is not present, span text otherwise.
     */
    private String getAddressTextWithKeyMapByCss(final String keyMap) {
        if (webElementAction.isElementPresent(By.cssSelector(
                String.format(ADDRESS_XPATH, DIV_ADDRESS.get(keyMap))), time)) {
            return driver.findElement(By.cssSelector(
                    String.format(ADDRESS_XPATH, DIV_ADDRESS.get(keyMap)))).getText();
        }
        return null;
    }

    /**
     * Gets the text of a name with key map by xpath.
     *
     * @param keyMap of the map.
     * @return null if the name is not present, span text otherwise.
     */
    private String getNamesTextWithKeyMapByXpath(final String keyMap) {
        if (webElementAction.isElementPresent(By.xpath(
                String.format(NAMES_XPATH, SPAN_NAMES.get(keyMap))), time)) {
            return driver.findElement(By.xpath(
                    String.format(NAMES_XPATH, SPAN_NAMES.get(keyMap)))).getText();
        }
        return null;
    }

}
