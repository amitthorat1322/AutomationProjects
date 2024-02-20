package com.trail.proj.Base;


import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TBase {

	protected static WebDriver driver;
	
	@BeforeClass
	public static void initalization()
	{	
		System.setProperty("webdriver.chrome.driver","E:/drivers/chromedriver.exe");
		driver= new ChromeDriver();
		
	}
	
	@AfterClass
	public static void teardown()
	{
		driver.quit();
	}
}
