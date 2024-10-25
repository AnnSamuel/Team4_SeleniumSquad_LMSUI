package com.lms.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BatchPage extends BasePage {

	@FindBy(xpath = "//*[text()='Batch']/..")
	WebElement batchBtn;
	
	@FindBy(className = "box")
	WebElement heading;
	
	public void clickOnBatchBtn() {
		batchBtn.click();
	}
	
	public String getHeading() {
		return heading.getText();
		
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

}

