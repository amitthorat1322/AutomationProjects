package com.trail.proj.Base;


import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


public class TBase {

	protected static WebDriver driver;
	
	@BeforeSuite
	public static void initalization()
	{	
		System.setProperty("webdriver.chrome.driver","E:/finaldriver/chromedriver.exe");
		driver= new ChromeDriver();
	}
	
	@AfterSuite
	public static void teardown()
	{
		driver.quit();
	}
}
