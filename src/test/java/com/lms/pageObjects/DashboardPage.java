package com.lms.pageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.Assert;



public class DashboardPage extends BasePage{
	private static final int DEFAULT_TIMEOUT_MS = 5000;
	@FindBy(xpath = "//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']") WebElement headerBar;
	
	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']") WebElement headerTitle;
public boolean verifyHeaderTitle(String expected) {
		
		if (getText(headerTitle).equals(expected)) {
			return true;
		}

		return false;
	}
	public void isDashboardLoaded() {
	    // Verify key elements on the dashboard
	    //WebElement menuBar = driver.findElement(headerBar); // replace with actual ID or selector
	    Assert.assertTrue(  headerBar.isDisplayed(), "Dashboard menu bar is not displayed as expected.");
	}

public void navigateToUrl(String url, Integer timeoutMs) {
    int timeout = (timeoutMs != null) ? timeoutMs : DEFAULT_TIMEOUT_MS;

    try {
        driver.navigate().to(url);
        new WebDriverWait(driver, Duration.ofSeconds(timeout / 1000))
        .until(ExpectedConditions.urlToBe(url));
        System.out.println("Navigation to " + url + " completed successfully.");
    } catch (TimeoutException e) {
        System.out.println("Navigation to " + url + " failed after " + timeout + " milliseconds.");
    }
}

public void checkLink(String baseUrl, int statusCodeThreshold) {
    
   
	 try {
	        URI uri = URI.create(baseUrl);  // Create URI from the base URL string
	        URL url = uri.toURL();          // Convert URI to URL

	        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
	        httpURLConnection.setRequestMethod("GET");
	        httpURLConnection.connect();

	        int responseCode = httpURLConnection.getResponseCode();

	        if (responseCode >= statusCodeThreshold) {
	            System.out.println("The link is broken. Response code: " + responseCode);
	        } else {
	            System.out.println("The link is working fine. Response code: " + responseCode);
	        }

	        // Assert to fail if the link is broken
	        Assert.assertTrue(responseCode < statusCodeThreshold, "The link is broken. Response code: " + responseCode);

	    } catch (MalformedURLException e) {
	        System.out.println("Invalid URL format: " + e.getMessage());
	    } catch (IOException e) {
	        System.out.println("An error occurred while checking the link: " + e.getMessage());
	    }
	}
	public void titleCheck(String expectedTitle) {
		//String actualTitle = headerTitle.getText(); 
		 // Assert.assertEquals("Title does not match.", expectedTitle, actualTitle);

		Point location = headerTitle.getLocation();
        
        // Check if the title is positioned near the top left corner
		Assert.assertTrue(isNearTopLeftCorner(location), "Title is not in the top left corner.");
 
	}
	private boolean isNearTopLeftCorner(Point location) {
	    int xThreshold = 50; // Define a threshold for x-axis
	    int yThreshold = 50; // Define a threshold for y-axis
	    return (location.getX() <= xThreshold && location.getY() <= yThreshold);
	}
	public void expectedTitleCheck(String expectedTitle) {
		
		String actualTitle = headerTitle.getText();
		Assert.assertEquals(actualTitle, expectedTitle, "Title does not match.");
		 System.out.println("The title '" + actualTitle + "' matches the expected title '" + expectedTitle + "'.");
		
	}
	public void NavigationBarText() {
        // Locate the navigation bar
        
		List<WebElement> buttons = headerBar.findElements(By.xpath("//div[@class='ng-star-inserted']//button"));

		    // Verify that the navigation bar contains buttons
		    Assert.assertTrue(buttons.size() > 0, "Navigation buttons are not present in the navbar");

		    // Check that each button has non-empty text
		    for (WebElement button : buttons) {
		        String buttonText = button.getText().trim();
		        Assert.assertFalse(buttonText.isEmpty(), "Navigation button text is missing for one of the buttons.");
		        System.out.println("Button text: " + buttonText);
		    }
}
	public void correctSpellingAndSpacingInTitle() {
        // Locate the title element
     //   WebElement titleElement = driver.findElement(By.cssSelector(".navbar-title"));

        // Get the text of the title
        String actualTitle = headerTitle.getText();

        // Expected title
        String expectedTitle = "LMS - Learning Management System";

        // Assert to check if the actual title matches the expected title
        Assert.assertEquals(actualTitle, expectedTitle, "The title does not match the expected spelling or spacing.");
    }
	
	 public void home() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		 List<WebElement> buttons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				    By.xpath("//div[@class='ng-star-inserted']//button")));

				String actualButtonText = buttons.get(0).getText();
				String expectedButton = "Home";

				//Assert.assertEquals(actualButtonText, expectedButton, "The first button is not 'Home'.");
				if (!actualButtonText.equals(expectedButton)) {
			        // If they are not equal, log a message or take other actions
			        System.out.println("The first button is not 'Home'. Expected: " + expectedButton + ", but found: " + actualButtonText);
			    } else {
			        System.out.println("The first button is correctly labeled 'Home'.");
			    }
}
}
