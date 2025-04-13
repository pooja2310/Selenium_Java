package org.example.test_scenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


 /* JavascriptExecutor is an interface provided by Selenium for executing JavaScript commands.
		Since the WebDriver class itself does not implement the JavascriptExecutor interface directly,
		you need to explicitly cast the driver to JavascriptExecutor.
		This tells Java that the driver object can behave as a JavascriptExecutor*/

public class ScrollViewTest {
	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-notifications"); // Disable notifications
		
		// Initialize WebDriver with EdgeOptions
		WebDriver driver = new EdgeDriver(options);
		driver.get("https://www.rediff.com");
		driver.manage().window().maximize();
		
		WebElement disclaimerElement = driver.findElement(By.xpath("//a[text()='Disclaimer']"));
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView();", disclaimerElement);
		Thread.sleep(5000);
		System.out.println("Scroll is down");
		WebElement CreateAccElement = driver.findElement(By.xpath("//a[text()='Create Account']"));
		javascriptExecutor.executeScript("arguments[0].scrollIntoView();", CreateAccElement);
		Thread.sleep(5000);
		System.out.println("Scroll is up");
		driver.quit();
	}
}