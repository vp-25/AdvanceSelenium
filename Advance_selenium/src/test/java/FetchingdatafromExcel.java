import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingdatafromExcel {

	public static void main(String[] args) throws Throwable 
	{
		//Step1: path connection
		String path = "C:\\Users\\vishn\\OneDrive\\Desktop\\excel2.xlsx";
		FileInputStream fis = new FileInputStream(path);
		//Step2: keeps the workbook/excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		//step 3: navigate into mentioned sheetname
		Sheet sheet = book.getSheet("Sheet1");	
		//step 4: navigate into memtioned rownum
		Row row = sheet.getRow(2);
		Row row1 = sheet.createRow(5);
		Row row2 = sheet.getRow(2);
		//step 5: navigate into mentioned cell
		Cell cell = row.getCell(1);
		Cell cel = row1.createCell(1);
		Cell cel2 = row2.getCell(3);
		//step 6: fetch the cell value 
		//String data = cell.getStringCellValue();
		DataFormatter f = new DataFormatter();
		String data = f.formatCellValue(cel2);
		System.out.println(data);
		cel.setCellValue("qspiders");
		cell.setCellValue("Automation");
		FileOutputStream out = new FileOutputStream(path);
		book.write(out);
		System.out.println("Data is written");
	}

}
