package com.lms.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lms.utilities.ConfigReader;

public class LoginPage {
	WebDriver driver;
	int respCode = 200;

	 @FindBy (xpath  = "//form//button[@id='login']") WebElement loginBtn ;
	 @FindBy (xpath  = "//div//input[@id='username']") WebElement userTextLogin;
	 @FindBy (xpath  = "//div//input[@id='password']") WebElement passwordTextLogin;
	 public LoginPage(WebDriver driver){
			this.driver= driver;
	        PageFactory.initElements(driver, this);

	 }
	 
	 public void url() {
		   ConfigReader.load_prop(); 
	        
		   String url = ConfigReader.getProp("baseUrl");
		   driver.get(url);
		   
	        
	        // Use the URL as needed
		   System.out.println("The URL is: " + url);
		   
	 }
     public void loginUser(String user) {
    	 userTextLogin.sendKeys(user);
     }
     
     public void loginPassword(String pass) {
    	 passwordTextLogin.sendKeys(pass);
     }
     public void signIn() {
    	 loginBtn.click();
     }
}
