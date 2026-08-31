Feature: Dropdown List

  Scenario: Create a State dropdown value
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
    When User clicks Staff and User
    And User clicks Dropdownlist
    And User selects "state" from Dropdown Type
    And User selects "India" from Filter By
    And User enters "Tamil Nadu" in Item Name
    And User clicks Save
    And User clicks Dropdownlist
    And User selects "state" from Dropdown Type
    Then the State dropdown value should be displayed
