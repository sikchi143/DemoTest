package com.utilitis;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils {
	
	public static String readProperty(String key) throws Exception 
	{
		Properties prop = new Properties();
		String Path =System.getProperty("user.dir")+"/src/main/resources/config.properties";
		FileInputStream fis = new FileInputStream(Path);
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	

}
