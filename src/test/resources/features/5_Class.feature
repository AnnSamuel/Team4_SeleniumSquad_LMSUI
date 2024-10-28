@class_Scenarios 
Feature: Class Module 

Background: Admin logged on the Dashboard page 
	Given Admin is on the Dashboard Page 
	
@TC_Class_01 
Scenario: Validating the class manage page 
	When Admin clicks the "Class" in the Header 
	Then Admin should land on the "Manage Class" 
	And Admin should see the "LMS - Learning Management System" Title 
	And Admin should see the Searchbar 
	 
	
@TC_Class_02 
Scenario: Add New Class Validation 
	Given Admin is on the Manage class page 
	When Admin clicks add new class under the class menu bar 
	Then Admin should see a manage class pop up with empty form and <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window 
	Then Admin should see few input fields and their respective text boxes in the class details window 
	
@TC_Class_03 
Scenario Outline: Class Details pop up Validation 
	Given Admin is on the Class Popup window 
	When Admin enters "<testcase>" mandatory fields in the form and clicks on save button 
	Then Admin gets message Class added Successfully

 Examples:
     |testcase|
     |validInputMandatory|
     |validInputAll|
     
     	
	
	 
 
	

	
	