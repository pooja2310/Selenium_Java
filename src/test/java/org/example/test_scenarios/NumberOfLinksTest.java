package org.example.test_scenarios;

import org.example.base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NumberOfLinksTest extends TestBase
{
	NumberOfLinks numberOfLinks;
	
	public NumberOfLinksTest (){
	  super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		Thread.sleep(2000);
		numberOfLinks=new NumberOfLinks();
	}
	
	@Test
	public void countOfLinks(){
		numberOfLinks.countOfLinks();
	}
	
	@AfterMethod
	public void closeTest() {
		if (driver != null)
			driver.quit();
	}
	
}
