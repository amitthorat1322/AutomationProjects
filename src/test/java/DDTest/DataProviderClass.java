package DDTest;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name="logincredentials")
	public Object[][] loginData()
	{
		return new Object[][]
				{
			{"amit","amit@123"},
			{"amist","amit@123"}
				};
	}
}
