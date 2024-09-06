Feature: Retrieve Pet Details By ID

  As a user,
  I want to retrieve pet details by pet ID
  So that I can get information about a specific pet

  @happy
  Scenario Outline: Successful Retrieval of Pet Details
    Given I have a valid pet ID of "<petId>"
    When I make get a request to find pet by id
    Then I should receive a 200 status code
    And the pet details should have an ID of "<petId>"
    Examples:
      | petId |
      | 1     |
      | 3     |
      | 5     |
      | 6     |


  @sad
  Scenario: Pet ID Does Not Exist
    Given I have an invalid pet ID that does not exist
    When I make get a request to find pet by id
    Then I should receive a 404 status code
    And an error message indicating that the pet was not found


  @sad
  Scenario: Invalid Pet ID Format
    Given I have a pet ID in an invalid format
    When I make get a request to find pet by id
    Then I should receive a 400 status code
    And an error message indicating that the pet ID format is invalid
