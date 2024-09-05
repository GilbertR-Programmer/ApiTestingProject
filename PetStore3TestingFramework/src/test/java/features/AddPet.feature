Feature: Add Pet

  Test a user can add a pet with the api and results are as expected

  @Happy
  Scenario: Adding a valid pet using the api
    Given I have created a post request
    And I have entered Valid information
    When I send the POST request
    Then I should receive a 200 status Code
    And the store should contain the new pet

  @Sad
  Scenario:
    Given I have created a post request
    And I have not entered Valid information
    When I send the POST request
    Then I should receive a 405 status Code
    And the store should not contain the invalid entry