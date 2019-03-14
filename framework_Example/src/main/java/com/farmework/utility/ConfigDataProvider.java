package com.farmework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties properties;
	
	public ConfigDataProvider()
	{
	   File src=new File(System.getProperty("user.dir")+"/Configuration/config.properties");
	   try {
		FileInputStream file=new FileInputStream(src);
	     properties=new Properties();
	     properties.load(file);
	     
	
	} catch (Exception e) {
		
		System.out.println("Not getting properties file"+e.getMessage());
	}
	   }
	
	public String getDataFromConfig(String key)
	{
		return properties.getProperty(key);
	}

	public String getBrowser()
	{
		return properties.getProperty("browser");
	}
	
	public String getUrl()
	{
		return properties.getProperty("qaurl");
	}
	
}
