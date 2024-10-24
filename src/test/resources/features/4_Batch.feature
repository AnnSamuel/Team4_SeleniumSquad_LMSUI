@Batch
Feature: This feature file contain scenario for the Batch module

  Background: Admin successfully Logged on to the LMS Portal
    Given Admin is in login Page
    When Admin enter valid credentials "ValidCredentials" and clicks login button
    Then Admin should land on dashboard page ( centre of the page will be empty , menu bar is present).

  @ManageBatchPage
  Scenario: Verify Admin Navigate to Batch page successfully
    Given Admin is on the Dashboard Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should be in the Manage Batch Page