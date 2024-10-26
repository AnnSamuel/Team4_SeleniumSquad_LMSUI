package com.lms.stepDefinition;

import org.testng.Assert;

import com.lms.pageObjects.BatchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Batch_SD {

	BatchPage batchPage = new BatchPage();

	@When("Admin Clicks on the {string} menu from the header")
	public void admin_clicks_on_the_menu_from_the_header(String string) {
		batchPage.clickOnBatchBtn();
	}

	@Then("Admin should be in the {string} Page")
	public void admin_should_be_in_the_page(String string) {
		Assert.assertEquals(batchPage.getHeading(), string);
	}

	@Then("Admin should see a title with text as {string}")
	public void admin_should_see_a_title_with_text_as(String string) {
		Assert.assertEquals(batchPage.getTitle(), string);
	}

	@Given("Admin is on batch page")
	public void admin_is_on_batch_page() {
		batchPage.clickOnBatchBtn();
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {
		// batchPage.clickOnBatchBtn();

	}

	@Then("Admin should see the {string} Heading")
	public void admin_should_see_the_heading(String string) {
		Assert.assertEquals(batchPage.getHeading(), string);
	}

	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String string) {
		Assert.assertEquals(batchPage.getMenuItemText(), string);

	}

	@Then("Admin should see the {string} {string} under the header")
	public void admin_should_see_the_under_the_header(String string, String string2) {
		boolean isEnabled = false;
		if ("enabled".equalsIgnoreCase(string)) {
			isEnabled = true;
		}

		Assert.assertEquals(batchPage.isTopDeleteButtonEnabled(), isEnabled);

	}

	@When("Admin clicks on {string} under the {string} menu bar")
	public void admin_clicks_on_under_the_menu_bar(String string, String string2) {
		batchPage.clickOnBatchBtn();
		batchPage.clickOnMenuItem();
	}

	@Then("Admin should see the Batch Details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {
		Assert.assertEquals(batchPage.getPopUpWindowTitle(), "Batch Details");
	}

	@Then("Admin should see the edit icon in each row")
	public void admin_should_see_the_edit_icon_in_each_row() {
		Assert.assertEquals(batchPage.isEditIconsPresentInEachRow(), true);
	}
	
	@Then("Admin should see the delete icon in each row")
	public void admin_should_see_the_delete_icon_in_each_row() {
		Assert.assertEquals(batchPage.isDeleteIconsPresentInEachRow(), true);
	}

	@Then("Admin should the checkbox in each row")
	public void admin_should_the_checkbox_in_each_row() {
		Assert.assertEquals(batchPage.isCheckBoxPresentInEachRow(), true);
	}
	
	@Then("Admin should see the datatable headers")
	public void admin_should_see_the_datatable_headers() {
	    Assert.assertEquals(batchPage.verifyTableHeaders("Batch Name "), true);
	    Assert.assertEquals(batchPage.verifyTableHeaders("Batch Description "), true);
	    Assert.assertEquals(batchPage.verifyTableHeaders("Batch Status "), true);
	    Assert.assertEquals(batchPage.verifyTableHeaders("No Of Classes "), true);
	    Assert.assertEquals(batchPage.verifyTableHeaders("Program Name "), true);
	}
	
	@Then("Admin should see the checkbox in the datatable header row")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
		batchPage.verifyCheckBoxInHeader();
	}

	
	@Then("Admin should see the sort icon next to all Datatable headers")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
		Assert.assertEquals(batchPage.verifySortIconInHeaders("Batch Name "), true);
	    Assert.assertEquals(batchPage.verifySortIconInHeaders("Batch Description "), true);
	    Assert.assertEquals(batchPage.verifySortIconInHeaders("Batch Status "), true);
	    Assert.assertEquals(batchPage.verifySortIconInHeaders("No Of Classes "), true);
	    Assert.assertEquals(batchPage.verifySortIconInHeaders("Program Name "), true);
	    Assert.assertEquals(batchPage.verifySortIconInHeaders(" Edit / Delete "), false);
	}

}
