Feature: DeletePet

  @Happy
  Scenario: Delete a pet from the store
    Given I send a DELETE request to the Petstore API
    And I have provided a valid Pet ID
    And I have provided a valid Api_Key
    When I send the Request
    Then I should receive a 204 No Content status code
    And The Pet should be removed from the Store