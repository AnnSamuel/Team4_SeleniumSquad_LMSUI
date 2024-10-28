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
Feature: ClassPagination&Sorting
  I want to use this template for my feature file
  
  Background: Admin logged on the Dashboard page 
	Given Admin is on the Dashboard Page 
   
      @classPagination1
    Scenario: Verify Next page link(>)
    Given Admin is on the Manage Class page
    When Admin clicks Next page link on the class table 
    Then Admin should see the next page record on the table  with Pagination has next active link enabled

 @classPagination2
    Scenario: Verify Last page link(>>)
    Given Admin is on the Manage Class page
    When Admin clicks Last page link
    Then Admin should see the last page record on the table with Next page link are disabled
    
    @classPagination3
    Scenario: Verify First page link(<)
    Given Admin is on last page of class table
    When Admin clicks First page link
    Then Admin should see the previous page record on the table with pagination has previous page link enabled
    
     @classPagination4
    Scenario: Verify Start page link(<<)
    Given Admin is on Previous class page 
    When Admin clicks Start page link
    Then Admin should see the very first page record on the table with Previous page link are disabled
    
    
    @classSorting1
    Scenario: Sort Class by Batch name
    Given Admin is on the Manage Class page
    When Admin clicks on the Batchname sort icon
    Then Admin should see Class details are sorted by Batch Name
    
   @classSorting2
    Scenario: Sort Class by Class topic
    Given Admin is on the Manage Class page
    When Admin clicks on the Class topic sort icon
    Then Admin should see Class details are sorted by Class topic 
    
    @classSorting3
    Scenario: Sort Class by Class Descreption
    Given Admin is on the Manage Class page
    When Admin clicks on the descreption sort icon
    Then Admin should see Class details are sorted by descreption
    
    @classSorting4
    Scenario: Sort Class by Class Status
    Given Admin is on the Manage Class page
    When Admin clicks on the Status sort icon
    Then Admin should see Class details are sorted by Status
    
    
   #@classSorting5
    #Scenario: Sort Class by Class date
    #Given Admin is on the Manage Class page
    #When Admin clicks on the Class Date sort icon
    #Then Admin should see Class details are sorted by Class Date
    
     @classSorting6
    Scenario: Sort Class by staff name
    Given Admin is on the Manage Class page
    When Admin clicks on the Staff Name sort icon
    Then Admin should see Class details are sorted by Staff Name
    