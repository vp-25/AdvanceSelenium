package Pom_Repo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ValidateOrgPage {

    public ValidateOrgPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void validateOrg(WebDriver driver, String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ Java 8-compatible constructor

        String actdata = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[@id='dtlview_Organization Name']")))
                .getText();

        Assert.assertEquals(actdata, name, "Organization is not created");
        System.out.println("Organization is created");
    }
}
