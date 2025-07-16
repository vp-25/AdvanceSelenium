import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");

		// Close login popup
		try {
			driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
		} catch (Exception e) {
			System.out.println("Popup not found, continuing...");
		}

		driver.findElement(By.name("q")).sendKeys("iphone");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(5000); // Wait for results

		// For grid view
		List<WebElement> names = driver.findElements(By.xpath("//div[contains(@class,'_4rR01T')]"));
		List<WebElement> prices = driver.findElements(By.xpath("//div[contains(@class,'_30jeq3')]"));

		// For list view (if grid view doesn't work)
		if (names.size() == 0) {
			names = driver.findElements(By.xpath("//a[@class='s1Q9rs']"));
		}

		if (names.size() == 0) {
			System.out.println("No product names found. Flipkart layout might have changed.");
		} else {
			for (int i = 0; i < Math.min(names.size(), prices.size()); i++) {
				String phone = names.get(i).getText();
				String price = prices.get(i).getText();
				System.out.println("iPhone Name: " + phone + " | Price: " + price);
			}
		}

		driver.quit();
	}
}
