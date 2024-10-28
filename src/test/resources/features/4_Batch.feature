Feature: This feature file contain scenario for the Batch module

  Background: Admin logged on the Dashboard page
    Given Admin is on the Dashboard Page - Batch

  @TC_Batch_01 @Batch
  Scenario: Verify Admin Navigate to Batch page successfully
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should be in the "Manage Batch" Page

  @TC_Batch_02 @Batch
  Scenario: Validate "Title" in Batch Page
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should see a title with text as "LMS - Learning Management System"

  @TC_Batch_03
  Scenario: Validate "heading" in the Batch Page
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should see the "Manage Batch" Heading

  @TC_Batch_04
  Scenario: Validate disabled "Delete Icon" under the header in the Batch Page
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should see the "disabled" "Delete Icon" under the header

  @TC_Batch_06
  Scenario: Validate edit icon in each data rows
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should see the edit icon in each row

  @TC_Batch_07
  Scenario: Validate delete icon in each data rows
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should see the delete icon in each row

  @TC_Batch_08
  Scenario: validate checkbox in each data rows
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should the checkbox in each row

  @TC_Batch_09
  Scenario: Validate Datatable headers
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should see the datatable headers

  @TC_Batch_10
  Scenario: Validate "Checkbox" in the Datatable header row
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should see the checkbox in the datatable header row

  @TC_Batch_11
  Scenario: Validate "sort icon" next to all the datatable header
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should see the sort icon next to all Datatable headers

  @TC_Batch_12
  Scenario: Verify sub menu displayed in batch menu bar
    Given Admin is on batch page
    When Admin clicks "Batch" on the navigation bar
    Then Admin should see sub menu in menu bar as "Add New Batch"
#
  @TC_Batch_13
  Scenario: Validate Admin able to click on the Add new Batch Option
    When Admin clicks on "Add New batch" under the "batch" menu bar
    Then Admin should see the Batch Details pop up window

  @TC_Batch_15
  Scenario: Validate batchname prefix selected program name
    Given Admin is on the Batch Details Pop Up WIndow
    When Admin selects program name present in the dropdown
    Then Admin should see selected program name in the batch name prefix box

  @TC_Batch_16
  Scenario: Validate batch name suffix box should accept only numbers
    Given Admin is on the Batch Details Pop Up WIndow
    When Admin enters alphabets in batch name suffix box
    Then Admin should get error message below the text box of respective field

  @TC_Batch_17
  Scenario: Validate batch name prefix box is not editable
    Given Admin is on the Batch Details Pop Up WIndow
    When Admin enters alphabets in batch "name prefix" box
    Then Admin should see empty text box

  @TC_Batch_18 @TC_Batch_20
  Scenario: Validate input data only for mandatory fields
    Given Admin is on the Batch Details Pop Up WIndow
    When Admin enters the "Mandatory" data and clicks "save" button
    Then Admin should get a successful message

  @TC_Batch_19 @TC_Batch_19.1
  Scenario: Validate input data only for mandatory fields
    Given Admin is on the Batch Details Pop Up WIndow
    When Admin enters the "MissingProgram" data and clicks "save" button
    Then Admin should get error message below the text box of respective field for "MissingProgram"

  @TC_Batch_19 @TC_Batch_19.2
  Scenario: Validate input data only for mandatory fields
    Given Admin is on the Batch Details Pop Up WIndow
    When Admin enters the "MissingBatchName" data and clicks "save" button
    Then Admin should get error message below the text box of respective field for "MissingBatchName"

  @TC_Batch_191 @TC_Batch_19.3
  Scenario: Validate input data only for mandatory fields
    Given Admin is on the Batch Details Pop Up WIndow
    When Admin enters the "MissingStatus" data and clicks "save" button
    Then Admin should get error message below the text box of respective field for "MissingStatus"

  @TC_Batch_191 @TC_Batch_19.4
  Scenario: Validate input data only for mandatory fields
    Given Admin is on the Batch Details Pop Up WIndow
    When Admin enters the "MissingDesc" data and clicks "save" button
    Then Admin should get error message below the text box of respective field for "MissingDesc"

  @TC_Batch_191 @TC_Batch_19.5
  Scenario: Validate input data only for mandatory fields
    Given Admin is on the Batch Details Pop Up WIndow
    When Admin enters the "MissingNoOfClass" data and clicks "save" button
    Then Admin should get error message below the text box of respective field for "MissingNoOfClass"

  @TC_Batch_21 
  Scenario: validate cancel button in Batch details pop up
    Given Admin is on the Batch Details Pop Up WIndow
    When Admin enters the "Mandatory" data and clicks "cancel" button
    Then Admin can see the batch details popup closes without creating any batch

  @TC_Batch_22 
  Scenario: validate close icon on the batch details pop up
    Given Admin is on the Batch Details Pop Up WIndow
    When Admin enters the "Mandatory" data and clicks "close" button
    Then Admin can see the batch details popup closes without creating any batch
    
  @TC_Batch_23 
  Scenario: Validate Edit icon feature in any row
    Given Admin is on batch page
    When Admin clicks edit batch button for a batch "ValidSearch"
    Then Admin should see the Batch Details pop up window
    
    @TC_Batch_24 
  Scenario: Validate program name  value is disabled to edit
    Given Admin is on batch page
    When Admin clicks edit batch button for a batch "ValidSearch"
    Then Admin should see "Program name" value field is disabled for editing
    
    @TC_Batch_25 
  Scenario: Validate batch name  value is disabled to edit
    Given Admin is on batch page
    When Admin clicks edit batch button for a batch "ValidSearch"
    Then Admin should see "Batch name" value field is disabled for editing
    
    @TC_Batch_26 
  Scenario: Validate editing description and No. of classes fields with invalid data in the pop up
    Given Admin is on batch page
    And Admin clicks edit batch button for a batch "ValidSearch"
    When Admin enters the "InvalidDescriptionEdit" data and clicks "save" button
    Then Admin should get error message below the text box of respective field for "InvalidDescriptionEdit"
    
    @TC_Batch_27 
  Scenario: Validate editing description and No. of classes fields with invalid data in the pop up
    Given Admin is on batch page
    And Admin clicks edit batch button for a batch "ValidSearch"
    When Admin enters the "ValidEdit" data and clicks "save" button
    Then Admin should get a successful message
    
     @TC_Batch_28 
  Scenario: validate cancel button in Batch details pop up
    Given Admin is on batch page
    And Admin clicks edit batch button for a batch "ValidSearch"
    When Admin enters the "ValidEdit" data and clicks "cancel" button
    Then Admin can see the batch details popup closes without creating any batch
    
    @TC_Batch_39 @TC_Batch_40 @TC_Batch_41 
  Scenario: validate serach box functionality
    Given Admin is on batch page
    When Admin enters the batch name "ValidSearch" in the search text box 
    Then Admin should see the filtered "ValidSearch" batches in the data table
  
    
    
    
