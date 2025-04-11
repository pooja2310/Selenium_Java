package org.example.test_scenarios;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class BrowserPopUpWindowElements extends TestBase {
	public void popUpWindow() {
		driver.findElement(By.xpath("//button[@title='New Tab']")).click();
//		driver.findElement(By.xpath("//button[text()='New Window']")).click();
//		driver.findElement(By.xpath("//button[text()='New Window Message']")).click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		Set<String> windowHandler = driver.getWindowHandles();
		Iterator<String> it = windowHandler.iterator();
		String parentWindow = it.next();
		System.out.println("Parent window id: " + parentWindow);
		String childWindow = it.next();
		System.out.println("Child window id: " + childWindow);
		driver.switchTo().window(childWindow);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		System.out.println(driver.getTitle());
	}
}
