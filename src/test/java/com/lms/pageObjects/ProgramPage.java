package com.lms.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.lms.driverManager.WebDriverFactory;

public class ProgramPage {

	WebDriver driver = WebDriverFactory.getDriver();
	String programName = "Micro services";
	
	
	
	 @FindBy (id = "username") WebElement userName;
	 @FindBy (id= "password") WebElement password;
	 @FindBy (id="login") WebElement loginBtn;
	 @FindBy (xpath = "//*[text() = 'Program Details']") WebElement editProgramHeading;
	
	@FindBy(xpath = "//*[contains(text(),'Manage Program')]")WebElement programHeading;
	
	@FindBy(xpath = "//div/button[contains(@icon ,'pi-trash')]") WebElement deleteAllBtn;

	@FindBy(id = "filterGlobal") WebElement searchBtn;
	
	@FindBy(xpath = "//*[text()='Program']/..") WebElement programBtn;
	
	@FindBy (xpath = "//button[text() = 'Add New Program']") WebElement addProgramBtn;
	
	@FindBy (xpath = "//table/tbody") WebElement programTable;
	
	@FindAll (value = {@FindBy (xpath = "//table/tbody//tr")}) List<WebElement> programData;
	
	@FindBy (xpath = "//table/tbody//tr//td[2]") WebElement progName;

	@FindBy(id = "editProgram") WebElement editProgram;
	
	@FindBy(id = "deleteProgram") WebElement deleteProgram;
	
	@FindBy(xpath="//th//div[@role='checkbox']") WebElement allCheckBox;
	
	@FindBy(xpath="//td//div[@role='checkbox']") WebElement programCheckBox;
	
	
	//init elements
	public ProgramPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void login() {
		userName.sendKeys("Sdet@gmail.com");
		password.sendKeys("LmsHackathon@2024");
		loginBtn.click();
	}
	public String getProgramHeading() {
		return programHeading.getText();
	}
	
	public void setSearchText(String searchInput) {
		searchBtn.sendKeys(searchInput);
	}
	
	public void clickProgramBtn() {
		programBtn.click();
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
	
	
    public ArrayList<String> getProgramNames() {
    	ArrayList<String>programNamesList = new ArrayList<String>();
		
		int rows = programData.size();
		for(int row=1; row<=rows; row++) {
			String name = progName.getText();
			programNamesList.add(name);
		}
		return programNamesList;
		 
	}
    
    public boolean validateSearch(ArrayList<String>dataInputsList, String searchInput) {
    	
		for(int i=0;i<dataInputsList.size();i++) {
			if(dataInputsList.get(i).toLowerCase().contains(searchInput.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	

	
	

}

