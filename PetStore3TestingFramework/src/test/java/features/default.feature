Feature: default

  this is an example file for wirting the tests
  #The comments are what to write in the step defs

  @Happy
  Scenario: Example
    #Here all your pre build steps for the request happen
    Given I have Valid credentials
    And I have entered a valid body
    #Here you actually build and get the respons
    When I submit the request to the api
    #Here you make Assertions to confirm the response is correct
    Then i get a response with a 200