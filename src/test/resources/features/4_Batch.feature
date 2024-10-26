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

  @VerifySubMenu
  Scenario: Verify sub menu displayed in batch menu bar
    Given Admin is on batch page
    When Admin clicks "Batch" on the navigation bar
    Then Admin should see sub menu in menu bar as "Add New Batch"

  @VerifyBatchWindowOpens
  Scenario: Validate Admin able to click on the Add new Batch Option
    When Admin clicks on "Add New batch" under the "batch" menu bar
    Then Admin should see the Batch Details pop up window
