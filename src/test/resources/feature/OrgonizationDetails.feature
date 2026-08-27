Feature: Organization Details

  Scenario: Verify Organization Details page

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

    When I click Admin
    And I click Organization Details
    Then Organization Details page should be displayed
    And Add New button should be displayed
    Then I click Add New
    Then Organization creation form should be displayed
    And Search by Org Name field should be displayed

