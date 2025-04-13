package org.example.test_scenarios;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragNDropElements extends TestBase {
	public void actionClass() throws InterruptedException {
		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//span//div[text()='Interactions']"))).build().perform();
//		Thread.sleep(3000);
//		WebElement element = driver.findElement(By.xpath("//ul[@class='menu-list']//li//span[@class='text' and text()='Droppable']"));
//		if (element.isDisplayed()) {
//			element.click();
//
//		}
//		System.out.println("Element is clickable");
		WebElement sourceElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
		
		action.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();
		Thread.sleep(5000);
		System.out.println("Element is drag and dropped");
	}
}
