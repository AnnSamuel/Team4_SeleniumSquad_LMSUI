package com.lms.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.poi.util.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.util.Strings;

import com.beust.jcommander.JCommander.ProgramName;
import com.lms.utilities.LMSUIConstants;

public class BatchPage extends BasePage {

	@FindBy(xpath = "//*[text()='Batch']/..")
	WebElement batchBtn;

	@FindBy(className = "box")
	WebElement heading;

	@FindBy(xpath = "//mat-toolbar/span[1]")
	WebElement title;

	@FindBy(id = "filterGlobal")
	WebElement searchBox;

	@FindBy(className = "mat-menu-item")
	WebElement menuItem;

	@FindBy(className = "p-dialog-title")
	WebElement popupWindowTitle;

	@FindBy(xpath = "//mat-card-title//button[@icon='pi pi-trash']")
	WebElement topDeletebtn;

	@FindBy(xpath = "//button[@icon='pi pi-pencil']")
	WebElement editIcon;

	@FindBy(className = "p-dropdown-label")
	WebElement dropdownLabel;

	@FindBy(className = "p-dropdown-trigger")
	WebElement dropdownTrigger;

	@FindBy(id = "batchName")
	WebElement batchName;

	@FindBy(id = "batchProg")
	WebElement batchProg;

	@FindBy(className = "p-invalid")
	WebElement errorMessage;

	@FindBy(id = "batchDescription")
	WebElement batchDescription;

	@FindBy(id = "batchStatus")
	WebElement batchStatus;

	@FindBy(id = "batchNoOfClasses")
	WebElement batchNoOfClasses;

	@FindBy(xpath = "//*[@ng-reflect-value = 'ACTIVE']")
	WebElement activeStatusInput;
	@FindBy(xpath = "//*[@ng-reflect-value = 'INACTIVE']")
	WebElement inactiveStatusInput;
	
	@FindBy(xpath="//*[text()='Cancel']/..")WebElement cancelBtn;
	@FindBy(xpath="//*[text()='Save']/..")WebElement saveBtn;
	@FindBy(xpath="//span[contains(@class,'p-dialog-header-close-icon ng-tns')]/..") WebElement closeBtn;
	
	@FindBy(xpath = "//div[contains(@role, 'alert')]") WebElement saveBatchPopup; 
	@FindBy(xpath = "//div[contains(@class, 'p-toast-summary')]") WebElement saveBatchPopupTitle;
	@FindBy(xpath = "//div[contains(@class, 'p-toast-detail')]") WebElement saveBatchPopupMessage;

	

	public void clickOnBatchBtn() {
		click(batchBtn);
	}

	public String getHeading() {
		return heading.getText();

	}

	public String getTitle() {
		return title.getText();
	}

	public void clickOnMenuItem() {
		click(menuItem);
	}

	public String getMenuItemText() {
		return menuItem.getText();
	}

	public String getPopUpWindowTitle() {
		driver.switchTo().activeElement();
		return getText(popupWindowTitle);
	}

	public boolean isTopDeleteButtonEnabled() {
		return topDeletebtn.isEnabled();
	}

	public boolean isEditIconsPresentInEachRow() {
		boolean isFlag = true;
		List<WebElement> rows = driver.findElements(By.xpath("//mat-card-content//table/tbody/tr"));

		for (int i = 0; i < rows.size(); i++) {
			WebElement editButton = rows.get(i).findElement(By.xpath("//button[@icon='pi pi-pencil']"));
			if (editButton.isDisplayed()) {
				System.out.println("Edit button is present in row " + (i + 1));
			} else {
				isFlag = false;
			}
		}

		return isFlag;
	}

	public boolean isDeleteIconsPresentInEachRow() {
		boolean isFlag = true;
		List<WebElement> rows = driver.findElements(By.xpath("//mat-card-content//table/tbody/tr"));

		for (int i = 0; i < rows.size(); i++) {
			WebElement editButton = rows.get(i).findElement(By.xpath("//button[@icon='pi pi-trash']"));
			if (editButton.isDisplayed()) {
				System.out.println("Delete button is present in row " + (i + 1));
			} else {
				isFlag = false;
			}
		}

		return isFlag;
	}

	public boolean isCheckBoxPresentInEachRow() {
		boolean isFlag = true;
		List<WebElement> rows = driver.findElements(By.xpath("//mat-card-content//table/tbody/tr"));

		for (int i = 0; i < rows.size(); i++) {
			WebElement editButton = rows.get(i).findElement(By.xpath("//div[@role='checkbox']"));
			if (editButton.isDisplayed()) {
				System.out.println("CheckBox button is present in row " + (i + 1));
			} else {
				isFlag = false;
			}
		}

		return isFlag;
	}

	public boolean verifyTableHeaders(String headerTitle) {
		WebElement header = driver
				.findElement(By.xpath("//mat-card-content//table/thead/tr//th[text()='" + headerTitle + "']"));

		if (header.isDisplayed()) {
			System.out.println("Element " + headerTitle);
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyCheckBoxInHeader() {
		WebElement header = driver
				.findElement(By.xpath("//mat-card-content//table/thead/tr//th//div[@role='checkbox']"));
		if (header.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifySortIconInHeaders(String headerTitle) {
		System.out.println("//mat-card-content//table/thead/tr//th[text()='" + headerTitle + "']//p-sorticon");
		WebElement header = driver.findElement(
				By.xpath("//mat-card-content//table/thead/tr//th[text()='" + headerTitle + "']//p-sorticon"));

		if (header.isDisplayed()) {
			System.out.println("Element " + headerTitle);
			return true;
		} else {
			return false;
		}
	}

	public boolean isOnBatchPopupPage() {
		return "Batch Details".equalsIgnoreCase(getPopUpWindowTitle());
	}

	public void inputBatchFields(String testcase) {
		Map<String, String> batchTestData = LMSUIConstants.applicationData.getData("Batch", testcase);
		System.out.println("batchTestData:"+ batchTestData);

		String programName = batchTestData.get("ProgramName");
		if (!Strings.isNullOrEmpty(programName)) {
			dropDownSelect(dropdownTrigger, batchTestData.get("ProgramName"));
		}

		String batchNamePrefix = batchTestData.get("BatchNamePrefix");
		if (!Strings.isNullOrEmpty(batchNamePrefix)) {
			sendKeys(batchProg, batchNamePrefix);
		}

		String batchNameTxt = batchTestData.get("BatchName");
		if (!Strings.isNullOrEmpty(batchNameTxt)) {
			sendKeys(batchName, batchNameTxt); //+ new Random().nextInt()
		}

		String description = batchTestData.get("Description");
		if (!Strings.isNullOrEmpty(description)) {
			sendKeys(batchDescription, description);
		}

		String status = batchTestData.get("Status");

		if (!Strings.isNullOrEmpty(status)) {
			if (status.equalsIgnoreCase("ACTIVE")) {
				click(activeStatusInput);
			} else {
				click(inactiveStatusInput);
			}
		}

		String numberOfClasses = batchTestData.get("NumberOfClasses");
		if (numberOfClasses != null) {
			sendKeys(batchNoOfClasses, numberOfClasses);
		}

	}

	public String getSelectedProgramName() {
		return dropdownLabel.getAttribute("value");
	}

	public String getErrorForField() {
		return errorMessage.getText();
	}

	public String getBatchNamePefix() {
		return batchProg.getText();
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
    
    public String saveActionPopup() {
    	if (saveBatchPopup.isDisplayed()) {
	        return saveBatchPopup.getText();
	    } else {
	        return "No Popup Displayed";
	    	}
	}
	
    
    public boolean isSaveBatchPopupDisplayed() {
    	return isDisplayed(saveBatchPopup);
    }
	

}

