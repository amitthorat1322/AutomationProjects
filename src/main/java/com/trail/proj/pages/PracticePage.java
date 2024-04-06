package com.trail.proj.pages;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
