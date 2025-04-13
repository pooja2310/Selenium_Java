package org.example.test_scenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickTest extends TestBase {
	
	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		WebElement rightClick = driver.findElement(By.cssSelector(".context-menu-one"));
		actions.contextClick(rightClick).build().perform();
		WebElement copyBtn = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
		String copyTxt = copyBtn.getText();
		System.out.println(copyTxt);
		copyBtn.click();
		Thread.sleep(5000);
		driver.quit();
	}
}
