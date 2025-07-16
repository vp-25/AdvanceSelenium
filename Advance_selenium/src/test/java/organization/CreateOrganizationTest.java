package organization;

import org.testng.annotations.Test;

import Genric_Utilities.BaseClass;
import Genric_Utilities.Excel_Utility;
import Genric_Utilities.Java_Utility;
import Pom_Repo.HomePage;
import Pom_Repo.OrganizationCreatePage;
import Pom_Repo.OrganizationLookUpImg;
import Pom_Repo.ValidateOrgPage;

public class CreateOrganizationTest extends BaseClass {

    @Test(groups = { "regressionTest", "smokeTest" })
    public void createOrganizationTest() throws Throwable {

        // Navigate to Organizations
        HomePage home = new HomePage(driver);
        home.clickOrgLink();

        // Click on Create Organization
        OrganizationLookUpImg lookUp = new OrganizationLookUpImg(driver);
        lookUp.clickPrdLookUp();      

        // Read test data
        Java_Utility jUtil = new Java_Utility();
        int ranNum = jUtil.getRandomNum();

        Excel_Utility eUtil = new Excel_Utility();
        String orgName = eUtil.getExcelData("Organization", 0, 0) + ranNum;
        String phoneNum = eUtil.getExcelDataUsingFormatter("Organization", 1, 0);
        String email = eUtil.getExcelDataUsingFormatter("Organization", 2, 0);

        // Fill form and submit
        OrganizationCreatePage orgPage = new OrganizationCreatePage(driver);
        orgPage.enterOrgnaizationData(driver, orgName, phoneNum, email);  // ✅ Fixed missing WebDriver

        // Validate
        ValidateOrgPage validate = new ValidateOrgPage(driver);
        validate.validateOrg(driver, orgName);
    }

    @Test
    public void m2() {
        System.out.println("Hello everyone !!");
    }
}
