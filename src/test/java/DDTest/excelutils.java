package DDTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class excelutils {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;
	

	@DataProvider(name="am")
    public Object[][] readValueFromExcel() throws IOException
    {
        FileInputStream fis = new FileInputStream("E:\\c.xlsx");
        ExcelWBook = new XSSFWorkbook(fis);
        ExcelWSheet = ExcelWBook.getSheet("Amit");
        int rowCount = ExcelWSheet.getLastRowNum()+1;
        int colCount = ExcelWSheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][colCount];
        for(int i=0;i<rowCount;i++)
        {
        	//Row = ExcelWSheet.getRow(i);
            for(int j=0;j<colCount;j++)
            {
               // Cell = ExcelWSheet.getRow(i).getCell(j);
                data[i][j] = ExcelWSheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return data;
    }
    
    
    @Test(dataProvider="am")
    public void d(String data1,String data2,String data3)
    {
         System.out.println("Data from Excel: " + data1 + ", " + data2+ ", "+data3);
    }
}

