package com.lms.stepDefinition;

import org.testng.Assert;

import com.lms.pageObjects.BatchPage;

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
		Assert.assertEquals(string, batchPage.getHeading());
	}
	
	@Then("Admin should see a title with text as {string}")
	public void admin_should_see_a_title_with_text_as(String string) {
	    Assert.assertEquals(string, batchPage.getTitle());
	}

}
