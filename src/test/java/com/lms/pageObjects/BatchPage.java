package com.lms.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BatchPage extends BasePage {

	@FindBy(xpath = "//*[text()='Batch']/..")
	WebElement batchBtn;
	
	@FindBy(className = "box")
	WebElement heading;
	
	@FindBy(xpath  = "//mat-toolbar/span[1]")
	WebElement title;
	
	@FindBy(id = "filterGlobal")
	WebElement searchBox;
	
	@FindBy(className = "mat-menu-item")
	WebElement menuItem;
	
	@FindBy(className = "p-dialog-title")
	WebElement popupWindowTitle;
	
	public void clickOnBatchBtn() {
		batchBtn.click();
	}
	
	public String getHeading() {
		return heading.getText();
		
	}
	
	public String getTitle() {
		return title.getText();
	}
	
	
	public void clickOnMenuItem() {
		menuItem.click();
	}
	
	public String getMenuItemText() {
		return menuItem.getText();
	}
	
	public String getPopUpWindowTitle() {
		driver.switchTo().activeElement();	
		return popupWindowTitle.getText();
		
	}
	
}

