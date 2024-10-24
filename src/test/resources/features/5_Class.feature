@class_Scenarios
Feature: Class Module 

Background: Admin logged on the Dashboard page 
	Given Admin is on the Dashboard Page 

@TC_Class_01	
Scenario Outline: Validating the class manage page 
	When Admin clicks the "<pagename>" in the Header 
	Then Admin should land on the "<expected page>" 
	
	Examples: 
		|pagename|expected page|
		|Class|Manage Class|