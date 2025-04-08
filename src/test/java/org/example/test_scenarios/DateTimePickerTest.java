package org.example.test_scenarios;

import org.example.base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.example.test_scenarios.DropDownHandlingElements.*;

public class DateTimePickerTest extends TestBase {
	DateTimePickerElements dateTimePickerElements;
	
	public DateTimePickerTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		Thread.sleep(2000);
		dateTimePickerElements = new DateTimePickerElements();
	}
	
	@Test(priority = 1)
	public void validateDateTimePicker() throws InterruptedException {
		dateTimePickerElements.monthYearSelection("7", "September", "2026");
	}
	
	
	@AfterMethod
	public void closeTest() {
		if (driver != null)
			driver.quit();
	}
}
