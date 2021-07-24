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

    @FindBy(css = "tr:nth-child(1) .slds-icon_container > span:nth-child(1)")
    private WebElement arrowMenuIcon;

    @FindBy(xpath = "//div[contains(@class, 'popupTargetContainer')]//a[@title=\"Delete\"]")
    private WebElement deleteOption;

    @FindBy(xpath = "//button[@title=\"Delete\"]")
    private WebElement deleteBtn;

    @FindBy(css = ".slds-theme--success")
    private WebElement successMessage;

    private static final String tableEntity = "//div[contains(@class, 'slds-table--edit_container')]//a[@title='%s']";

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
                String.format(tableEntity, tableEntityName))));
    }

    /**
     * Clicks the delete button.
     *
     * @return a LegalEntityPage.
     */
    public LegalEntitiesPage clickDeleteBtn() {
        webElementAction.clickElement(arrowMenuIcon);
        webElementAction.clickElement(deleteOption);
        webElementAction.clickElement(deleteBtn);
        return new LegalEntitiesPage();
    }

}
