package org.example.test_scenarios;

import org.apache.commons.io.FileUtils;
import org.example.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class LoginPage extends TestBase {
	@FindBy(xpath = "//input[@id='email']")
	WebElement email_txt;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password_txt;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement login;
	
	@FindBy(xpath = "//a[contains(text(),'New User')]")
	WebElement newUser;
	
	@FindBy(xpath = "//h1[contains(text(),'Welcome, Login In')]")
	WebElement loginHeader;
	
	@FindBy(xpath = "//h1[contains(text(),'Welcome,Register')]")
	WebElement registerHeader;
	@FindBy(xpath = "//a[contains(text(), 'Back to Login')]")
	WebElement back_to_Login_btn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);   //Login page constructor
	}
	
	public String validateLoginPageHeader() {
		return loginHeader.getText();
	}
	
	public void bck_login() throws InterruptedException {
		back_to_Login_btn.click();
		Thread.sleep(5000);
	}
	
	public void login(String email, String pwd) throws InterruptedException {
		email_txt.sendKeys(email);
		Thread.sleep(1000);
		password_txt.sendKeys(pwd);
		Thread.sleep(1000);
		login.click();
		
	}
	
	public void newUser() throws InterruptedException {
		newUser.click();
		Thread.sleep(1000);
	}
	
	public String validateRegisterPageTitle() {
		return driver.getTitle();
	}
	
	public String validateRegisterPageHeader() {
		return registerHeader.getText();
	}
	
	public void takeScreenShot(String fileName) throws IOException {
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination= new File("/Users/sandipkumbhar/IdeaProjects/UI_Automation/Selenium_Java/" +
				"src/main/java/org/example/test_scenarios"+fileName+".jpg");
		FileUtils.copyFile(source,destination);
	}
}
