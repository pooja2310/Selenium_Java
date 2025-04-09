package org.example.test_scenarios;

import org.example.base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertPopupHandlingTest extends TestBase {
	
	AlertPopupHandlingElements alertPopupHandlingElements;
	
	public AlertPopupHandlingTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		Thread.sleep(2000);
		alertPopupHandlingElements = new AlertPopupHandlingElements();
	}
	
	@Test(priority = 1)
	public void validateAlert() {
		alertPopupHandlingElements.alertBtn();
	}
	
	
	@AfterMethod
	public void closeTest() {
		if (driver != null)
			driver.quit();
	}
}
