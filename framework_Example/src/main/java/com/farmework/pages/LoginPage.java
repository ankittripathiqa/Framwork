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
	
	@FindBy(how= How.XPATH,using="//div[contains(text(),'Inicia Sesión')]")
	WebElement mouseOver;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Inicia sesión')]")
	WebElement loginBtn;
	
	@FindBy(how=How.ID,using="inputEmail")
	WebElement txtBxUser;
	
	@FindBy(how=How.ID,using="loginPassword")
	WebElement txtPwd;
	
	@FindBy(how=How.ID,using="loginClick")
	WebElement btnLogin;
	
	public void login(String username,String pwd)
	{
	
		Actions action=new Actions(driver);
		action.moveToElement(mouseOver).build().perform();
		loginBtn.click();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		txtBxUser.sendKeys(username);
		txtPwd.sendKeys(pwd);
		btnLogin.click();
		
	}
	
	
	
	
	

}
