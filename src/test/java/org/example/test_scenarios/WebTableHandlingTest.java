package org.example.test_scenarios;

import org.example.base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTableHandlingTest extends TestBase {
	
	public WebTableHandlingTest() {
		super();
	}
	
	WebTableHandlingElements wthe;
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		Thread.sleep(2000);
		wthe = new WebTableHandlingElements();
	}
	
	@Test
	public void validateWebTableData() {
		wthe.webTableHandle();
	}
	
	@AfterMethod
	public void closeTest() {
		if (driver != null)
			driver.quit();
	}
}
