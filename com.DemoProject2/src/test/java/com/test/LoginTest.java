package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPage;


public class LoginTest {
	
	WebDriver driver;
	LoginPage lp;
	@BeforeMethod
	public void CorrectCred() 
	{
		System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/Selenium_Software/Offline%20Website/index.html");
		driver.manage().window().maximize();
		lp=new LoginPage(driver);
	}
	@Test(priority = 1)
	public void verifyTitleOfNextPage() 
	{
		lp.loginToApplication();
		//Assert.assertEquals(driver.getTitle(),"JavaByKiran | Dashboard");
		WebElement Open_Dahsbord_element=driver.findElement(By.xpath("/html/body/div/header/a/span[2]/b"));
		String actualResult_Open_Dahsbord=Open_Dahsbord_element.getText();
		System.out.println(actualResult_Open_Dahsbord);
		String expectedResult_Open_Dahsbord="Java By Kiran";
	}
	
	@Test(priority = 2)
	public void VerifyWrongGmailAccount() 
	{
		  lp.loginToWrongGmail();
		//Assert.assertEquals("Please enter email as kiran@gmail.com", "Please enter email as kiran@gmail.com");
		 WebElement emailError_element=driver.findElement(By.xpath("//div[@id='email_error']"));
		 String actualResult_emailError=emailError_element.getText();
		 System.out.println(actualResult_emailError);
		 String expectedResult_emailError="Please enter email as kiran@gmail.com";//brd me rahega 
		   
	}
	
	@Test(priority = 3)
	public void VerifyWrongPassword() 
	{
	   	lp.LoginToWrongPass();
		//Assert.assertEquals("Please enter password 123456","Please enter password 123456");
		 WebElement passwordError_Element=driver.findElement(By.xpath("//div[@id='password_error']"));
		 String actualResult_passwordError= passwordError_Element.getText();
		 System.out.println(actualResult_passwordError);
		 String expectedResult_password="Please enter password 123456";
		   
    }
	
	@Test(priority = 4)
	public void VerifyWrongGamilAndPassword() 
	{
		lp.LoginToWrongGamilAndPass();
		//Assert.assertEquals("", "");
		 WebElement emailError_element=driver.findElement(By.xpath("//div[@id='email_error']"));
		 String actualResult_emailError=emailError_element.getText();
		 System.out.println(actualResult_emailError);
		 String expectedResult_emailError="Please enter email as kiran@gmail.com";//brd me rahega 
	 
		 WebElement passwordError_Element=driver.findElement(By.xpath("//div[@id='password_error']"));
		 String actualResult_passwordError= passwordError_Element.getText();
		 System.out.println(actualResult_passwordError);
		 String expectedResult_password="Please enter password 123456";
	
	}
	

}
