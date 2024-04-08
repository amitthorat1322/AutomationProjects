package TestResult;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.trail.proj.Base.TBase;
import com.trail.proj.pages.DemoQAPages;

public class DemoQAPagesTestCase extends TBase{

	DemoQAPages demoqa;
	
	@BeforeClass
	public void setup()
	{
		initalization();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public void end()
	{
		driver.quit();
	}
	
	
	
	
}
