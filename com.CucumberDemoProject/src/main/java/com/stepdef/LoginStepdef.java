package com.stepdef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginStepdef {
	
	WebDriver driver=null;
	@Given("^user should be on login page$")
	public void user_should_be_on_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/Selenium_Software/Offline%20Website/index.html"); 
	}
    @When("^user enters valid credentials$")
	public void user_enters_valid_credentials() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	    	}
    @Then("^user should be on home page$")
	public void user_should_be_on_home_page() throws Throwable {
		
		Assert.assertEquals("JavaByKiran | Dashboard",driver.getTitle());
	}
    
    @When("^user enter invalid username$")
    public void user_enter_invalid_username() throws Throwable {
    	driver.findElement(By.id("email")).sendKeys("krishna@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
     }

    @Then("^verify email error$")
    public void verify_email_error() throws Throwable {
    	WebElement Email_error=driver.findElement(By.id("email_error"));
    	Assert.assertTrue(Email_error.isDisplayed());
    }
    @When("^user enter invalid password$")
    public void user_enter_invalid_password() throws Throwable {
    	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("1234567");
		driver.findElement(By.xpath("//button")).click();
       
    }

    @Then("^verify password error$")
    public void verify_password_error() throws Throwable {
      WebElement Password_error=driver.findElement(By.id("password_error"));
      Assert.assertTrue(Password_error.isDisplayed());
    }
  }
