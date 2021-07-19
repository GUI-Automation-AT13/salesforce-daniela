package salesforce.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Interacts with the Legal Entity elements.
 */
public class LegalEntitiesPage extends BasePage {

    @FindBy(xpath = "//li[contains(@class, \'slds-button--neutral\')]//a")
    private WebElement newEntityBtn;

    @FindBy(css = ".slds-theme--success")
    private WebElement successMessage;

    @Override
    protected void waitForPageLoaded() {
        //wait.until(ExpectedConditions.visibilityOf(newEntityBtn));
    }

    /**
     * Clicks the new entity button.
     *
     * @return A NewLegalEntityPage.
     */
    public NewLegalEntityPage clickNewBtn() {
        webElementAction.clickButton(newEntityBtn);
        return new NewLegalEntityPage();
    }

}
