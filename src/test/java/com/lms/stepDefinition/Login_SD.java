package com.lms.stepDefinition;

import java.time.Duration;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.lms.driverManager.WebDriverFactory;
import com.lms.pageObjects.LoginPage;
import com.lms.utilities.ExcelReader;
import com.lms.utilities.LoggerLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_SD {
	WebDriverFactory driverFactory;
	WebDriver driver;
	LoginPage lp;
	
	public Login_SD() {
        // You can initialize driver or other components here if needed.
    }
	
	public Login_SD(WebDriverFactory driverFactory) {
		this.driverFactory=driverFactory;
		this.driver=driverFactory.getDriver();
		this.lp=driverFactory.getLoginPage();
		if (lp == null) {
		    System.out.println("LoginPage object is null!");
		} else {
		    System.out.println("LoginPage object is NOT null.");
		}
	}
	ExcelReader reader = new ExcelReader();
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
		  WebDriverFactory.initializeDriver("chrome");
		    
		    // Retrieve LoginPage through WebDriverFactory
		    lp = WebDriverFactory.getLoginPage();
		    
		    LoggerLoad.info("Admin Launch the Browser");
	}
@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		
	    Map<String, List<Map<String, String>>> excelData = ExcelReader.loadExcelData();

	    List<Map<String, String>> testData = excelData.get("Login");

	    // Retrieve specific data from the sheet, assuming you want to use the first row (0-indexed)
	    String userName = testData.get(0).get("Username");  // Changed "User" to "Username"
	    String passWord = testData.get(0).get("Password");

	    System.out.println(userName);
	    System.out.println(passWord);
	    // Use the data to interact with the login page
	    lp.url();
	    lp.loginUser(userName);
	    lp.loginPassword(passWord);
	    lp.signIn();
	    
	}
	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		System.out.println("Success");
		
	}
}
