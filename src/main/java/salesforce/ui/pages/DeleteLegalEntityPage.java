package salesforce.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Locale;
import java.util.ResourceBundle;

public class DeleteLegalEntityPage extends BasePage {

    @FindBy(css = "div.slds-modal__content")
    private WebElement deleteMessage;

    private By deleteBtnXpath = By.xpath("//button[@title='"
            + ResourceBundle.getBundle("internationalization/i18NLegalEntities",
            new Locale("es")).getString("button.delete") + "']");

    /**
     * Waits for the visibility of an element.
     */
    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(deleteMessage));
    }

    /**
     * Deletes the first legal entity from table.
     *
     * @return a new LegalEntitiesPage.
     */
    public LegalEntitiesPage deleteLegalEntity() {
        webElementAction.clickElement(driver.findElement(deleteBtnXpath));
        return new LegalEntitiesPage();
    }
}
