Feature: Does users service work?
  It's necessary check that users service works correctly every time

  Scenario: Cleanup the database
    Given the system has no users registered
    When all the users are requested
    Then 0 users are returned

  Scenario: A new user is created
    Given the system has no users registered
    When a new active user with login TestLogin and password TestPassword is created
    And all the users are requested
    Then 1 users are returned