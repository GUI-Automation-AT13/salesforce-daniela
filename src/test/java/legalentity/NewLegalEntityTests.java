package legalentity;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import salesforce.ui.pages.*;

public class NewLegalEntityTests extends BaseTest {

    SoftAssert sa = new SoftAssert();
    NewLegalEntityPage newLegalEntityPage;
    LegalEntityPage legalEntityPage;
    int numero = (int)(Math. random()*100+1);
    String name = "New Legal Entity" + numero;
    String nameComplete = "New complete Legal Entity";
    String company = "First company";
    String street = "S. elm # 557";
    String description = "Blue door";
    String city = "New city";
    String state = "The state";
    String postalCode = "0023";
    String country = "Boolivia";
    String dropdownOption = "Active";
    String cityStatePostalCode = city + ", " + state + " " + postalCode;

    @Test
    public void testCreateLegalEntityWithRequiredFields() {
        newLegalEntityPage = legalEntitiesPage.clickNewBtn();
        legalEntityPage = newLegalEntityPage.setInputField("name", name).clickSaveBtn();
        String expectedMessage = legalEntityPage.getUserSuccessMessage();
        String expectedName = legalEntityPage.getEntityNameText(name);
        sa.assertEquals(expectedMessage, "success\nLegal Entity \"" + name + "\" was created.\nClose", "Message is incorrect");
        sa.assertEquals(name, expectedName);
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
        sa.assertEquals(nameComplete, legalEntityPage.getNamesText("name"));
        sa.assertEquals(company, legalEntityPage.getNamesText("company name"));
        sa.assertEquals(street, legalEntityPage.getAddressNamesText("street"));
        sa.assertEquals(cityStatePostalCode, legalEntityPage.getAddressNamesText("city state postalCode"));
        sa.assertEquals(country, legalEntityPage.getAddressNamesText("country"));
        sa.assertEquals(description, legalEntityPage.getDescriptionText());
        sa.assertEquals(dropdownOption, legalEntityPage.getStatusText());
        sa.assertAll();
        legalEntitiesPage = pageTransporter.navigateToLegalEntityPage();
    }
}
