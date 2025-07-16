package Pom_Repo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ValidationCampaignPage {
	
	public ValidationCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to validate the campaign
	 * @param driver
	 * @param expData
	 */
	public void validateCamp(WebDriver driver , String expData) {
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		Assert.assertEquals(actData, expData, "Campaign not created");
		System.out.println("Campaign created");
	}

	/**
	 * This method is used to validate the product
	 */
	public void validateProduct(WebDriver driver, String prdName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ Java 8 compatible
		WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[@id='dtlview_Product Name']")));
		
		String actData1 = productElement.getText();
		Assert.assertEquals(actData1, prdName, "Product is not created");
		System.out.println("Product is created");
	}
}
