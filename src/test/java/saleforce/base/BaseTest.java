package saleforce.base;

import core.selenium.DriverManager;
import core.utils.DateManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.HomePage;
import salesforce.ui.pages.LegalEntitiesPage;
import salesforce.ui.pages.LoginPage;

import static salesforce.configuration.ConfigurationFile.getEnvVariables;

public class BaseTest {

    DriverManager driverManager;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected PageTransporter pageTransporter;
    protected LegalEntitiesPage legalEntitiesPage;

    @BeforeTest
    public void beforeClass() {
        pageTransporter = new PageTransporter();
        driverManager = DriverManager.getInstance();
        loginPage = pageTransporter.navigateToLoginPage();
        homePage = loginPage.loginSuccessful(getEnvVariables("USER"), getEnvVariables("PASSWORD"));
        legalEntitiesPage = pageTransporter.navigateToLegalEntityPage();
    }

    @AfterTest
    public void tearDown() {
        DriverManager.getInstance().quitDriver();
    }
}
