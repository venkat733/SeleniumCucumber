package com.DataTableCucumber;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility {
	String strUrl;
	public Utility(){
		credentials();
	}
	public void credentials() {
File file = new File("C:\\Users\\vmalarvannan\\eclipse-workspace\\DataTableCucumber\\src\\test\\resources\\Features\\Credentials.properties");
		
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

	}


}
