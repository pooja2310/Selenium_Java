package org.example.test_scenarios;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DateTimePickerElements extends TestBase {
	
	public String[] getMonthYear(String monthYearVal) {
		return monthYearVal.split(" ");
	}
	
	public void monthYearSelection(String exDay, String exMonth, String exYear) throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.id("datepicker")).click();
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		String monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(monthYearVal);
		while (!(getMonthYear(monthYearVal)[0].equals("September") && getMonthYear(monthYearVal)[1].equals("2026"))) {
			driver.findElement(By.xpath("//a//span[contains(text(),'Next')]")).click();
			monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.findElement(By.xpath("//a[text()='" + exDay + "']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9000));
	}
}
