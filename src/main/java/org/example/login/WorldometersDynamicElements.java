package org.example.login;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WorldometersDynamicElements extends TestBase {

//	@FindBy(xpath=)
//	WebElement todays_count;
//
//	@FindBy(xpath=)
//	WebElement years_count;
	
	public void validateAndPrintData() throws InterruptedException {
		Thread.sleep(2000);
		int count =1;
		while(count <=20) {
			System.out.println(count + " sec");
			if(count==21)
				break;
			List<WebElement> populationList = driver.findElements(By.xpath("//div//span[@rel='current_population'])"));
			for (WebElement list : populationList) {
				System.out.println(list.getText());
			}
		}
	}
}
