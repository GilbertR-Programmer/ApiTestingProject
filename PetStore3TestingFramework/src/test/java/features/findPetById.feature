Feature: Retrieve Pet Details By ID

  As a user,
  I want to retrieve pet details by pet ID
  So that I can get information about a specific pet

  @happy
  Scenario: Successful Retrieval of Pet Details
    Given I have a valid pet ID
    When I make a GET request to /pet/{petId}
    Then I should receive a 200 OK response
    And the pet details should be correct

  @sad
  Scenario: Pet ID Does Not Exist
    Given I have an invalid pet ID that does not exist
    When I make a GET request to /pet/{petId}
    Then I should receive a 404 Not Found response
    And an error message indicating that the pet was not found


  @sad
  Scenario: Invalid Pet ID Format
    Given I have a pet ID in an invalid format
    When I make a GET request to /pet/{petId}
    Then I should receive a 400 Bad Request response
    And an error message indicating that the pet ID format is invalid
