package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampLookUpImgPage {
	
	public CampLookUpImgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css ="img[alt='Create Campaign...']")
	private WebElement lookUpImg;

	public WebElement getLookUpImg() {
		return lookUpImg;
	}
	
	/**
	 * This method is used to click on LookUpImg
	 */
	public void clickLookUpImg() {
		lookUpImg.click();
	}

}
