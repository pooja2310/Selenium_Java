package org.example.login;

import org.example.base.TestBase;
import org.openqa.selenium.SearchContext;
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
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement Back_to_Login_btn;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement registerTitle;
	
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);   //Register page constructor
	}
	
	public String validateRegisterPageTitle() {
		return driver.getTitle();
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
	}
	
	public void bck_login(){
		Back_to_Login_btn.click();
	}
}