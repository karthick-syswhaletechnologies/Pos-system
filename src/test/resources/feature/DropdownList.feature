Feature: Dropdown List

  Scenario: Create a State dropdown value

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

    When I click Staff and User
    And I click Dropdownlist
    And I select "state" from Dropdown Type
    And I select "India" from Filter By
    And I enter "Tamil Nadu" in Item Name
    And I click Save
    Then the State dropdown value should be displayed