Feature: A user can add an image to a specific pet

  Test a user gets expected results when trying to add an image to a pet

  @Happy
  Scenario: Add image to a pet
    Given I have created an upload image request
    And I have added the id 200 to the parameters
    And I have added an image to the body
    When I send the POST request
    Then I should receive a 200 status code
    And The Image should be in the pet

  @Happy
  Scenario: Add image of a pet
    Given I have created an upload image request
    And I have added the id 9999 to the parameters
    And I have added an image to the body
    When I send the POST request
    Then I should receive a 400 status code


  @Sad
  Scenario: Add an image to a pet with invalid input
    Given I have created an upload image request
    And I have added the id "Smedfjgi" to the parameters
    When I send the POST request
    Then I should receive a 400 status code
