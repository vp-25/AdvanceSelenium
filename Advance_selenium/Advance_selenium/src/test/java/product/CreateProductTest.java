package product;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Genric_Utilities.BaseClass;
import Genric_Utilities.Excel_Utility;
import Genric_Utilities.File_Utility;
import Genric_Utilities.Java_Utility;
import Genric_Utilities.WebDriver_Utility;
import Pom_Repo.CreateProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductLookUpImg;
import Pom_Repo.ValidationCampaignPage;
//@Listeners(Genric_Utilities.ListenerImp.class)
public class CreateProductTest extends BaseClass{


   //---> final push

	@Test
    public void createProductTest() throws Throwable {
		HomePage home = new HomePage(driver);
		home.clickProductLink();
		ProductLookUpImg lookUp = new ProductLookUpImg(driver);
		lookUp.clickPrdLookUp();
		Java_Utility jlib = new Java_Utility();
        int rannum = jlib.getRandomNum();
        Excel_Utility eUtil = new Excel_Utility();
        String prdName = eUtil.getExcelData("Product", 0, 0) + rannum;
        CreateProductPage prdpage = new CreateProductPage(driver);
		prdpage.enterPrdData(prdName);
		Thread.sleep(2000);
		//Assert.fail("I'm failing");
    	ValidationCampaignPage validate = new ValidationCampaignPage(driver);
		validate.validateProduct(driver, prdName);
    }
}
