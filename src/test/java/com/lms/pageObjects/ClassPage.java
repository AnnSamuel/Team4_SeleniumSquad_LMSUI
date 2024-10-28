package com.lms.pageObjects;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.lms.utilities.LMSUIConstants.*;

public class ClassPage extends BasePage {

	@FindBy(xpath = "//span[text()='Class']/..")
	WebElement classLink;
	@FindBy(xpath = "//div[contains(@role, 'dialog')]")
	WebElement addNewPopup;
	@FindBy(xpath = "//span[@id='pr_id_85-label']")
	WebElement PopupTitle;
	@FindBy(xpath = "//div[text()=' Manage Class']")
	WebElement pageTitle;
	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
	WebElement headerTitle;
	@FindBy(id = "filterGlobal")
	WebElement searchBar;
	@FindBy(xpath = "//button[text()='Add New Class']")
	WebElement addNewBtn;
	@FindBy(xpath = "//span[text()='Cancel']")
	WebElement cancelBtn;
	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;
	@FindBy(xpath = "//span[contains(@class,'p-dialog-header-close-icon ng-tns')]")
	WebElement closeBtn;
	@FindBy(xpath = "//span[@class='p-button-icon pi pi-calendar']")
	WebElement calenderIcon;
	@FindBy(xpath = "//input[@id='classTopic']")
	WebElement classTopic;
	@FindBy(xpath = "//label[text()='No of Classes']")
	WebElement noOfClassesLabel;
	@FindBy(xpath = "//input[@id='classNo']")
	WebElement noOfClasses;
	@FindBy(xpath = "//input[@id='icon']")
	WebElement classDates;
	@FindBy(xpath = "//input[@placeholder='Select a Batch Name']")
	WebElement batchNamedd;
	@FindBy(xpath = "//input[@placeholder='Select a Staff Name']")
	WebElement staffNamedd;
	@FindBy(xpath = "//input[@id='Active']/../..")
	WebElement statusActiveOption;
	@FindBy(xpath = "//input[@id='Inactive']/../..")
	WebElement statusInactiveOption;
	@FindBy(xpath = "//button[@id='saveClass']")
	WebElement savebtn;
	@FindBy(xpath = "//input[@id = 'classDescription']")
	WebElement classDescText;
	@FindBy(xpath = "//input[@id = 'classComments']")
	WebElement classCommentsText;
	@FindBy(xpath = "//input[@id = 'classNotes']")
	WebElement classNotesText;
	@FindBy(xpath = "//input[@id = 'classRecordingPath']")
	WebElement classRecordingText;

	JavascriptExecutor js = (JavascriptExecutor) driver;



	Map<String, String> classData;

	public void openPage() {
		driver.get(BASE_URL + "session");

	}

	public boolean isOnClassPage() {
		if (driver.getCurrentUrl().contains("session")) {
			return true;
		}
		return false;
	}

	public boolean selectDate(String dateStr) {

		try {
			Date date = DateFormat.getDateInstance().parse(dateStr);

			WebElement wb = driver.findElement(By.xpath(
					"//span[contains(@class,'p-ripple ng-star-inserted')] and text() = '" + date.getDay() + "']"));
			if (wb.isEnabled()) {
				wb.click();
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void createClassInputFields(String testcase) {

		classData = applicationData.getData("Class", testcase); // TestData from Excel based on the testcase
		
		driver.findElements(By.xpath("//div[@aria-haspopup='listbox']")).get(0).click();
		System.out.println("");
		wait(100);
		if (classData.get("Batchname") != null) {
			driver.findElement(By.xpath("//li[@aria-label='" + classData.get("Batchname") + "']")).click();
		}
		batchNamedd.sendKeys(Keys.TAB);
		if (classData.get("ClassTopic") != null) {
			sendKeys(classTopic, classData.get("ClassTopic"));
		}
		if (classData.get("ClassDescription") != null) {
			sendKeys(classDescText, classData.get("ClassDescription"));
		}

		// datepicker
//		String dateValues = classData.get("SelectClassDates");
//		for (String val : dateValues.split(",")) {
//			selectDate(val);
//		}
		
		click(classDates);
		if (classData.get("SelectClassDates") != null) {
			sendKeys(classDates, classData.get("SelectClassDates"));
		}
		classDates.sendKeys(Keys.TAB);
		
		js.executeScript("arguments[0].scrollIntoView(true);", staffNamedd);
		driver.findElements(By.xpath("//div[@aria-haspopup='listbox']")).get(1).click();
		
		if (classData.get("StaffName") != null) {
			driver.findElement(By.xpath("//li[@aria-label='" + classData.get("StaffName") + "']")).click();
		}
		
		staffNamedd.sendKeys(Keys.TAB);
		
		click(statusActiveOption);
		if (classData.get("Comments") != null) {
			sendKeys(classCommentsText, classData.get("Comments"));
		}
		if (classData.get("Notes") != null) {
			sendKeys(classNotesText, classData.get("Notes"));
		}
		if (classData.get("Recording") != null) {
			sendKeys(classRecordingText, classData.get("Recording"));
		}
		
		click(savebtn);
		applicationData.getClassTopics().add(classData.get("ClassTopic"));

	}
	
	

	public boolean searchClass() {

		String applnClassTopic = applicationData.getClassTopics().get(0);
		// searchText(text);
		System.out.println("applnClassTopic ======>" + applnClassTopic);
		sendKeys(searchBar, applnClassTopic);
		searchBar.sendKeys(Keys.TAB);
		String dataTableClassTopic = getText(
				driver.findElement(By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[3]")));
		if (dataTableClassTopic.equalsIgnoreCase(applnClassTopic)) {
			return true;
		}

		return false;

	}

	public boolean verifySearhBox() {
		if (searchBar.isEnabled()) {
			return true;
		}
		return false;
	}

	public boolean verifyPopupTextField() {

		if (classTopic.isDisplayed() && noOfClasses.isDisplayed() && classDates.isDisplayed()) {
			return true;
		}
		return false;
	}

	public void addNewBtnClick() {
		click(addNewBtn);
	}

	public boolean verifyPopup() {
		if (isDisplayed(cancelBtn) && isDisplayed(saveBtn) && isDisplayed(closeBtn)) {
			return true;
		}
		return false;
	}

	public void classBtnClick() {
		click(classLink);

	}

	public boolean verifyPageTitle(String expected) {

		if (getText(pageTitle).equals(expected)) {
			return true;
		}

		return false;
	}

	public boolean verifyHeaderTitle(String expected) {

		if (getText(headerTitle).equals(expected)) {
			return true;
		}

		return false;
	}

	public String validateAddNewPopupTitle() {
		if (addNewPopup.isDisplayed()) {
			String poptitle = PopupTitle.getText();
			System.out.println("popup title text is: " + poptitle);
			return PopupTitle.getText();
		} else {
			return "";
		}
	}

}
