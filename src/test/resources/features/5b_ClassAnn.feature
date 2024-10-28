#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@class
Feature: Class Module
  I want to use this template for my feature file
  
  Background: Admin logged on the Dashboard page 
	Given Admin is on the Dashboard Page 
#
  @classEdit1
  Scenario: Validate row level edit icon and batch & class topic fields disabled
    Given Admin is on the Manage Class page
    When Admin clicks on the edit icon 
    Then A new pop up with class details appears
    Then Admin should see batch name field is disabled
    Then Admin should see class topic field is disabled

    
   @classEdit4
  Scenario Outline: Check if the fields are updated with invalid values
    Given Admin is on the Edit Class Popup window
    When Update the fields with invalid values "<testcase>" and click save
    Then Admin should get Error message "Class Date is required"
     
     Examples:
     |testcase|
     |EditInvalidClassDates|
       

  @classEdit5
  Scenario Outline: Check if the mandatory fields are updated with valid data
    Given Admin is on the Edit Class Popup window
    When Update the mandatory fields with valid values "<testcase>" and click save
    Then Admin gets message "Successful" and see the updated values in data table
     Examples:
     |testcase|
     |EditMandateFields|
    
    
  @classEdit6
  Scenario Outline: Check if the optional fields are updated with valid data
    Given Admin is on the Edit Class Popup window again
    When Update the optional fields with valid values "<testcase>" and click save
    Then Admin gets message "Successful" and see the updated values in data table
      Examples:
     |testcase|
     |EditOptionalFields|
    

 @classEdit7
  Scenario Outline: Validate invalid values in the text fields
    Given Admin is on the Edit Class Popup window again
    When Admin enters only numbers or special char "<testcase>" in the text fields
    Then Admin should not get success message
     Examples:
     |testcase|
     |EditNumbersOrSpecialChar|
    
    
   @classEdit8
  Scenario Outline: Validate Cancel button on Edit popup
    Given Admin is on the Edit Class Popup window again
    When Admin clicks Cancel button on edit popup "<testcase>"
    Then Admin can see the class details popup disappears and can see nothing changed for particular Class
     Examples:
     |testcase|
     |EditCancelButton|

    
  @classEdit9
  Scenario Outline: Check if the fields are updated with valid data
    Given Admin is on the Edit Class Popup window again
    When Update the fields with valid data "<testcase>" and click save
    Then Admin gets message "Successful" and see the updated values in data table
    
      Examples:
     |testcase|
     |EditValidClassDescription|
     |EditValidClassDates|
     #|EditValidStaffName|     
     |EditValidStatus|
     
    
    @logout
    Scenario: Validate logout
    When Admin clicks on the logout in the menu bar
    Then Admin should be redirected to login page "Please login to LMS application"
    
     

    