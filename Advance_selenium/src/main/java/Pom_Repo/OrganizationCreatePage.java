package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class OrganizationCreatePage {

	public OrganizationCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(name = "phone")
	private WebElement phnNum;
	
	@FindBy(id = "email1")
	private WebElement mailId;

	@FindBy(css = "[title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getPhnNum() {
		return phnNum;
	}

	public WebElement getMailId() {
		return mailId;
	}

	/**
	 * Method to fill and save organization data
	 * @param driver - WebDriver instance
	 * @param name - Organization name
	 * @param PhoneNum - Phone number
	 * @param email - Email ID
	 */
	public void enterOrgnaizationData(WebDriver driver, String name, String PhoneNum, String email) {
		orgName.sendKeys(name);
		phnNum.sendKeys(PhoneNum);
		mailId.sendKeys(email);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
	}
}
