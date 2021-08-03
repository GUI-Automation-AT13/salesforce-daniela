package cucumber.hooks;

import core.selenium.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import salesforce.Configuration.Api.Auth.Authentication;
import salesforce.Configuration.Ui.Url;
import salesforce.entities.CreatedResponse;
import salesforce.entities.LegalEntity;
import salesforce.entities.RequisiteElement;
import salesforce.entities.Token;

public class Hooks {
    private CreatedResponse createdResponse;
    private RequisiteElement requisiteElement;
    private LegalEntity legalEntity;
    private Logger logger = LogManager.getLogger(getClass());
    private WebDriver driver;


    public Hooks(final CreatedResponse createdResponse, final RequisiteElement requisiteElement, LegalEntity legalEntity) {
        this.createdResponse = createdResponse;
        this.requisiteElement = requisiteElement;
        this.legalEntity = legalEntity;
    }

    @Before(value = "@CreateLegaEntity", order = 0)
    public void authenticate() {
        logger.info("================ A Authenticate Before Hook");
        if (Token.accessToken == null) {
            Authentication.getAuth();
        }
    }

    @Before(value = "@CreateLegaEntity", order = 1)
    public void setUp() {
        logger.info("================ Set Up Before Hook");
        driver = DriverManager.getInstance().getDriver();
        driver.get(Url.BASE_URL.get());
    }

    @After(value = "@CreateLegaEntity", order = 1)
    public void setDown() {
        logger.info("================ SetDown After Hook");
        DriverManager.getInstance().quitDriver();
    }
}
