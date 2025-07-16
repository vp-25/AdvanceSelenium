import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDTPractice_script2 {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\vishn\\OneDrive\\Desktop\\Commondata1.properties");
		Properties Pro = new Properties();
		Pro.load(fis);
		String url = Pro.getProperty("url");
		String name = Pro.getProperty("name");
		String pass = Pro.getProperty("password");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.id("email")).sendKeys(name);
		driver.findElement(By.id("pass")).sendKeys(pass);
		

	}

}

