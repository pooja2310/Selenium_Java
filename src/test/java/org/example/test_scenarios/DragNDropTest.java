package org.example.test_scenarios;

import org.example.base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragNDropTest extends TestBase {
	DragNDropElements dragNDropElements;
	
	public DragNDropTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		Thread.sleep(2000);
		dragNDropElements = new DragNDropElements();
	}
	
	@Test(priority = 1)
	public void validateActionClass() throws InterruptedException {
		dragNDropElements.actionClass();
	}
	
	
	@AfterMethod
	public void closeTest() {
		if (driver != null)
			driver.quit();
	}
}
