Feature: FindByStatus

  @Happy
  Scenario: Find pets by status
    Given that I select "available"
    When getting pets by status
    Then I should see all "available" pets in the store