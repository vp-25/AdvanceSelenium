package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CreateProductPage {
    
    public CreateProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(name = "productname")
    private WebElement name;
    
    @FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveButton;

    public WebElement getName() {
        return name;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }
    
    /**
     * This method is used to enter product name and click save
     */
    public void enterPrdData(WebDriver driver, String prdName) {
        name.sendKeys(prdName);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
}
