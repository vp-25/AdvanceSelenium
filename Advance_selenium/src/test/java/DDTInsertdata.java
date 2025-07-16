import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DDTInsertdata {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream f = new FileInputStream("C:\\Users\\vishn\\OneDrive\\Desktop\\Commondata.properties");
		//open property file
		Properties p = new Properties();
		p.load(f); 
		p.setProperty("browser", "saphari");
		p.setProperty("url","http://localhost:8888");
		p.setProperty("username", "admin");
		p.setProperty("password", "admin");
		FileOutputStream f1 = new FileOutputStream("C:\\Users\\vishn\\OneDrive\\Desktop\\Commondata.properties");
		p.store(f1,"inserttestdata");
		FileInputStream fis = new FileInputStream("C:\\Users\\vishn\\OneDrive\\Desktop\\Commondata.properties");
		//step2: create the obj of properties class and load all the keys
		//Properties pro = new Properties();
		p.load(fis);
		//step3: read the value using getproperty()
		String BROWSER = p.getProperty("browser");
		//String BROWSER = pro.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		

	}
	}


