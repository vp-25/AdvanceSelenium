package contact;

import org.testng.annotations.Test;

import Genric_Utilities.BaseClass;
import Genric_Utilities.Excel_Utility;
import Pom_Repo.ContactLookUpImgPage;
import Pom_Repo.CreateContactPage;
import Pom_Repo.HomePage;
import Pom_Repo.ValidateContactPage;

public class CreatecontactTest extends BaseClass {

    @Test(groups = "regressionTest")
    public void createcontactTest() throws Throwable {
        // Navigate to Contacts section
        HomePage home = new HomePage(driver);
        home.clickContactLink();

        // Click on Create Contact lookup image
        ContactLookUpImgPage lookUp = new ContactLookUpImgPage(driver);
        lookUp.clickLookUp();

        // Fetch data from Excel
        Excel_Utility eUtil = new Excel_Utility();
        String firstName = eUtil.getExcelData("Contact", 0, 0);
        String lastName = eUtil.getExcelData("Contact", 0, 1);

        // Fill in contact details and save
        CreateContactPage contactPage = new CreateContactPage(driver);
        contactPage.selectDropDown(driver); // e.g., select salutation "Ms."
        contactPage.enterPrdData(driver, firstName, lastName);

        // Validate the saved contact data
        ValidateContactPage validate = new ValidateContactPage(driver);
        validate.validateContactFirstNAme(driver, firstName);
        validate.validateContactlastNAme(driver, lastName);
    }
}
