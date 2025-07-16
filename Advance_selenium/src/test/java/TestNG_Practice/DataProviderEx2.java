package TestNG_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx2 {

    @Test(dataProvider = "getData")
    public void createContact(String FirstName, String LastName) throws Throwable {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8888");
        driver.manage().window().maximize();

        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Contacts")).click();
        driver.findElement(By.cssSelector("[alt ='Create Contact...']")).click();
        driver.findElement(By.name("firstname")).sendKeys(FirstName);
        driver.findElement(By.name("lastname")).sendKeys(LastName);
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
        driver.findElement(By.linkText("Sign Out")).click();
        driver.quit();
    }

    @DataProvider(name = "getData")
    public Object[][] getData() throws Exception {
        return ExcelUtill.readExcelData(
            "C:\\Users\\vishn\\OneDrive\\Desktop\\CommonExcel.xlsx",
            "Contact"
        );
    }
}
