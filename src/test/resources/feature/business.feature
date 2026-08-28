Feature: Business Centre 01
  Scenario: Validate the Business Centre Details
    Given Login to App and Navigate to Dashboard

    When User is on dashboard verify the dropdown list page
    Then Enter the Business Centre Fields
    And Enter the Branch Information,Address and Contact Number
    And Save Business Centre List