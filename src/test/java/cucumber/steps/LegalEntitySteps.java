package cucumber.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.selenium.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import salesforce.entities.LegalEntity;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.*;

import java.util.Map;

import static salesforce.configuration.ConfigurationFile.getEnvVariables;

public class LegalEntitySteps {

    // Pages
    LegalEntitiesPage legalEntitiesPage;
    NewLegalEntityPage newLegalEntityPage;
    DriverManager driverManager;
    LegalEntity legalEntity;
    LegalEntityPage legalEntityPage;
    Map<String, String> tableData;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected PageTransporter pageTransporter;

    @Before
    public void beforeClass() {
        pageTransporter = new PageTransporter();
        driverManager = DriverManager.getInstance();
        loginPage = pageTransporter.navigateToLoginPage();
    }

    @After
    public void tearDown() {
        DriverManager.getInstance().quitDriver();
    }

    @Given("^I login to Salesforce site as an? (.*?) user$")
    public void iLoginToSalesforceSiteAsAnUser(final String userType) {
            homePage = loginPage.loginSuccessful(getEnvVariables("USER"), getEnvVariables("PASSWORD"));
        //get user credentials
        //login by ui if user is not logged in

    }

    @When("^I create a new (.*?) with fields$")
    public void iCreateAnNewFeatureWithFields(final String feature, final Map<String, String> table) throws JsonProcessingException {
        // setear la entidad
        tableData = table;
        String json = new ObjectMapper().writeValueAsString(tableData);
        legalEntity = new ObjectMapper().readValue(json, LegalEntity.class);
        // crear el Legal Entity por UI
        legalEntitiesPage = new LegalEntitiesPage();
        newLegalEntityPage = legalEntitiesPage.clickNewBtn();
        newLegalEntityPage.createLegalEntity(tableData.keySet(), legalEntity);
    }

    @Then("A successful message is displayed")
    public void aSuccessfulMessageIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        legalEntityPage  = new LegalEntityPage();
        String expectedMessage = legalEntityPage.getUserSuccessMessage();
        softAssert.assertEquals(expectedMessage, "success\nLegal Entity \"" + legalEntity.getName()
                + "\" was created.\nClose", "Message is incorrect");
        softAssert.assertAll();
    }

    @And("The title matches")
    public void theTitleMatches() {
        SoftAssert softAssert = new SoftAssert();
        String expectedTitle = legalEntityPage.getHeaderEntityNameText();
        softAssert.assertEquals(expectedTitle, legalEntityPage.getHeaderEntityNameText(), "Header name is incorrect");
        softAssert.assertAll();
    }

    @And("All given details fields matches")
    public void allGivenDetailsFieldsMatches() {
        SoftAssert softAssert = new SoftAssert();
        legalEntityPage = new LegalEntityPage();
        softAssert.assertEquals(legalEntityPage.getNamesText("Name"), legalEntity.getName());
        softAssert.assertEquals(legalEntityPage.getNamesText("CompanyName"), legalEntity.getCompanyName());
        softAssert.assertEquals(legalEntityPage.getAddressNamesText("Street"), legalEntity.getLegalEntityStreet());
        softAssert.assertTrue(legalEntityPage.getAddressNamesText("CityStatePostalCode").contains(legalEntity.getLegalEntityCity()));
        softAssert.assertTrue(legalEntityPage.getAddressNamesText("CityStatePostalCode").contains(legalEntity.getLegalEntityState()));
        softAssert.assertTrue(legalEntityPage.getAddressNamesText("CityStatePostalCode").contains(legalEntity.getLegalEntityPostalCode()));
        softAssert.assertEquals(legalEntityPage.getAddressNamesText("Country"), legalEntity.getLegalEntityCountry());
        softAssert.assertEquals(legalEntityPage.getDescriptionText(), legalEntity.getDescription());
        softAssert.assertEquals(legalEntityPage.getStatusText(), legalEntity.getStatus());
        softAssert.assertAll();
    }

}
