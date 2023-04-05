package com.test;

import java.util.List;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.page.HomePage;

public class HomepageTest extends BaseClass {
	
	
	HomePage hp = null;
	
	@BeforeSuite
	public void setup()throws Exception 
	{
		initialisation();
		reportInit();
		hp= new HomePage(driver);
	
	}
	
	@Test
	public void verifyMenu() 
	{
		List<String>menuName = hp.getMenu();
		System.out.println(menuName);
	}
	
	
	@Test
	public void verifyMenuapi() 
	{
		List<String>menuNameapi =hp.getMenuapi();
		System.out.println(menuNameapi);
	}
	
	@Test
	public void verifylogo() 
	{
	    hp.logo.isDisplayed();
		System.out.println(); 
	}
	
	/*@Test
	public void sendgamil() 
	{
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.xpath("//button")).click();
		
    }*/
 	
   
}
