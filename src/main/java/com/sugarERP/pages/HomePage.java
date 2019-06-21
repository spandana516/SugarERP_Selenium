package com.sugarERP.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sugarERP.TestBase.TestBase;



public class HomePage extends TestBase
{
		@FindBy(xpath="//i[@class='collapse-icon glyphicon glyphicon-th']")
	WebElement Grid_Btn;	
		
	@FindBy(xpath="//i[@class='fa fa-bell-o fa-2x ng-scope']")
	WebElement Bell;	

	@FindBy(xpath="//a[@class='list-group-item list-group-item-info ng-binding'][contains(text(),'SUGAR')]")
WebElement SUGAR_Div;

@FindBy(xpath="//a[contains(text(),'DISTILLERY')]")
WebElement DISTILLERY_Div;

@FindBy(xpath="//a[contains(text(),'CO2')]")
WebElement CO2_Div;

@FindBy(xpath="//a[contains(text(),'ORGANIC')]")
WebElement ORGANIC_Div;

@FindBy(xpath="//a[contains(text(),'R & D DIVISION')]")
WebElement RD_Div;
	
	@FindBy(xpath="//p[@id='getname']")
	WebElement username;
	
	@FindBy(xpath="//img[@src='img/logout1.png']")
	WebElement logutimg;
	
	@FindBy(xpath="//img[@src='img/widgets/sssltdlogo.jpg']")
	WebElement logoimg;
	
	@FindBy(xpath="//li[@class='FinanceandAccountsmodl']/a[@class='menu-dropdown']/i[1]")
	
     WebElement finanace_module;
	
	@FindBy(linkText="Masters")
	WebElement Masters1;
	
	@FindBy(linkText="BSSchedule")
	WebElement BSSchedule1;
	
	
	@FindBy(xpath="//i[@class='zmdi zmdi-arrow-forward']")
	WebElement signin;
	
	@FindBy(xpath="//div[@class='lv-header']")
	WebElement pending_voucher;
	
	@FindBy(xpath="//button[@class='confirm btn btn-lg btn-primary']")
	WebElement okBtn;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomepagetitle() {
		signin.click();
		return driver.getTitle();
	}
	
	public SugarDiv_VoucherListPage validate_sugar_notify() throws Exception {
	
		Bell.click();
		Thread.sleep(3000);
		Actions a=new Actions(driver);
		a.moveToElement(SUGAR_Div).build().perform();
		SUGAR_Div.click();
		//DISTILLERY_Div.click();
		
		String myWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(myWindowHandle);
		okBtn.click();
		return new SugarDiv_VoucherListPage();
	}
	
	public F_A_Masters_BSschedule clickOnBSschedule() throws Exception {
	
		Actions a = new Actions(driver);
		a.moveToElement(finanace_module).build().perform();
		Thread.sleep(2000);
		Masters1.click();
		BSSchedule1.click();
		return new F_A_Masters_BSschedule();
		
	}
	
	
	
}
