package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidateContactPage {

	public ValidateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateContactFirstNAme(WebDriver driver,String name)
	{
		String actdata = driver.findElement(By.id("dtlview_First Name")).getText();
		//if (actdata.contains(name)) {
		//	System.out.println("contact first Name is Created");
		//} else {

		//	System.out.println("contact first is not Created");
		//}
		Assert.assertEquals(actdata, name,"contact first is not created");
		System.out.println("contact first name is created");
	}
	
	
	public void validateContactlastNAme(WebDriver driver,String name)
	{
		String actdata = driver.findElement(By.id("dtlview_Last Name")).getText();
		//if (actdata.contains(name)) {
		//	System.out.println("contact last Name is Created");
		//} else {

		//	System.out.println("contact last is not Created");
		//}
		Assert.assertEquals(actdata, name,"contact last is not created");
		System.out.println("contact last name is created");
	}
	
}