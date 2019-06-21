package com.sugarERP.Util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import com.sugarERP.TestBase.TestBase;
import com.sun.media.sound.InvalidFormatException;


public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 100;
	public static long IMPLICIT_WAIT = 100;
	
	public static String TESTDATA_SHEET_PATH = "D:\\SeleniumAutomationNew\\SugarERP\\src\\main\\"
			+ "java\\com\\sugarERP\\Util\\TestUtil.java";
	
	
	static Workbook book;
	static Sheet sheet;
	
	
	
	public static void switchToFrame() {
		driver.switchTo().window("SRI SARVARAYA SUGARS LTD.");
	}
	
	
	public static Object[][] getTestData(String sheetName) throws Exception {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);		
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];	
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {					
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();				
		
				System.out.println(data[i][k]);		
			}
		}
		return data;
	}
	
	
}
	

