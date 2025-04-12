package org.example.test_scenarios;

import org.example.base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionClassTest extends TestBase {
	ActionClassElements actionClassElements;
	
	public ActionClassTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		Thread.sleep(2000);
		actionClassElements = new ActionClassElements();
	}
	
	@Test(priority = 1)
	public void validateActionClass() {
	
	}
	
	
	@AfterMethod
	public void closeTest() {
		if (driver != null)
			driver.quit();
	}
}
