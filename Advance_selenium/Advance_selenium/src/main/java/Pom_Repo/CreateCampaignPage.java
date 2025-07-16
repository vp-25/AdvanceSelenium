package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignname")
	private WebElement campNAme;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getCampName() {
		return campNAme;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * This method is used to enter campaignName
	 */
	public void entercampName(String name) {
		campNAme.sendKeys(name);
	}
	/**
	 * This method is used to click on save button
	 */
	public void clickSaveButton() {
		saveButton.click();
	}

}
