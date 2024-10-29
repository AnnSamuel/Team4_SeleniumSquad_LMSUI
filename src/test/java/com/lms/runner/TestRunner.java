package com.lms.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( monochrome = false, tags = "@Program", features = {
				"src/test/resources/features" }, glue = { "com.lms.stepDefinition", "com.lms.hooks" },
      plugin= {"pretty","html:target/cucumber-reports/cucumber.html",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		// "rerun:target/rerun.txt",
		})

public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
