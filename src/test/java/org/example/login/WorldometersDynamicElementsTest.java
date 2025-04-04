package org.example.login;

import org.example.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WorldometersDynamicElementsTest extends TestBase {
	
	WorldometersDynamicElements wde;
	
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
