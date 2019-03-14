package com.farmework.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.farmework.pages.BaseClass;
import com.farmework.pages.LoginPage;
import com.farmework.utility.BrowserFactory;

public class LoginTestFalabella extends BaseClass {
	
	
	@Test
	public void loginTest()

	{
		logger=report.createTest("Login to falabella");
		LoginPage loginPage=PageFactory.initElements(driver,LoginPage.class);
		logger.info("start application");
	    loginPage.login(excelDataProvider.getStringData("Sheet1", 0, 0),excelDataProvider.getStringData("Sheet1", 0, 1));
	   logger.pass("Test case pass");
	}

	
}
