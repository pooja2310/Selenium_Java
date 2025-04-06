package org.example.test_scenarios;

import org.example.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends TestBase {
	
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement passWord;
	
	@FindBy(xpath = "//input[@value='Register']")
	WebElement register_btn;
	
	@FindBy(xpath = "//a[contains(text(), 'Back to Login')]")
	WebElement back_to_Login_btn;

//	@FindBy(xpath = "///head//title[contains(text(),'Selenium Practice - Register')]")
//	WebElement registerTitle;
	
	@FindBy(xpath = "//h1[contains(text(),'Welcome,Register')]")
	WebElement registerHeader;

//	@FindBy(xpath= "//head//title[contains(text(),'Selenium Practice - Login')]")
//	WebElement loginTitle;
	
	@FindBy(xpath = "//h1[contains(text(),'Welcome, Login In')]")
	WebElement loginHeader;
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);   //Register page constructor
	}
	
	public String validateRegisterPageTitle() {
		return driver.getTitle();
	}
	
	public String validateRegisterPageHeader() {
		return registerHeader.getText();
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String validateLoginPageHeader() {
		return loginHeader.getText();
	}
	
	public void register(String fName, String lName, String uName, String pwd) throws InterruptedException {
		firstName.sendKeys(fName);
		Thread.sleep(1000);
		lastName.sendKeys(lName);
		Thread.sleep(1000);
		userName.sendKeys(uName);
		Thread.sleep(1000);
		passWord.sendKeys(pwd);
		Thread.sleep(1000);
		register_btn.click();
		Thread.sleep(1000);
	}
	
	public void bck_login() throws InterruptedException {
		back_to_Login_btn.click();
		Thread.sleep(5000);
	}
}