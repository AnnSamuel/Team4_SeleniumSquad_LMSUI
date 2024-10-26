@Batch
Feature: This feature file contain scenario for the Batch module

  Background: Admin logged on the Dashboard page
    Given Admin is on the Dashboard Page

  @BatchPageNavigation
  Scenario: Verify Admin Navigate to Batch page successfully
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should be in the "Manage Batch" Page

  @BatchPageValidation-Title
  Scenario: Validate "Title" in Batch Page
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should see a title with text as "LMS - Learning Management System"

  @BatchPageValidation-heading
  Scenario: Validate "heading" in the Batch Page
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should see the "Manage Batch" Heading

  @BatchPageValidation-DisabledDeleteIcon
  Scenario: Validate disabled "Delete Icon" under the header in the Batch Page
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should see the "disabled" "Delete Icon" under the header

  @BatchPageValidation-EditIcon
  Scenario: Validate edit icon in each data rows
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should see the edit icon in each row

  @BatchPageValidation-DeleteIcon
  Scenario: Validate delete icon in each data rows
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should see the delete icon in each row

  @BatchPageValidation-CheckBox
  Scenario: validate checkbox in each data rows
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should the checkbox in each row
    
   @BatchPageValidation-TableHeaders
  Scenario: Validate Datatable headers
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should see the datatable headers 
    
    
    
    @BatchPageValidation-CheckboxHeader
  Scenario: Validate "Checkbox" in the Datatable header row
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should see the checkbox in the datatable header row
    
    
    @BatchPageValidation-SortIconHeaders
  Scenario: Validate "sort icon" next to all the datatable header
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should see the sort icon next to all Datatable headers 
    
    
    
    
  @VerifySubMenu
  Scenario: Verify sub menu displayed in batch menu bar
    Given Admin is on batch page
    When Admin clicks "Batch" on the navigation bar
    Then Admin should see sub menu in menu bar as "Add New Batch"

  @VerifyBatchWindowOpens
  Scenario: Validate Admin able to click on the Add new Batch Option
    When Admin clicks on "Add New batch" under the "batch" menu bar
    Then Admin should see the Batch Details pop up window
