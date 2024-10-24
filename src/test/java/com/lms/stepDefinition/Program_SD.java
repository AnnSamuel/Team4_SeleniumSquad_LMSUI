package com.lms.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.lms.driverManager.WebDriverFactory;
import com.lms.pageObjects.ProgramPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Program_SD {
	
	WebDriver driver = WebDriverFactory.getDriver();
	ProgramPage programObj = new ProgramPage();
	
	@Given("the user is in homepage and logged in")
	public void the_user_is_in_homepage_and_logged_in() {
		programObj.login();
		
	    
	}

	@When("user clicks the program button in the menu bar")
	public void user_clicks_the_program_button_in_the_menu_bar() {
		programObj.clickProgramBtn();
		
	    
	}

	@Then("user views the program page")
	public void user_views_the_program_page() {
		Assert.assertEquals(programObj.getProgramHeading(),"Manage Program");
	    
	}

	@Given("the user is in program page")
	public void the_user_is_in_program_page() {
		programObj.login();
		programObj.clickProgramBtn();
	    
	}

	@When("user clicks the edit button for the {string}")
	public void user_clicks_the_edit_button_for_the(String programName) {
		programObj.clickEditProgram(programName);
	    
	}

	@Then("user views the edit program popup")
	public void user_views_the_edit_program_popup() {
		Assert.assertEquals(programObj.getEditProgramHeading(), "Program Details");
	    
	}

}
