import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DDTpractice_file {

	public static void main(String[] args) throws Throwable 
	{   //step1: connect to path
		FileInputStream fis = new FileInputStream("C:\\Users\\vishn\\OneDrive\\Desktop\\Commondata.properties");
		//step2: create the obj of properties class and load all the keys
		Properties pro = new Properties();
		pro.load(fis);
		//step3: read the value using getproperty()
		String BROWSER = pro.getProperty("browser");
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

	}

}
