package product;

import org.openqa.selenium.WebDriver;
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

    public static void main(String[] args) throws Throwable {

        // Load properties
        File_Utility fLib = new File_Utility();
        String BROWSER = fLib.getKeyAndValue("browser");
        String URL = fLib.getKeyAndValue("url");
        String USERNAME = fLib.getKeyAndValue("username");
        String PASSWORD = fLib.getKeyAndValue("password");

        // Launch browser
        WebDriver driver;
        if (BROWSER.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (BROWSER.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (BROWSER.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }

        WebDriver_Utility wUtil = new WebDriver_Utility();
        wUtil.maximizeWindow(driver);
        driver.get(URL);

        // Login to Vtiger
        LoginPage login = new LoginPage(driver);
        login.getUserTextField().sendKeys(USERNAME);
        login.getPasswordTextField().sendKeys(PASSWORD);
        login.getLoginButton().click();

        // Navigate to Product
        HomePage home = new HomePage(driver);
        home.clickProductLink();

        // Click on + (create product)
        ProductLookUpImg lookUp = new ProductLookUpImg(driver);
        lookUp.clickPrdLookUp();

        // Read data
        Java_Utility jLib = new Java_Utility();
        int randNum = jLib.getRandomNum();

        Excel_Utility eUtil = new Excel_Utility();
        String prdName = eUtil.getExcelData("Product", 0, 0) + randNum;

        // Create product
        CreateProductPage prdPage = new CreateProductPage(driver);
        prdPage.enterPrdData(driver, prdName); // ✅ updated to pass WebDriver

        // Navigate back to Product list
        home.clickProductLink();

        // Select created product and delete
        DeleteProductPage deletePrd = new DeleteProductPage(driver);
        deletePrd.selectprdCheckBox(driver, prdName);
        deletePrd.clickDeleteButton();
        wUtil.alerthandle(driver);
        wUtil.Refreshpage(driver);

        // Validate deletion
        deletePrd.validatePrdDeleted(driver, prdName);

        // Logout
        home.logoutApp();
        driver.quit();
    }
}
