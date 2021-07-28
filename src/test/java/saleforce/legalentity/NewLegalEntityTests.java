package saleforce.legalentity;

import saleforce.base.BaseTest;
import core.utils.DateManager;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import salesforce.ui.pages.*;

public class NewLegalEntityTests extends BaseTest {

    SoftAssert sa = new SoftAssert();
    DateManager dateManager = new DateManager();
    NewLegalEntityPage newLegalEntityPage;
    LegalEntityPage legalEntityPage;
    String name = "New Legal Entity" + dateManager.getTodayDate();
    String nameComplete = "New complete Legal Entity" + dateManager.getTodayDate();
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
        legalEntityPage = newLegalEntityPage.setInputField("Name", name).clickSaveBtn();
        String expectedMessage = legalEntityPage.getUserSuccessMessage();
        String expectedName = legalEntityPage.getHeaderEntityNameText();
        //Verify success message
        sa.assertEquals(expectedMessage, "success\nLegal Entity \"" + name + "\" was created.\nClose", "Message is incorrect");
        //Verify Legal Entity field (name)
        sa.assertEquals(name, expectedName);
        //Go to Legal Entities Page
        legalEntitiesPage = pageTransporter.navigateToLegalEntityPage();
        //Verify Legal Entity name
        sa.assertEquals(name, legalEntitiesPage.getTableEntity(name));
        sa.assertAll();
    }

    @Test
    public void testCreateLegalEntityWithFullFields() {
        newLegalEntityPage = legalEntitiesPage.clickNewBtn();
        legalEntityPage = newLegalEntityPage.setInputField("Name", nameComplete)
                .setInputField("CompanyName", company).setStreetTxtBox(street)
                .setDescriptionTxtBox(description).setInputField("City", city)
                .setInputField("State", state).setInputField("PostalCode", postalCode)
                .setInputField("Country", country).selectFromDropDown("select", dropdownOption)
                .clickSaveBtn();
        String expectedMessage = legalEntityPage.getUserSuccessMessage();
        //Verify success message
        sa.assertEquals(expectedMessage, "success\nLegal Entity \"" + nameComplete + "\" was created.\nClose", "Message is incorrect");
        //Verify Legal Entity fields (name, company name, street, address, country, description, status)
        sa.assertEquals(nameComplete, legalEntityPage.getNamesText("Name"));
        sa.assertEquals(company, legalEntityPage.getNamesText("CompanyName"));
        sa.assertEquals(street, legalEntityPage.getAddressNamesText("Street"));
        sa.assertEquals(cityStatePostalCode, legalEntityPage.getAddressNamesText("CityStatePostalCode"));
        sa.assertEquals(country, legalEntityPage.getAddressNamesText("Country"));
        sa.assertEquals(description, legalEntityPage.getDescriptionText());
        sa.assertEquals(dropdownOption, legalEntityPage.getStatusText());
        //Go to Legal Entities Page
        legalEntitiesPage = pageTransporter.navigateToLegalEntityPage();
        //Verify Legal Entity name
        sa.assertEquals(nameComplete, legalEntitiesPage.getTableEntity(nameComplete));
        sa.assertAll();
    }
}
