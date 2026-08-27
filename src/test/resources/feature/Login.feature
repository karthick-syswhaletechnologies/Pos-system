Feature: POS System Login

  Scenario: Login with valid credentials and select branch

    Given I launch the browser
    When I open the POS System login page
    And I enter Branch Code "SA001"
    And I enter User Id "superadmin"
    And I enter Password "Admin@123"
    And I click the Login button
    And I click Get Started
    And I click the branch dropdown
    And I select Super Admin Branch
    And I click OK
    Then Dashboard should be displayed