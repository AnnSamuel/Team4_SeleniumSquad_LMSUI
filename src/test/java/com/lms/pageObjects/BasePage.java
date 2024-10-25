package com.lms.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lms.driverManager.WebDriverFactory;
import com.lms.utilities.ConfigReader;

public class BasePage {


	protected WebDriver driver = WebDriverFactory.getInstance().getDriver();
	protected String BASE_URL = ConfigReader.getProp("baseUrl");

	private static final long IMPLICIT_WAIT = 10;

	@FindBy(xpath = "//table/tbody/tr//div[@role='checkbox']")
	List<WebElement> rows;
	@FindBy(xpath = "//table/tbody/tr//button[contains(@icon, 'pi-pencil')]")
	List<WebElement> editicons;
	@FindBy(xpath = "//table/tbody/tr//button[contains(@icon, 'pi-trash')]")
	List<WebElement> deleteIcons;

	public BasePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void initElements() {
		PageFactory.initElements(driver, this);
	}

	public void openPage(String pagename) {
		driver.get(BASE_URL + pagename);

	}

	public boolean click(WebElement element) {
		try {
			WebElement eleToClick = new WebDriverWait(driver, Duration.ofSeconds(IMPLICIT_WAIT))
					.until(ExpectedConditions.visibilityOf(element));

			if (eleToClick.isEnabled()) {
				eleToClick.click();
				return true;
			} else {
				throw new IllegalStateException("Element is not enabled");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean sendKeys(WebElement element, String text) {
		try {
			WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(IMPLICIT_WAIT))
					.until(ExpectedConditions.visibilityOf(element));

			if (ele.isEnabled()) {

				ele.clear();
				ele.sendKeys(text);
				return true;
			} else {
				throw new Exception("Element is not enabled");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isDisplayed(WebElement element) {
		try {
			WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(IMPLICIT_WAIT))
					.until(ExpectedConditions.visibilityOf(element));

			return ele.isEnabled();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getText(WebElement element) {

		WebElement textElement = new WebDriverWait(driver, Duration.ofSeconds(IMPLICIT_WAIT))
				.until(ExpectedConditions.visibilityOf(element));
		return textElement.getText();
	}

	public boolean verifyText(String expectedMsg, WebElement element) {

		if (getText(element).equals(expectedMsg)) {
			return true;
		}

		return false;
	}

	public String ActualPageTitle() {
		return driver.getTitle();
	}

	public boolean clickElementByText(String text) {
		try {
			driver.findElement(By.xpath("//span[text()='" + text + "']/..")).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean ValidateCheckboxes() {
		boolean allCheckboxesDisplayed = true;
		for (WebElement row : rows) {
			if (!row.isDisplayed()) {
				System.out.println("Checkbox not present in row: " + row.getText());
				allCheckboxesDisplayed = false;
			}
		}
		return allCheckboxesDisplayed;
	}

	public void search(String text) {

	}

	public void singleDelete() {

	}

	public void multipleDelete() {

	}

}
