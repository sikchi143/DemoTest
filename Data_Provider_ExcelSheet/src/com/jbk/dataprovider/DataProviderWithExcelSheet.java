package com.jbk.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.jbk.utility.Utility;
public class DataProviderWithExcelSheet extends Utility {
	
	@BeforeMethod
	public void configSetting() 
	{
		Configsetting("file:///D:/Selenium_Software/Offline%20Website/index.html");
	}		
	
	@Test(dataProvider = "logintestdata")
	public void LoginTestCase(String username,String password) 
{
	WebElement email_Element=findWebElement("//input[@id='email']");
    email_Element.sendKeys(username);
    WebElement Password_element =findWebElement("//input[@id='password']");
    Password_element.sendKeys(password);
    WebElement login_element =findWebElement("//button[starts-with(text(),\"Sign In\")]");
    login_element.click();
  
    //screen shot ke liye code
    try {
    	
    WebDriver driver = getDriver();
    	
    File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//workspace ke leye
	File target=new File("D:\\Selenium_Workspace\\Screenshot\\Login\\Login1"+username+".png");	
	
	Thread.sleep(2000);
	
	FileHandler.copy(source,target);
	
	WebElement emailError_element=findWebElement("//div[@id='email_error']");
    String actualResult_emailError=emailError_element.getText();
    System.out.println(actualResult_emailError);
    String expectedResult_emailError="Please enter email as kiran@gmail.com";//brd me rahega 
   
    WebElement passwordError_Element=findWebElement("//div[@id='password_error']");
    String actualResult_passwordError= passwordError_Element.getText();
    System.out.println(actualResult_passwordError);
    String expectedResult_password="Please enter password 123456";
   
    SoftAssert softassert = new SoftAssert();
    softassert.assertEquals(actualResult_emailError, expectedResult_emailError);
   
    softassert.assertEquals(actualResult_passwordError, expectedResult_password);
    softassert.assertAll();


    }catch(IOException e) 
	{
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
 }
	
   @DataProvider(name="logintestdata")
    public Object[][] LoginDataProvider()
	{
		Object[][] testObjArray=ReadExcelSheet("D:\\Selenium_Workspace\\227_IMPDemoExcelFile\\Login_And_Pwd.xlsx");
	    return testObjArray;
	}
	
	
	
// excel file read krnekeleye
	public Object[][] ReadExcelSheet(String path)
	{
		String[][] tabArray = null;
		int ci,cj;
		
		try {
			FileInputStream fis=new FileInputStream(path);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet objSheet = workbook.getSheetAt(0);
			
			int rowCount = objSheet.getLastRowNum();
			System.out.println(rowCount);
			
			tabArray = new String[rowCount][2];
			ci=0;
			for(int i=1;i<=rowCount;i++,ci++) 
			{
				cj=0;
				XSSFRow row = objSheet.getRow(i);
				
				for(int j=0;j<2;j++,cj++) 
				{
				tabArray[ci][cj]=row.getCell(j).getStringCellValue();	
				}
			}
			workbook.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tabArray;
		
	}
	
}
