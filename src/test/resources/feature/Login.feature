Feature: POS System Login

  Scenario: Login with valid credentials and select branch

    Given User launch the browser
    When User opens the POS System login page
    And User enters Branch Code "SA001"
    And User enters User Id "superadmin"
    And User enters Password "Admin@123"
    And User clicks the Login button
    And User clicks Get Started
    And User clicks the branch dropdown
    And User selects Super Admin Branch
    And User clicks OK
    Then Dashboard should be displayed