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

  @addProgram @TC_Program_02
  Scenario: Add New Program Validation
    Given Admin is on the Manage Program page
    When Admin clicks add new program under the program menu bar
    Then Admin should see a manage program pop up with empty form and <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window
    Then Admin should see program name description and status fields in the program details window

  @addProgram @TC_Program_03
  Scenario: Program Details pop up Validation for valid inputs
    Given Admin is on the program Popup window
    When Admin enters "validInputAll" mandatory fields in the add program form and clicks on save button
    Then Admin gets message program added Successfully
    
  @addProgram @TC_Program_04
  Scenario: Program Details pop up Validation for blank program name input
    Given Admin is on the program Popup window
    When Admin enters "BlankProgramName" mandatory fields in the add program form and clicks on save button
    Then Admin gets error text on program details popup
    
  @addProgram @TC_Program_05
  Scenario: Program Details pop up Validation for invalid program name input
    Given Admin is on the program Popup window
    When Admin enters "InvalidProgramName" mandatory fields in the add program form and clicks on save button
    Then Admin gets error text on program details popup
    
  @addProgram @TC_Program_06
  Scenario: Program Details pop up Validation for blank program description input
    Given Admin is on the program Popup window
    When Admin enters "BlankDescriptionName" mandatory fields in the add program form and clicks on save button
    Then Admin gets error text on program details popup
    
  @addProgram @TC_Program_07
  Scenario: Program Details pop up Validation for blank program status input
    Given Admin is on the program Popup window
    When Admin enters "BlankStatus" mandatory fields in the add program form and clicks on save button
    Then Admin gets error text on program details popup
    
    
    

  #
  #Menu bar
  #@programMenu @programTC02
  #Scenario: Verify any broken links on program page
  #When Admin clicks Program on the navigation bar
  #Then Admin should not have any broken links for Program module
  #
  #@programMenu @programTC003
  #Scenario: Verify heading in menu bar
  #When Admin clicks Program on the navigation bar
  #Then Admin should see the heading "LMS - Learning Management System"
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
  #Manage program page validation
  #Scenario: Verify heading in manage program
  #Given Admin is on dashboard page after Login
  #When Admin clicks Program on the navigation bar
  #Then Admin should see the heading "Manage Program"
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
  #Scenario: Verify the Search button
  #Given Admin is on dashboard page after Login
  #When Admin clicks Program on the navigation bar
  #Then Admin should see Search bar with text as "Search..."
  #
  #Scenario: Verify column header name of data table
  #Given Admin is on dashboard page after Login
  #When Admin clicks Program on the navigation bar
  #Then Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit/Delete
  #
  #Scenario: Verify checkbox default state beside Program Name column header
  #Given Admin is on dashboard page after Login
  #When Admin clicks Program on the navigation bar
  #Then AAdmin should see checkbox default state as unchecked beside Program Name column header as
  #
  #Scenario: Verify checkboxes default state beside each Program names in the data table
  #Given Admin is on dashboard page after Login
  #When Admin clicks Program on the navigation bar
  #Then Admin should see check box default state as unchecked on the left side in all rows against program name
  #
  #Scenario: Verify Sort icon in manage program
  #Given Admin is on dashboard page after Login
  #When Admin clicks Program on the navigation bar
  #Then Admin should see the sort arrow icon beside to each column header except Edit and Delete
  #
  #Scenario: Verify edit and delete icon in manage program
  #Given Admin is on dashboard page after Login
  #When Admin clicks Program on the navigation bar
  #Then Admin should see the Edit and Delete buttons on each row of the data table
  #
  #Scenario: Verify pagination icons below data table in manage program
  #Given Admin is on dashboard page after Login
  #When Admin clicks Program on the navigation bar
  #Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table
  #
  #Scenario: Verify footer message in manage program
  #Given Admin is on dashboard page after Login
  #When Admin clicks Program on the navigation bar
  #Then Admin should see the footer as "In total there are z programs"
  #
  # Menu bar - Program - Add New Program
  #Scenario: Verify add New Program
  #Given Admin is on Program module
  #When Admin clicks on New Program under the Program menu bar
  #Then Admin should see pop up window for program details
  #
  #Scenario: Verify title of the pop up window
  #Given Admin is on Program module
  #When Admin clicks on New Program under the Program menu bar
  #Then Admin should see window title as "Program Details"
  #
  #Scenario: Verify mandatory fields with red "*" mark
  #Given Admin is on Program module
  #When Admin clicks on New Program under the Program menu bar
  #Then Admin should see red "*" mark beside mandatory field "Name"
  #
  #Scenario: Verify empty form submission
  #Given Admin is on Program details form
  #When Admin clicks save button without entering mandatory fields
  #Then Admin gets message '<field> is required'
  #
  #Scenario: Verify cancel button
  #Given Admin is on Program details form
  #When Admin clicks Cancel button
  #Then Admin can see Program Details form disappears
  #
  #Scenario: Verify enter program name
  #Given Admin is on program details form
  #When Admin enters the Name in the text box
  #Then Admin can see the text entered
  #
  #Scenario: Verify enter description
  #Given Admin is on program details form
  #When Admin enters the Description in text boxbar
  #Then Admin can see the text entered in description box
  #
  #Scenario: Verify select Status
  #Given Admin is on program details form
  #When Admin selects the status of the program by clicking on the radio button "(Active/InActive)"
  #Then Admin can see 'Active/Inactive' status selected
  #
  #Scenario: Verify select Status
  #Given Admin is on Program module
  #When Admin clicks on New Program under the Program menu bar
  #Then Admin should see pop up window for program details
  #Scenario: Verify Admin is able to save the program details
  #Given Admin is on program details form
  #When Admin enter valid details for mandatory fields and Click on save button
  #Then Admin gets message 'Successful Program created'
  #
  #Scenario: Verify cancel program details
  #Given Admin is on program details form
  #When Admin Click on cancel button
  #Then Admin can see program details form disappear
  #
  #Scenario: Verify added Program is created
  #Given Admin is on Program module
  #When Admin searches with newly created "Program Name"
  #Then Records of the newly created  "Program Name" is displayed and match the data entered
  #
  #Scenario: Verify close window with X
  #Given Admin is on program details form
  #When Admin Click on "X" button
  #Then Admin can see program details form disappear
  #
  #Manage program- Edit
  #Scenario: Verify Edit option
  #Given Admin is on Program module
  #When Admin clicks on Edit option for particular program
  #Then Admin lands on Program details form
  #
  #Scenario: Verify title of the pop up window
  #Given Admin is on Program module
  #When Admin clicks on Edit option for particular program
  #Then Admin should see window title as "Program Details"
  #
  #Scenario: Verify mandatory fields with red "*" mark
  #Given Admin is on program details form
  #When Admin clicks on Edit option for particular program
  #Then Admin should see red "*" mark beside mandatory field "Name"
  #
  #Scenario: Verify edit Program Name
  #Given Admin is on program details form
  #When Admin edits the program name and click on save button
  #Then Updated program name is seen by the Admin
  #
  #Scenario: Verify edit Description
  #Given Admin is on program details form
  #When Admin edits the description text and click on save button
  #Then Admin can see the description is updated
  #
  #Scenario: Verify edit Status
  #Given Admin is on program details form
  #When Admin can change the status of the program and click on save button
  #Then Status updated can be viewed by the Admin
  #
  #Scenario: Verify Admin is able to click Save
  #Given Admin is on program details form
  #When Admin click on save button
  #Then Admin can see the updated program details
  #
  #Scenario: Verify Admin is able to click Cancel
  #Given Admin is on program details form
  #When Admin click on cancel button
  #Then Admin can see the Program details form disappears
  #
  #Scenario: Verify edited Program details
  #Given Admin is on Program module
  #When Admin searches with newly updated "Program Name"
  #Then Admin verifies that the details are correctly updated.
  #
  #Scenario: Verify close the window with "X"
  #Given Admin is on program details form
  #When Admin Click on "X" button
  #Then Admin can see program details form disappear
  #
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
    Given Admin is on Program module
    When Admin enter the program to search by "<programName>"
    Then Admin should able to see Program name, description, and status for searched program name

    Examples: 
      | programName |
      | testssjavaa |

  @searchProgramNameinvalid @searchPrograms
  Scenario Outline: Verify Admin is not able view to search results for invalid program name
    Given Admin is on Program module
    When Admin enter the program to search by "<programName>"
    Then Admin should not view any search results

    Examples: 
      | programName |
      | invalid     |

  @searchProgramNamePartial @searchPrograms
  Scenario Outline: Verify Admin is able to view search results found for partial program name
    Given Admin is on Program module
    When Admin enter the program to search by "<programName>"
    Then Admin should able to see Program name, description, and status for searched program name

    Examples: 
      | programName |
      | mast        |

  @searchProgramNameMultiple @searchPrograms
  Scenario Outline: Verify Admin is able to view multiple search results for program name
    Given Admin is on Program module
    When Admin enter the program to search by "<programName>"
    Then Admin should able to see multiple program results for searched program name

    Examples: 
      | programName | count |
      | tss         |     2 |

  @searchProgramDescfull @searchPrograms
  Scenario Outline: Verify Admin is able to view search results found for valid program description
    Given Admin is on Program module
    When Admin enter the program to search by "<programDescription>"
    Then Admin should able to see Program name, description, and status for searched program name

    Examples: 
      | programDescription |
      | testjava           |

  @searchProgramDescInvalid @searchPrograms
  Scenario Outline: Verify Admin is not able view to search results for invalid program description
    Given Admin is on Program module
    When Admin enter the program to search by "<programDescription>"
    Then Admin should not view any search results

    Examples: 
      | programDescription |
      | invalid            |

  @searchProgramDescPartial @searchPrograms
  Scenario Outline: Verify Admin is able to view search results found for partial program description
    Given Admin is on Program module
    When Admin enter the program to search by "<programDescription>"
    Then Admin should able to see Program name, description, and status for searched program description

    Examples: 
      | programDescription |
      | stja               |

  @searchProgramDescMultiple @searchPrograms
  Scenario Outline: Verify Admin is able to view multiple search results found for program description
    Given Admin is on Program module
    When Admin enter the program to search by "<programDescription>"
    Then Admin should able to see multiple program results for searched program description

    Examples: 
      | programDescription |
      | tjava              |
