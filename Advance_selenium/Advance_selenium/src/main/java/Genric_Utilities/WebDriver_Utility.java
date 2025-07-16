package Genric_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {

    /**
     * This method is used to maximize the browser window
     * @param driver - WebDriver instance
     */
    public void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }
    public void WindowSwitching(WebDriver driver, String partialtext) {
    	Set<String> allWins = driver.getWindowHandles();
		Iterator<String> it = allWins.iterator();

		while (it.hasNext())
		{
			String win = it.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if (title.contains(partialtext))
			{
				break;
			}

		}
    }
    public void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    
    public void Refreshpage(WebDriver driver) {
    	driver.navigate().refresh();
    }
    
    public void alerthandle(WebDriver driver) {
    	driver.switchTo().alert().accept();
    }
    public void waitForElementInDOM(WebDriver driver) {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    public static String takeScreenShotEx(WebDriver driver, String screenShotName) throws Throwable {
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File dest = new File("./ScreenShots/"+screenShotName+".png");
    	FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
    	
    }
}
