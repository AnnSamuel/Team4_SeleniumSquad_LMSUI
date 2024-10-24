package com.lms.stepDefinition;

import com.lms.pageObjects.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_SD {

	LoginPage lp = new LoginPage();
	
	@Given("Admin is in login Page")
	public void admin_is_in_login_page() {
	  
	   lp.openPage();
	   
	}
	
	@When("Admin enter login credentials {string} and clicks login button")
	public void admin_enter_login_credentials_and_clicks_login_button(String testcase) {
	  
		lp.login(testcase);
		
	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {

		
	}
}
