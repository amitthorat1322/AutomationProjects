package DDTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DPClass {
	
	private static  XSSFWorkbook workbook;
	private static  XSSFSheet sheet ;
	private static  XSSFRow row ;
	private static  XSSFCell cell;
	
	@DataProvider(name="testdata")
	public Object[][] getExcelData() throws IOException
	{
		FileInputStream fis = new FileInputStream("E:/a.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Amit");
		
		int rowcount =  sheet.getLastRowNum()+1;
		int collcount = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowcount][collcount];
		
		for(int i=1;i<rowcount;i++)
		{
		//	Row w = sheet.getRow(i);
			
			for(int j=0;j<collcount;j++)
			{
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		return data;		
	}

}
