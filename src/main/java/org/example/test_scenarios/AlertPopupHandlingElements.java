package org.example.test_scenarios;

import org.apache.commons.io.FileUtils;
import org.example.base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
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
		
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		String alertMsg = alert2.getText();
		if (alertMsg.equals("Hello just appeared")) {
			System.out.println("correct msg");
			alert2.accept();
		}
	}
	
	
	public static void takeScreenShot(String fileName) throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("/Users/sandipkumbhar/IdeaProjects/UI_Automation/Selenium_Java/" +
				"src/main/java/org/example/test_scenarios" + fileName + ".jpg");
		FileUtils.copyFile(source, destination);
	}
}
