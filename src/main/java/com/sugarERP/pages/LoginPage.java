package com.sugarERP.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sugarERP.TestBase.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//i[@class='zmdi zmdi-arrow-forward']")
	WebElement signin;

	public LoginPage() {
		PageFactory.initElements(driver, this);
		}

public String ValidateLoginPagetitle(){
	return driver.getTitle();
	
}

public HomePage login(String un,String pwd) throws Exception
{
	Thread.sleep(1000);
	username.sendKeys(un);
	password.sendKeys(pwd);
	signin.click();
	
	return new HomePage();
}
}
