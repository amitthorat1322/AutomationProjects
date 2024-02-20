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

public class excelutils {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;
	
	public static void main(String args[])
	{
		 FileInputStream ExcelFile;
		try {
			ExcelFile = new FileInputStream("E:\\c.xlsx");
		
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			
			ExcelWSheet = ExcelWBook.getSheet("Amit");
			
			int rc = ExcelWSheet.getLastRowNum()+1;
			int cc = 2;
			for(int i=0;i<rc;i++)
			{
				for(int j=0;j<cc;j++)
				{
					Cell = ExcelWSheet.getRow(i).getCell(j);
					String S = Cell.getStringCellValue();
					System.out.println("C:-"+S);
				}
			}
			
			
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
}
	}

