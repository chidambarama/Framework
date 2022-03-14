package com.automation.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;

public class LoginTestCRM extends BaseClass
{
	@Test(priority = 1)
	public void loginApp() throws InterruptedException 
	{
		logger=	report.createTest("Welcome to the login page to crm");
		LoginPage	loginpage= PageFactory.initElements(driver, LoginPage.class);
		//loginpage.loginCRM("123", "344");
		logger.info("Starting application");
		loginpage.loginCRM(excel.getStringData("Sheet1", 0, 0), excel.getStringData("Sheet1", 0, 1));
		logger.pass("Login success");

	}

//	@Test(priority = 2)
//	public void loginApp1() throws InterruptedException 
//	{
//		logger=	report.createTest("Logout");
//		logger.fail("Login failed");
//
//
//	}
}
