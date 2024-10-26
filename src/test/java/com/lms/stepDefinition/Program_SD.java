package com.lms.stepDefinition;

import static com.lms.utilities.LMSUIConstants.applicationData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.lms.driverManager.WebDriverFactory;
import com.lms.pageObjects.BasePage;
import com.lms.pageObjects.ClassPage;
import com.lms.pageObjects.LoginPage;
import com.lms.pageObjects.PageObjectFactory;
import com.lms.pageObjects.ProgramPage;
import com.lms.utilities.LMSUIConstants;
import com.lms.utilities.LoggerLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Program_SD {
	
	LoginPage loginObj = PageObjectFactory.getLoginPage();
	ProgramPage programObj = PageObjectFactory.getProgramPage();
	String testcaseName = "";
	
//	@Given("Admin is on the Dashboard Page")
//	public void admin_is_on_the_dashboard_page() {
//		programObj.login();
//	    
//	}
	
	@Then("Admin should land on the {string} page on Program module")
	public void admin_should_land_on_the_page_on_program_module(String expected) {

		Assert.assertEquals(true, programObj.verifyPageTitle(expected));

	}
	
	//Add new program
	
	@Given("Admin is on the Manage Program page")
	public void admin_is_on_the_manage_program_page() {
		System.out.println("program Manage ############" + programObj);
		if (!applicationData.isLoggedIn()) {
			loginObj.login("ValidCredentials");

		}
		if (!programObj.isOnProgramPage()) {
			programObj.clickProgramBtn();
		}

	}
	
	
	@When("Admin clicks add new program under the program menu bar")
	public void admin_clicks_add_new_program_under_the_program_menu_bar() {

		programObj.clickAddNewProgramBtn();
	}

	@Then("Admin should see program details pop up with empty form and <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_program_details_pop_up_with_empty_form_and_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {

		Assert.assertEquals(programObj.verifyPopup(),true);

	}

	@Then("Admin should see program name description and status fields in the program details window")
	public void admin_should_see_program_name_description_and_status_fields_in_the_program_details_window() {

		Assert.assertEquals(programObj.verifyPopupTextField(),true);

	}
	
	@Given("Admin is on the program Popup window")
	public void admin_is_on_the_program_popup_window() {

		if (!applicationData.isLoggedIn()) {
			loginObj.login("ValidCredentials");
		}
		programObj.clickProgramBtn();
		programObj.clickAddNewProgramBtn();
	}
	
	@When("Admin enters {string} mandatory fields in the add program form and clicks on save button")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_save_button(String testcase) {
		
		programObj.validateInputMandatoryFields(testcase);
		programObj.clickSaveBtn();

	}

	@Then("Admin gets message program added Successfully")
	public void admin_gets_message_class_added_successfully() {
       programObj.validateAddNewPopupTitle();
		
	}
	
	@Then("Admin gets error text on program details popup")
	public void admin_gets_error_text_on_program_details_popup() {
       programObj.validateErrorText();
		
	}
	
	//cancel
	@When("Admin clicks the cancel button in the program details window")
	public void admin_clicks_the_cancel_button_in_the_program_details_window() {
	    programObj.clickCancelBtn();
	}
	
	//close
	@When("Admin clicks the close X button in the program details window")
	public void admin_clicks_the_close_x_button_in_the_program_details_window() {
	    programObj.clickCloseBtn();
	}
	
	@Then("The program details window is closed and new program is not created")
	public void the_program_details_window_is_closed_and_new_program_is_not_created() {
	    Assert.assertEquals(programObj.validateAddNewPopup(), "false");
	    
	    
	}
	
	//Edit program
	
	@When("Admin clicks edit program button for a program")
	public void admin_clicks_edit_program_button_for_a_program() {
		//programObj.clickEditProgram();
	    
	}
	@Then("Admin should see a program details pop up with filled form and <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_program_details_pop_up_with_filled_form_and_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
	    
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
	@When("Admin enter the program to search by {string}")
	public void admin_enter_the_program_to_search_by_valid(String testcase) {
		programObj.setSearchText(testcase);
		testcaseName = testcase;
	}
	
	@Then("Admin should able to see Program name, description, and status for searched program name")
	    public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_name() {
		
		LoggerLoad.info("in then step");
		String searchInput = LMSUIConstants.applicationData.getSearchInput();
		if(testcaseName.toLowerCase().contains("programname")) {
			LoggerLoad.info("search inside program name loop");
			ArrayList<String> programNames = programObj.getProgramNamesList();
			Assert.assertEquals(programObj.validateSearch(programNames, searchInput), true);
		}
		else if(testcaseName.toLowerCase().contains("programdesc")) {
			LoggerLoad.info("search inside program desc loop");
			ArrayList<String> programDescList = programObj.getProgramDescriptionsList();
			Assert.assertEquals(programObj.validateSearch(programDescList, searchInput), true);	
		}
	    
	}

	@Then("Admin should able to see multiple program results for searched program name")
	public void admin_should_able_to_see_multiple_program_results_for_searched_program_name() {
	    
	}

	@Then("Admin should able to see Program name, description, and status for searched program description")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_description() {
	    
	}

	@Then("Admin should able to see multiple program results for searched program description")
	public void admin_should_able_to_see_multiple_program_results_for_searched_program_description() {
	    
	}
	
	@Then("Admin should not view any search results")
	public void admin_should_not_view_any_search_results() {
	   
	}
	


}
