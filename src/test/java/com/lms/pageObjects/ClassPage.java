package com.lms.pageObjects;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lms.utilities.LMSUIConstants;

public class ClassPage extends BasePage{
	
	
	@FindBy(xpath = "//span[text()='Class']/..") WebElement classLink;
	@FindBy(xpath = "//div[contains(@role, 'dialog')]") WebElement addNewPopup; 
   	@FindBy(xpath = "//span[@id='pr_id_85-label']") WebElement PopupTitle;
	@FindBy(xpath = "//div[text()=' Manage Class']") WebElement pageTitle;
	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']") WebElement headerTitle;
	@FindBy(id="filterGlobal") WebElement searchBar;
	@FindBy(xpath = "//button[text()='Add New Class']") WebElement addNewBtn;
	@FindBy(xpath = "//span[text()='Cancel']") WebElement cancelBtn;
	@FindBy(xpath="//span[text()='Save']")WebElement saveBtn;
	@FindBy(xpath = "//span[contains(@class,'p-dialog-header-close-icon ng-tns')]") WebElement closeBtn;
	@FindBy(xpath = "//span[@class='p-button-icon pi pi-calendar']") WebElement calenderIcon;
	@FindBy(xpath = "//input[@id='classTopic']") WebElement classTopic;
	@FindBy(xpath = "//input[@id='classNo']") WebElement noOfClasses;
	@FindBy(xpath = "//input[@id='icon']") WebElement classDates;
	
	
	
	
	
	
	@FindBy(id="deleteProgram")WebElement deletebtn;
//	@FindBy(id="filterGlobal")WebElement searchbtn;
	@FindBy(xpath="//span[text()='Confirm']")WebElement confirmlabel;
	@FindBy(xpath="//span[text()='Yes']")WebElement yesBtn;
	@FindBy(xpath="//span[text()='No']")WebElement noBtn;
	@FindBy(xpath="//*[contains(text(),'Are you sure you want to delete')]")WebElement contentTxt;
//	@FindBy(xpath="//span[@class='pi pi-times ng-tns-c133-4']")WebElement closeBtn;
	@FindBy(xpath="//div[contains(@class,'p-toast-summary')]")WebElement successPopupTitle;
	@FindBy(xpath="//div[contains(@class,'p-toast-detail')]")WebElement successPopupContent;
	
	@FindBy(xpath="//button[@class='p-button-rounded p-button-danger p-button p-component ng-star-inserted']")WebElement cancelbtn;
	
//	@FindBy(xpath="//span[@class='p-dialog-header-close-icon ng-tns-c132-3 pi pi-times']")WebElement crossbtn;
	@FindBy(xpath="//*[contains(text(),'Successful Program Created')]") WebElement pgmPopSuccessTxt;

	Map<String, String> classData;
	
	
	public void openPage() {
		driver.get(BASE_URL + "session");
				
	}
	
	public boolean isOnClassPage() {
		if(driver.getCurrentUrl().contains("session")) {
			return true;
		}
		return false;
	}
	
	public void validInputMandatoryFields(String testcase) {
		
		classData = LMSUIConstants.applicationData.getData("Class", testcase);
		
		sendKeys(classTopic, classData.get("ClassTopic"));
		sendKeys(noOfClasses, classData.get("NoofClasses"));
		sendKeys(classDates, classData.get("SelectClassDates"));
		
	}
	
	public boolean verifySearhBox() {
		if(searchBar.isEnabled()) {
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
		if(isDisplayed(cancelBtn) && isDisplayed(saveBtn) && isDisplayed(closeBtn)){
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
	    	System.out.println("popup title text is: " +poptitle);
	        return PopupTitle.getText();
	    } else {
	        return "";
	    	}
		}
	
	
	
}
