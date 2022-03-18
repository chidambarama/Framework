package com.automation.testcase;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class cc {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://49.205.216.188:8008/verify-students-mock");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.name("field_mob_no_number")).sendKeys("9632763330");
		Thread.sleep(1000);
		driver.findElement(By.id("edit-submit-verify-students-mock")).click();
		driver.findElement(By.name("name")).sendKeys("Umamaheshwari");
		driver.findElement(By.name("pass")).sendKeys("umamaheshwari@123");
		driver.findElement(By.id("edit-submit--2")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		System.out.println("Page title of new tab: " + driver.getTitle());
		//	driver.switchTo().window(newTb.get(0));
		//	System.out.println("Page title of parent window: " + driver.getTitle());
		driver.findElement(By.name("field_mock_rating_add_more")).click();

		//		Thread.sleep(3000);
		//		driver.findElement(By.xpath("//div[text()='Login']")).click();
		//		Thread.sleep(3000);
		//driver.quit();
	}

}
