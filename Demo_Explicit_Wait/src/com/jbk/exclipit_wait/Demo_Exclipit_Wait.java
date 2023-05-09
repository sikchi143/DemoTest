package com.jbk.exclipit_wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Demo_Exclipit_Wait {
	
WebDriver driver;
	
	public void ConfigSetting(String url) 
		{
			System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
			
			driver=new ChromeDriver();
			driver.get(url);
		}
		
   public void search() 
   {
	  driver.switchTo().frame("webform");
	 
	  WebDriverWait waitelement= new WebDriverWait(driver, 5);
      WebElement element= waitelement.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div")));
      element.click();   
    }
   }
