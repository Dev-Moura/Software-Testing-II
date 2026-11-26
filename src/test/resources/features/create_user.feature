Feature: Create User

  Scenario: successfully create a user

    Given the user name is "Pedro"
    When i send a request to create the user
    Then the user should be saved with name "Pedro"
