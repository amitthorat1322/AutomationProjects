package TestResult;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.trail.proj.Base.TBase;
import com.trail.proj.pages.PracticePage;

import DDTest.DPClass;

public class PracticePageTest extends TBase{
	
	
	PracticePage practicePage;
	@BeforeClass
	public void Setup()
	{
		initalization();
		practicePage = new PracticePage();
		//driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
		
	}
	
	/*
	 * @Test(enabled = false) public void SelectGender() {
	 * practicePage.SelectMaleRadioButton();
	 * Assert.assertEquals(practicePage.SelectMaleRadioButton(), true);
	 * 
	 * }
	 * 
	 * @Test public void MultiCheckSelectGenderButton() { String[] radioButton =
	 * {"male","female","other"}; for(String select : radioButton) {
	 * practicePage.MultipleRadioSelect(select);
	 * Assert.assertTrue(practicePage.isMultipleRadioSelected(select), select +
	 * " should be selected"); }
	 * 
	 * }
	 */
	
	@Test(enabled = false)
	public void SelectGender() 
	{
		 practicePage.SelectMaleRadioButton();
		 Assert.assertTrue(practicePage.isMaleRadioButtonSelected(), "Male Selected");
	}
	
	@Test(enabled = false)
	public void SelectDD()
	{
		practicePage.SelectDropDown();
	}
	
	@Test(enabled = false)
	public void WindowHandleTest()
	{
		driver.get("https://demoqa.com/browser-windows");
		String f = driver.getWindowHandle();
		System.out.println("window name is:-"+f);
	}
	@Test(enabled=false)
	public void checkMultipleWindows()
	{
		driver.get("https://demoqa.com/browser-windows");
		driver.findElement(By.id("windowButton")).click();
		String mainWindow = driver.getWindowHandle();
		
		Set<String> multiWindows = driver.getWindowHandles();
		
		 Iterator<String> i1 = multiWindows.iterator();
		while(i1.hasNext())
		{
			String w = i1.next();
			 System.out.println("Other Windows"+w);
			
			 if(!mainWindow.equals(w))
			{
				 driver.switchTo().window(w);
				 driver.close();
				 System.out.println("Child Window Closed");
			}
		}
	}
	@Test(enabled=false)
	public void validateTextBox()
	{
		driver.get("https://demoqa.com/text-box");
		//practicePage.TextBox();
		practicePage.TextBoxViaJE();
	}
	
	
	@Test(enabled=false)
	@Parameters({"name","email","caddress","paddress"})
	public void validateByParameters(String name,String email,String caddress,String paddress)
	{
		driver.get("https://demoqa.com/text-box");
		practicePage.ByParameter(name, email, caddress, paddress);
	}
	
	@Test(dataProvider="testdata" , dataProviderClass = DPClass.class)
	public void uisngDataProvider(String name,String email,String caddress,String paddress)
	{
		driver.get("https://demoqa.com/text-box");
		practicePage.byDataProvider(name, email, caddress, paddress);
		
	}
	@AfterClass
	public void tear()
	{
		driver.quit();
	}
}
