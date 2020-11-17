Feature: TestCase4
  /**
  Date: 29-Oct-20
  "Test Objective:
  To verify the title of the book with a given ISBN

  Expected Result:
  Title of the book must match for a given ISBN"
  **/
  @scenario
  Scenario Outline:
    Given I get the title of the book for a given "<ISBN>"
    Then I verify the title matches with "<title>"

    Examples:
    |ISBN | title|
    | 9781491950296 | Programming JavaScript Applications |

