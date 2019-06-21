package com.sugarERP.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.sugarERP.TestBase.TestBase;
import com.sugarERP.Util.TestUtil;
import com.sugarERP.pages.HomePage;
import com.sugarERP.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.ValidateLoginPagetitle();
		Assert.assertEquals(title, "SugarERP","Home page title not matched");
	}
	
	
	@Test(priority=2)
	public void loginTest() throws Exception{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
