package legalentity;

import base.BaseTest;
import org.testng.annotations.Test;
import salesforce.ui.pages.*;
import static org.testng.Assert.assertEquals;

public class NewLegalEntityTests extends BaseTest {

    String name = "New Legal Entity";
    String nameComplete = "New complete Legal Entity";
    String company = "First company";
    String street = "S. elm # 557";
    String description = "Blue door";
    String city = "New city";
    String state = "The state";
    String postalCode = "0023";
    String country = "Boolivia";
    NewLegalEntityPage newLegalEntityPage;
    LegalEntityPage legalEntityPage;

    @Test
    public void testCreateLegalEntityWithRequiredFields() {
        newLegalEntityPage = legalEntitiesPage.clickNewBtn();
        legalEntityPage = newLegalEntityPage.setNameTxtBox(name).clickSaveBtn();
        String expectedMessage = legalEntityPage.getUserSuccessMessage();
        assertEquals(expectedMessage, "success\nLegal Entity \"" + name + "\" was created.\nClose", "Message is incorrect");
        legalEntitiesPage = pageTransporter.navigateToLegalEntityPage();
    }

    @Test
    public void testCreateLegalEntityWithFullFields() {
        newLegalEntityPage = legalEntitiesPage.clickNewBtn();
        legalEntityPage = newLegalEntityPage.setNameTxtBox(nameComplete).setCompanyNameTxtBox(company).setStreetTxtBox(street)
                .setDescriptionTxtBox(description).setCityTxtBox(city).setStateTxtBox(state).setPostalCodeTxtBox(postalCode)
                .setCountryTxtBox(country).clickStatusDrpDwnMenu().clickStatusOptionDrpDwnMenu().clickSaveBtn();
        String expectedMessage = legalEntityPage.getUserSuccessMessage();
        assertEquals(expectedMessage, "success\nLegal Entity \"" + nameComplete + "\" was created.\nClose", "Message is incorrect");
        legalEntitiesPage = pageTransporter.navigateToLegalEntityPage();
    }
}
