package com.lms.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
		WebElement header = driver.findElement(By.xpath("//mat-card-content//table/thead/tr//th[text()='" + headerTitle + "']"));
		
		if(header.isDisplayed()) {
			System.out.println("Element " + headerTitle);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verifyCheckBoxInHeader() {
		WebElement header = driver.findElement(By.xpath("//mat-card-content//table/thead/tr//th//div[@role='checkbox']"));
		if(header.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verifySortIconInHeaders(String headerTitle) {
		System.out.println("//mat-card-content//table/thead/tr//th[text()='" + headerTitle + "']//p-sorticon");
		WebElement header = driver.findElement(By.xpath("//mat-card-content//table/thead/tr//th[text()='" + headerTitle + "']//p-sorticon"));
		
		if(header.isDisplayed()) {
			System.out.println("Element " + headerTitle);
			return true;
		} else {
			return false;
		}
	}
	
	
	

}
