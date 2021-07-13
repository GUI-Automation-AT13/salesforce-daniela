package base;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import salesforce.ui.pages.LoginPage;

import static configuration.ConfigurationFile.getEnvVariables;

public class BaseTest {

    private WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        driver = DriverManager.getDriver("chrome");
        driver.get(getEnvVariables("BASE_URL"));
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
