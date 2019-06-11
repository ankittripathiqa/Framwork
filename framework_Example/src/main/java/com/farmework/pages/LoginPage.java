package com.farmework.pages;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	@FindBy(how= How.XPATH,using="//div[@id='header-login-modal']")
	WebElement mouseOver;
	
	@FindBy(how=How.ID,using="emailAddress")
	WebElement txtBxUser;
	
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	WebElement txtPwd;
	
	@FindBy(how=How.XPATH,using="//button/p[contains(text(),'Iniciar sesión')]")
	WebElement btnLogin;
	
	public void login(String username,String pwd)
	{
	
		Actions action=new Actions(driver);
		action.moveToElement(mouseOver).build().perform();
		mouseOver.click();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		txtBxUser.sendKeys(username);
		txtPwd.sendKeys(pwd);
		btnLogin.click();
		
	}
	
	
	
	
	

}
