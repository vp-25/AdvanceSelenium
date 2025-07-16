package integration_scenario;

import org.testng.annotations.Test;

import Genric_Utilities.BaseClass;
import Genric_Utilities.Excel_Utility;
import Genric_Utilities.Java_Utility;
import Genric_Utilities.WebDriver_Utility;
import Pom_Repo.CampLookUpImgPage;
import Pom_Repo.CreateCampaignPage;
import Pom_Repo.CreateProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.ProductLookUpImg;
import Pom_Repo.ValidationCampaignPage;
import Pom_Repo.WindowSwitchingPage;

public class Createcampaignandproduct extends BaseClass {

    @Test(groups = "regressionTest")
    public void createcampaignandproductTest() throws Throwable {
        // Step 1: Navigate to Products and create a new product
        HomePage home = new HomePage(driver);
        home.clickProductLink();

        ProductLookUpImg productLookup = new ProductLookUpImg(driver);
        productLookup.clickPrdLookUp();

        Java_Utility jUtil = new Java_Utility();
        int randNum = jUtil.getRandomNum();

        Excel_Utility eUtil = new Excel_Utility();
        String prdName = eUtil.getExcelData("Product", 0, 0) + randNum;
        System.out.println("Generated Product Name: " + prdName);

        CreateProductPage createProduct = new CreateProductPage(driver);
        createProduct.enterPrdData(driver, prdName);  // ✅ Updated with WebDriver param

        // Step 2: Navigate to Campaigns and create a new campaign with the product
        home.clickCampaignsLink();

        CampLookUpImgPage campLookup = new CampLookUpImgPage(driver);
        campLookup.clickLookUpImg();

        String campName = eUtil.getExcelData("Camapign", 0, 0) + randNum;
        System.out.println("Generated Campaign Name: " + campName);

        CreateCampaignPage createCampaign = new CreateCampaignPage(driver);
        createCampaign.entercampName(campName);

        WindowSwitchingPage switcher = new WindowSwitchingPage(driver);
        switcher.clickPrdLookUpImgInCamp();

        wlib.WindowSwitching(driver, "Product&action");
        switcher.enterPrdDetails(prdName);
        switcher.enterPrdNameInCamp(driver, prdName);

        Thread.sleep(2000);  // Allow time for selection
        wlib.WindowSwitching(driver, "Campaigns&action");

        createCampaign.clickSaveButton();

        // Step 3: Validation
        ValidationCampaignPage validate = new ValidationCampaignPage(driver);
        validate.validateCamp(driver, campName);
        validate.validateProduct(driver, prdName);
    }
}
