package com.trail.proj.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.trail.proj.Base.TBase;
import com.trail.proj.utils.RadioUtility;

public class PracticePage extends TBase{

	@FindBy(xpath="//input[@type='radio' and @value='male']")
	private WebElement MaleRationButton;
	
	@FindBy(xpath="//input[@type='radio' and @value='female']")
	private WebElement FeMaleRationButton; 
	
	@FindBy(xpath="//input[@type='radio' and @value='other']")
	private WebElement OtherRationButton; 
	
	
	@FindBy(xpath="//input[@value='Bike']")
	private WebElement CheckboxSelectBike;
	
	@FindBy(xpath="//input[@value='Car']")
	private WebElement CheckboxSelectCar;
	
	@FindBy(xpath="//div[@class='et_pb_blurb_description']//select")
	private WebElement SelectDropDown;
	
	@FindBy(xpath="//input[@id='userName']")
	private WebElement TextBox;
	@FindBy(xpath="//input[@id='userEmail']")
	private WebElement Email;
	@FindBy(xpath="//textarea[@id='currentAddress']")
	private WebElement CurAddress;
	@FindBy(xpath="//textarea[@id='permanentAddress']")
	private WebElement PerAddress;
	
	public void TextBox()
	{
		TextBox.sendKeys("Amit Shivaji Thorat");
		Email.sendKeys("amit94thorat@gmail.com");
		CurAddress.sendKeys("Pune");
		PerAddress.sendKeys("Pune");
	}
	
	public void TextBoxViaJE()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='amit shivaji thorat'", TextBox);
		js.executeScript("arguments[0].value='amit94thorat@gmail.com'", Email);
		js.executeScript("arguments[0].value='pune'", CurAddress);
		js.executeScript("arguments[0].value='Pune'", PerAddress);
	
	}
	
	public void ByParameter(String name,String email,String caddress,String paddress)
	{
		TextBox.sendKeys(name);
		Email.sendKeys(email);
		CurAddress.sendKeys(caddress);
		PerAddress.sendKeys(paddress);
	}
	
	
	public void byDataProvider(String name,String email,String caddress,String paddress)
	{
		TextBox.sendKeys(name);
		Email.sendKeys(email);
		CurAddress.sendKeys(caddress);
		PerAddress.sendKeys(paddress);
	}
	
	public PracticePage()
	{
		PageFactory.initElements(driver,this);
	}
	public boolean isMaleRadioButtonSelected()
	{
		return RadioUtility.isRadioButtonSelected(MaleRationButton);
	}
	
	public void SelectMaleRadioButton()
	{
		RadioUtility.selectRadioButton(MaleRationButton);
	}
	
	public void SelectDropDown()
	{
		Select S = new Select(SelectDropDown);
		List<WebElement> sdd = S.getOptions();
		for(WebElement DD : sdd)
		{
			String TextReceived = DD.getText();
		}
	}
	
	/*
	 * public void MultipleRadioSelect(String optionRadio) { switch(optionRadio) {
	 * case "male": MaleRationButton.click(); break; case "female":
	 * FeMaleRationButton.click(); break; case "other": OtherRationButton.click();
	 * break; default: System.out.println("Invalid option: " + optionRadio); break;
	 * } }
	 */
	
	
}
