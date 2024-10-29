@dashboard_Scenarios 
Feature: Dashboard Module 

Background: Admin logged on the Dashboard page 
	Given Admin is on the Dashboard Page 
	
@TC_Dashboard_01 
Scenario: Verify after login Admin lands on dashboard page
    When Admin enter valid credentials and clicks login button
    And Admin should see dashboard 
   # And Maximum navigation time in milliseconds, defaults to 30 seconds
  And HTTP response >= 400. Then the link is broken
    And Admin should see "LMS - Learning Management System" as title
    And The Title "LMS - Learning Management System" should be on the top left corner of page
    And Admin should see "LMS - Learning Management System" correct spelling in navigation bar text
    And Admin should see correct spelling and spacing in LMS title
    And Admin should see the navigation bar text on the top right side
    And Admin should see Home in the 1st place
    And Admin should see program in the 2nd place
    And Admin should see batch in the 3rd place
    And Admin should see class in the 4th place
    And Admin should see logout in the 5th place