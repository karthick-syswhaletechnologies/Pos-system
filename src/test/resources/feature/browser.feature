Feature: Browser Launch


  Background:

    Given Login to App and Navigate to Dashboard

Scenario: Launch browser
#  Given I lauch the chromeBrowser

  Scenario: Validate the Dropdown Details
    When user is on dashboard verify the dropdown list page
    Then Enter Fields Dropdown type,Filter by and Item Name
    And Save Dropdown list



#    @smoke

#  Scenario: Validate the Dropdown Details
#    When user is on dashboard verify the dropdown list page
#    Then Enter Fields Dropdown type,Filter by and Item Name
#    And Reset Dropdown list
#    Then Verify all field values are cleared


#Feature: Business Centre 01
  Scenario: Validate the Business Centre Details

    When User is on dashboard verify the Business Center  list page
    Then Enter the Business Centre Fields
    And Enter the Branch Information,Address and Contact Number
    And Save Business Centre List
