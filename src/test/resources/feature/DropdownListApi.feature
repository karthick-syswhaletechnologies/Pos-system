@API
Feature: Dropdown List API

  #DL_TC_001
  Scenario: Verify Dropdown List GET API returns successful response
    When User sends a GET request to the Dropdown List API
    Then Dropdown API response status should be 200

    #DL_TC_002
  Scenario: Verify Dropdown API response body is not empty
    When User sends a GET request to the Dropdown List API
    Then Dropdown API response body should not be empty

    #DL_TC_003
  Scenario: Verify Dropdown API IsSuccess value
    When User sends a GET request to the Dropdown List API
    Then Dropdown API IsSuccess should be true

    #DL_TC_004
  Scenario: Verify dropdown records are returned
    When User sends a GET request to the Dropdown List API
    Then Dropdown API should return dropdown records

    #DL_TC_005
  Scenario: Verify dropdown ID is available
    When User sends a GET request to the Dropdown List API
    Then Dropdown API records should contain valid IDs

    #DL_TC_006
  Scenario: Verify dropdown type is available
    When User sends a GET request to the Dropdown List API
    Then Dropdown API records should contain dropdown type

    #DL_TC_007
  Scenario: Verify item name is available
    When User sends a GET request to the Dropdown List API
    Then Dropdown API records should contain item name

    #DL_TC_008
  Scenario: Verify filter by field is available
    When User sends a GET request to the Dropdown List API
    Then Dropdown API records should contain filter by value

    #DL_TC_009
  Scenario: Verify state records are returned
    When User sends a GET request to the Dropdown List API
    Then Dropdown API should contain state records

    #DL_TC_010
  Scenario: Verify country record is returned
    When User sends a GET request to the Dropdown List API
    Then Dropdown API should contain country record

    #DL_TC_011
  Scenario: Verify district record is returned
    When User sends a GET request to the Dropdown List API
    Then Dropdown API should contain district record

    #DL_TC_012
  Scenario: Verify Tamil Nadu state record
    When User sends a GET request to the Dropdown List API
    Then Dropdown API should contain Tamil Nadu state

    #DL_TC_013
  Scenario: Verify India country record
    When User sends a GET request to the Dropdown List API
    Then Dropdown API should contain India country

    #DL_TC_014
  Scenario: Verify Chennai record
    When User sends a GET request to the Dropdown List API
    Then Dropdown API should contain Chennai record

    #DL_TC_015
  Scenario: Verify total count
    When User sends a GET request to the Dropdown List API
    Then Dropdown API total should be 4

    #DL_TC_016
  Scenario: Verify skip value
    When User sends a GET request to the Dropdown List API
    Then Dropdown API skip should be 0

    #DL_TC_017
  Scenario: Verify take value
    When User sends a GET request to the Dropdown List API
    Then Dropdown API take should be 9

    #DL_TC_018
  Scenario: Verify createdAt and updatedAt fields
    When User sends a GET request to the Dropdown List API
    Then Dropdown API records should contain valid date fields

    #DL_TC_019
  Scenario: Verify Error value
    When User sends a GET request to the Dropdown List API
    Then Dropdown API Error should be 0

    #DL_TC_020
  Scenario: Verify Exception value
    When User sends a GET request to the Dropdown List API
    Then Dropdown API Exception should be null