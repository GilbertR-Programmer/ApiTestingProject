Feature: Retrieve Pet Details

  As a user,
  I want to retrieve pet details by pet ID
  So that I can get information about a specific pet

  @happy
  Scenario: Successful Retrieval
    Given I have a valid pet ID
    When I make a GET request to /pet/{petId}
    Then I should receive a response with the pet's details

  @sad
  Scenario: Pet ID Does Not Exist
    Given I provide an invalid pet ID that does not exist
    When I make a GET request to /pet/{petId}
    Then I should receive a 404 Not Found error
    And the response message should indicate that the pet was not found

  @sad
  Scenario: Invalid Pet ID Format
    Given I provide a pet ID that does not conform to the expected format
    When I make a GET request to /pet/{petId}
    Then I should receive a 400 Bad Request error
    And the response message should indicate that the pet ID format is invalid
