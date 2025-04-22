package org.example.test_scenarios;

import org.example.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(CustomListener.class)
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
	
	@Test(priority = 0, enabled = true)
	public void register() throws InterruptedException {
		String registerTitle = registerPage.validateRegisterPageTitle();
		Assert.assertEquals(registerTitle, "Selenium Practice - Register");
		System.out.println("Verifying register page title");
		String registerHeader = registerPage.validateRegisterPageHeader();
		Assert.assertEquals(registerHeader, "Welcome,Register");
		System.out.println("Verifying register page header");
		registerPage.register(prop.getProperty("firstname_reg"), prop.getProperty("lastname_reg"),
				prop.getProperty("username_reg"), prop.getProperty("password_reg"));
		System.out.println("User is registered successfully");
		registerPage.bck_login();
		Thread.sleep(2000);
		System.out.println("Login page is opened");
		String loginTitle = registerPage.validateLoginPageTitle();
		Assert.assertEquals(loginTitle, "Selenium Practice - Login");
		System.out.println("Verifying login page title");
		String loginHeader = registerPage.validateLoginPageHeader();
		Assert.assertEquals(loginHeader, "Welcome, Login In");
		System.out.println("Verifying login page header");
	}
	
	@AfterMethod
	public void CloseTest() {
		if (driver != null)
			driver.quit();
	}
}
