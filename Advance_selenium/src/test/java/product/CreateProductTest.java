package product;

import org.testng.annotations.Test;
import Genric_Utilities.BaseClass;
import Genric_Utilities.Excel_Utility;
import Genric_Utilities.Java_Utility;
import Pom_Repo.CreateProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.ProductLookUpImg;
import Pom_Repo.ValidationCampaignPage;

public class CreateProductTest extends BaseClass {

    //---> Final push

    @Test
    public void createProductTest() throws Throwable {
        // Navigate to Product page
        HomePage home = new HomePage(driver);
        home.clickProductLink();

        // Click on + image to create product
        ProductLookUpImg lookUp = new ProductLookUpImg(driver);
        lookUp.clickPrdLookUp();

        // Read product name from Excel and generate random
        Java_Utility jlib = new Java_Utility();
        int rannum = jlib.getRandomNum();

        Excel_Utility eUtil = new Excel_Utility();
        String prdName = eUtil.getExcelData("Product", 0, 0) + rannum;

        // Enter product name and save
        CreateProductPage prdpage = new CreateProductPage(driver);
        prdpage.enterPrdData(driver, prdName); // ✅ Pass driver as required by updated POM

        // Validate product
        Thread.sleep(2000);
        ValidationCampaignPage validate = new ValidationCampaignPage(driver);
        validate.validateProduct(driver, prdName);
    }
}
