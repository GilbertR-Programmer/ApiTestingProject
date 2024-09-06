Feature: Add A Pet

  Test a user can add a pet with the api and results are as expected

  @Happy
  Scenario Outline: Adding a valid pet using the API
    Given I have created an add pet request
    And I have entered the following information
      | field         | value             |
      | name          | <name>            |
      | id            | <id>              |
      | categoryId    | <categoryId>      |
      | categoryName  | <categoryName>    |
      | photoUrls     | <photoUrls>       |
      | tags          | <tags>            |
      | status        | <status>          |
    When I send the POST request
    Then I should receive a 200 status code
    And the store should contain the new pet
    Examples:
      | name      | id  | categoryId | categoryName | photoUrls                      | tags                | status    |
      | Buddy     | 123 | 1          | Dog          | https://example.com/photo1.jpg | friendly,playful    | available |
      | Whiskers  | 456 | 2          | Cat          | https://example.com/photo2.jpg | shy,lazy            | available |
      | Goldy     | 789 | 3          | Fish         | https://example.com/photo3.jpg | calm,colorful       | sold      |


  @Sad
  Scenario: Trying to add an invalid pet
    Given I have created an add pet request
    And I have not entered Valid information
    When I send the POST request
    Then I should receive a 400 status code