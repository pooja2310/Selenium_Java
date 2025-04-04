package org.example.login;

import org.example.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WorldometersDynamicElementsTest extends TestBase {
	WorldometersDynamicElements wde;
//	String current_population = "//div//span[@rel='current_population']";
	String todays_population ="";
	String years_population ="";
	
	public WorldometersDynamicElementsTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		Thread.sleep(2000);
		wde = new WorldometersDynamicElements();
	}
	
	@Test
	public void validateDynamicElements() throws InterruptedException {
        Thread.sleep(2000);
		wde.validateAndPrintData();
	}
	
	@AfterMethod
	public void closeTest() {
		if (driver != null)
			driver.quit();
	}
	
}
