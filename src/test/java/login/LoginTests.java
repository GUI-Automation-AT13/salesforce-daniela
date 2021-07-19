package login;

import base.BaseTest;
import org.testng.annotations.Test;
import salesforce.ui.pages.HomePage;

import static salesforce.configuration.ConfigurationFile.getEnvVariables;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginInTheWebPage() {
        HomePage homePage = loginPage.loginSuccessful(getEnvVariables("USER"), getEnvVariables("PASSWORD"));
    }
}
