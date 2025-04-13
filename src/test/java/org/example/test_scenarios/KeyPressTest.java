package org.example.test_scenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class KeyPressTest extends TestBase {
	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://practice.expandtesting.com/key-presses?");
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.SPACE).build().perform();
		String text = driver.findElement(By.id("result")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "You entered: SPACE");
		Thread.sleep(5000);
		driver.quit();
		
	}
}
