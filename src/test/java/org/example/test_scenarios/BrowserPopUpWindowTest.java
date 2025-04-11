package org.example.test_scenarios;

import org.example.base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
/*
1- Alert pop up- we accept and dismiss
2- Browser pop up- we use window handler api- getwindowhandles()
3- File upload pop up- we use sendkeys for that system pop up . Make sure type is file for that matter
 */

public class BrowserPopUpWindowTest extends TestBase {
	BrowserPopUpWindowElements browserPopUpWindowElements;
	
	public BrowserPopUpWindowTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		Thread.sleep(2000);
		browserPopUpWindowElements = new BrowserPopUpWindowElements();
	}
	
	@Test(priority = 1)
	public void validateWindowPopUp() {
		browserPopUpWindowElements.popUpWindow();
	}
	
	
	@AfterMethod
	public void closeTest() {
		if (driver != null)
			driver.close();
	}
}
