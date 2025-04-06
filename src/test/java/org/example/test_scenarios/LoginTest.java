package org.example.test_scenarios;

import org.example.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
	LoginPage loginpage;
	
	public LoginTest() {     //Constructor
		super();   //It is calling base class constructor to access config property file
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();   // To init the browser
		loginpage = new LoginPage();  // To init the webElement
	}
	
	@Test(priority = 0, enabled = true)
	public void login() throws InterruptedException {
		loginpage.bck_login();
		Thread.sleep(2000);
		System.out.println("Login page is opened");
		String loginHeader = loginpage.validateLoginPageHeader();
		Assert.assertEquals(loginHeader, "Welcome, Login In");
		System.out.println("Verifying login page header");
		loginpage.login(prop.getProperty("email_login"), prop.getProperty("pwd_login"));
		System.out.println("login has been done");
		Thread.sleep(1000);
		loginpage.newUser();
		String registerTitle = loginpage.validateRegisterPageTitle();
		Assert.assertEquals(registerTitle, "Selenium Practice - Register");
		System.out.println("Verifying register page title");
		String registerHeader = loginpage.validateRegisterPageHeader();
		Assert.assertEquals(registerHeader, "Welcome,Register");
		System.out.println("Verifying register page header");
	}
	
	@AfterMethod
	public void closeTest() {
		if (driver != null)
			driver.quit();
	}
}
