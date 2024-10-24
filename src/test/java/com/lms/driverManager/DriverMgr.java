package com.lms.driverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverMgr {

	private WebDriver driver;

	

	public void init_driver(String browser) {

		if (driver != null) {
			switch (browser.toLowerCase()) {

			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			default:
				throw new RuntimeException("Please pass the correct browser value: " + browser);

			}

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// implicit wait
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

//		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void quit() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	
}
