@Program
Feature: LMSprogram Functionality

  Background: Admin logged on the Dashboard page
    Given Admin is on the Dashboard Page

  @manageProgram @TC_Program_01
  Scenario: Validating the Manage Program page
    When Admin clicks the "Program" in the Header
    Then Admin should land on the "Manage Program" page on Program module
    And Admin should see the "LMS - Learning Management System" Title
    And Admin should see the Searchbar
    
  @columnHeaderProgram   
  Scenario: Verify view details of programs
  When Admin clicks the "Program" in the Header from program
  Then Admin should be able to see table with Program name, description, and status headings
  
 
    
  @addProgram @TC_Program_03
  Scenario Outline: Program Details pop up Validation for valid inputs
    Given Admin is on the program Popup window
    When Admin enters fields from "<testcase>" in the add program form and clicks on save button
    Then Admin is able to see message "Program Created Successfully"

    Examples: 
      | testcase      |
      |validInputAllOne|
      |validInputAllTwo|


  #//search for the added program
  @addProgram @TC_Program_10
  Scenario: Verify added Program is created
    Given Admin is on the Manage Program page
    When Admin searches with newly created program "poland"
    Then Records of the newly created program "poland" is displayed with correct values

  # EDIT PROGRAM
 
  @editProgram @TC_Program_12
  Scenario: Verify edit Program Name
    Given Admin clicks edit program button for a program "africa"
    When Admin Clicks on Save button after updating program Name as "egypt"
    Then Admin is able to see message "Program Updated"

  @editProgram @TC_Program_13
  Scenario: Verify edit Program description
    Given Admin clicks edit program button for a program "egypt"
    When Admin Clicks on Save button after updating program description as "it is here"
    Then Admin is able to see message "Program Updated"
    
   @editProgram @TC_Program_14
  Scenario: Verify edit Program status
    Given Admin clicks edit program button for a program "egypt"
    When Admin Clicks on Save button after updating program status as "Active"
    Then Admin is able to see message "Program Updated"
 
  #//search for the edited program
  @editProgram @TC_Program_17
  Scenario: Verify added Program is edited
    Given Admin is on the Manage Program page
    When Admin searches with newly edited program "egypt"
    Then Records of the edited program "egypt" is displayed with correct values

   @deleteProgram @TC_Program_19
   Scenario: verify Yes button in Delete Confirm window
    Given Admin Clicks on delete button for program "egypt"
    When Admin Clicks on Yes button for program
    Then Admin is able to see message "Program Deleted"

  @deleteProgram @TC_Program_20
   Scenario: Verify No button in Delete Confirm window
    Given Admin Clicks on delete button for a program 
    When Admin Clicks on No button for program
    Then The confirmation popup should disappear for program module
    
    
  
   #//search for the deleted program
   @deleteProgram @TC_Program_22
   Scenario: Verify Deleted Program
    Given Admin is on the Manage Program page
    When Admin searches with deleted program name "egypt"
    Then The program "egypt" is not displayed
  
  
   #Program Search
  @searchProgramNamefull @searchPrograms
  Scenario: Verify Admin is able to view search results for valid program name
    Given Admin is on the Manage Program page
    When Admin searches with program name "poland"
    Then Admin should able to see Program name, description, and status for name "poland" 

      


  @searchProgramDescfull @searchPrograms
  Scenario: Verify Admin is able to view search results found for valid program description
    Given Admin is on the Manage Program page
    When Admin searches with Program Description "for other modules"
    Then Admin should able to see Program name, description, and status for description "for other modules"
    
    
  #Logout
  @logout
   Scenario: Verify logout from program
    Given Admin is on the Manage Program page
    When Admin clicks the logout button from program module
    Then Admin should be displayed with login screen from program "Please login to LMS application"
    
  


  #//sorting functionality
  #Ascending order 
  #@programsort @programnamesortasc
  #Scenario: Verify Program Name are displayed in Ascending order
    #Given Admin is on the Manage Program page
    #When Admin clicks on Program Name Ascending Arrow
    #Then Admin can see the Program Name displayed in Ascending order
#
  #@programsort @programdescsortasc
  #Scenario: Verify Program Description are displayed in Ascending order
    #Given Admin is on the Manage Program page
    #When Admin clicks on Program Description Ascending Arrow
    #Then Admin can see the Program Description displayed in Ascending order
#
  #@programsort @programstatussortasc
  #Scenario: Verify Program Status are displayed in Ascending order
    #Given Admin is on the Manage Program page
    #When Admin clicks on Program Status Ascending Arrow
    #Then Admin can see the Program Status displayed in Ascending order


