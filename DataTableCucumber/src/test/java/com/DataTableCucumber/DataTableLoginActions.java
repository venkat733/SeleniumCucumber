package com.DataTableCucumber;

import org.openqa.selenium.support.PageFactory;





public class DataTableLoginActions {
	DataTableLocators loginPageLocators=null;
	public DataTableLoginActions() {
		this.loginPageLocators=new DataTableLocators();
		PageFactory.initElements(HelperClass.getDriver(), loginPageLocators);
	}
	public void setUserName(String strUserName) {
		loginPageLocators.username.sendKeys(strUserName);
	}
	public void setPassword(String strPassword) {
		loginPageLocators.Password.sendKeys(strPassword);
	}
	public void clickLogin() {
		loginPageLocators.login.click();
	}
	
	public void login(String username, String password) {
		
		
		this.setUserName(username);
		this.setPassword(password);
		
		

}

}
