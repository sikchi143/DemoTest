package com.page;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@id='homeSubmenu']/li")
	List<WebElement> menu;
	
	public List<String> getMenu()
	{
	   List<String> menuNames=new ArrayList<String>();//10
		
		for(WebElement option : menu) //for each loop laun text anayche
		{
		  menuNames.add(option.getText());
		}
		
		return menuNames;
	}
	
	
	
	@FindBy(xpath="//a[@data-toggle='pill']")
	List<WebElement> menuapi;
	
	public List<String> getMenuapi()
	{
		List<String> menuNamesapi=new ArrayList<String>();
		
		for(WebElement option1 : menuapi) 
		{
			menuNamesapi.add(option1.getText());
		}
		
		return menuNamesapi;
	}
	
	 
      @FindBy(xpath="//a[@class='logo']")
      public WebElement logo;
     
     
      
     // @FindBy(xpath="//input[@id='email']")
      //public WebElement email;
       
    }
