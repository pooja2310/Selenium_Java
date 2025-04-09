package org.example.test_scenarios;

import org.example.base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesHandlingTest extends TestBase {
	
	FramesHandlingElements framesHandlingElements;
	
	public FramesHandlingTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		Thread.sleep(2000);
		framesHandlingElements = new FramesHandlingElements();
	}
	
	@Test(priority = 1)
	public void validateFrame() {
		framesHandlingElements.frameSwitch();
	}
	
	
	@AfterMethod
	public void closeTest() {
		if (driver != null)
			driver.quit();
	}
}
