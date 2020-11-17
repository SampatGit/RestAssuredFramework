Feature: TestCase3
  /**
  Date: 27-Oct-20
  "Test Objective: To Generate token and store in excel.
  Expected Result: Generated token should be stored in an excel
  **/
  @scenario
Scenario:
  Given I fetch the user details from spreadsheet
  When I get the books for the assigned user from API.
  Then I verify that the stored details matches with the API results