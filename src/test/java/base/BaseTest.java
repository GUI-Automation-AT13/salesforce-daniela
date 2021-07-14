package base;

import core.selenium.DriverManager;
import core.selenium.WebElementAction;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.LoginPage;

import static salesforce.configuration.ConfigurationFile.getEnvVariables;

public class BaseTest {

    private DriverManager driverManager;
    protected LoginPage loginPage;
    protected PageTransporter pageTransporter;

    @BeforeClass
    public void beforeClass() {
        pageTransporter = new PageTransporter();
        driverManager = DriverManager.getInstance();
        loginPage = pageTransporter.navigateToLoginPage();
    }

    @AfterClass
    public void tearDown() {
        DriverManager.getInstance().quitDriver();
    }
}
