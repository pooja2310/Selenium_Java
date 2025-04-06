package org.example.test_scenarios;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NumberOfLinks extends TestBase {
	public void countOfLinks() {
		List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
		System.out.println(listOfLinks.size());
		for (int i = 0; i < listOfLinks.size(); i++) {
			System.out.println(listOfLinks.get(i).getText());
		}
	}
}
