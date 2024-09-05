Feature: FindByStatus

  @Happy
  Scenario Outline: Find pets by status
    Given that I select "<status>"
    When getting pets by status
    Then I should see all "<status>" pets in the store

    Examples:
      | status    |
      | available |
      | sold      |
      | pending   |