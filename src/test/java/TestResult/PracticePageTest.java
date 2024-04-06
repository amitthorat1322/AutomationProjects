package TestResult;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.trail.proj.Base.TBase;
import com.trail.proj.pages.PracticePage;

public class PracticePageTest extends TBase{
	
	
	PracticePage practicePage;
	@BeforeClass
	public void Setup()
	{
		initalization();
		practicePage = new PracticePage();
		driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
		
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
	
	@Test
	public void SelectGender() 
	{
		 practicePage.SelectMaleRadioButton();
		 Assert.assertTrue(practicePage.isMaleRadioButtonSelected(), "Male Selected");
	}
	
	@Test
	public void SelectDD()
	{
		practicePage.SelectDropDown();
	}
	@AfterClass
	public void tear()
	{
		driver.close();
	}
}
