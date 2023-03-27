package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.objectRepo.LoginObjectRepo;

public class LoginPage extends LoginObjectRepo{
	
// page object - separate  class for each page/screen	
// link/webelements/constructor follow krna pdta hai
	

	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication() 
	{
		email.sendKeys("kiran@gmail.com");
		pass.sendKeys("123456");
		button.click();
	}
	
	
	public void loginToWrongGmail() 
	{
		email.sendKeys("kiran11@gmail.com");
		pass.sendKeys("123456");
		button.click();
	}
	
	public void LoginToWrongPass() 
	{
		email.sendKeys("kiran@gmail.com");
		pass.sendKeys("1234567");
		button.click();
	}
	
	public void LoginToWrongGamilAndPass() 
	{
		email.sendKeys("kiran11@gmail.com");
		pass.sendKeys("1234567");
		button.click();
	}
	
}
