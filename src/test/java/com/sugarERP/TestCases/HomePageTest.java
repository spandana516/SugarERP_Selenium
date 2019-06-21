package com.sugarERP.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sugarERP.TestBase.TestBase;
import com.sugarERP.Util.TestUtil;
import com.sugarERP.pages.F_A_Masters_BSschedule;
import com.sugarERP.pages.HomePage;
import com.sugarERP.pages.LoginPage;
import com.sugarERP.pages.SugarDiv_VoucherListPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	SugarDiv_VoucherListPage sugarDiv_VoucherListPage;
	F_A_Masters_BSschedule f_a_Masters_BSschedule;
	
	
 public HomePageTest() {
	 super();
	 
 }
 @BeforeMethod
	public void setUp() throws Exception{
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		sugarDiv_VoucherListPage = new SugarDiv_VoucherListPage();
		f_a_Masters_BSschedule = new F_A_Masters_BSschedule();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
 
 @Test(priority=1)
	public void validateHomepagetitleTest(){
		String title = homePage.validateHomepagetitle();
		System.out.println(driver.getTitle());
		Assert.assertEquals(title, "SRI SARVARAYA SUGARS LTD.","Home page title not matched");
	}
 
 @Test(priority=2)
	public void validate_sugar_notifyTest() throws Exception{
	 sugarDiv_VoucherListPage = homePage.validate_sugar_notify();
	}
 
 @Test(priority=3)
	public void clickOnBSscheduleTest() throws Exception{
	 f_a_Masters_BSschedule = homePage.clickOnBSschedule();
		
	}
 
 @AfterMethod
	public void tearDown(){
		  driver.quit();
	}
	
 
}
