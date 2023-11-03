package com.CucumberFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UtilityClass {
	String strUserName,strPassword,strUrl;
	public UtilityClass(){
		credentials();
	}
	public void credentials() {
File file = new File("C:\\Users\\vmalarvannan\\eclipse-workspace\\CucumberFileReading\\src\\test\\resources\\Properties\\Credentials.properties");
		
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch(FileNotFoundException e) {
			e.printStackTrace();			
		}
		
		Properties property = new Properties();
		
		try {
			property.load(fileInput);
		} catch(IOException e) {
			e.printStackTrace();
		}
		strUrl=property.getProperty("url");
		strUserName = property.getProperty("username");
		strPassword = property.getProperty("password");
	}

}
