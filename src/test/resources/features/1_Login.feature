@login_Scenarios
Feature: Login Page
  
  @TC_Login_01
  Scenario Outline: Login page validation
    Given Admin is in login Page
    When Admin enter login credentials "<testcase>" and clicks login button          
    Then Admin should land on dashboard page  
     
     Examples:
     |testcase|
     |ValidCredentials|
     |InvalidCredentials|

