package com.automation.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCaseWithoutFrameWork
{

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");

		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://ui.freecrm.com/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.name("email")).sendKeys("chiduanjan@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("chiduI@20");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		Thread.sleep(3000);
		driver.quit();

	}


}
