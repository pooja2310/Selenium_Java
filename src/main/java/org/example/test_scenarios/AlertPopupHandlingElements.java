package org.example.test_scenarios;

import org.example.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class AlertPopupHandlingElements extends TestBase {
	public void alertBtn() {
		driver.findElement(By.xpath("//button[@onclick='showAlert()']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		driver.findElement(By.xpath("//button[@onclick='myMessage()']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7000));
		try {
			Alert alert2 = driver.switchTo().alert();
			System.out.println(alert2.getText());
			String alertMsg = alert2.getText();
			if (alertMsg.equals("Hello just appeared")) {
				System.out.println("correct msg");
				alert2.accept();
			}
		} catch (NoAlertPresentException e) {
			System.out.println("No Alert");
		}
		
	}
}
