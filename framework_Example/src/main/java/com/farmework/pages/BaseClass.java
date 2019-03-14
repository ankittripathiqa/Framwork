package com.farmework.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.farmework.utility.BrowserFactory;
import com.farmework.utility.ConfigDataProvider;
import com.farmework.utility.ExcelDataProvider;
import com.farmework.utility.Helper;
import com.google.common.reflect.ImmutableTypeToInstanceMap;

public class BaseClass {
	
	public WebDriver driver;
	public  ExcelDataProvider excelDataProvider;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupsuit()
	{
		excelDataProvider=new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Report/falabella"+Helper.currnetDate()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
	}
	
	@BeforeClass
	public void setup()
	{
		driver=BrowserFactory.startBrowser(driver,config.getUrl(),config.getBrowser());
	}
	
	@AfterClass
	public void close()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void  tearDownMehtod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
		logger.fail("Test Fail",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());	
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Pass",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());	
		}
		report.flush();
	}

}
