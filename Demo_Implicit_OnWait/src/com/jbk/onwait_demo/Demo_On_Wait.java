package com.jbk.onwait_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_On_Wait {
	
	WebDriver driver;
	
	public void ConfigSetting(String url) 
		{
			System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
			
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //implicitwait
			driver.get(url);
		}
		
	public void search() 
	{
		driver.findElement(By.name("q")).sendKeys("java by kiran"+Keys.ENTER);
		
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3")).click();
	}
	
	
	

}

//pure driver ke uper applay kr sakte hai implicit wait