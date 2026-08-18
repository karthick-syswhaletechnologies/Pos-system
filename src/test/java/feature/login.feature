Feature: Login functionality

  Scenario: Login with valid username and password
    Given I am on the login page
    When I enter a valid username
    And I enter a valid password
    And I click the login button
    Then I should be successfully logged in