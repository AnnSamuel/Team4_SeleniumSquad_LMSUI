package com.lms.driverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.lms.utilities.LoggerLoad;

public class WebDriverFactory {
	public static WebDriver driver;

	public static WebDriver initializeDriver(String browser) {

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();// initialize chrome driver

			LoggerLoad.info("testing on chrome");
			break;

		case "firefox":
			driver = new FirefoxDriver();
			LoggerLoad.info("testing on firefox");
			break;

		case "edge":
			driver = new EdgeDriver();
			LoggerLoad.info("testing on edge");
			break;

		case "safari":
			driver = new SafariDriver();
			LoggerLoad.info("testing on safari");
			break;

		default:
			throw new RuntimeException("Please pass the correct browser value: " + browser);

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// implicit wait
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
