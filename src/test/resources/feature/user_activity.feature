Feature: User Activity API

  Scenario: UA_001 Verify User Activity API returns 200 OK
    Given I have a valid token
    When I send GET request to User Activity API
    Then response status code should be 200

  Scenario: UA_002 Verify Table Menu Name
    Given I have a valid token
    When I send GET request to User Activity API
    Then table menu name should be returned

  Scenario: UA_003 Verify Action
    Given I have a valid token
    When I send GET request to User Activity API
    Then action should be returned

  Scenario: UA_004 Verify Date Time
    Given I have a valid token
    When I send GET request to User Activity API
    Then date time should be returned

  Scenario: UA_005 Verify Shift ID
    Given I have a valid token
    When I send GET request to User Activity API
    Then shift id should be returned

  Scenario: UA_006 Verify User ID
    Given I have a valid token
    When I send GET request to User Activity API
    Then user id should be returned

  Scenario: UA_007 Verify Record ID
    Given I have a valid token
    When I send GET request to User Activity API
    Then record id should be returned

  Scenario: UA_008 Verify Filter by Table Menu
    Given I have a valid token
    When I send GET request with table menu filter
    Then only matching table menu records should be returned

  Scenario: UA_009 Verify Filter by Action
    Given I have a valid token
    When I send GET request with action filter
    Then only matching action records should be returned

  Scenario: UA_010 Verify Filter by User
    Given I have a valid token
    When I send GET request with user filter
    Then only matching user records should be returned

  Scenario: UA_011 Verify Filter by From Date and To Date
    Given I have a valid token
    When I send GET request with date range
    Then only records within date range should be returned

  Scenario: UA_012 Verify Filter by From Time and To Time
    Given I have a valid token
    When I send GET request with time range
    Then only records within time range should be returned

  Scenario: UA_013 Verify Empty Result When No Match
    Given I have a valid token
    When I send GET request with non matching filter
    Then empty list should be returned

  Scenario: UA_014 Verify Request Without Token
    When I send GET request without token
    Then response status code should be 401

  Scenario: UA_015 Verify Invalid Date Format
    Given I have a valid token
    When I send GET request with invalid date
    Then proper error message should be returned
