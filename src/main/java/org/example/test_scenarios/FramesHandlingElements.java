package org.example.test_scenarios;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class FramesHandlingElements extends TestBase {
	
	@FindBy(xpath = "//frame[@src='frame_1.html']")
	WebElement frame1;
	
	@FindBy(xpath = "//frame[@src='frame_2.html']")
	WebElement frame2;
	
	public void frameSwitch() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.switchTo().frame(frame1);
		System.out.println("Frame1 selected");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		///driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome to frame 1");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame2);
		System.out.println("Frame2 selected");
		driver.switchTo().frame(0);
		System.out.println("Inner frame");
	}
}
