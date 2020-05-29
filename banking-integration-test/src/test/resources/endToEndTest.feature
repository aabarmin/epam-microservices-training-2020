Feature: Example of end-to-end test

  Scenario Outline: Create accounts
    Given the system without accounts for <ownerId>
    When an account with name <name> and owner <ownerId> is created
    Then <number> of accounts for <ownerId> exist

  Examples:
    | name  | ownerId | number |
    | Fedor | 1       | 1      |
    | Ivan  | 2       | 1      |