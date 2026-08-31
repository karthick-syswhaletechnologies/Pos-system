@API
#Staff Details-02
Feature: Staff API

  Scenario: Validate Staff API - 29 Test Cases

    # SD_TC-001
    When User sends staff API GET request
    Then staff API status should be 200

    # SD_TC-002
    When User sends staff API request for response body
    Then staff API response body should not be empty

    # SD_TC-003
    When User sends staff API request for staff list
    Then staff API records should be returned

    # SD_TC-004
    When User sends staff API request to verify IDs
    Then staff API ID should be available

    # SD_TC-005
    When User sends staff API request to verify names
    Then staff API name should be available

    # SD_TC-006
    When User sends staff API request to verify store names
    Then staff API store name should be available

    # SD_TC-007
    When User sends staff API request to verify emails
    Then staff API email should be available

    # SD_TC-008
    When User sends staff API request to verify mobile numbers
    Then staff API mobile number should be available

    # SD_TC-009
    When User sends staff API request to verify roles
    Then staff API role should be available

    # SD_TC-010
    When User sends staff API request to verify status
    Then staff API status should be available

    # SD_TC-011
    When User sends staff API request with valid search
    Then staff API matching records should be returned

    # SD_TC-012
    When User sends staff API request with invalid search
    Then staff API search result should be empty

    # SD_TC-013
    When User sends staff API request using staff ID
    Then staff API matching record should be returned

    # SD_TC-014
    When User sends staff API request with pagination
    Then staff API page data should be returned

    # SD_TC-015
    When User sends staff API request without authorization
    Then staff API status should be 401

    # SD_TC-016
    When User sends staff API request with invalid token
    Then staff API invalid token status should be 401

    # SD_TC-017
    When User sends staff API request with expired token
    Then staff API expired token should be unauthorized

    # SD_TC-018
    When User sends staff API request to verify content type
    Then staff API content type should be JSON

    # SD_TC-019
    When User sends staff API request to check response time
    Then staff API response time should be within 2 seconds

    # SD_TC-020
    When User sends staff API request to verify mandatory fields
    Then staff API mandatory fields should not be empty

    # SD_TC-021
    When User sends staff API request to verify duplicate records
    Then staff API duplicate IDs should not exist

    # SD_TC-022
    When User sends staff API request when no records exist
    Then staff API response should contain empty data

    # SD_TC-023
    When User sends staff API request to verify data types
    Then staff API field data types should be valid

    # SD_TC-024
    When User sends staff API request to verify record count
    Then staff API record count should be valid

    # SD_TC-025
    When User sends repeated staff API GET requests
    Then staff API response should be consistent

    # SD_TC-026
    When User sends staff API request to verify JSON format
    Then staff API response should be valid JSON

    # SD_TC-027
    When User sends staff API request to verify GET method
    Then staff API GET method should be supported

    # SD_TC-028
    When User sends staff API request with special characters
    Then staff API should handle special characters

    # SD_TC-029
    When User sends staff API request with long search input
    Then staff API should return a valid response