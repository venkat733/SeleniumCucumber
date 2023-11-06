package com.CucumberFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;

public class TestLogger {
	 
	public static WebDriver driver;
	public static org.apache.logging.log4j.Logger log;
	
	public static void main(String[] args) {
		
		log = LogManager.getLogger(TestLogger.class);
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("Implicit wait is applied for 10 seconds");
		driver.get("https://www.myntra.com/");
		log.info("Logged into Myntra");
		
		try {
			boolean text = driver.findElement(By.xpath("//a[contains(text(),'Women')]")).isDisplayed();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			log.error("Exception occured",new Exception("Element Not Found"));
		}
		finally {
			driver.quit();
			log.info("Quitted the driver");
		}
	}
}
 