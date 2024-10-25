@Batch
Feature: This feature file contain scenario for the Batch module

  Background: Admin logged on the Dashboard page 
	Given Admin is on the Dashboard Page 

  @BatchPageNavigation 
  Scenario: Verify Admin Navigate to Batch page successfully
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should be in the "Manage Batch" Page
    
    
    @BatchPageValidation
    Scenario: Validate "Title" in Batch Page
    When Admin Clicks on the "Batch" menu from the header
    Then Admin should see a title with text as "LMS"