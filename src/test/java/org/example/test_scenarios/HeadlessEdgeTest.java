package org.example.test_scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessEdgeTest {
	
	public static void main(String[] args) {
		// Setup Edge driver
		WebDriverManager.edgedriver().setup();
		
		// Set Edge options for headless mode
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--headless");                  // Enable headless mode
		options.addArguments("--disable-gpu");               // Avoid GPU rendering issues (Windows)
		options.addArguments("--window-size=1920,1080");     // Optional: screen size for layout consistency
		
		// Launch Edge with options
		WebDriver driver = new EdgeDriver(options);
		
		// Open a website
		driver.get("https://www.tutorialspoint.com/selenium/practice/register.php");
		
		// Print page title
		System.out.println("Title: " + driver.getTitle());
		
		// Close browser
		driver.quit();
	}
}