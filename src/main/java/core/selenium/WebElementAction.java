package core.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

/**
 * Helps with the actions of the web elements.
 */
public class WebElementAction {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final int TIME_OUT_IN_SECONDS = 30;

    public WebElementAction() {
        driver = DriverManager.getInstance().getDriver();
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
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
     * @return a string with the text.
     */
    public String getTextOfElement(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    /**
     * Verifies if an element is present.
     * Uses an interval time to wait and find the element and return true if it is present.
     *
     * @param by - Selector of element to Find.
     * @param intervalTime - Time in milliseconds to wait.
     * @return True if the element is present, false otherwise.
     */
    public boolean isElementPresent(final By by, final int intervalTime) {
        driver.manage().timeouts().implicitlyWait(intervalTime, TimeUnit.MILLISECONDS);
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(DriverConfig
                    .getInstance().getImplicitWait(), TimeUnit.MILLISECONDS);
        }
    }

    /**
     * Gets the attribute value on web element.
     *
     * @param webElement any web element on page
     * @param attributeName an attribute of the web element
     * @return a String with the value
     */
    public String getAttributeFromWebElement(final WebElement webElement,
                                             final String attributeName) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getAttribute(attributeName);
    }
}
