package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductPage {
	
	public DeleteProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteButton;
	
	/**
	 * 
	 * @param driver
	 * @param prdName
	 */
	
	public void selectprdCheckBox(WebDriver driver, String prdName)
	{
		 driver.findElement(By.xpath("//a[text()='" + prdName + "']/ancestor::tr/td[1]/input[@type='checkbox']")).click();
		
	}
	/**
	 * 
	 */
	public void clickDeleteButton() {
		deleteButton.click();
	}
	/**
	 * 
	 */
	public void validatePrdDeleted(WebDriver driver, String prdName) {
		boolean isDeleted;
		try {
			driver.findElement(By.linkText(prdName));
			isDeleted = false;
		} catch (Exception e) {
			isDeleted = true;
		}
		
		// Print result
		if (isDeleted) {
			System.out.println("The created product is deleted successfully: " + prdName);
		} else {
			System.out.println("The created product is NOT deleted: " + prdName);
		}
	}
	
}

