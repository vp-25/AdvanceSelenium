package organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Genric_Utilities.BaseClass;
import Genric_Utilities.Excel_Utility;
import Genric_Utilities.File_Utility;
import Genric_Utilities.Java_Utility;
import Genric_Utilities.WebDriver_Utility;
import Pom_Repo.CreateProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.OrganizationCreatePage;
import Pom_Repo.OrganizationLookUpImg;
import Pom_Repo.ProductLookUpImg;
import Pom_Repo.ValidateOrgPage;
import Pom_Repo.ValidationCampaignPage;

public class CreateOrganizationTest extends BaseClass {


	//--> i'm branch2-regression

	//--> i'm branch1

	@Test(groups={"regressionTest","smokeTest"})
	public void createOrganizationTest() throws Throwable {
        HomePage home = new HomePage(driver);
        home.clickOrgLink();
        OrganizationLookUpImg lookUp = new OrganizationLookUpImg(driver);
		lookUp.clickPrdLookUp();      
        Java_Utility jlib = new Java_Utility();
        int rannum = jlib.getRandomNum();

        Excel_Utility eUtil = new Excel_Utility();
        String OrgName = eUtil.getExcelData("Organization",0,0)+ rannum;
       String PhnNum = eUtil.getExcelDataUsingFormatter("Organization", 1, 0);
		String mailId = eUtil.getExcelDataUsingFormatter("Organization", 2, 0);
		OrganizationCreatePage orgPage = new OrganizationCreatePage(driver);
		orgPage.enterOrgnaizationData(OrgName, PhnNum, mailId);
		ValidateOrgPage validate = new ValidateOrgPage(driver);
		validate.validateOrg(driver, OrgName);
	}
	@Test
	public void m2() {
		System.out.println("Hello everyone !!");
	}
	

}
