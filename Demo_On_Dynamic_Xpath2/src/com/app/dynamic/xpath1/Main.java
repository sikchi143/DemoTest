package com.app.dynamic.xpath1;

import com.app.dynamic.xpath.Demo_On_Xpath;

public class Main {
	
	public static void main(String[] args) throws InterruptedException{
		
		Demo_On_Xpath obj = new Demo_On_Xpath();
		obj.Setting("https://register.rediff.com/register/register.php?FormName=user_details");
		obj.OptionSelect();
  }
}
