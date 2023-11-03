package com.DataTableCucumber;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableLoginDefinition {
	WebDriver driver;
	DataTableLoginActions objLogin = new DataTableLoginActions();
	Utility data = new Utility();
	HomePageActions objHome = new HomePageActions();

	@Given("User is on OrangeHRM login webpage")
	public void user_is_on_orange_hrm_login_webpage() {
		  System.out.println("login page ");
		  HelperClass.openPage(data.strUrl);

	}

	@When("user must provide the correct credentials")
	public void user_must_provide_the_correct_credentials(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String,String>> signup = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> form : signup) {
			
			String username = form.get("Username");
			System.out.println("Username :" +username);
			driver.findElement(By.xpath("//*[@id=\\\"app\\\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys(username);
			
			String Password = form.get("Password");
			System.out.println("Password :" +Password);
			driver.findElement(By.xpath("//*[@id=\\\"app\\\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys(Password);
			
			objLogin.clickLogin();
		}

	}
	@Then("user is able to login suessfully and see homepage")
	public void user_is_able_to_login_suessfully_and_see_homepage() {
		Assert.assertTrue(objHome.getVerifyText().contains("Dashboard"));
		   System.out.println("sucessfull login");

	}

	@Then("User should be able to see unsucessfull with error message")
	public void user_should_be_able_to_see_unsucessfull_with_error_message() {
		String required =driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span")).getText();
		System.out.println("invalid credentials: "+required);
		Assert.assertTrue(required.equals("Required"));

	}


	

}
