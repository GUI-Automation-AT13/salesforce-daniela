package saleforce.base;

import core.selenium.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.HomePage;
import salesforce.ui.pages.LegalEntitiesPage;
import salesforce.ui.pages.LoginPage;

import static salesforce.Configuration.ConfigurationFile.getEnvVariables;

public class BaseTest {

    DriverManager driverManager;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected PageTransporter pageTransporter;
    protected LegalEntitiesPage legalEntitiesPage;
    protected JavascriptExecutor javascriptExecutor;

    @BeforeTest
    public void beforeClass() throws Exception {
        pageTransporter = new PageTransporter();
        driverManager = DriverManager.getInstance();
        javascriptExecutor = (JavascriptExecutor) driverManager;
        loginPage = pageTransporter.navigateToLoginPage();
        homePage = loginPage.loginSuccessful(getEnvVariables("USER"), getEnvVariables("PASSWORD"));
        legalEntitiesPage = pageTransporter.navigateToLegalEntityPage();
    }

    @AfterTest
    public void tearDown() {
        DriverManager.getInstance().quitDriver();
    }
}
