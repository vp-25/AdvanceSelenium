package campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Genric_Utilities.BaseClass;
import Genric_Utilities.Excel_Utility;
import Genric_Utilities.File_Utility;
import Genric_Utilities.WebDriver_Utility;
import Pom_Repo.CampLookUpImgPage;
import Pom_Repo.ContactLookUpImgPage;
import Pom_Repo.CreateCampaignPage;
import Pom_Repo.CreateContactPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ValidateContactPage;
import Pom_Repo.ValidationCampaignPage;

//@Listeners(Genric_Utilities.ListenerImp.class)
@Listeners(Genric_Utilities.ExtentReportImp.class)
public class CreateCampaignTest extends BaseClass {

	//--->I am pulling this-->pull1
	//-->pushback
	//-->pull back
	@Test(retryAnalyzer = Genric_Utilities.RetryAnalyserImp.class)
	 public void createCampaignTest() throws Throwable {
		//Login to vtiger application->mouseOverOn more Link->click on campaigns->click on create campaign lookup image->Enter campaignName->
		//click on save Btn->verify whether the campaign is created in campaign Information page and Logout from the application.
		
	         HomePage home = new HomePage(driver);
	         home.clickCampaignsLink();
	         //refer CampLookUpImgPage-->Pom package
	         CampLookUpImgPage campLookUp = new CampLookUpImgPage(driver);
	         campLookUp.clickLookUpImg();
	     
	        //calling Excel utility method
	        Excel_Utility eUtil = new Excel_Utility();
	        String campName = eUtil.getExcelData("Sheet1", 0, 0);        
	        
	        //refer createcampaignpage-->pom package
	        CreateCampaignPage campPage = new CreateCampaignPage(driver);
	        campPage.entercampName(campName);
	        campPage.clickSaveButton();
	        //refer validationcampaignpage -->POM package
	        //Assert.fail("I'm Intentionally failing");//--> To trigger the listenerImp for screenshot
	        ValidationCampaignPage validate = new ValidationCampaignPage(driver);
	        validate.validateCamp(driver, campName);
	}
	

}
