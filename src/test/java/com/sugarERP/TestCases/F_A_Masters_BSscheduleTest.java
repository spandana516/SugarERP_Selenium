package com.sugarERP.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sugarERP.TestBase.TestBase;
import com.sugarERP.Util.TestUtil;
import com.sugarERP.pages.F_A_Masters_BSschedule;
import com.sugarERP.pages.HomePage;
import com.sugarERP.pages.LoginPage;

public class F_A_Masters_BSscheduleTest extends TestBase{

	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	F_A_Masters_BSschedule f_a_Masters_BSschedule;
	
	String sheetName ="ScheduleAddedData";
	
	 public F_A_Masters_BSscheduleTest() {
		 super();
}
	 
	 @BeforeMethod
		public void setUp() throws Exception{
			initialization();
			testUtil = new TestUtil();
			loginPage = new LoginPage();
			f_a_Masters_BSschedule = new F_A_Masters_BSschedule();
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			}
	
	 
@Test(priority=1, dataProvider="getCRMTestData")
public void BSscheduleDataTest(String schedulename, String scheduledesc, String acctdigistart) throws Exception{
	homePage.clickOnBSschedule();
	f_a_Masters_BSschedule.BSscheduleData(schedulename, scheduledesc, acctdigistart);
}

@DataProvider
public Object[][] getCRMTestData() throws Exception{
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
}


@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
