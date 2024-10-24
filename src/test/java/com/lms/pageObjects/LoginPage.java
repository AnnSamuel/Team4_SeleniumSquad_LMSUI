package com.lms.pageObjects;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lms.utilities.LMSUIConstants;

public class LoginPage extends BasePage {


	Map<String, String> loginData;
	boolean isLoggedIn;

	@FindBy(xpath = "//form//button[@id='login']")
	WebElement loginBtn;
	@FindBy(xpath = "//div//input[@id='username']")
	WebElement userTextLogin;
	@FindBy(xpath = "//div//input[@id='password']")
	WebElement passwordTextLogin;

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public void enterUserNameId(String username) {
		userTextLogin.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordTextLogin.sendKeys(password);
	}
	public void clickOnLogin() {
		loginBtn.click();

	}
	public void openPage() {
		driver.get(BASE_URL + "login");
				
	}

	public void login(String testcase) {

		loginData = LMSUIConstants.applicationData.getData("Login", testcase);
		openPage("login");
		enterUserNameId(loginData.get("Username"));
		enterPassword(loginData.get("Password"));
		clickOnLogin();
		isLoggedIn = true;
	}
}
