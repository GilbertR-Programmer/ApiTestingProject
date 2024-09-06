Feature: Find A Pet By Their Tags

  Test a user gets expected results when searching for a pet by tags

  @Happy
  Scenario Outline: Search based on tag and get expected result
    Given I have created a find by tags request
    And I have added the tag "<tag>" to the parameters
    When I send the GET request
    Then I should receive an array of pets with the tag "<tag>"
    And I should receive a 200 status code
    Examples:
      | tag |
      |tag1|
      |tag2|
      |tag3|

  @Sad
  Scenario: Search based on tags but give an invalid input
    Given I have created a find by tags request
    And I add no tags to the parameters
    When I send the GET request
    Then I should receive the message "No tags provided. Try again?"
    And I should receive a 400 status code

  @Sad
  Scenario: Search based on tags using a valid but unused tag
    Given I have created a find by tags request
    And I have added the tag "unused tag" to the parameters
    When I send the GET request
    Then I should receive an empty array
    And I should receive a 200 status code
