package product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

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

import Genric_Utilities.Excel_Utility;
import Genric_Utilities.File_Utility;
import Genric_Utilities.Java_Utility;
import Genric_Utilities.WebDriver_Utility;
import Pom_Repo.CreateProductPage;
import Pom_Repo.DeleteProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductLookUpImg;

public class CreateAndDeleteProduct {

	public static void main(String[] args) throws Throwable 
	{
		File_Utility flib = new File_Utility();
		 String BROWSER = flib.getKeyAndValue("browser");
       String URL = flib.getKeyAndValue("url");
       String USERNAME = flib.getKeyAndValue("username");
       String PASSWORD = flib.getKeyAndValue("password");

		WebDriver driver;

		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}

		 WebDriver_Utility Wutil = new WebDriver_Utility();
	        Wutil.maximizeWindow(driver);
		driver.get(URL);

		// LOGIN TO VTIGER
		 LoginPage login = new LoginPage(driver);
         login.getUserTextField().sendKeys(USERNAME);
         login.getPasswordTextField().sendKeys(PASSWORD);
         login.getLoginButton().click();
         
         // click on product link
         HomePage home = new HomePage(driver);
         home.clickProductLink();

         // click on create product lookup image
         ProductLookUpImg lookUp = new ProductLookUpImg(driver);
         lookUp.clickPrdLookUp();

		 Java_Utility jlib = new Java_Utility();
	     int rannum = jlib.getRandomNum();
	     Excel_Utility eUtil = new Excel_Utility();
	     String prdName = eUtil.getExcelData("Product", 0, 0) + rannum;

		 // Enter product name and save
	     CreateProductPage prdPage = new CreateProductPage(driver);
	     prdPage.enterPrdData(prdName);

		// Go back to Products list
		home.clickProductLink();
		// Find the row of the created product and click its checkbox
		DeleteProductPage deletePrd = new DeleteProductPage(driver);
		deletePrd.selectprdCheckBox(driver, prdName);
		// Click delete and accept alert
		deletePrd.clickDeleteButton();
		Wutil.alerthandle(driver);
		Wutil.Refreshpage(driver);
		// Try to find the deleted product again
		deletePrd.validatePrdDeleted(driver, prdName);
		// logout from application
		home.logoutApp();
		driver.quit(); 
	}
}
