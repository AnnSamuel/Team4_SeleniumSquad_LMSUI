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
  Then Admin should able to see Program name, description, and status headings
  

  # ADD PROGRAM
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
    Then Admin gets message program added Successfully

    Examples: 
      | testcase      |
      | validInputAll |

  @addProgram @TC_Program_04
  Scenario Outline: Program Details pop up Validation for blank program name input
    Given Admin is on the program Popup window
    When Admin enters fields from "<testcase>" in the add program form and clicks on save button
    Then Admin gets error text on program details popup

    Examples: 
      | testcase         |
      | BlankProgramName |

  @addProgram @TC_Program_05
  Scenario Outline: Program Details pop up Validation for invalid program name input
    Given Admin is on the program Popup window
    When Admin enters fields from "<testcase>" in the add program form and clicks on save button
    Then Admin gets error text on program details popup

    Examples: 
      | testcase           |
      | InvalidProgramName |

  @addProgram @TC_Program_06
  Scenario Outline: Program Details pop up Validation for blank program description input
    Given Admin is on the program Popup window
    When Admin enters fields from "<testcase>" in the add program form and clicks on save button
    Then Admin gets error text on program details popup

    Examples: 
      | testcase             |
      | BlankDescriptionName |

  @addProgram @TC_Program_07
  Scenario Outline: Program Details pop up Validation for blank program status input
    Given Admin is on the program Popup window
    When Admin enters fields from "<testcase>" in the add program form and clicks on save button
    Then Admin gets error text on program details popup

    Examples: 
      | testcase    |
      | BlankStatus |

  @addProgram @cancelProgram @TC_Program_08
  Scenario: Program Details cancel button validation for add new program
    Given Admin is on the program Popup window
    When Admin clicks the cancel button in the program details window
    Then The program details window is closed and new program is not created

  @addProgram @closeProgram @TC_Program_09
  Scenario: Program Details close button validation for add new program
    Given Admin is on the program Popup window
    When Admin clicks the close X button in the program details window
    Then The program details window is closed and new program is not created

  #//search for the added program
  @addProgram @TC_Program_10
  Scenario: Verify added Program is created
    Given Admin is on the Manage Program page
    When Admin searches with newly created "sanDoNotEditt"
    Then Records of the newly created  "sanDoNotEditt" is displayed with correct values

  # EDIT PROGRAM
  @editProgram @TC_Program_11
  Scenario: Edit Program Validation
    Given Admin is on the Manage Program page
    When Admin clicks edit program button for a program "sanDoNotEditt"
    Then Admin should see a program details pop up with filled form and <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window
    Then Admin should see a red * mark for mandatory fields

  @editProgram @TC_Program_12
  Scenario: Verify edit Program Name
    Given Admin clicks edit program button for a program "sanDoNotEditt"
    When Admin Clicks on Save button after updating program Name as "sanDoNotEdited"
    Then Admin gets message program edited Successfully

  @editProgram @TC_Program_13
  Scenario: Verify edit Program description
    Given Admin clicks edit program button for a program "sanDoNotEdited"
    When Admin Clicks on Save button after updating program description as "it is here"
    Then Admin gets message program edited Successfully
    
   @editProgram @TC_Program_14
  Scenario: Verify edit Program status
    Given Admin clicks edit program button for a program "sanDoNotEdited"
    When Admin Clicks on Save button after updating program status as "inactive"
    Then Admin gets message program edited Successfully
    
   @editProgram @cancelProgram @TC_Program_15
  Scenario: Program Details cancel button validation for edit new program
    Given Admin clicks edit program button for a program "sanDoNotEdited"
    When Admin clicks the cancel button in the program details window
    Then The program details window is closed

  @editProgram @closeProgram @TC_Program_16
  Scenario: Program Details close button validation for edit new program
    Given Admin clicks edit program button for a program "sanDoNotEdited"
    When Admin clicks the close X button in the program details window
    Then The program details window is closed
    
    
  #//search for the edited program
  @addProgram @TC_Program_17
  Scenario: Verify added Program is edited
    Given Admin is on the Manage Program page
    When Admin searches with newly edited program name "sanDoNotEdited"
    Then Records of the edited program name "sanDoNotEditt" is displayed with correct values


  #Delete program feature
  
   @deleteProgram @TC_Program_18
   Scenario: Delete Program Validation
    Given Admin is on the Manage Program page
    When Admin clicks delete program button for a program "sanDoNotEdited"
    Then Admin should see confirmation pop up with and <No> and <Yes> buttons and Close(X) Icon on the top right corner of the window
   
   @deleteProgram
   Scenario: verify Yes button in Delete Confirm window
    Given Admin Clicks on any Delete button for program "sanDoNotEdited"
    When Admin Clicks on Yes button
    Then Admin is able to see message "Program Deleted Successfully"

  @deleteProgram
   Scenario: Verify No button in Delete Confirm window
    Given Admin Clicks on Delete button for a program 
    When Admin Clicks on No button
    Then The program should not be deleted
    
    
   @deleteProgram
   Scenario: Verify close button in Delete Confirm window
    Given Admin Clicks on Delete button for a program 
    When Admin Clicks on close button
    Then The program should not be deleted
    
   #//search for the deleted program
   @deleteProgram 
   Scenario: Verify Deleted Program
    Given Admin is on the Manage Program page
    When Admin searches with newly edited program name "sanDoNotEdited"
    Then The program name is not displayed
  
  
  #
  #Menu bar
  #@programMenu @programTC02
  #Scenario: Verify any broken links on program page
  #When Admin clicks Program on the navigation bar
  #Then Admin should not have any broken links for Program module
 
  #
  #@programMenu @programTC001
  #Scenario: Verify other modules name displayed in menu bar
  #When Admin clicks Program on the navigation bar
  #Then Admin should see the module names as in order
  #
  #@programMenu @programTC001
  #Scenario: Verify Logout displayed in menu bar
  #When Admin clicks Program on the navigation bar
  #Then Admin should see "Logout" in menu bar
  #
  #@programMenu @programTC001
  #Scenario: Verify sub menu displayed in program menu bar
  #When Admin clicks Program on the navigation bar
  #Then Admin should see sub menu in menu bar as "Add New Program"
  #

  #
  #Scenario: Verify view details of programs
  #Given Admin is on dashboard page after Login
  #When Admin clicks Program on the navigation bar
  #Then Admin should able to see Program name, description, and status for each program
  #
  #Scenario: Verify the Multiple Delete button state
  #Given Admin is on dashboard page after Login
  #When Admin clicks Program on the navigation bar
  #Then Admin should see a Delete button in left top is disabled
  #
  
   #Scenario: Verify checkbox default state beside Program Name column header
  #Given Admin is on dashboard page after Login
  #When Admin clicks Program on the navigation bar
  #Then Admin should see checkbox default state as unchecked beside Program Name column header as
  #
  #Scenario: Verify checkboxes default state beside each Program names in the data table
  #Given Admin is on dashboard page after Login
  #When Admin clicks Program on the navigation bar
  #Then Admin should see check box default state as unchecked on the left side in all rows against program name
  #
  
  

  
  
  @programheader
  Scenario: Verify column header name of data table
  Given Admin is on dashboard page after Login
  When Admin clicks Program on the navigation bar
  Then Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit/Delete
  
 
  Scenario: Verify Sort icon in manage program
  Given Admin is on dashboard page after Login
  When Admin clicks Program on the navigation bar
  Then Admin should see the sort arrow icon beside to each column header except Edit and Delete
  
  Scenario: Verify edit and delete icon in manage program
  Given Admin is on dashboard page after Login
  When Admin clicks Program on the navigation bar
  Then Admin should see the Edit and Delete buttons on each row of the data table
  
  Scenario: Verify pagination icons below data table in manage program
  Given Admin is on dashboard page after Login
  When Admin clicks Program on the navigation bar
  Then Admin should see the text as "Showing 1 to 5 of 56 entries" along with Pagination icon below the table
  
  Scenario: Verify footer message in manage program
  Given Admin is on dashboard page after Login
  When Admin clicks Program on the navigation bar
  Then Admin should see the footer as "In total there are 56 programs"
  
 
  #Manage Program - Delete Program
  #Scenario: Verify delete feature
  #Given Admin is on Program module
  #When Admin clicks on delete button for a program
  #Then Admin will get confirm deletion popup
  #
  #Scenario: Verify Admin is able to click 'Yes'
  #Given Admin is on Confirm deletion form
  #When Admin clicks on "Yes" button
  #Then Admin can see 'Successful Program Deleted' message
  #
  #Scenario: Verify Admin is able to deleted program
  #Given Admin is on Program module
  #When Admin Searches for "Deleted Program name"
  #Then There should be zero results
  #
  #Scenario: Verify Admin is able to click 'No'
  #Given Admin is on Program Confirm Deletion Page after selecting a program to delete
  #When Admin clicks on "No" button
  #Then Admin can see Confirmation form disappears
  #
  #Scenario: Verify Admin is able to close the window with "X"
  #Given Admin is on Program Confirm Deletion Page after selecting a program to delete
  #When Admin Click on "X" button
  #Then Admin can see Confirm Deletion form disappear
  #
  #Manage Program - Delete Multiple Program
  #Scenario: Verify Admin is able to select multiple programs
  #Given Admin is on Program module
  #When Admin clicks on delete button for a program
  #Then Admin will get confirm deletion popup
  #
  #Scenario: Verify Admin is able to select multiple programs
  #Given Admin is on Program module
  #When Admin selects more than one program by clicking on the checkbox
  #Then Programs get selected
  #
  #Scenario: Verify Admin is able to click 'Yes'
  #Given Admin is on Confirm deletion form
  #When Admin clicks on "Yes" button
  #Then Admin can see 'Successful Program Deleted' message
  #
  #Scenario: Verify Admin is able to deleted program
  #Given Admin is on Program module
  #When Admin Searches for "Deleted Program name"
  #Then There should be zero results
  #
  #Scenario: Verify Admin is able to click 'No'
  #Given Admin is on Confirm deletion form
  #When Admin clicks on "No" button
  #Then Admin can see Programs are still selected and not deleted
  #
  #Scenario: Verify Admin is able to close the window with "X"
  #Given Admin is on Program Confirm Deletion Page after selecting a program to delete
  #When Admin Click on "X" button
  #Then Admin can see Confirm Deletion form disappear
  #Program Search
  @searchProgramNamefull
  Scenario Outline: Verify Admin is able to view search results for valid program name
    Given Admin is on Program module and creates a new program
    When Admin enters Program Name as "<programName>" to be searched
    Then Admin should able to see Program name, description, and status for searched program name

    Examples: 
      | programName     |
      | sanDoNotEdit    |
      | invalid program |

  @searchProgramDescfull @searchPrograms
  Scenario Outline: Verify Admin is able to view search results found for valid program description
    Given Admin is on Program module and creates a new program
    When Admin enters Program Description as "<programDesc>" to be searched
    Then Admin should able to see Program name, description, and status for searched program name

    Examples: 
      | programDesc         |
      | undergrad DoNotEdit |
      | invalid description |

  #//sorting functionality
  #Feature:Ascending order Functionality
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

  #Feature: Descending order Functionality
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
