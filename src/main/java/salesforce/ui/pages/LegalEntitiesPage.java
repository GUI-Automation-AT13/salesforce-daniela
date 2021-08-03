package salesforce.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Interacts with the Legal Entity elements.
 */
public class LegalEntitiesPage extends BasePage {

    @FindBy(xpath = "//li[contains(@class, \'slds-button--neutral\')]//a")
    private WebElement newEntityBtn;

    @FindBy(css = "table.slds-table")
    private WebElement entitiesTable;

    @FindBy(css = ".slds-theme--success")
    private WebElement successMessage;

    private static final String TABLE_ENTITY = "//div[contains(@class, 'slds-table--edit_container')]//a[@title='%s']";
    private String legalEntityNumberCellXpath = "//table//*[@title='%s']";

    /**
     * Waits for the visibility of a web element.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfElement(entitiesTable);
    }

    /**
     * Clicks the new entity button.
     *
     * @return A NewLegalEntityPage.
     */
    public NewLegalEntityPage clickNewBtn() {
        webElementAction.clickElement(newEntityBtn);
        return new NewLegalEntityPage();
    }

    /**
     * Get the name of a legal entity from the table of entities.
     *
     * @param tableEntityName the name of the legal entity.
     * @return s string with the name of the legal entity.
     */
    public String getTableEntity(final String tableEntityName) {
        return webElementAction.getTextOfElement(driver.findElement(By.xpath(
                String.format(TABLE_ENTITY, tableEntityName))));
    }

    /**
     * Gets the legal entity id.
     *
     * @param name a String with the value
     * @return the case id
     */
    public String getLegalEntityId(final String name) {
        return webElementAction.getAttributeFromWebElement(driver.findElement(
                By.xpath(String.format(legalEntityNumberCellXpath, name))),
                "data-recordid");
    }
}
