package com.farmework.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Check {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Driver/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		WebElement link = driver.findElement(By.xpath("//a[@id='birthday-help']"));
		          Actions action = new Actions(driver);
		          action.moveToElement(link).build().perform();
		          try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		          WebElement textLnk=driver.findElement(By.xpath("//div[@id='globalContainer']/div[3]/descendant::div"));
		       //   WebElement textLnk=driver.findElement(By.xpath("//div[@id='globalContainer']/div[3]//div/div/div/div/div/div"));
		String s=textLnk.getText();
		System.out.println(s);
		
	
	}

}
