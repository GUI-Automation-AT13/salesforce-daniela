package core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * sadsa.
 */
public class WebElementAction {

    private WebDriver driver;
    private WebDriverWait wait;

    public WebElementAction() {
        driver = DriverManager.getInstance().getDriver();
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * coment.
     *
     * @param webElement sadfsd
     * @param text sdf
     */
    public void setTextInputField(final WebElement webElement, final String text) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void waitForVisibilityOfElement(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
