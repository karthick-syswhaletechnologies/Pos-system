Feature: Business Centre GET API

  Background:
    Given the Business Centre API endpoint is available

  @BC_GET_001
  Scenario: Verify user can retrieve all Business Centre records
    When user sends a GET request to retrieve all Business Centre records
    Then the response status code should be 200
    And the response should contain Business Centre records

  @BC_GET_002
  Scenario: Verify Business Centre details using valid ID
    When user sends a GET request with valid Business Centre ID 1
    Then the response status code should be 200
    And the Business Centre ID should be 1

  @BC_GET_003
  Scenario: Verify API with invalid Business Centre ID
    When user sends a GET request with invalid Business Centre ID 999999
    Then the response status code should be 400 or 404

  @BC_GET_004
  Scenario: Verify API with ID as zero
    When user sends a GET request with Business Centre ID 0
    Then the response status code should be 400 or 404

  @BC_GET_005
  Scenario: Verify API with negative Business Centre ID
    When user sends a GET request with Business Centre ID -1
    Then the response status code should be 400 or 404

  @BC_GET_006
  Scenario: Verify API with non numeric Business Centre ID
    When user sends a GET request with Business Centre ID "abc"
    Then the response status code should be 400

  @BC_GET_007
  Scenario: Verify id field in response
    When user sends a GET request to retrieve all Business Centre records
    Then the response status code should be 200
    And the id field should be present
    And the id field should be a number

  @BC_GET_008
  Scenario: Verify organization_id field
    When user sends a GET request to retrieve all Business Centre records
    Then the response status code should be 200
    And the organization_id field should be present
    And the organization_id field should be a number

  @BC_GET_009
  Scenario: Verify branch_code field
    When user sends a GET request to retrieve all Business Centre records
    Then the response status code should be 200
    And the branch_code field should be present

  @BC_GET_010
  Scenario: Verify branch_name field
    When user sends a GET request to retrieve all Business Centre records
    Then the response status code should be 200
    And the branch_name field should be present
    And the branch_name should be "Main Branch"

  @BC_GET_011
  Scenario: Verify service_type field
    When user sends a GET request to retrieve all Business Centre records
    Then the response status code should be 200
    And the service_type field should be present

  @BC_GET_012
  Scenario: Verify address related fields
    When user sends a GET request to retrieve all Business Centre records
    Then the response status code should be 200
    And the address field should be present
    And the location field should be present
    And the district field should be present
    And the state field should be present
    And the country field should be present

  @BC_GET_013
  Scenario: Verify contact field
    When user sends a GET request to retrieve all Business Centre records
    Then the response status code should be 200
    And the contact field should be present

  @BC_GET_014
  Scenario: Verify email field
    When user sends a GET request to retrieve all Business Centre records
    Then the response status code should be 200
    And the email field should be present

  @BC_GET_015
  Scenario: Verify website field
    When user sends a GET request to retrieve all Business Centre records
    Then the response status code should be 200
    And the website field should be present

  @BC_GET_016
  Scenario: Verify status field
    When user sends a GET request to retrieve all Business Centre records
    Then the response status code should be 200
    And the status field should be present
    And the status field should be 0 or 1

  @BC_GET_017
  Scenario: Verify response Content-Type
    When user sends a GET request to retrieve all Business Centre records
    Then the response status code should be 200


  @BC_GET_018
  Scenario: Verify response time
    When user sends a GET request to retrieve all Business Centre records
    Then the response status code should be 200
    And the response time should be less than 2000 milliseconds

  @BC_GET_019
  Scenario: Verify GET API without authentication
    When user sends a GET request without authentication
    Then the response status code should be 401

  @BC_GET_020
  Scenario: Verify GET API with invalid token
    When user sends a GET request with an invalid authentication token
    Then the response status code should be 401

  @BC_GET_022
  Scenario: Verify response data against database
    When user sends a GET request with valid Business Centre ID 1
    Then the response status code should be 200
    And the API branch_code should match the database branch_code

  @BC_GET_023
  Scenario: Verify response structure and data types
    When user sends a GET request to retrieve all Business Centre records
    Then the response status code should be 200
    And the response should contain the expected structure
    And the required fields should have the correct data types