package salesforce.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Load the home page.
 */
public class HomePage extends BasePage {
    protected WebDriver driver;
    @FindBy(css = "div.onesetupHelpBanner")
    private WebElement cardsBlock;

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfElement(cardsBlock);
    }
}
