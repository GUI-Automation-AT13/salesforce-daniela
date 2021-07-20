package legalentity;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import salesforce.ui.pages.*;

public class NewLegalEntityTests extends BaseTest {

    SoftAssert sa= new SoftAssert();
    NewLegalEntityPage newLegalEntityPage;
    LegalEntityPage legalEntityPage;
    String name = "New Legal Entity";
    String nameComplete = "New complete Legal Entity";
    String company = "First company";
    String street = "S. elm # 557";
    String description = "Blue door";
    String city = "New city";
    String state = "The state";
    String postalCode = "0023";
    String country = "Boolivia";
    String dropdownOption = "Active";

    @Test
    public void testCreateLegalEntityWithRequiredFields() {
        newLegalEntityPage = legalEntitiesPage.clickNewBtn();
        legalEntityPage = newLegalEntityPage.setInputField("name",name).clickSaveBtn();
        String expectedMessage = legalEntityPage.getUserSuccessMessage();
        String expectedName = legalEntityPage.getNamesText("name");
        sa.assertEquals(expectedMessage, "success\nLegal Entity \"" + name + "\" was created.\nClose", "Message is incorrect");
        sa.assertEquals(name ,expectedName);
        sa.assertAll();
        legalEntitiesPage = pageTransporter.navigateToLegalEntityPage();
    }

    @Test
    public void testCreateLegalEntityWithFullFields() {
        newLegalEntityPage = legalEntitiesPage.clickNewBtn();
        legalEntityPage = newLegalEntityPage.setInputField("name", nameComplete)
                .setInputField("company name", company).setStreetTxtBox(street)
                .setDescriptionTxtBox(description).setInputField("city", city)
                .setInputField("state", state).setInputField("postal code", postalCode)
                .setInputField("country", country).selectFromDropDown("select", dropdownOption)
                .clickSaveBtn();
        String expectedMessage = legalEntityPage.getUserSuccessMessage();
        sa.assertEquals(expectedMessage, "success\nLegal Entity \"" + nameComplete + "\" was created.\nClose", "Message is incorrect");
        legalEntitiesPage = pageTransporter.navigateToLegalEntityPage();
    }
}
