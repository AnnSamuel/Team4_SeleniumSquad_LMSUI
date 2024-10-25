package com.lms.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.lms.driverManager.WebDriverFactory;
import com.lms.utilities.ConfigReader;

public class BasePage {
	
	protected WebDriver driver = WebDriverFactory.getDriver();
	protected String BASE_URL=ConfigReader.getProp("baseUrl");
	
	public BasePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void openPage(String pagename) {
		driver.get(BASE_URL + pagename);
				
	}
	
	public void search(String text) {
		
	}
	
	public void singleDelete() {
		
	}
	
	public void multipleDelete() {
		
		
	}
	
	
	
	public WebDriver getDriver() {
		return driver;
	}
	
	
	
}


