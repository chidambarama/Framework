package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ConfigDataProvider;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public  ExtentReports report;
	public 	ExtentTest logger;

	@BeforeSuite
	public void ExcelDataProvider()
	{
		excel=new ExcelDataProvider();	
		config	=new ConfigDataProvider();

		ExtentHtmlReporter customreport=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM "+Helper.getCurrentDate()+".html"));
		report=new ExtentReports();
		report.attachReporter(customreport);
	}


	@BeforeClass
	public void  setup()
	{
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getqaURL());

	}


	@AfterClass
	public void teardown()
	{
		BrowserFactory.EndApplication(driver);
	}

	@AfterMethod
	public void teardownmethod(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("TEst failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.ScreenShot(driver)).build());
		}

		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("TEst pass", MediaEntityBuilder.createScreenCaptureFromPath(Helper.ScreenShot(driver)).build());
		}
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			logger.skip("TEst skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.ScreenShot(driver)).build());
		}

		report.flush();
	}
}
