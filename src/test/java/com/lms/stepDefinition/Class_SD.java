package com.lms.stepDefinition;

import org.testng.Assert;

import com.lms.pageObjects.ClassPage;
import com.lms.pageObjects.LoginPage;
import com.lms.pageObjects.PageObjectFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.lms.utilities.LMSUIConstants.*;

public class Class_SD {

	// #####################################Febi########################################################

//	LoginPage lp = new LoginPage();
//	ClassPage cp = new ClassPage();

	LoginPage lp = PageObjectFactory.getLoginPage();
	ClassPage cp = PageObjectFactory.getClassPage();
	
	@Given("Admin is on the Dashboard Page")
	public void admin_is_on_the_dashboard_page() {
		System.out.println("Class Dashboard======> " + cp + "loginPage " + lp);
		if (!applicationData.isLoggedIn()) {

			lp.login("ValidCredentials");
		}
	}

	@When("Admin clicks the {string} in the Header")
	public void admin_clicks_the_in_the_header(String btnText) {

		cp.clickElementByText(btnText);

	}

	@Then("Admin should land on the {string}")
	public void admin_should_land_on_the(String expected) {

		Assert.assertEquals(true, cp.verifyPageTitle(expected));

	}

	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String string) {

		Assert.assertEquals(true, cp.verifyHeaderTitle(string));

	}

	@Then("Admin should see the Searchbar")
	public void admin_should_see_the_searchbar() {

		Assert.assertEquals(true, cp.verifySearhBox());
	}

	// ###################################################################################################################
	// Add New Class Validation
	// ###################################################################################################################

	@Given("Admin is on the Manage class page")
	public void admin_is_on_the_manage_class_page() {
		System.out.println("Class Manage ############" + cp);
		if (!applicationData.isLoggedIn()) {
			lp.login("ValidCredentials");

		}
		if (!cp.isOnClassPage()) {
			cp.classBtnClick();
		}

	}

	@When("Admin clicks add new class under the class menu bar")
	public void admin_clicks_add_new_class_under_the_class_menu_bar() {

		cp.addNewBtnClick();
	}

	@Then("Admin should see a manage class pop up with empty form and <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_manage_class_pop_up_with_empty_form_and_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {

		Assert.assertEquals(true, cp.verifyPopup());

	}

	@Then("Admin should see few input fields and their respective text boxes in the class details window")
	public void admin_should_see_few_input_fields_and_their_respective_text_boxes_in_the_class_details_window() {

		Assert.assertEquals(true, cp.verifyPopupTextField());

	}

	@Given("Admin is on the Class Popup window")
	public void admin_is_on_the_class_popup_window() {

		if (!applicationData.isLoggedIn()) {

			lp.login("ValidCredentials");

		}
		if (!cp.isOnClassPage()) {
			cp.classBtnClick();
			cp.addNewBtnClick();
		}

	}

	@When("Admin enters mandatory fields in the form and clicks on save button")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_save_button() {

	}

	@Then("Admin gets message Class added Successfully")
	public void admin_gets_message_class_added_successfully() {

	}

	/////////////////////////////////////////////////////////////////////////

	// Ann

}
