@API
Feature: User API

  Scenario: Validate User API - 24 Test Cases

    # US_GET_TC-001
    When User sends user API GET request
    Then user API status should be 200

    # US_GET_TC-002
    When User sends user API request for response body
    Then user API response body should not be empty

    # US_GET_TC-003
    When User sends user API request for user list
    Then user API records should be returned

    # US_GET_TC-004
    When User sends user API request to verify user ID
    Then user API user ID should be available

    # US_GET_TC-005
    When User sends user API request to verify user name
    Then user API user name should be available

    # US_GET_TC-006
    When User sends user API request to verify staff ID
    Then user API staff ID should be available

    # US_GET_TC-007
    When User sends user API request to verify staff role
    Then user API staff role should be available

    # US_GET_TC-008
    When User sends user API request to verify status
    Then user API status should be available

    # US_GET_TC-009
    When User sends user API request to verify role
    Then user API role should be available

    # US_GET_TC-010
    When User sends user API request with user name search
    Then user API matching user records should be returned

    # US_GET_TC-011
    When User sends user API request with staff ID search
    Then user API matching staff record should be returned

    # US_GET_TC-012
    When User sends user API request with invalid search
    Then user API invalid search result should be empty

    # US_GET_TC-013
    When User sends user API request with role filter
    Then user API role filtered records should be returned

    # US_GET_TC-014
    When User sends user API request with status filter
    Then user API status filtered records should be returned

    # US_GET_TC-015
    When User sends user API request with alphabet filter
    Then user API alphabet filtered records should be returned

    # US_GET_TC-016
    When User sends user API request to verify mandatory fields
    Then user API mandatory fields should not be empty

    # US_GET_TC-017
    When User sends user API request to verify JSON response
    Then user API response should be valid JSON

    # US_GET_TC-018
    When User sends user API request to verify content type
    Then user API content type should be JSON

    # US_GET_TC-019
    When User sends user API request to check response time
    Then user API response time should be acceptable

    # US_GET_TC-020
    When User sends user API request without authorization
    Then user API unauthorized status should be 401

    # US_GET_TC-021
    When User sends user API request with invalid token
    Then user API invalid token status should be 401

    # US_GET_TC-022
    When User sends user API request to verify active and inactive users
    Then user API active and inactive users should be handled

    # US_GET_TC-023
    When User sends user API request to verify record count
    Then user API record count should be valid

    # US_GET_TC-024
    When User sends user API request to verify data integrity
    Then user API data should be accurate