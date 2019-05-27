package com.farmework.utility;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
	
	WebDriver driver;
	
	public static WebDriver startBrowser(WebDriver driver,String url,String browser)

	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Driver/chromedriver");
			driver=new ChromeDriver();
			
 
		//	DesiredCapabilities capabilitiesChrome = DesiredCapabilities.chrome();
	    //    ChromeOptions options = new ChromeOptions();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Driver/geckodriver");
			driver=new FirefoxDriver();
		}
		else if(browser.equals("safari"))
		{
			driver=new SafariDriver();
		}
		else
		{
			System.out.println("Not able understand the browser");
		}
		
	// driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	//	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.get(url);
		
		
	    driver.manage().window().setSize(new Dimension(1366, 768));
	   // driver.manage().window().maximize();
	  // driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  //  driver.manage().window().fullscreen();
	    
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	

}
