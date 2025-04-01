package org.example.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/org/example/config/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	public void initialization() throws InterruptedException {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		if (driver == null) {
			System.out.println("Driver is not initialized!");
		} else {
			driver.manage().window().maximize();
		}
		Thread.sleep(5000);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
	}
}
