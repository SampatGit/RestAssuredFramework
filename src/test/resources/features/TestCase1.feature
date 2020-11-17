
Feature: TestCase1

/**
Date: 29-Sep-20
"Test Objective: To Generate token and store in excel.
Expected Result: Generated token should be stored in an excel
**/

@scenario
Scenario Outline: Generate token and store in excel

  Given I have userName "<User>" and password as "<Password>"
  And I verify user is posted in API with response code 201
  When I post the details to generate token
  Then I verify that the token is stored in Data Provider excel

  Examples:
    | User | Password |
    | SampatUser33 | Sampat@1235 |