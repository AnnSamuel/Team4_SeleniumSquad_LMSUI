package com.lms.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClassPage extends BasePage{
	
	@FindBy(xpath = "//span[text()='Class']")
	WebElement classLink;
	
	public void openPage() {
		driver.get(BASE_URL + "class");
				
	}
	
	
}
