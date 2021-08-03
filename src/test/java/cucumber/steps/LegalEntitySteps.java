package cucumber.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;
import salesforce.entities.CreatedResponse;
import salesforce.entities.LegalEntity;
import salesforce.entities.RequisiteElement;
import salesforce.ui.pages.*;
import java.util.Map;
import static salesforce.Configuration.ConfigurationFile.getEnvVariables;

public class LegalEntitySteps {

    private Logger logger = LogManager.getLogger(getClass());
    SoftAssert softAssert = new SoftAssert();
    LegalEntity legalEntity;
    CreatedResponse createdResponse;
    RequisiteElement requisiteElement;

    public LegalEntitySteps(final CreatedResponse createdResponse, final RequisiteElement requisiteElement, LegalEntity legalEntity) {
        this.createdResponse = createdResponse;
        this.requisiteElement = requisiteElement;
        this.legalEntity = legalEntity;
    }

    @Given("^I login to Salesforce site as an admin user$")
    public void iLoginToSalesforceSiteAsAnAdminUser() {
        logger.info("=================== Given I login to Salesforce site ==========================");
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginSuccessful(getEnvVariables("USER"), getEnvVariables("PASSWORD"));
    }

    @When("^I create a new LegalEntity with fields$")
    public void iCreateAnNewLegalEntityWithFields(final Map<String, String> table) throws JsonProcessingException {
        logger.info("=================== When I create a new legal entity ==========================");
        String json = new ObjectMapper().writeValueAsString(table);
        legalEntity.setEntity(new ObjectMapper().readValue(json, LegalEntity.class));
        LegalEntitiesPage legalEntitiesPage = new LegalEntitiesPage();
        NewLegalEntityPage newLegalEntityPage = legalEntitiesPage.clickNewBtn();
        newLegalEntityPage.createLegalEntity(table.keySet(), legalEntity);
    }

    @Then("A successful message should be displayed")
    public void aSuccessfulMessageShouldBeDisplayed() {
        logger.info("=================== Then A successful message should be displayed ==========================");
        LegalEntityPage legalEntityPage  = new LegalEntityPage();
        boolean message = legalEntityPage.getUserSuccessMessage().contains(legalEntity.getName());
        softAssert.assertTrue(message, "Message is incorrect");
    }

    @And("The header name should match in the created legal entity page")
    public void theHeaderNameShouldMatchInTheCreatedLegalEntityPage() {
        logger.info("=================== And The header name should match ==========================");
        LegalEntityPage legalEntityPage = new LegalEntityPage();
        softAssert.assertEquals(legalEntity.getName(), legalEntityPage.getHeaderEntityNameText(), "Header name is incorrect");
    }

    @And("All given details fields should match in the created legal entity page")
    public void allGivenDetailsFieldsShouldMatchesInTheCreatedLegalEntityPage() {
        logger.info("=================== And All the given details fields should match ==========================");
        LegalEntityPage legalEntityPage = new LegalEntityPage();
        softAssert.assertEquals(legalEntity.summaryMap(), legalEntityPage.entityMap(), "Fields doesn't match");
        softAssert.assertAll();
    }

    @Then("The created legal entity should be displayed on the legal entities table")
    public void theCreatedLegalEntityShouldBeDisplayedOnTheLegalEntitiesTable() {
        logger.info("=================== Then The created legal entity should be on table ==========================");
        LegalEntitiesPage legalEntitiesPage = new LegalEntitiesPage();
        legalEntity.setId(legalEntitiesPage.getLegalEntityId(legalEntity.getName()));
        softAssert.assertEquals(legalEntitiesPage.getTableEntity(legalEntity.getName()), legalEntity.getName(),
                "The name is incorrect");
        softAssert.assertAll();
    }

}
