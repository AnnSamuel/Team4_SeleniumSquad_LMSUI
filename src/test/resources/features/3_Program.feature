@Program
Feature: LMS program Functionality
  
    #Background: Successful login with valid credentials
    #Given the admin is on the login page
    #When the admin enters the valid username and password "LoginCredentials"
    
    
    Scenario: validate the program page
    Given the user is in homepage and logged in
    When user clicks the program button in the menu bar
    Then user views the program page
    
    Scenario: validate the edit button page in program page
    Given the user is in program page
    When user clicks the edit button for the "Micro services"
    Then user views the edit program popup