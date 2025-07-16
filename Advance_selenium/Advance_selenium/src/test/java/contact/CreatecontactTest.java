package contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Genric_Utilities.BaseClass;
import Genric_Utilities.Excel_Utility;
import Genric_Utilities.File_Utility;
import Genric_Utilities.WebDriver_Utility;
import Pom_Repo.ContactLookUpImgPage;
import Pom_Repo.CreateContactPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ValidateContactPage;

public class CreatecontactTest extends BaseClass {

	@Test(groups="regressionTest")
	public void createcontactTest() throws Throwable 
	{
	     HomePage home = new HomePage(driver);
		 home.clickContactLink();
		 ContactLookUpImgPage lookUp = new ContactLookUpImgPage(driver);
		lookUp.clickLookUp();
		 Excel_Utility eUtil = new Excel_Utility();
	     String firstName = eUtil.getExcelData("Contact", 0, 0);
	     CreateContactPage contactPage = new CreateContactPage(driver);
	     contactPage.selectDropDown(driver);
		 String lastName = eUtil.getExcelData("Contact", 0, 1);
		 contactPage.enterPrdData(firstName, lastName);
		 ValidateContactPage validate = new ValidateContactPage(driver);
		 //Assert.fail();
		 validate.validateContactFirstNAme(driver, firstName);
		 validate.validateContactlastNAme(driver, lastName);
	}
}
