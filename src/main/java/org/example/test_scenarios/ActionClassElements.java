package org.example.test_scenarios;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClassElements extends TestBase {
	
	public void actionClass() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span//div[text()='Elements']"))).build().perform();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//ul[@class='menu-list']//li//span[@class='text' and text()='Text Box']"));
		if (element.isDisplayed()) {
			element.click();
			
		}
		System.out.println("Element is clickable");
		
	}
}
