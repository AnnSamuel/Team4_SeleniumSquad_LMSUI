package com.lms.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.lms.driverManager.WebDriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Batch_SD {
	
	WebDriver driver = WebDriverFactory.getDriver();
	
	@Given("Admin is on the Dashboard Page")
	public void admin_is_on_the_dashboard_page() {
	   System.out.println("Admin is on the Dashboard Page");
	}

	@When("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
	   System.out.println("Admin Clicks on the Batch menu from the header");
	}

	@Then("Admin should be in the Manage Batch Page")
	public void admin_should_be_in_the_manage_batch_page() {
	  System.out.println("Admin should be in the Manage Batch Page");
	}




}
