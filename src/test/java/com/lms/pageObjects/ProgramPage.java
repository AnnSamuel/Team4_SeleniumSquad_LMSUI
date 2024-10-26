package com.lms.pageObjects;

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

import com.lms.driverManager.WebDriverFactory;
import com.lms.utilities.LMSUIConstants;
import com.lms.utilities.LoggerLoad;

public class ProgramPage extends BasePage {

	WebDriver driver = WebDriverFactory.getInstance().getDriver();
	String programName = "Micro services";
	Map<String, String> programdata;
	Map<String, String> searchData;
	
	
	
	
	 @FindBy (id = "username") WebElement userName;
	 @FindBy (id= "password") WebElement password;
	 @FindBy (id="login") WebElement loginBtn;
	 @FindBy(xpath = "//span[text()=' LMS - Learning Management System ']") WebElement headerTitle;
	 @FindBy (xpath = "//*[text() = 'Program Details']") WebElement editProgramHeading;
	
	@FindBy(xpath = "//*[contains(text(),'Manage Program')]")WebElement programHeading;
	
	@FindBy(xpath = "//div/button[contains(@icon ,'pi-trash')]") WebElement deleteAllBtn;

	@FindBy(id = "filterGlobal") WebElement searchBox;
	
	@FindBy(xpath = "//*[text()='Program']/..") WebElement programLink;
	
	
	@FindBy (xpath = "//table/tbody") WebElement programTable;
	
	@FindAll (value = {@FindBy (xpath = "//table/tbody//tr")}) List<WebElement> programData;
	
	@FindBy (xpath = "//table/tbody//tr//td[2]") WebElement progName;
	@FindBy (xpath = "//table/tbody//tr//td[3]") WebElement progDesc;
	@FindBy (xpath = "//table/tbody//tr//td[4]") WebElement progStatus;

	@FindBy(id = "editProgram") WebElement editProgram;
	
	@FindBy(id = "deleteProgram") WebElement deleteProgram;
	
	@FindBy(xpath="//th//div[@role='checkbox']") WebElement allCheckBox;
	
	@FindBy(xpath="//td//div[@role='checkbox']") WebElement programCheckBox;
	
	//Addprogram
	@FindBy(xpath = "//button[text()='Add New Program']") WebElement addProgramBtn;
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
	
	
	public void openPage() {
		driver.get(BASE_URL + "program");
				
	}
	
	public boolean isOnProgramPage() {
		if(driver.getCurrentUrl().contains("program")) {
			return true;
		}
		return false;
	}
	
    public void validateInputMandatoryFields(String testcase) {
		
		programdata = LMSUIConstants.applicationData.getData("Program", testcase);
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
    
    public boolean verifyPopupTextField() {
		
		if (isDisplayed(programNameInput) && isDisplayed(programDescInput) && isDisplayed(activeStatusInput)
				&& isDisplayed(inactiveStatusInput)) {
			return true;
		}
		return false;
	}
    
    public void clickAddNewProgramBtn() {
		 click(addProgramBtn);
	}
    
    public boolean verifyPopup() {
		if(isDisplayed(cancelBtn) && isDisplayed(saveBtn) && isDisplayed(closeBtn)){
			return true;
		}
		return false;
	}
    
    public void clickSaveBtn() {
    	click(saveBtn);
    }
    
    public void clickCancelBtn() {
    	click(cancelBtn);
    }
    
    public void clickCloseBtn() {
    	click(closeBtn);
    }
    
    
	
	

	public String getProgramHeading() {
		return programHeading.getText();
	}
	
	public void setSearchText(String testcase) {
		searchData = LMSUIConstants.applicationData.getData("Search", testcase);
		LMSUIConstants.applicationData.setSearchInput(searchData.get("input"));
		//LoggerLoad.info(searchData.get("input"));
		sendKeys(searchBox,searchData.get("input"));
		
	}
	
	public void clickProgramBtn() {
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
	    if (addNewPopup.isDisplayed()) {

	        return true;
	    } 
	    return false;
	}
	
	public String validateErrorText() {
	    return errorText.getText();
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
		WebElement editButton = getProgramRowElement(programName).findElement(By.id("editProgram"));
	   ((JavascriptExecutor)driver).executeScript("arguments[0].click();",editButton);
		
	}
	
	public void clickDeleteProgram(String programName) {
		WebElement deleteButton = getProgramRowElement(programName).findElement(By.id("deleteProgram"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",deleteButton);
	}
	
	
	public String getEditProgramHeading() {
		return  editProgramHeading.getText();
	}
	
	
    public ArrayList<String> getProgramNamesList() {
    	ArrayList<String>programNamesList = new ArrayList<String>();
		
		int rows = programData.size();
		for(int row=1; row<=rows; row++) {
			String name = progName.getText();
			programNamesList.add(name);
		}
		return programNamesList;
		 
	}
    
    public ArrayList<String> getProgramDescriptionsList() {
    	ArrayList<String>programDescList = new ArrayList<String>();
		
		int rows = programData.size();
		for(int row=1; row<=rows; row++) {
			String name = progDesc.getText();
			programDescList.add(name);
		}
		System.out.println("program desc size"+programDescList.size());
		return programDescList;
		 
	}
    
    public boolean validateSearch(ArrayList<String>dataInputsList, String searchInput) {
    	
		for(int i=0;i<dataInputsList.size();i++) {
			if(dataInputsList.get(i).toLowerCase().contains(searchInput.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
    
    
//    public List<Map<String, String>> validateSearchResult() {
//    	List<Map<String, String>> programDataSearchResults = new ArrayList<>();
//    	for(int i=0;i<programData.size();i++) {
//    		Map<String,String>programRow = new HashMap<>();
//    		programRow.put("programName", progName.getText());
//    		programRow.put("programDescription", progDesc.getText());
//    		programRow.put("programStatus", progStatus.getText());
//    		programDataSearchResults.add(programRow);
//    		
//    	}
//    	return programDataSearchResults;
//    	
//    }

}

