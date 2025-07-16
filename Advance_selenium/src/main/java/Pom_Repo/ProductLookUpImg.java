package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLookUpImg {
	
	public ProductLookUpImg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[alt='Create Product...']")
	private WebElement lookUpImg;

	public WebElement getLookUpImg() {
		return lookUpImg;
	}
	
	/**
	 * This method is used to create product
	 */
	public void clickPrdLookUp() {
		lookUpImg.click();
	}

}
