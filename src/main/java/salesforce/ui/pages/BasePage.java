package salesforce.ui.pages;

import core.selenium.DriverManager;
import core.selenium.WebElementAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Initializes the Web elements.
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebElementAction webElementAction;
    protected DriverManager driverManager;
    protected JavascriptExecutor javascriptExecutor;

    /**
     * Initializes the elements and wait for page to be loaded.
     */
    public BasePage() {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        javascriptExecutor = (JavascriptExecutor) driver;
        webElementAction = new WebElementAction();
        PageFactory.initElements(driver, this);
        waitForPageLoaded();
    }

    protected abstract void waitForPageLoaded();
}
