@API
Feature: Organization API

  # TC-001
  Scenario: Validate Get Organization API
    When User sends GET request for organization API
    Then organization API status should be 200

  # TC-002
  Scenario: Validate Response Body
    When User sends GET request for organization response body
    Then organization response body should not be empty

  # TC-003
  Scenario: Validate Organization List
    When User sends GET request for organization list
    Then organization records should be returned

  # TC-004
  Scenario: Validate Organization ID
    When User sends GET request to verify organization IDs
    Then organization ID should be available

  # TC-005
  Scenario: Validate Organization Name
    When User sends GET request to verify organization names
    Then organization name should be available

  # TC-006
  Scenario: Validate Registration Number
    When User sends GET request to verify registration numbers
    Then registration number should be available

  # TC-007
  Scenario: Validate TIN Number
    When User sends GET request to verify TIN numbers
    Then TIN number should be available

  # TC-008
  Scenario: Validate Organization Address
    When User sends GET request to verify organization addresses
    Then organization address should be available

  # TC-009
  Scenario: Validate Organization Location
    When User sends GET request to verify organization locations
    Then organization location should be available

  # TC-010
  Scenario: Validate Organization District
    When User sends GET request to verify organization districts
    Then organization district should be available

  # TC-011
  Scenario: Validate Organization State
    When User sends GET request to verify organization states
    Then organization state should be available

  # TC-012
  Scenario: Validate Organization Country
    When User sends GET request to verify organization countries
    Then organization country should be available

  # TC-013
  Scenario: Validate Organization Contact
    When User sends GET request to verify organization contacts
    Then organization contact should be available

  # TC-014
  Scenario: Validate Organization Postal Code
    When User sends GET request to verify organization postal codes
    Then organization postal code should be available

  # TC-015
  Scenario: Validate Organization Status
    When User sends GET request to verify organization status
    Then organization status should be boolean

  # TC-016
  Scenario: Validate Get Organization With ID
    When User sends GET request using organization ID
    Then matching organization should be returned

  # TC-017
  Scenario: Validate Get Organization With Name
    When User sends GET request with organization name
    Then organization name matching record should be returned

  # TC-018
  Scenario: Validate Get Organization With State
    When User sends GET request with state
    Then organization state matching record should be returned

  # TC-019
  Scenario: Validate Get Organization With District
    When User sends GET request with district
    Then organization district matching record should be returned

  # TC-020
  Scenario: Validate Get Organization With Status
    When User sends GET request with organization status
    Then active organization should be returned

  # TC-021
  Scenario: Validate Invalid Organization ID
    When User sends GET request with invalid organization ID
    Then empty organization response should be returned

  # TC-022
  Scenario: Validate Empty Organization Data
    When User sends GET request with non existing organization name
    Then empty response should be returned

  # TC-023
  Scenario: Validate Organization Pagination
    When User sends GET request with skip parameter
    Then organization records should start from sixth record

  # TC-024
  Scenario: Validate Organization Page Size
    When User sends GET request with take parameter
    Then maximum 10 organization records should be returned

  # TC-025
  Scenario: Validate Organization Response Time
    When User sends GET request to check organization response time
    Then organization response time should be within acceptable limit

  # TC-026
  Scenario: Validate Organization JSON Format
    When User sends GET request to verify organization JSON format
    Then organization response should be valid JSON

  # TC-027
  Scenario: Validate Organization Data Type
    When User sends GET request to verify organization data type
    Then organization ID should be integer

  # TC-028
  Scenario: Validate Duplicate Organizations
    When User sends GET request to verify duplicate organizations
    Then duplicate organization records should not exist

  # TC-029
  Scenario: Validate Organization Without Authorization
    When User sends GET request for organization without authorization
    Then organization response status should be 401

  # TC-030
  Scenario: Validate Organization With Invalid Token
    When User sends GET request for organization with invalid token
    Then organization response should be unauthorized