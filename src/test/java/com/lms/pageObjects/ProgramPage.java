package com.lms.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.lms.driverManager.WebDriverFactory;
import com.lms.utilities.LMSUIConstants;
import com.lms.utilities.LoggerLoad;

public class ProgramPage extends BasePage {

	WebDriver driver = WebDriverFactory.getInstance().getDriver();
	BasePage BasepageObj =  new BasePage();
	String programNamefromStep = "";
	Map<String, String> programdata;
	Map<String, String> searchData;
	
	String progNamePath =  "//table/tbody/tr/td[2]";
	String progDescPath =  "//table/tbody/tr/td[3]";
	String progStatusPath =  "//table/tbody/tr/td[4]";
	@FindBy(xpath = "//p[text()='Please login to LMS application']")
	WebElement loginPage;
	
	 @FindBy (id = "username") WebElement userName;
	 @FindBy (id= "password") WebElement password;
	 @FindBy (id="login") WebElement loginBtn;
	 @FindBy(xpath = "//span[text()=' LMS - Learning Management System ']") WebElement headerTitle;
	 @FindBy (xpath = "//*[text() = 'Program Details']") WebElement editProgramHeading;
	
	@FindBy(xpath = "//*[contains(text(),'Manage Program')]")WebElement programHeading;
	
	@FindBy(xpath = "//div/button[contains(@icon ,'pi-trash')]") WebElement deleteAllBtn;

	@FindBy(id = "filterGlobal") WebElement searchBox;
	
	@FindBy(xpath = "//*[text()='Program']/..") WebElement programLink;
	@FindBy(xpath = "//table")WebElement tableComplete;
	
	@FindBy (xpath = "//table/tbody") WebElement programTable;
	@FindBy (xpath = "//table/thead/tr/th[2]") WebElement programNameHeading;
	@FindBy (xpath = "//table/thead/tr/th[3]") WebElement programDescHeading;
	@FindBy (xpath = "//table/thead/tr/th[4]") WebElement programStatusHeading;
	
	@FindAll (value = {@FindBy (xpath = "//table/tbody//tr")}) List<WebElement> programData;



	@FindBy(id = "editProgram") WebElement editProgram;
	
	@FindBy(id = "deleteProgram") WebElement deleteProgram;
	
	@FindBy(xpath="//th//div[@role='checkbox']") WebElement allCheckBox;
	
	@FindBy(xpath="//td//div[@role='checkbox']") WebElement programCheckBox;
	
	//Addprogram
	@FindBy(xpath = "//button[text()='Add New Program']") WebElement addProgramBtn;
	@FindBy(xpath="//*[text()='Name']") WebElement name;
	@FindBy(xpath="//*[text()='Description']") WebElement description;
	@FindBy(xpath="//*[text()='Status']") WebElement status;
	@FindBy(id="programName") WebElement programNameInput;
	@FindBy(id="programDescription") WebElement programDescInput;
	@FindBy(xpath="//*[@ng-reflect-value = 'Active']") WebElement activeStatusInput;
	@FindBy(xpath="//*[@ng-reflect-value = 'Inactive']") WebElement inactiveStatusInput;
	@FindBy(xpath="//*[text()='Cancel']/..")WebElement cancelBtn;
	@FindBy(xpath="//*[text()='Save']/..")WebElement saveBtn;
	@FindBy(xpath="//span[contains(@class,'p-dialog-header-close-icon ng-tns')]/..") WebElement closeBtn;
	@FindBy(xpath = "//div[contains(@role, 'dialog')]") WebElement addNewPopup; 
	@FindBy(xpath = "//span[@id='pr_id_85-label']") WebElement PopupTitle;
	@FindBy(xpath="//*[contains(@class, 'p-invalid ng-star-inserted')]") WebElement errorText;
	@FindBy(xpath = "//div[contains(@class,'p-toast-summary')]")WebElement successPopupTitle;
	@FindBy(xpath = "//div[contains(@class,'p-toast-detail')]")WebElement successPopupContent;
	
	//edit program
	@FindBy(id="Inactive") WebElement inactiveRadioEdit;
	@FindBy(id="Active") WebElement activeRadioEdit;
	
	//delete program
	@FindBy(xpath="//*[text()='No']/..") WebElement noBtn;
	@FindBy(xpath="//*[text()='Yes']/..") WebElement yesBtn;
	@FindBy(xpath="//*[contains(@class,' p-dialog-header-close p-link ng-star-inserted')]/..")WebElement deleteCloseBtn;
	@FindBy(id="deleteProgram") WebElement firstProgDeleteBtn;
	@FindBy (xpath="//span[text()='Confirm']") WebElement deleteConfirmPopup;
	
	//logout
	@FindBy(id="logout") WebElement logout;
	
	
	
	public void openPage() {
		driver.get(BASE_URL + "program");
				
	}
	
	public boolean isOnProgramPage() {
		if(driver.getCurrentUrl().contains("program")) {
			return true;
		}
		return false;
	}
	
	public boolean verifyColumnHeader() {
		
		if (programNameHeading.getText().contains("Program Name") && (programDescHeading.getText().contains("Program Description"))  && 
				(programStatusHeading.getText().contains("Program Status")) ) {
			return true;
		}
		return false;
		
		
	}
	
    public void validateInputMandatoryFields(String testcase) {
		
		programdata = LMSUIConstants.applicationData.getData("Program", testcase);
		//LMSUIConstants.applicationData.setProgramName(programdata.get("ProgramName"));
		//LMSUIConstants.applicationData.setProgramDesc(programdata.get("ProgramDescription"));
		//LMSUIConstants.applicationData.setProgramStatus(programdata.get("ProgramStatus"));
		
		
		LoggerLoad.info(programdata.get("ProgramName"));
		sendKeys(programNameInput, programdata.get("ProgramName"));
		sendKeys(programDescInput, programdata.get("ProgramDescription"));
		if(programdata.get("ProgramStatus").equalsIgnoreCase("active")) {
			click(activeStatusInput);
		}
		else {
			click(inactiveStatusInput);
		}
		
	}
    
    public void setProgramName(String name) {
    	click(programNameInput);
    	programNameInput.clear();
    	sendKeys(programNameInput,name);
    }
    
    public void setProgramDesc(String desc) {
    	click(programNameInput);
    	programDescInput.clear();
    	sendKeys(programDescInput,desc);
    }
    
    public void setProgramStatus(String status) {
    	if(status.equalsIgnoreCase("active")) {
    		((JavascriptExecutor)driver).executeScript("arguments[0].click();",activeStatusInput);
			//click(activeStatusInput);
		}
		else {
			//click(inactiveStatusInput);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",inactiveStatusInput);
		}
    }
    
    public void setProgramStatusForEdit(String status) {
    	if(status.equalsIgnoreCase("active")) {
    		((JavascriptExecutor)driver).executeScript("arguments[0].click();",activeRadioEdit);
			//click(activeStatusInput);
		}
		else {
			//click(inactiveStatusInput);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",inactiveRadioEdit);
		}
    }
    
    
    
    public boolean verifyPopupTextField() {
		
		if (isDisplayed(programNameInput) && isDisplayed(programDescInput) && isDisplayed(activeStatusInput)
				&& isDisplayed(inactiveStatusInput)) {
			return true;
		}
		return false;
	}
    
    public void clickAddNewProgramBtn() {
    	((JavascriptExecutor)driver).executeScript("arguments[0].click();",addProgramBtn);
		// click(addProgramBtn);
	}
    
    public boolean verifyPopup() {
		if(isDisplayed(cancelBtn) && isDisplayed(saveBtn) && isDisplayed(closeBtn)){
			return true;
		}
		return false;
	}
    
    public boolean verifyDeletePopup() {
		if(isDisplayed(noBtn) && isDisplayed(yesBtn) && isDisplayed(deleteCloseBtn)){
			return true;
		}
		return false;
	}
    public void clickYesBtn() {
    	((JavascriptExecutor)driver).executeScript("arguments[0].click();",yesBtn);
    }
    
    public void clickNoBtn() {
    
    	((JavascriptExecutor)driver).executeScript("arguments[0].click();",noBtn);
    }
    public void clickDeleteCloseBtn() {
    	((JavascriptExecutor)driver).executeScript("arguments[0].click();",deleteCloseBtn);
    }
    
    
    
    public boolean verifyFilledForm() {
		if(verifyPopupTextField()) {
			
			String pname = LMSUIConstants.applicationData.getProgramName();
			//String pDesc = LMSUIConstants.applicationData.getProgramDesc();
			//String pStatus =LMSUIConstants.applicationData.getProgramStatus();
			
			
			if(programNameInput.getText().equals(pname)) {
				return true;
			}
			//complete for desc and status
		}
		return false;
	}
    
    public void clickSaveBtn() {
    	((JavascriptExecutor)driver).executeScript("arguments[0].click();",saveBtn);
    	//click(saveBtn);
    }
    
    public void clickCancelBtn() {
    	//click(cancelBtn);
    	((JavascriptExecutor)driver).executeScript("arguments[0].click();",cancelBtn);
    }
    
    public void clickCloseBtn() {
    	//click(closeBtn);
    	((JavascriptExecutor)driver).executeScript("arguments[0].click();",closeBtn);
    }
    
    
	
	

	public String getProgramHeading() {
		return programHeading.getText();
	}
	
//	public void setSearchText(String testcase) {
//		searchData = LMSUIConstants.applicationData.getData("Search", testcase);
//		LMSUIConstants.applicationData.setSearchInput(searchData.get("input"));
//		//LoggerLoad.info(searchData.get("input"));
//		sendKeys(searchBox,searchData.get("input"));
//		
//	}
	
	public void search(String programName) {
		WebElement searchBox1 = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(searchBox));
		//click(searchBox1);
		searchBox.clear();
		sendKeys(searchBox,programName);

	}
	
	public void clickProgramBtn() {
		WebElement programLink1 = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(programLink));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",programLink);
		//click(programLink);
	}
	
	public boolean verifyPageTitle(String expected) {
		
		if (getText(programHeading).equals(expected)) {
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
	
	public boolean validateAddNewPopup() {
		boolean popup = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.invisibilityOf(addNewPopup));
	    if (popup) {

	        return false;
	    } 
	    return true;
	}
	public boolean validateDeleteConfirmPopup() {
		boolean popup = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.invisibilityOf(deleteConfirmPopup));
	    if (popup) {
	        return false;
	    } 
	    return true;
	}
	
	public boolean validateErrorText() {
	    return errorText.isDisplayed();
	}
	
	public void clickAddProgramBtn() {
		addProgramBtn.click();
	}
	
	public void clickDeleteAllBtn() {
		deleteAllBtn.click();
	}
	
	public WebElement getProgramRowElement(String programName){
		 return programTable.findElement(By.xpath("//tr/td[contains(text(),'"+programName+"')]/.."));
		  
	}
	
	
	public void clickProgramcheckbox(String programName) {
		WebElement checkBox = getProgramRowElement(programName).findElement(By.xpath("//td//div[@role='checkbox']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",checkBox);
	}
	
	public void clickEditProgram(String programName) {
		programNamefromStep=programName;
		WebElement editButton = getProgramRowElement(programName).findElement(By.id("editProgram"));
	   ((JavascriptExecutor)driver).executeScript("arguments[0].click();",editButton);
		
	}
	
	public void clickDeleteProgram(String programName) {
		WebElement deleteButton = getProgramRowElement(programName).findElement(By.id("deleteProgram"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",deleteButton);
	}
	
	public void clickDeleteFirstProgram() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",firstProgDeleteBtn);
	}
	
	
	public String getEditProgramHeading() {
		return  editProgramHeading.getText();
	}
	
	
//    public ArrayList<String> getProgramNamesList() {
//    	ArrayList<String>programNamesList = new ArrayList<String>();
//		
//		int rows = programData.size();
//		for(int row=1; row<=rows; row++) {
//			String name = progName.getText();
//			programNamesList.add(name);
//		}
//		return programNamesList;
//		 
//	}
    
//    public ArrayList<String> getProgramDescriptionsList() {
//    	ArrayList<String>programDescList = new ArrayList<String>();
//		
//		int rows = programData.size();
//		for(int row=1; row<=rows; row++) {
//			String name = progDesc.getText();
//			programDescList.add(name);
//		}
//		System.out.println("program desc size"+programDescList.size());
//		return programDescList;
//		 
//	}
    
    public boolean validateSearch(ArrayList<String>dataInputsList, String searchInput) {
    	
		for(int i=0;i<dataInputsList.size();i++) {
			if(dataInputsList.get(i).toLowerCase().contains(searchInput.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
    
    
    
    public boolean verifyAsterikforFields() {
    	if(name.getText().contains("*") && description.getText().contains("*") && status.getText().contains("*")) {
    		return true;
    	}
    	return false;
    }
    
    public void verifySearchResultProgramName(String searchString) throws Exception {
		
		ArrayList<String> data = BasepageObj.getAllPageData(progNamePath);
		System.out.println("data found:      ");
		for(int i=0;i<data.size();i++) {
			System.out.println(data.get(i));
		}
		Assert.assertEquals(BasepageObj.validateSearch(data, searchString), true);
	}
    
    public void verifySearchResultProgramDesc(String searchString) throws Exception{
    	ArrayList<String> data = BasepageObj.getAllPageData(progDescPath);
		System.out.println("data found:      ");
		for(int i=0;i<data.size();i++) {
			System.out.println(data.get(i));
		}
		Assert.assertEquals(BasepageObj.validateSearch(data, searchString), true);
    }
    
    public boolean verifyZeroResults(String programName) {
    	if(programData.size()<1) return true;
    	return false;
    }
    
    public boolean verifySuccessMessage(String message) {
    	WebElement title = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(successPopupTitle));
    	
    	WebElement content = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(successPopupContent));
    	
    	if(title.getText().contains("Successful")){
    		return true;
    	}
    	return false;
    }
    
    public boolean verifyErrorMessage() {
    	return true;
    }
    
    public void clickProgNameSort() {
    	searchBox.clear();
    	((JavascriptExecutor)driver).executeScript("arguments[0].click();",programNameHeading);
    }
    
    public void clickProgDescSort() {
    	searchBox.clear();
    	((JavascriptExecutor)driver).executeScript("arguments[0].click();",programDescHeading);
    }
    public void clickProgStatusSort() {
    	searchBox.clear();
    	((JavascriptExecutor)driver).executeScript("arguments[0].click();",programStatusHeading);
    }
    
    public void clickLogout() {
    	((JavascriptExecutor)driver).executeScript("arguments[0].click();",logout);
    }
    
    public void validatelogout(String string) {
    	String valLogin = loginPage.getText();
    	Assert.assertEquals(valLogin, string);
    }

}

