import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class linktext {

	public static void main(String[] args) throws Throwable 
	{
		String path = "C:\\Users\\vishn\\OneDrive\\Desktop\\links.xlsx";
		FileInputStream fis = new FileInputStream(path);
		//Step2: keeps the workbook/excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
		for(int i=0;i<alllinks.size();i++) {
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(alllinks.get(i).getAttribute("href"));
		}
	FileOutputStream fos = new FileOutputStream("C:\\Users\\vishn\\OneDrive\\Desktop\\links.xlsx");
	book.write(fos);
	// Step 4: Read from Excel and print to console
    DataFormatter formatter = new DataFormatter();
    int rowCount = sheet.getLastRowNum();

    for (int i = 0; i <= rowCount; i++) {
        Row row = sheet.getRow(i);
        if (row != null) {
            Cell cell = row.getCell(0);
            if (cell != null) {
                String url = formatter.formatCellValue(cell);
                System.out.println("Link " + (i + 1) + ": " + url);
            }
        }
    }
    book.close();
    driver.quit();
	}

}
