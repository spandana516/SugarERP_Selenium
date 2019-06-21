package com.sugarERP.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sugarERP.TestBase.TestBase;
import com.sugarERP.Util.TestUtil;

public class F_A_Masters_BSschedule extends TestBase{
	
	@FindBy(xpath="//div[@class='col-sm-7']//label[2]")
	WebElement liability_RBtn;
	
	@FindBy(xpath="//div[@class='col-sm-7']//label[3]")
	WebElement asset_RBtn;
	
	@FindBy(xpath="//div[@class='col-sm-7']//label[4]")
	WebElement income_RBtn;
	
	@FindBy(xpath="//div[@class='col-sm-7']//label[5]")
	WebElement expence_RBtn;
	
	
	
	@FindBy(id="schedule")
	WebElement schedule_Name;
	
	@FindBy(name="description")
	WebElement schedule_desc;
	
	@FindBy(xpath="//div[@class='col-sm-6']//label[2]")
	WebElement single_RBtn;
	
	
	@FindBy(xpath="//div[@class='col-sm-6']//label[3]")
	WebElement multiple_RBtn;
	
	@FindBy(xpath="//input[@name='acctstart']")
	WebElement acctdigi_start;
	
	@FindBy(xpath="//input[@name='acctend']")
	WebElement acctdigi_end;
	
	@FindBy(xpath="//div[@class='col-sm-4']//label[2]")
	WebElement status_active;
	
	@FindBy(xpath="//div[@class='col-sm-4']//label[3]")
	WebElement status_inactive;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement save_Btn;
	
	@FindBy(xpath="//button[contains(text(),'Reset')]")
	WebElement Reset_Btn;
	
	@FindBy(xpath="//button[@class='confirm btn btn-lg btn-primary']")
	WebElement okBtn;
	//
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//i[@class='zmdi zmdi-arrow-forward']")
	WebElement signin;
	
	public F_A_Masters_BSschedule() {
		PageFactory.initElements(driver, this);
	}
	
	public F_A_Masters_BSschedule BSscheduleData(String schedulename, String scheduledesc, String acctdigistart){
		Reset_Btn.click();
		liability_RBtn.click();
		schedule_Name.sendKeys(schedulename);
		schedule_desc.sendKeys(scheduledesc);
		single_RBtn.click();
		//multiple_RBtn.click();
		
		
		acctdigi_start.sendKeys(acctdigistart);
		
		//acctdigi_end.sendKeys(acctdigiend);
		status_active.click();
		save_Btn.click();
		
		//popup handle
		
		String myWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(myWindowHandle);
		okBtn.click();
		TestUtil.switchToFrame();
		
			
		return new F_A_Masters_BSschedule();
		
		
	}
}
