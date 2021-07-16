package salesforce.ui.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.configuration.ConfigurationFile;


/**
 * Interacts with the Legal Entity elements.
 */
public class LegalEntityPage extends BasePage {

    @FindBy(xpath = "//li[contains(@class, \'slds-button--neutral\')]//a")
    private WebElement newEntityBtn;

    @FindBy(css = ".slds-theme--success")
    private WebElement successMessage;

    public LegalEntityPage() {
        super();
    }

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newEntityBtn));
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

    /**
     * Gets the success message.
     *
     * @return a String with the message.
     */
    public String getUserSuccessMessage() {
        successMessage.click();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigurationFile.getEnvVariables("implicitTimeWait")),
                TimeUnit.SECONDS);
        return successMessage.getText();
    }

}
