package com.lms.hooks;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.lms.driverManager.WebDriverFactory;
import com.lms.utilities.ConfigReader;
import org.openqa.selenium.OutputType;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {

	public static WebDriver driver;

	@BeforeAll
	public static void before_all() {
		ConfigReader.load_prop();
	}

	@Before
	public static void setUp() {

		if (driver == null) {
			driver = WebDriverFactory.initializeDriver(ConfigReader.getProp("browser"));
			System.out.println("driver details --->" + driver.toString());
			driver.get(ConfigReader.getProp("baseUrl"));
			System.out.println("url opened");
		}
	}

	@AfterStep
	public void addScreenShot(Scenario scenario) {
		if (scenario.isFailed()) {
			String ScreenShotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", ScreenShotName);
		}
	}

	@After
	public void after() {
		// TestDataCleanup();
		WebDriverFactory.closeDriver();
		System.out.println("driver closed");
		// private void TestDataCleanup(){
		// }

	}
}
