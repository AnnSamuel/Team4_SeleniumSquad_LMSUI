package com.lms.stepDefinition;

import static com.lms.utilities.LMSUIConstants.applicationData;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.testng.Assert;
import org.testng.util.Strings;

import com.lms.pageObjects.BatchPage;
import com.lms.pageObjects.LoginPage;
import com.lms.pageObjects.PageObjectFactory;
import com.lms.utilities.LMSUIConstants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Batch_SD {

	LoginPage lp = PageObjectFactory.getLoginPage();
	BatchPage batchPage = PageObjectFactory.getBatchPage();

	@Given("Admin is on the Dashboard Page - Batch")
	public void admin_is_on_the_dashboard_page() {
		if (!applicationData.isLoggedIn()) {
			lp.login("ValidCredentials");
		}
	}

	@When("Admin Clicks on the {string} menu from the header - Batch")
	public void admin_clicks_on_the_menu_from_the_header(String string) {
		if (!batchPage.isOnBatchPage()) {
			batchPage.clickOnBatchBtn();
		}
	}

	@Then("Admin should be in the {string} Page - Batch")
	public void admin_should_be_in_the_page(String string) {
		Assert.assertEquals(batchPage.getHeading(), string);
	}

	@Then("Admin should see a title with text as {string} - Batch")
	public void admin_should_see_a_title_with_text_as(String string) {
		Assert.assertEquals(batchPage.getTitle(), string);
	}

	@Given("Admin is on batch page - Batch")
	public void admin_is_on_batch_page() {
		if (batchPage.isOnBatchPage() && batchPage.isOnBatchPopuUpindow()) {
			batchPage.clickCloseBtn();
		}
		
		if (!batchPage.isOnBatchPage()) {
			batchPage.clickOnBatchBtn();
			batchPage.closeSubMenu();
		}
	}

	@When("Admin clicks {string} on the navigation bar - Batch")
	public void admin_clicks_on_the_navigation_bar(String string) {
		if (!batchPage.isOnBatchPage()) {
			batchPage.clickOnBatchBtn();
		}

	}

	@Then("Admin should see the {string} Heading - Batch")
	public void admin_should_see_the_heading(String string) {
		Assert.assertEquals(batchPage.getHeading(), string);
	}

	@Then("Admin should see sub menu in menu bar as {string} - Batch")
	public void admin_should_see_sub_menu_in_menu_bar_as(String string) {
		Assert.assertEquals(batchPage.getMenuItemText(), string);

	}

	@Then("Admin should see the {string} {string} under the header - Batch")
	public void admin_should_see_the_under_the_header(String string, String string2) {
		boolean isEnabled = false;
		if ("enabled".equalsIgnoreCase(string)) {
			isEnabled = true;
		}

		Assert.assertEquals(batchPage.isTopDeleteButtonEnabled(), isEnabled);

	}

	@When("Admin clicks on {string} under the {string} menu bar - Batch")
	public void admin_clicks_on_under_the_menu_bar(String string, String string2) {
		if (!batchPage.isOnBatchPage()) {
			batchPage.clickOnBatchBtn();
		}

		batchPage.clickOnMenuItem();
	}

	@Then("Admin should see the Batch Details pop up window - Batch")
	public void admin_should_see_the_batch_details_pop_up_window() {
		Assert.assertEquals(batchPage.getPopUpWindowTitle(), "Batch Details");
	}

	@Then("Admin should see the edit icon in each row - Batch")
	public void admin_should_see_the_edit_icon_in_each_row() {
		Assert.assertEquals(batchPage.isEditIconsPresentInEachRow(), true);
	}

	@Then("Admin should see the delete icon in each row - Batch")
	public void admin_should_see_the_delete_icon_in_each_row() {
		Assert.assertEquals(batchPage.isDeleteIconsPresentInEachRow(), true);
	}

	@Then("Admin should the checkbox in each row - Batch")
	public void admin_should_the_checkbox_in_each_row() {
		Assert.assertEquals(batchPage.isCheckBoxPresentInEachRow(), true);
	}

	@Then("Admin should see the datatable headers - Batch")
	public void admin_should_see_the_datatable_headers() {
		Assert.assertEquals(batchPage.verifyTableHeaders("Batch Name "), true);
		Assert.assertEquals(batchPage.verifyTableHeaders("Batch Description "), true);
		Assert.assertEquals(batchPage.verifyTableHeaders("Batch Status "), true);
		Assert.assertEquals(batchPage.verifyTableHeaders("No Of Classes "), true);
		Assert.assertEquals(batchPage.verifyTableHeaders("Program Name "), true);
	}

	@Then("Admin should see the checkbox in the datatable header row - Batch")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
		batchPage.verifyCheckBoxInHeader();
	}

	@Then("Admin should see the sort icon next to all Datatable headers - Batch")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
		Assert.assertEquals(batchPage.verifySortIconInHeaders("Batch Name "), true);
		Assert.assertEquals(batchPage.verifySortIconInHeaders("Batch Description "), true);
		Assert.assertEquals(batchPage.verifySortIconInHeaders("Batch Status "), true);
		Assert.assertEquals(batchPage.verifySortIconInHeaders("No Of Classes "), true);
		Assert.assertEquals(batchPage.verifySortIconInHeaders("Program Name "), true);
	}

	@Given("Admin is on the Batch Details Pop Up WIndow - Batch")
	public void admin_is_on_the_batch_details_pop_up_w_indow() {
		if (!applicationData.isLoggedIn()) {

			lp.login("ValidCredentials");

		}

		if (batchPage.isOnBatchPage() && batchPage.isOnBatchPopuUpindow()) {
			batchPage.clickCloseBtn();
		}

		batchPage.clickOnBatchBtn();
		batchPage.clickOnMenuItem();
		Assert.assertEquals(batchPage.getPopUpWindowTitle(), "Batch Details");
	}

	@When("Admin selects program name present in the dropdown - Batch")
	public void admin_selects_program_name_present_in_the_dropdown() {
		batchPage.inputBatchFields("ValidProgramName");

	}

	@Then("Admin should see selected program name in the batch name prefix box - Batch")
	public void admin_should_see_selected_program_name_in_the_batch_name_prefix_box() {
		Map<String, String> batchTestData = LMSUIConstants.applicationData.getData("Batch", "ValidProgramName");
		String programName = batchTestData.get("ProgramName");
		Assert.assertEquals(batchPage.getSelectedProgramName(), programName);

	}

	@When("Admin enters the {string} data and clicks {string} button - Batch")
	public void admin_enters_the_data_and_clicks_button(String string, String string2) {
		if ("Mandatory".equalsIgnoreCase(string)) {
			batchPage.inputBatchFields("validInputMandatory");
		} else {
			batchPage.inputBatchFields(string);
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if ("save".equalsIgnoreCase(string2)) {
			batchPage.clickSaveBtn();
		} else if ("cancel".equalsIgnoreCase(string2)) {
			batchPage.clickCancelBtn();
		} else if ("close".equalsIgnoreCase(string2)) {
			batchPage.clickCloseBtn();
		}
	}

	@When("Admin enters alphabets in batch name suffix box - Batch")
	public void admin_enters_alphabets_in_batch_name_suffix_box() {
		batchPage.inputBatchFields("InvalidBatchName");
	}

	@Then("Admin should get error message below the text box of respective field - Batch")
	public void admin_should_get_error_message_below_the_text_box_of_respective_field() {
		Assert.assertEquals(batchPage.getErrorForField(), "This field accept only numbers and max 5 count.");
	}

	@Then("Admin should get error message below the text box of respective field for {string} - Batch")
	public void admin_should_get_error_message_below_the_text_box_of_respective_field_for(String string) {
		Assert.assertEquals(batchPage.getErrorForField(),
				LMSUIConstants.applicationData.getData("Batch", string).get("ErrorMessage"));
	}

	@When("Admin enters alphabets in batch {string} box - Batch")
	public void admin_enters_alphabets_in_batch_box(String string) {
		if (string.equalsIgnoreCase("name prefix")) {
			batchPage.inputBatchFields("InvalidBatchNamePrefix");
		}

	}

	@Then("Admin should see empty text box - Batch")
	public void admin_should_see_empty_text_box() {
		Assert.assertEquals(batchPage.getBatchNamePefix(), "");

	}

	@Then("Admin should get a successful message - Batch")
	public void admin_should_get_a_successful_message() {
		Assert.assertEquals(batchPage.saveActionPopup(), "Successful");
	}

	@Then("Admin can see the batch details popup closes without creating any batch - Batch")
	public void admin_can_see_the_batch_details_popup_closes_without_creating_any_batch() {
//		Assert.assertEquals(batchPage.isSaveBatchPopupDisplayed(), false);
		Assert.assertEquals(batchPage.getHeading(), "Manage Batch");

	}

	@When("Admin clicks edit batch button for a batch {string} - Batch")
	public void admin_clicks_edit_batch_button_for_a_batch(String string) {
		String expectedatchNameTxt = batchPage.getBatchName(string);
		batchPage.search(expectedatchNameTxt);
		batchPage.clickEditBatch();
	}
	
	@Then("Admin should see {string} value field is disabled for editing - Batch")
	public void admin_should_see_value_field_is_disabled_for_editing(String string) {
		if(string.equalsIgnoreCase("Program name")) {
			batchPage.isProgramNameEditable();
		} else if(string.equalsIgnoreCase("Batch name")) {
			batchPage.isBatchNameEditable();
		}
		 
	}
	
	@When("Admin enters the batch name {string} in the search text box - Batch")
	public void admin_enters_the_batch_name_in_the_search_text_box(String string) {
		String expectedatchNameTxt = batchPage.getBatchName(string);
		batchPage.search(expectedatchNameTxt);
	}
	
	@Then("Admin should see the filtered {string} batches in the data table - Batch")
	public void admin_should_see_the_filtered_batches_in_the_data_table(String string) {
		
		String expectedatchNameTxt = batchPage.getBatchName(string);
		
		List<String> list = batchPage.getBatchNamesForAllRows();
		Assert.assertTrue(list.size()>0);
		System.out.println("SIZE=" + list.size());
		for(String batchName: list) {
			Assert.assertTrue(batchName.startsWith(expectedatchNameTxt));
		}
	}
	
	
}
