package org.example.login;

import org.example.base.TestBase;
import org.testng.annotations.*;

public class RegistrationTest extends TestBase {
	RegistrationPage registerPage;
	
	public RegistrationTest() {
		super(); //   It is calling base class constructor to access config property file
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();  // To initialize the browser
		registerPage = new RegistrationPage();   // To init the webElement
	}
	
	@Test
	public void register() throws InterruptedException {
		registerPage.register(prop.getProperty("firstname_reg"),prop.getProperty("lastname_reg"),
				prop.getProperty("username_reg"),prop.getProperty("password_reg"));
		System.out.println("Register successfully");
		

	}
    @Test(priority = 1)
	public void bck_login(){
		registerPage.bck_login();
		System.out.println("Login page opened");
	}
	
	@AfterMethod
	public void CloseTest() {
		if (driver != null)
			driver.quit();
	}
}
