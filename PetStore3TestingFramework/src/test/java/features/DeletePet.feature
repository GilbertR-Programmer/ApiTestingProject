Feature: DeletePet

  @happy
  Scenario: Delete a pet from the store
    Given I have provided a valid Pet ID of "789"
    And I have provided a valid Api_Key of "api_key"
    When I send a DELETE request to the Petstore API
    Then I should receive a 200 status code
    And The Pet should be removed from the Store

  @sad
  Scenario: Delete a pet from the store with invalid API key
    Given I have provided a valid Pet ID of "3"
    And I have provided a valid Api_Key of " "
    When I send a DELETE request to the Petstore API
    Then I should receive a 401 status code
    And The Pet should remain in the store
#   This test will fail unless development team adds a check for the API key