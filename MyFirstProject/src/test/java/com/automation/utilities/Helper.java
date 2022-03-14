package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String ScreenShot(WebDriver driver)
	{

		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		String ScreenShotParth=System.getProperty("user.dir")+"/SnapShots/chidu_"+getCurrentDate();
		try {
			FileHandler.copy(src, new File(ScreenShotParth));
			System.out.println("Screen shot captured");
		} 
		catch (Exception e) {
			System.out.println("unable to get the screenshot "+e.getMessage());
		}

		return ScreenShotParth;
	}


	public static String getCurrentDate()
	{
		SimpleDateFormat cusformat=new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss");
		Date current=new Date();
		return cusformat.format(current);


	}

}
