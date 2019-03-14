package com.farmework.utility;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	
	public  static String captureScreenShot(WebDriver driver)
	{
		//Screen shot
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/ScreenShot/"+currnetDate() +".png";
		try {
			FileHandler.copy(src,new File(path));
		} catch (IOException e) {
			System.out.println("Unable to capture the screenshot"+e.getMessage());
		}
		
		System.out.println("Screen Shot capture");
		return path;
	}
	
	public static String currnetDate()
	{
		DateFormat cutomFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdate=new Date();
		return cutomFormat.format(currentdate);
		
	}
}
