package org.example.test_scenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class FileUploadTest extends TestBase {
	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("/Users/sandipkumbhar/Downloads/Selenium commands.jpeg");
		driver.findElement(By.xpath("//input[@value='Upload']")).click();
		driver.quit();
	}
}