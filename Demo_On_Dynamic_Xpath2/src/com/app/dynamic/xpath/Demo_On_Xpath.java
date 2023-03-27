package com.app.dynamic.xpath;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo_On_Xpath {
	
	WebDriver driver;
	
	public void Setting(String url) 
	{
		System.setProperty("WebDriver.crome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}
     public void OptionSelect() throws InterruptedException
	{
		driver.findElement(By.xpath("//table[@id='tblcrtac']/tbody/tr[3]/td[3]/input")).sendKeys("Krishna Dharnidhar sikchi");
	    System.out.println("Full Name");
		driver.findElement(By.xpath("//table[@id='tblcrtac']/tbody/tr[7]/td[3]/input")).sendKeys("sikchi1111");
	    System.out.println("Choose a Rediffmail ID	");
	
	    /*  
	   * explicit time
	   WebDriverWait wait = new WebDriverWait(driver,10);
	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@value='Check availability']")));
	   driver.findElement(By.xpath("//input[@value='Check availability']")).click();
	  */ 
	   
	    // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//input[@value='Check availability']")).click();
	    System.out.println("====click====");
		driver.findElement(By.xpath("//input[starts-with(@name,'passwd')]")).sendKeys("Pass@12345");
		System.out.println("Password");
		driver.findElement(By.xpath("//input[starts-with(@name,'confirm_passwd')]")).sendKeys("Pass@12345");
		System.out.println("Retype password	");
	    // driver.findElement(By.xpath("//input[starts-with(@name,'altemail')]")).sendKeys("sikchi4@gamil.com");
	    driver.findElement(By.xpath("//table[@id='tblcrtac']/tbody/tr[15]/td[2]/table/tbody/tr/td/input")).click();
	    System.out.println("Click if you have an alternate ID");
	    WebElement element = driver.findElement(By.xpath("//table[@id='tblcrtac']/tbody/tr[16]/td/div/table/tbody/tr[2]/td[3]/select"));
	    Select D = new Select(element);
	    D.selectByIndex(3);
	    System.out.println("Select a Security Question");
	    driver.findElement(By.xpath("//table[@id='tblcrtac']/tbody/tr[16]/td/div/table/tbody/tr[4]/td[3]/input")).sendKeys("Apple");
	    System.out.println("Enter an Answer");
	    driver.findElement(By.xpath("//table[@id='tblcrtac']/tbody/tr[16]/td/div/table/tbody/tr[6]/td[3]/input")).sendKeys("Ranjana");
	    System.out.println("Mother's Maiden Name");
	    driver.findElement(By.xpath("//div[@id='div_mob']/table/tbody/tr/td[3]/div[2]")).click();
	    driver.findElement(By.xpath("//div[@id='div_mob']/table/tbody/tr/td[3]/div/ul/li[1]")).click();
	    System.out.println("Select country code");
	    driver.findElement(By.xpath("//table[@id='tblcrtac']/tbody/tr[20]/td/div/table/tbody/tr/td[3]/div[3]/input")).sendKeys("8149725084");
	    System.out.println("Enter mobile no");
	    WebElement element2 = driver.findElement(By.xpath("//table[@id='tblcrtac']/tbody/tr[22]/td[3]/select"));
	    Select D1 = new Select(element2);
	    D1.selectByValue("06");
	    System.out.println("Birth Date");
	    WebElement element3 = driver.findElement(By.xpath("//table[@id='tblcrtac']/tbody/tr[22]/td[3]/select[2]"));
	    Select D3 = new Select(element3);
	    D3.selectByValue("04");
	    System.out.println("Birth Month");
	    WebElement element4 = driver.findElement(By.xpath("//table[@id='tblcrtac']/tbody/tr[22]/td[3]/select[3]"));
	    Select D4 = new Select(element4);
	    D4.selectByValue("1996");
	    System.out.println("Birth Year");
	    driver.findElement(By.xpath("//table[@id='tblcrtac']/tbody/tr[24]/td[3]/input")).click();
	    System.out.println("Gender");
	    WebElement element5 = driver.findElement(By.xpath("//select[starts-with(@id,'country')]"));
	    Select D5 = new Select(element5);
	    D5.selectByValue("99");
	    System.out.println("inCountry");
	    WebElement element6 = driver.findElement(By.xpath("//select[starts-with(@name,'city')]"));
	    Select D6 = new Select(element6);
	    D6.selectByValue("Aurangabad");
	    System.out.println("City Name");
	   }
}
