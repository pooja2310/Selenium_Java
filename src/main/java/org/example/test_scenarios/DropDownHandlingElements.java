package org.example.test_scenarios;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandlingElements extends TestBase {
	
	static By country_drp = By.id("country");
	static By option_drp = By.id("dropdown");
	
	/*
    To handle multiple dropdown using one function.
   */
	public static void dropDownSelection(By locator, String type, String value) {
		Select select = new Select(driver.findElement(locator));
		
		/*Normal way to select value from dropdown
		Select select1= new Select(driver.findElement(country_drp));
		select1.selectByVisibleText("India");
		Select select2= new Select(driver.findElement(option_drp));
		select2.selectByVisibleText("Option 2");*/
		
		switch (type) {
			case "index":
				select.selectByIndex(Integer.parseInt(value));
				break;
			case "text":
				select.selectByVisibleText(value);
				break;
			case "value":
				select.selectByValue(value);
				break;
			default:
				System.out.println("Provide the correct input");
				break;
		}
		
		
	}
	
}
