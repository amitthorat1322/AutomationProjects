package com.trail.proj.pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

import com.trail.proj.Base.TBase;

public class AdminPage2 extends TBase {

	
	AdminPage2 adminpage;
	@BeforeClass
	public void setup()
	{
		initalization();
		adminpage = new AdminPage2();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	}
	
	
	

	public void getAllOptions()
	{
		Select multiSelectDd =  new Select(driver.findElement(By.xpath("//select[@id='loanProvider']")));
		final List<WebElement> allOptions = multiSelectDd.getAllSelectedOptions();
		
		final int size = allOptions.size();
		for(WebElement options : allOptions)
		{
			
					  multiSelectDd.selectByIndex(1);
		}
	} 
}
