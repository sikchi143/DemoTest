package com.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utilitis.PropertiesUtils;

public class BaseClass {
	
	public static WebDriver driver = null;
	
	//report sathi method
	public static ExtentReports report=null;
	public static ExtentSparkReporter spark=null;
	public static ExtentTest test=null;
	
	public static void initialisation() throws Exception 
	{
		String browser=PropertiesUtils.readProperty("browser");
		
		if(browser.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe" );
			driver = new ChromeDriver();
		}
		
		driver.get(PropertiesUtils.readProperty("url"));
		driver.manage().window().maximize();
	}
   
	public void reportInit() 
	{
		report=new ExtentReports();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
		String date = sdf.format(new Date());
		System.out.println(date);
		String path = System.getProperty("user.dir")+"/target/ExtentReport"+date+".html";
		spark=new ExtentSparkReporter(path);
	    report.attachReporter(spark);
	
	}
	
	
	
}
