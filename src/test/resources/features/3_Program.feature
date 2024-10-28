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
  When Admin clicks the "Program" in the Header
  Then Admin should be able to see table with Program name, description, and status headings
  
 
   #ADD PROGRAM
   @addProgram @cancelProgram @TC_Program_08
  Scenario: Program Details cancel button validation for add new program
    Given Admin is on the program Popup window
    When Admin clicks the cancel button in the program details window
    Then The program details window is closed

  @addProgram @closeProgram @TC_Program_09
  Scenario: Program Details close button validation for add new program
    Given Admin is on the program Popup window
    When Admin clicks the close X button in the program details window
    Then The program details window is closed
    
  @addProgram @TC_Program_02
  Scenario: Add New Program Validation
    Given Admin is on the Manage Program page
    When Admin clicks add new program under the program menu bar
    Then Admin should see program details pop up with empty form and <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window
    Then Admin should see program name description and status fields in the program details window
    Then Admin should see a red * mark for mandatory fields

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
    When Admin searches with newly created program "car"
    Then Records of the newly created program "car" is displayed with correct values

  # EDIT PROGRAM
  @editProgram @TC_Program_11
  Scenario: Edit Program Validation
    Given Admin is on the Manage Program page
    When Admin clicks edit program button for a program "car"
    Then Admin should see a program details pop up with filled form and <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window
    Then Admin should see a red * mark for mandatory fields

  @editProgram @TC_Program_12
  Scenario: Verify edit Program Name
    Given Admin clicks edit program button for a program "car"
    When Admin Clicks on Save button after updating program Name as "carNew"
    Then Admin is able to see message "Program Updated"

  @editProgram @TC_Program_13
  Scenario: Verify edit Program description
    Given Admin clicks edit program button for a program "carNew"
    When Admin Clicks on Save button after updating program description as "it is here"
    Then Admin is able to see message "Program Updated"
    
   @editProgram @TC_Program_14
  Scenario: Verify edit Program status
    Given Admin clicks edit program button for a program "carNew"
    When Admin Clicks on Save button after updating program status as "Active"
    Then Admin is able to see message "Program Updated"
    
   @editProgram @cancelProgram @TC_Program_15
  Scenario: Program Details cancel button validation for edit new program
    Given Admin clicks edit program button for a program "carNew"
    When Admin clicks the cancel button in the program details window
    Then The program details window is closed

  @editProgram @closeProgram @TC_Program_16
  Scenario: Program Details close button validation for edit new program
    Given Admin clicks edit program button for a program "carNew"
    When Admin clicks the close X button in the program details window
    Then The program details window is closed
    
    
  #//search for the edited program
  @addProgram @TC_Program_17
  Scenario: Verify added Program is edited
    Given Admin is on the Manage Program page
    When Admin searches with newly edited program "carNew"
    Then Records of the edited program "carNew" is displayed with correct values


  #Delete program feature
  
   @deleteProgram @TC_Program_18
   Scenario: Delete Program Validation
    Given Admin is on the Manage Program page
    When Admin clicks delete button for program "carNew"
    Then Admin should see confirmation pop up with and <No> and <Yes> buttons and Close(X) Icon on the top right corner of the window
   
   @deleteProgram @TC_Program_19
   Scenario: verify Yes button in Delete Confirm window
    Given Admin Clicks on delete button for program "carNew"
    When Admin Clicks on Yes button for program
    Then Admin is able to see message "Program Deleted"

  @deleteProgram @TC_Program_20
   Scenario: Verify No button in Delete Confirm window
    Given Admin Clicks on delete button for a program 
    When Admin Clicks on No button for program
    Then The confirmation popup should disappear for program module
    
    
   @deleteProgram @TC_Program_21
   Scenario: Verify close button in Delete Confirm window
    Given Admin Clicks on delete button for a program 
    When Admin Clicks on close button for program
    Then The confirmation popup should disappear for program module
    
   #//search for the deleted program
   @deleteProgram @TC_Program_22
   Scenario: Verify Deleted Program
    Given Admin is on the Manage Program page
    When Admin searches with deleted program name "carNew"
    Then The program "carNew" is not displayed
  
  
   #Program Search
  @searchProgramNamefull @searchPrograms
  Scenario: Verify Admin is able to view search results for valid program name
    Given Admin is on the Manage Program page
    When Admin searches with program name "truck"
    Then Admin should able to see Program name, description, and status for name "truck" 

      
   @searchProgramNameinvalid @searchPrograms
   Scenario: Verify Admin is able to view search results for valid program name
    Given Admin is on the Manage Program page
    When Admin searches with program name "invalid program"
    Then The program "invalid program" is not displayed 
    
  @searchProgramNamepartial @searchPrograms
  Scenario: Verify Admin is able to view search results for valid program name
    Given Admin is on the Manage Program page
    When Admin searches with program name "uck"
    Then Admin should able to see Program name, description, and status for name "uck"

  @searchProgramDescfull @searchPrograms
  Scenario: Verify Admin is able to view search results found for valid program description
    Given Admin is on the Manage Program page
    When Admin searches with Program Description "it is here"
    Then Admin should able to see Program name, description, and status for description "it is here"



  #//sorting functionality
  #Ascending order 
  @programsort @programnamesortasc
  Scenario: Verify Program Name are displayed in Ascending order
    Given Admin is on the Manage Program page
    When Admin clicks on Program Name Ascending Arrow
    Then Admin can see the Program Name displayed in Ascending order

  @programsort @programdescsortasc
  Scenario: Verify Program Description are displayed in Ascending order
    Given Admin is on the Manage Program page
    When Admin clicks on Program Description Ascending Arrow
    Then Admin can see the Program Description displayed in Ascending order

  @programsort @programstatussortasc
  Scenario: Verify Program Status are displayed in Ascending order
    Given Admin is on the Manage Program page
    When Admin clicks on Program Status Ascending Arrow
    Then Admin can see the Program Status displayed in Ascending order

  #Descending order 
  @programsort @programnamesortdes
  Scenario: Verify Program Name are displayed in Descending order
    Given Admin is on the Manage Program page
    When Admin clicks on Program Name Descending Arrow
    Then Admin can see the Program Name displayed in Descending order

  @programsort @programdescsortdes
  Scenario: Verify Program Description are displayed in Descending order
    Given Admin is on the Manage Program page
    When Admin clicks on Program Description Descending Arrow
    Then Admin can see the Program Description displayed in Descending order

  @programsort @programstatussortdes
  Scenario: Verify Program Status are displayed in Descending order
    Given Admin is on the Manage Program page
    When Admin clicks on Program Status Descending Arrow
    Then Admin can see the Program Status displayed in Descending order
