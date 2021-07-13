package salesforce.ui.pages;

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

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfElement(loginBtn);
    }

    public LoginPage setUserName(final String userName) {
        webElementAction.setTextInputField(userNameTxtBox, userName);
        return this;
    }

    public LoginPage setPassword(final String password) {
        webElementAction.setTextInputField(passwordTxtBox, password);
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
