package Login;

import base.BaseTest;
import org.testng.annotations.Test;
import salesforce.ui.pages.HomePage;

import static configuration.ConfigurationFile.getEnvVariables;

public class Login extends BaseTest {

    @Test
    public void testLoginInTheWebPage() {
        HomePage homePage = loginPage.setUserName(getEnvVariables("USER"))
                .setPassword(getEnvVariables("PASSWORD"))
                .clickLoginBtn();
    }
}
