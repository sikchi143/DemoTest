package com.jbk.exclipit_Main;

import com.jbk.exclipit_wait.Demo_Exclipit_Wait;


public class Demo_Main {
	
public static void main(String[] args) {
		
		Demo_Exclipit_Wait obj = new Demo_Exclipit_Wait();
		
		obj.ConfigSetting("https://www.qa.jbktest.com/");
		
		obj.search();
		}
   }
