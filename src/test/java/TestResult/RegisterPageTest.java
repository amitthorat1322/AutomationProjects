package TestResult;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.trail.proj.Base.TBase;
import com.trail.proj.pages.LoginPage;
import com.trail.proj.pages.RegisterPage;

@Ignore
public class RegisterPageTest extends TBase{

	RegisterPage regPage;
	//private static Logger log = Logger.getLogger(RegisterPage.class);
	
	@BeforeClass
	public void setup()
	{
		initalization();
		regPage = new RegisterPage();
		driver.get("https://parabank.parasoft.com/parabank/register.htm");
	}
	
	
	@Test
	public void registerNewUser()
	{
		regPage.RegNewUser("amit","thorat","Pune","Pune","Maharashtra","411041","860553172","SAS","jyoti","jyoti@123","jyoti@123");
		System.out.println("Registration Done");
	}
}
