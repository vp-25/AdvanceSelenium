package Genric_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    public WebDriver driver;
    public static WebDriver sdriver;
    public WebDriver_Utility wlib = new WebDriver_Utility(); // Optional, can be moved to BM if needed

    @BeforeSuite(groups = {"smokeTest", "regressionTest"})
    public void BS() {
        System.out.println("DataBase connection");
    }

    @BeforeTest(groups = {"smokeTest", "regressionTest"})
    public void BT() {
        System.out.println("Parallel Execution");
    }

    @BeforeClass(groups = {"smokeTest", "regressionTest"})
    public void BC() throws Throwable {
        File_Utility flib = new File_Utility();
        String BROWSER = flib.getKeyAndValue("browser");

        if (BROWSER.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup(); // ✅ auto-download correct ChromeDriver
            driver = new ChromeDriver();
        } else if (BROWSER.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (BROWSER.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser, launching Firefox by default");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        System.out.println("Browser Launching");
        sdriver = driver;
    }

    @BeforeMethod(groups = {"smokeTest", "regressionTest"})
    public void BM() throws Throwable {
        File_Utility flib = new File_Utility();
        String URL = flib.getKeyAndValue("url");
        String USERNAME = flib.getKeyAndValue("username");
        String PASSWORD = flib.getKeyAndValue("password");

        driver.get(URL);
        LoginPage login = new LoginPage(driver);
        login.LoginToApp(USERNAME, PASSWORD);

        wlib.maximizeWindow(driver);
        wlib.waitForElementInDOM(driver);

        System.out.println("Login to Application");
    }

    @AfterMethod(groups = {"smokeTest", "regressionTest"})
    public void AM() {
        HomePage home = new HomePage(driver);
        home.logoutApp();
        System.out.println("Logout from Application");
    }

    @AfterClass(groups = {"smokeTest", "regressionTest"})
    public void AC() {
        driver.quit();
        System.out.println("Close the Browser");
    }

    @AfterTest(groups = {"smokeTest", "regressionTest"})
    public void AT() {
        System.out.println("Parallel execution close");
    }

    @AfterSuite(groups = {"smokeTest", "regressionTest"})
    public void AS() {
        System.out.println("Close DAtaBAse");
    }
}
