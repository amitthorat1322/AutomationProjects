package TestResult;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.trail.proj.utils.SelectClass;


public class TrailCode  extends SelectClass{

	@Test
	public void start() throws IOException
	{
		
		WebDriver driver ;
		System.setProperty("webdriver.chrome.driver","E:/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
		/*
		 * driver.findElement(By.xpath("//a[@id='idExample']")).click();
		 * driver.navigate().back();
		 * 
		 * driver.findElement(By.name("button1")).click(); String currentURL=
		 * driver.getCurrentUrl(); Assert.assertEquals(currentURL,
		 * "https://ultimateqa.com/button-success/?button1=");
		 */
		//driver.findElement(By.xpath("//a[normalize-space()="Go to login page"]")).click();
		//driver.navigate().back();
		
		/*
		 * List<WebElement> col =
		 * driver.findElements(By.xpath("//table[@id='htmlTableId']/tbody/tr[1]/th"));
		 * System.out.println("Col in table are:-"+col.size());
		 * 
		 * for(WebElement s : col) { String g = s.getText();
		 * System.out.println("D:-"+g); if(g.equalsIgnoreCase("Title")) {
		 * System.out.println("Test Passed"); } else { System.out.println("Not Passed");
		 * } }
		 * 
		 * List<WebElement> fd =
		 * driver.findElements(By.xpath("//table[@id='htmlTableId']/tbody/tr/td"));
		 * System.out.println("Size found is:-"+fd.size()); String fddd=""; int count=0;
		 * if(fd.contains("Automation")) { System.out.println("Found"); } else {
		 * System.out.print("could not be found"); }
		 * 
		 * WebElement d = driver.findElement(By.linkText("Click this link")); d.click();
		 * driver.navigate().back(); WebElement ss =
		 * driver.findElement(By.xpath("//*[@class='et_pb_blurb_description']/select"));
		 * Select sb = new Select(ss); sb.selectByIndex(2);
		 * 
		 * WebElement mytable =
		 * driver.findElement(By.xpath("//table[@id='htmlTableId']/tbody"));
		 * List<WebElement> rows = mytable.findElements(By.tagName("tr")); int row_count
		 * = rows.size(); for(int i=0;i<row_count;i++) { List<WebElement> column =
		 * rows.get(i).findElements(By.tagName("td")); int column_count = column.size();
		 * for(int j=0;j<column_count;j++) { String is = column.get(j).getText();
		 * System.out.println("Row is:-"+i+"Column is:-"+j+"Value is:-"+is);
		 * 
		 * if(is.equals("Automation")) { count++; } } }
		 * System.out.println("Count is:-"+count); driver.findElement(By.xpath(
		 * "//*[contains(@class,'et_pb_blurb_11')]//ancestor::button")).click();
		 * Assert.assertEquals(driver.getCurrentUrl(),
		 * "https://ultimateqa.com/button-success?"); driver.navigate().back();
		 * System.out.println("Done"); driver.findElement(By.
		 * xpath("//a[contains(@class,'et_pb_button et_pb_promo_button') and contains(text(),'Go to login page')]"
		 * )).click(); Assert.assertEquals(driver.getCurrentUrl(),
		 * "https://courses.ultimateqa.com/users/sign_in"); driver.navigate().back(); //
		 * driver.findElement(By.
		 * xpath("//*[contains(@class,'et_pb_toggle_0')][normalize-space()='Open toggle to read text']"
		 * )).click(); WebElement r =driver.findElement(By.xpath("//*[@value='male']"));
		 * r.click();
		 */
		  List<WebElement> checkBoxElementf = driver.findElements(By.xpath("//*[@type='checkbox']"));	
		  Select_The_Checkboxs(checkBoxElementf);
		  WebElement checkBoxElement = driver.findElement(By.xpath("//*[@type='checkbox']"));		
	      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(checkBoxElement));
		  Select_The_Checkbox(checkBoxElement);
		  System.out.println("OK");
		  DeSelect_The_Checkbox(checkBoxElement);
		  this.TakessResult(driver,"E:\\programs\\proj\\a.png");
		 System.out.print("-----------------------------------------------------------------------");
		 
			/*
			 * Actions dd = new Actions(driver); dd.selectDDL()
			 */
		 
	}

	
}