

Feature: TestCase1
  /**
  Date: 19-Oct-20
  "Test Objective: To Generate token and store in excel.
  Expected Result: Generated token should be stored in an excel
  **/
  @scenario
  Scenario Outline: Add book to a user

    Given I post a user details with "<User>" and "<password>"
    When I post the details to generate token
    And I post the User detail to add book with ISBN "<isbn>"
    Then I verify book is added to the user
    Examples:
      | User | password | isbn |
      |Sampat75 | Sampat@1234 | 9781491950296 |