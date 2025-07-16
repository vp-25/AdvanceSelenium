package integration_scenario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Genric_Utilities.BaseClass;
import Genric_Utilities.Excel_Utility;
import Genric_Utilities.File_Utility;
import Genric_Utilities.Java_Utility;
import Genric_Utilities.WebDriver_Utility;
import Pom_Repo.CampLookUpImgPage;
import Pom_Repo.CreateCampaignPage;
import Pom_Repo.CreateProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductLookUpImg;
import Pom_Repo.ValidationCampaignPage;
import Pom_Repo.WindowSwitchingPage;

public class Createcampaignandproduct extends BaseClass{

	
	public void createcampaignandproductTest() throws Throwable 
	{
	//Login to vtiger application->mouseOverOn more Link->click on campaigns->click on create campaign lookup image->Enter campaignName->Click on Product plus img->Handle the PopUp->Product name should be added to campaign createpage->
	//click on save Btn->verify whether the campaign name is created in campaign Information page and Logout from the application. 
		
				HomePage home = new HomePage(driver);
				home.clickProductLink();
				// >click on create product lookup image
				ProductLookUpImg lookUp = new ProductLookUpImg(driver);
				lookUp.clickPrdLookUp();
				Java_Utility jlib = new Java_Utility();
			    int rannum = jlib.getRandomNum();;
			    Excel_Utility eUtil = new Excel_Utility();
			    String prdName = eUtil.getExcelData("Product", 0, 0) + rannum;
                System.out.println(prdName);
                CreateProductPage prdPage = new CreateProductPage(driver);
            	prdPage.enterPrdData(prdName);
				// click on save Btn
            	home.clickCampaignsLink();
            	CampLookUpImgPage img = new CampLookUpImgPage(driver);
            	img.clickLookUpImg();
				Excel_Utility eUtil1 = new Excel_Utility();
		        String campName = eUtil1.getExcelData("Camapign", 0, 0) + rannum;
                System.out.println(campName);
                CreateCampaignPage campPage = new CreateCampaignPage(driver);
        		campPage.entercampName(campName);
        		WindowSwitchingPage winSwitch = new WindowSwitchingPage(driver);
        		winSwitch.clickPrdLookUpImgInCamp();
				wlib.WindowSwitching(driver, "Product&action");
				winSwitch.enterPrdDetails(prdName);
				// Dynamic xpath
				winSwitch.enterPrdNameInCamp(driver, prdName);
				Thread.sleep(2000); 
				wlib.WindowSwitching(driver, "Campaigns&action");
				campPage.clickSaveButton();
				ValidationCampaignPage validate = new ValidationCampaignPage(driver);
				validate.validateCamp(driver, campName);
				validate.validateProduct(driver, prdName);
			}
	}


