package org.example.test_scenarios;

import org.example.base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksTest extends TestBase {
	BrokenLinks brokenLinks;
	String link;
	
	public BrokenLinksTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		Thread.sleep(2000);
		brokenLinks=new BrokenLinks();
	}
	
	@Test
	public void validateBrokenLink(){
		brokenLinks.countOfLinks();
	}
	
	@AfterMethod
	public void closeTest() {
		if (driver != null)
			driver.quit();
	}
	
}
