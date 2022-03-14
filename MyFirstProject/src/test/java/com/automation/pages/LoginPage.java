package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.utilities.BrowserFactory;

public class LoginPage 
{

	WebDriver driver;	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;

	}

	@FindBy(name="email") WebElement username;
	@FindBy(name ="password")WebElement password;
	@FindBy(xpath="//div[text()='Login']")WebElement loginButton;


	public void loginCRM(String usernameapp, String passapp) throws InterruptedException
	{
		
		username.sendKeys(usernameapp);
		Thread.sleep(2000);
		password.sendKeys(passapp);
		Thread.sleep(2000);
		loginButton.click();
		Thread.sleep(4000);


	}

}
