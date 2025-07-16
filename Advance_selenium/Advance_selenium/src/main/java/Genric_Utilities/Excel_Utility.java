package Genric_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

public class Excel_Utility {

    /**
     * This method is used to fetch data from an Excel file
     * @param sheetName
     * @param rowNum
     * @param cellNum
     * @return String value from the specified cell
     * @throws Throwable
     */
    public String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable {
        FileInputStream fis = new FileInputStream("C:\\Users\\vishn\\OneDrive\\Desktop\\CommonExcel.xlsx");
        Workbook book = WorkbookFactory.create(fis);
        Sheet sheet = book.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(cellNum);
        return cell.getStringCellValue();
    }
    
    public String getExcelDataUsingFormatter(String SheetName,int rowNum,int cellNum) throws Throwable {
    	 FileInputStream fis = new FileInputStream("C:\\Users\\vishn\\OneDrive\\Desktop\\CommonExcel.xlsx");
         Workbook book = WorkbookFactory.create(fis);
         Sheet sheet = book.getSheet(SheetName);
         Row row2 = sheet.getRow(rowNum);
			Cell cell1 = row2.getCell(cellNum);
			DataFormatter format = new DataFormatter();
			String ExcelData= format.formatCellValue(cell1);
			System.out.println(ExcelData);
    	
    	return ExcelData;
    	
    }
}
