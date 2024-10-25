package com.lms.stepDefinition;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.lms.driverManager.WebDriverFactory;
import com.lms.pageObjects.ProgramPage;
import com.lms.utilities.LoggerLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Program_SD {
	
	WebDriver driver = WebDriverFactory.getDriver();
	ProgramPage programObj = new ProgramPage();
	String searchText = "";
	
	@Given("Admin is on the Dashboard Page")
	public void admin_is_on_the_dashboard_page() {
		programObj.login();
	    
	}
	
	@When("Admin clicks Program on the navigation bar")
	public void admin_clicks_program_on_the_navigation_bar() {
		programObj.clickProgramBtn();
	    
	}
	@Then("Admin should be navigated to Program module")
	public void admin_should_be_navigated_to_program_module() {
	    Assert.assertEquals(programObj.getProgramHeading(), "Manage Program");
	}
	
	@Then("Admin should see {string} in menu bar")
	public void admin_should_see_in_menu_bar(String logout) {
	    
	}

	@Then("Admin should not have any broken links for Program module")
	public void admin_should_not_have_any_broken_links_for_program_module() {
	   
	}
	
	@Then("Admin should see the heading {string}")
	public void admin_should_see_the_heading(String string) {
	    
	}
	
	@Then("Admin should see the module names as in order")
	public void admin_should_see_the_module_names_as_in_order() {
	
	}
	
	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String string) {
	    
	}
	
	//Search
	
	@Given("Admin is on Program module")
	public void admin_is_on_program_module() {
		programObj.clickProgramBtn();
	    
	}
	@When("Admin enter the program to search By program details {string}")
	public void admin_enter_the_program_to_search_by_program_details(String searchInput) {
		
		programObj.setSearchText(searchInput);
		searchText = searchInput;
		
		
	    
	}
	@Then("Admin should able to see Program name, description, and status for searched program name")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_name() {
		ArrayList<String> programNames = programObj.getProgramNames();
		if(programObj.validateSearch(programNames,searchText)) {
			LoggerLoad.info(programNames.size()+"");
			LoggerLoad.info("matches");
		}
		else {
			LoggerLoad.info("not matches");
		}
	}

}
