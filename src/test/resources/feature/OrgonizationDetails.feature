Feature: Organization Details

  Scenario: Verify Organization Details page

    Given User launches the browser
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

    When User clicks Admin
    And User clicks Organization Details

    Then Organization Details page should be displayed
    And Add New button should be displayed

    Then User clicks Add New

    Then Organization creation form should be displayed

    And User enters Organization Name "Test Organization"
    And User enters Registration Number "REG123456"
    And User enters TIN Number "TIN123456"
    And User enters Address "123 Main Street"
    And User enters Location "Chennai"
    And User selects Country "India"
    And User selects State "Tamil Nadu"
    And User selects District "Chennai"
    And User enters Postcode "600001"
    And User enters Contact Number "9876543210"
    And User clicks Organization Save button