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
       driver=new ChromeDriver();
       driver.get("file:///D:/Selenium_Software/Offline%20Website/index.html");
     }
//1)
	//regular expression
	@When("^user enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_and(String uname, String pass) throws Throwable {
        driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
	}
    @Then("^user should be on home page$")
	public void user_should_be_on_home_page() throws Throwable {
		Assert.assertEquals("JavaByKiran | Dashboard",driver.getTitle());
	}
//2)
	@When("^user enter invalid username$")
	public void user_enter_invalid_username() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("kiran11@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	}
	@Then("^verify email error$")
	public void verify_email_error() throws Throwable {
		 WebElement emailError_element=driver.findElement(By.id("email_error"));
		 String actualResult_emailError=emailError_element.getText();
		 System.out.println(actualResult_emailError);
		 String expectedResult_emailError="Please enter email as kiran@gmail.com";
	 }
//3)
	@When("^user enter invalid password$")
	public void user_enter_invalid_password() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.xpath("//button")).click();
	}

	@Then("^verify password error$")
	public void verify_password_error() throws Throwable {
	   WebElement PasswordError_element=driver.findElement(By.id("password_error"));
	   String actualResult_passwordError=PasswordError_element.getText();
	   System.out.println(actualResult_passwordError);
	   String expectedResult_emailError="Please enter password 123456";
	}
//4)
	@When("^user enter invalid credentials$")
	public void user_enter_invalid_credentials() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("kiran12@gmail.com");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.xpath("//button")).click();
	}
	@Then("^verify credentials error$")
	public void verify_credentials_error() throws Throwable {
	    
		 WebElement emailError_element=driver.findElement(By.id("email_error"));
		 String actualResult_emailError=emailError_element.getText();
		 System.out.println(actualResult_emailError);
		 String expectedResult_emailError="Please enter email as kiran@gmail.com";

		 WebElement PasswordError_element=driver.findElement(By.id("password_error"));
		 String actualResult_passwordError=PasswordError_element.getText();
		 System.out.println(actualResult_emailError);
		 String expectedResult_passwordError="Please enter password 123456";
	
	}


}
