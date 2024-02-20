package com.trail.proj.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectClass {
	
	public void Select_The_Checkboxs(List<WebElement> checkBoxElementf) {

		int count= checkBoxElementf.size();
		System.out.println("Size is:-"+count);		
		for(int i=0;i<count;i++)
		{
			if(checkBoxElementf.get(i).isEnabled() && checkBoxElementf.get(i).isDisplayed())
			{
				System.out.println("In Mutiselect");
				checkBoxElementf.get(i).click();
			}
			else
			{
				System.out.println("No");
			}
		}
	}
	public void Select_The_Checkbox(WebElement element) {
		try {
            if (element.isSelected()) {
               System.out.println("Checkbox: " + element + "is already selected");
            } else {
            	// Select the checkbox
                element.click();
            }
        } catch (Exception e) {
        	System.out.println("Unable to select the checkbox: " + element);
        }
		
	}

	public void DeSelect_The_Checkbox(WebElement element) {
		try {
            if (element.isSelected()) {
            	//De-select the checkbox
                element.click();
            } else {
            	System.out.println("Checkbox: "+element+"is already deselected");
            }
        } catch (Exception e) {
        	System.out.println("Unable to deselect checkbox: "+element);
        }
    }		
	
	public void TakessResult(WebDriver driver, String filename) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File c = ts.getScreenshotAs(OutputType.FILE);
		File s = new File(filename);
		FileUtils.copyFile(c, s);
			}
}
