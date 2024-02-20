package TestResult;

import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import org.testng.asserts.SoftAssert;

import com.sun.tools.sjavac.Log;
import com.trail.proj.Base.TBase;
import com.trail.proj.pages.LoginPage;

import DDTest.DataProviderClass;
import DDTest.LoggerClass;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class LoginPageTest extends TBase{

	LoginPage loginpage;
	static final Logger log = Logger.getLogger(LoginPageTest.class);
	
	
	public void setup()
	{
		initalization();
		loginpage = new LoginPage();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		PropertyConfigurator.configure("E:\\programs\\proj\\log4j.properties");
	}
	
	@Test(priority = 1,enabled = false)
	public void validateCurrentUrl()
	{
		SoftAssert softAssert = new SoftAssert();
		String cURL = loginpage.getCurrentUrl();
		AssertJUnit.assertEquals(cURL,"https://parabank.parasoft.com/parabank/index.htm");
	
	}
	
	@Test(dependsOnMethods = "vcheckInvalidLogin",enabled = false)
	public void validateTitle()
	{
		SoftAssert softAssert = new SoftAssert();
		String TitleVerify = loginpage.getPageTitle();
		AssertJUnit.assertEquals(TitleVerify,"ParaBank | Errorsss");
		if (driver.getTitle().equals("ParaBank | Errorsss")) {
			System.out.println("YES");
			log.info("Sucess");
		} 
		else
		{
			System.out.println("NO");
			log.error("Failed");
		}
		
	}
	@Parameters({"Username","Password"})
	@Test(enabled = false)
	public void validateLogin(String name,String pass)
	{
	//	loginpage.login("jyoti", "jyoti@123");
	/*
	 * loginpage.setName("amit"); loginpage.setPass("jyoti@123");
	 */
		loginpage.setName(name);
		loginpage.setPass(pass);
		loginpage.setClick();
		driver.navigate().back();
	}
	
	@Test(dataProvider = "logincredentials" , dataProviderClass = DataProviderClass.class,enabled = false )
	public void vcheckInvalidLogin(String username1,String password1)
	{
		loginpage.setName(username1);
		loginpage.setPass(password1);
		loginpage.setClick();	
		log.info("Click on login");
		driver.navigate().back();
		
	}

	@Test(enabled=false)
	public void voidDtable() {

		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
			WebElement s = driver.findElement(By.xpath("//table[@class='dataTable']"));
			
			List<WebElement> trow = s.findElements(By.tagName("tr"));
			
			int rowCount = trow.size();
			System.out.println("Tr:-"+rowCount);
			List<WebElement> thead = s.findElements(By.tagName("th"));
			
			for(int head = 0;head<thead.size();head++)
			{
				System.out.println("Head is:-"+thead.get(head).getText());
			}
			for(int i=0;i<rowCount;i++)
			{
				List<WebElement> tcol = trow.get(i).findElements(By.tagName("td"));
				int colCount = tcol.size();
				System.out.println("Rows:-"+i+"Col:-"+colCount);
				for(int j=0;j<colCount;j++)
				{
					
					  String data = tcol.get(j).getText();
					  System.out.println("Cell Value of row number " + i + " and column number " +
					  j + " Is " + data);
					String data1 = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr/td["+(j+1)+"]")).getText();
					String datas = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]")).getAttribute("td");
					System.out.println("asdasd:"+datas);
					System.out.println("Data is :-"+data1);
					
				}
	    	    System.out.println("-------------------------------------------------- ");
				
	    	    
			}
	}
	
	@Test(enabled = false)
	public void amazonDropdown()
	{
		driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=155259815513&hvpone=&hvptwo=&hvadid=676742245123&hvpos=&hvnetw=g&hvrand=12706191631117004662&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062116&hvtargid=kwd-10573980&hydadcr=14453_2367553");
		WebElement dropd = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select sd = new Select(dropd);
		
		List<WebElement> dpd = sd.getOptions();
		for(WebElement dropds : dpd)
		{
			String sg = dropds.getText();
			System.out.println("Sg:-"+sg);
			if(dropds.getText().contains("Baby"))
			{
				dropds.click();
			}
		}
	}
	@Test(enabled = false)
	public void wiki()
	{
		driver.get("https://www.wikipedia.org/");
		
		List<WebElement> s = driver.findElements(By.xpath("//nav[@class ='central-featured']/child::div[@dir='ltr']"));
		
		int c=s.size();
		System.out.println("Size is:-"+c);
		
		for(WebElement ck : s)
		{
			if(ck.getAttribute("lang").contains("ja"))
			{
				ck.click();
				driver.navigate().back();
			}
		}
	}
	@Test(enabled = false)
	public void s() {
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.navigate().refresh();
		List<WebElement> s = driver.findElements(By.xpath("//*[starts-with(@id,'desktop')]"));
		
		System.out.println("s:-"+s.size());
		WebElement ssd =driver.findElement(By.xpath("//*[@class='a-cardui-header']/child::*[contains(text(),'Gaming accessories')]/preceding::div[starts-with(@id,'desktop')]/ancestor::div[@id='gw-layout']"));

			if (ssd.getText().contains("Gaming accessories")) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		
	}
	
	@Test(enabled=false)
	public void mytrip()
	{
		String expectedSearchTerm = "Pune, India";
		driver.get("https://www.makemytrip.com/flights/");
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		WebElement d = driver.findElement(By.xpath("//*[@id='fromCity']"));
		WebDriverWait s = new WebDriverWait(driver,120);
		s.until(ExpectedConditions.visibilityOf(d));
		d.click();
		WebElement placeholder =driver.findElement(By.xpath("//input[@type='text' and @placeholder='From'] "));
	       List<WebElement> autoSuggestionList = driver.findElements(By.xpath("//*[@role='option']/ancestor::div[@class='flt_fsw_inputBox searchCity inactiveWidget activeWidget']"));
	       	System.out.println("Cl:"+autoSuggestionList.size());
	       // to traverse the list and navigate to required suggestion search results
	       for (WebElement autoSuggestion : autoSuggestionList) {
	           System.out.println("Auto Suggestion Value : " + autoSuggestion.getText());
	           if (autoSuggestion.getText().equalsIgnoreCase(expectedSearchTerm)) {
	               System.out.println("\nFound required value in auto suggestion list. Clicking on it now\n");
	               placeholder.sendKeys(expectedSearchTerm);
	               autoSuggestion.click();
	               break;
	           }
	       }
	     
	       
	}
	
	@Test
	public void checkTable() throws IOException
	{
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
		WebElement totaltable = driver.findElement(By.xpath("//table[@class='dataTable']"));
	
		List<WebElement> totalRows = totaltable.findElements(By.tagName("tr"));
		
		System.out.println("Total Rows:-"+totalRows.size());
		
		for(int i=0;i<totalRows.size();i++)
		{
			List<WebElement> totalCols = totalRows.get(i).findElements(By.tagName("td"));
			
			int totalColsCount =  totalCols.size();
			System.out.println("Col Count :-"+totalColsCount);
			
			for(int j=0;j<totalColsCount;j++)
			{
				String s = totalCols.get(j).getText();
				if(totalCols.get(j).getText().contains("Deepak Fertilisers"))
				{
					String data12 = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]")).getText();
					System.out.println("asdasd:"+data12);
				}	
				 
			}
			TakesScreenshot ts = (TakesScreenshot)driver;
			File c = ts.getScreenshotAs(OutputType.FILE);
			File d = new File(" ");
			FileUtils.copyFile(c, d);
			
			driver.get("https://maharerait.mahaonline.gov.in/PrintPreview/PrintPreview?q=9K1ErN3XXkStL6MeweQ6XFLvt8uCfwKPw1KXsRiVSE1TeKVSEVZJMdLYk8chnSJbUICp4C50w8QDAttSHw0AB742ZaJoHi%2fTo3FhdgwBkR2XxtQ7rnbtX0BRRsEg2pQR5wR%2fYDBglAeQNVXbj8mxh6jC2vvQMKJLQpS%2foPP6eaHsXiY7C23%2b4Q%3d%3d");
			
			
		}
	}
}

