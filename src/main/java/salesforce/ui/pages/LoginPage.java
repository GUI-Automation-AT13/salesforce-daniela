package salesforce.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    /**
     * Sets the user name.
     *
     * @param userName a string with the user name.
     * @return a LoginPage.
     */
    private LoginPage setUserName(final String userName) {
        webElementAction.setTextInputField(userNameTxtBox, userName);
        return this;
    }

    /**
     * Sets the password.
     *
     * @param password a string with the password.
     * @return a LoginPage.
     */
    private LoginPage setPassword(final String password) {
        webElementAction.setTextInputField(passwordTxtBox, password);
        return this;
    }

    /**
     * Clicks the login button.
     */
    public void clickLoginBtn() {
        webElementAction.clickElement(loginBtn);
    }

    /**
     * login with successful values.
     *
     * @param userName to be set.
     * @param password to be set.
     * @return the home page.
     */
    public HomePage loginSuccessful(final String userName, final String password) {
        if ((Boolean) javascriptExecutor.executeScript("return (document.querySelector(\'#theloginform\') && " +
                "document.querySelector(\'#theloginform\').offsetHeight !== 0)")) {
            setUserName(userName);
            setPassword(password);
            clickLoginBtn();
        }
        return new HomePage();
    }
}


