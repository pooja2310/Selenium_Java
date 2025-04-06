package org.example.test_scenarios;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DynamicElements extends TestBase {
	
	static String  current_population= "//div/span[@class='rts-counter' and @rel='current_population']";
	static String today_population= "//div[contains(text(),'today')]//parent::div//span[@class='rts-counter text-2xl font-bold']";
	
	static String year_population="//div[contains(text(),'This Year')]//parent::div//span[@class='rts-counter text-2xl font-bold']";
	public void validateCurrentPopulation(String locator) throws InterruptedException {
		int count = 0;
		while (count <= 20) {
			System.out.println("=============Current population count===============");
			List<WebElement> populationList = driver.findElements(By.xpath(locator));
			for (WebElement list1 : populationList) {
				System.out.println(list1.getText());
			}
			count++;
		}
		System.out.println("Total number of Records: " + count);
	}
	
	public void validateTodaysAndYearPopulationData(String today_locator,String year_locator) throws InterruptedException {
		int count = 0;
		while (count <= 20) {
			System.out.println("=============Today's population count===============");
			List<WebElement> populationList1 = driver.findElements(By.xpath(today_locator));
			for (WebElement list1 : populationList1) {
				System.out.println(list1.getText());
			}
			System.out.println("=============Year population count===============");
			List<WebElement> populationList2 = driver.findElements(By.xpath(year_locator));
			for (WebElement list2 : populationList2) {
				System.out.println(list2.getText());
			}
			count++;
		}
		System.out.println("Total number of Records: " + count);
	}
}
