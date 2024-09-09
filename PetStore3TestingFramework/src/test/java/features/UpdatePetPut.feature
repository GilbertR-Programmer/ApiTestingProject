Feature: Update pet using PUT request on Petstore API

  Background:
    Given I am using the Petstore API PUT pet method

  @Happy
  Scenario: Update pet using PUT method with valid credentials updates pet
    And I have a valid pet ID 5
    And I have a pet ID that exists 5
    When I submit the request
    Then I should receive a 200 status code
    And the pet should be updated