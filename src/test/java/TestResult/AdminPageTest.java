package TestResult;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.trail.proj.Base.TBase;
import com.trail.proj.pages.AdminPage;
import com.trail.proj.pages.LoginPage;

public class AdminPageTest 
	extends TBase{

		AdminPage adminpage;
		
		@BeforeClass
		public void setup()
		{
			initalization();
			adminpage = new AdminPage();
			driver.get("https://parabank.parasoft.com/parabank/admin.htm");
		}
		
		@Test
		public void Selectstatement()
		{
			adminpage.getAllOptions();
		}
		
		

}
