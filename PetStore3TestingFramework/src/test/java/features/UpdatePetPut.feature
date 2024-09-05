Feature: Update pet using PUT request on Petstore API

  Background:
    Given I am using the Petstore API PUT pet method

  @Happy
  @UpdatePetPutFeature
  Scenario: Update pet using PUT method with valid credentials updates pet
    And I have a valid pet ID {petId}
    And I have a pet ID that exists {petId}
    When I submit the request
    Then I should recieve a {status code} status code
    And the pet should be updated

  @Sad
  @UpdatePetPutFeature
  Scenario: update pet using PUT method where Pet with ID does not exist
    And I have a valid pet ID {petId}
    And I have a pet ID that does not exist {petId}
    When I submit the request
    Then I should recieve a {status code} status code
    And Nothing should be updated

  @Sad
  @UpdatePetPutFeature
    Scenario: update Pet using PUT method with invalid pet ID
    And I have an invalid pet ID {petId}
    When I submit the request
    Then I should recieve a {status code} status code
    And Nothing should be updated

  @Sad
  @UpdatePetPutFeature
    Scenario: update Pet using Put method with invalid information
    And I have a valid pet ID {petId}
    And I have a pet ID that exists {petId}
    And I have entered invalid information to be updated
    When I submit the request
    Then I should recieve a {status code} status code
    And Nothing should be updated