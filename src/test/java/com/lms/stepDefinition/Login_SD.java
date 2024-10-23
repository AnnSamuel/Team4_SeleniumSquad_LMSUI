package com.lms.stepDefinition;

import java.time.Duration;
import java.util.Map;

//import static com.lms.utilities.LMSUIConstants.LOGIN_SHEET_NAME;
import static com.lms.utilities.LMSUIConstants.applicationData;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.lms.utilities.LMSUIConstants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_SD {

	@Given("Admin is in login Page")
	public void admin_is_in_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	  
	   System.out.println("at given");
	}
	
	@When("Admin enter valid credentials {string} and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button(String testcase) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
//		Map<String,String> testRow = applicationData.getData(LMSUIConstants.LOGIN_SHEET_NAME,testcase);
//		System.out.println("check test data " + testRow.toString());
	}

	@Then("Admin should land on dashboard page \\( centre of the page will be empty , menu bar is present).")
	public void admin_should_land_on_dashboard_page_centre_of_the_page_will_be_empty_menu_bar_is_present() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
}
