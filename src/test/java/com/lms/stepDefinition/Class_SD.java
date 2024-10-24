package com.lms.stepDefinition;

import com.lms.pageObjects.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Class_SD {
	
	//#####################################Febi########################################################
	
	LoginPage lp = new LoginPage();
	
	@Given("Admin is on the Dashboard Page")
	public void admin_is_on_the_dashboard_page() {
		
		if(!lp.isLoggedIn()) {
			
			lp.login("ValidCredentials");
		}
	}

	@When("Admin clicks the {string} in the Header")
	public void admin_clicks_the_in_the_header(String string) {

		
	
	}

	@Then("Admin should land on the {string}")
	public void admin_should_land_on_the(String string) {

	
	
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////
	
	//Ann
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
