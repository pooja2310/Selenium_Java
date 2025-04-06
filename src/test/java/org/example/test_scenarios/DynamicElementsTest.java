package org.example.test_scenarios;

import org.example.base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicElementsTest extends TestBase {
	
	DynamicElements wde;
	
	public DynamicElementsTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		Thread.sleep(2000);
		wde = new DynamicElements();
	}
	
	@Test
	public void validatePopulation() throws InterruptedException {
			wde.validateCurrentPopulation(wde.current_population);
			wde.validateTodaysAndYearPopulationData(wde.today_population, wde.year_population);
		}
	
	@AfterMethod
	public void closeTest() {
		if (driver != null)
			driver.quit();
	}
	
}
