package com.lms.pageObjects;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.lms.utilities.LMSUIConstants.*;

public class LoginPage extends BasePage {


	Map<String, String> loginData;
	
	//private static LoginPage instance; 

	@FindBy(xpath = "//form//button[@id='login']")
	WebElement loginBtn;
	@FindBy(xpath = "//div//input[@id='username']")
	WebElement userTextLogin;
	@FindBy(xpath = "//div//input[@id='password']")
	WebElement passwordTextLogin;
	
	/* private LoginPage() {} */
	
	/*
	 * public static LoginPage getInstance() { if(instance == null) { instance = new
	 * LoginPage(); } return instance; }
	 */

	
	public void openPage() {
		driver.get(BASE_URL + "login");
				
	}

	public void login(String testcase) {

		loginData = applicationData.getData("Login", testcase);
		openPage("login");
		sendKeys(userTextLogin,loginData.get("Username"));
		sendKeys(passwordTextLogin,loginData.get("Password"));
		click(loginBtn);
		applicationData.setLoggedIn(true);
	}
}
