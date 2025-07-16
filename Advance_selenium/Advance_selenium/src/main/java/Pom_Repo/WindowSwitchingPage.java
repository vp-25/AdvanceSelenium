package Pom_Repo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowSwitchingPage {

    public WindowSwitchingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@alt='Select']")
    private WebElement prdLookUpImg;

    @FindBy(name = "search_text")
    private WebElement prdName;

    @FindBy(name = "search")
    private WebElement searchBar;

    public WebElement getPrdLookUpImg() {
        return prdLookUpImg;
    }

    public WebElement getPrdName() {
        return prdName;
    }

    public WebElement getSearchBar() {
        return searchBar;
    }

    public void clickPrdLookUpImgInCamp() {
        prdLookUpImg.click();
    }

    public void enterPrdDetails(String name) {
        prdName.sendKeys(name);
        searchBar.click();
    }

    public void enterPrdNameInCamp(WebDriver driver, String productName) {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ Fixed for Selenium 3
        WebElement productLink = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + productName + "']"))
        );
        productLink.click();
    }
}
