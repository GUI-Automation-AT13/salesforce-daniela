package core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Helps with the actions of the web elements.
 */
public class WebElementAction {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final int timeOutInSeconds = 30;

    public WebElementAction() {
        driver = DriverManager.getInstance().getDriver();
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    /**
     * Sets the text of an input field.
     *
     * @param webElement webElement to be set.
     * @param text       text as value that will be set.
     */
    public void setTextInputField(final WebElement webElement, final String text) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * Clicks an element.
     *
     * @param webElement webElement to be clicked.
     */
    public void clickElement(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }

    /**
     * Waits for a web element to be visible.
     *
     * @param webElement web element to wait for.
     */
    public void waitForVisibilityOfElement(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Gets the text of a web element.
     *
     * @param webElement web element to get it's text.
     */
    public String getTextOfElement(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }
}
