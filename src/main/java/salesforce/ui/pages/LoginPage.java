package salesforce.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Interacts with the login elements.
 */
public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement userNameTxtBox;

    @FindBy(id = "password")
    private WebElement passwordTxtBox;

    @FindBy(id = "Login")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
    }

    public LoginPage setUserName(final String userName) {
        userNameTxtBox.sendKeys(userName);
        return this;
    }

    public LoginPage setPassword(final String password) {
        passwordTxtBox.sendKeys(password);
        return this;
    }

    /**
     * Clicks the login button.
     *
     * @return A homePage.
     */
    public HomePage clickLoginBtn() {
        loginBtn.click();
        return new HomePage(driver);

    }
}
