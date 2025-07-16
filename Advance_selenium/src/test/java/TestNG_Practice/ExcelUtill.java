package TestNG_Practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtill {
    public static Object[][] readExcelData(String filePath, String sheetName) throws Exception {
        FileInputStream fis = new FileInputStream(filePath); 
        Workbook wb = WorkbookFactory.create(fis); 
        Sheet sheet = wb.getSheet(sheetName); 

        int lastRow = sheet.getLastRowNum(); // e.g., 10 for 10 data rows
        Row headerRow = sheet.getRow(0);
        int colCount = (headerRow != null) ? headerRow.getLastCellNum() : 0;

        Object[][] data = new Object[lastRow][colCount];

        for (int i = 1; i <= lastRow; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = (row == null) ? null : row.getCell(j);
                data[i - 1][j] = (cell == null) ? "" : cell.toString();
            }
        }

        wb.close();
        fis.close();
        return data;
    }
}
