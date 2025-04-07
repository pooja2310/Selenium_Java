package org.example.test_scenarios;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.example.test_scenarios.DropDownHandlingElements.*;

public class DropDownHandlingTest extends TestBase {
	public DropDownHandlingTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		Thread.sleep(2000);
		new DropDownHandlingElements();
	}
	
	@Test(priority = 1, enabled = false)
	public void validateDropDown() throws InterruptedException {
		dropDownSelection(country_drp, "text", "India");
		System.out.println("Text is selected");
		Thread.sleep(5000);
	}
	
	@Test(priority = 0)
	public void validateDropDown2() throws InterruptedException {
		dropDownSelection(option_drp, "index", "2");
		System.out.println("Index is selected");
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void closeTest() {
		if (driver != null)
			driver.quit();
	}
}
