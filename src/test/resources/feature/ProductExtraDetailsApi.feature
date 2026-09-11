@API
Feature: Product Extra Details API

  # PED_TC_001
  Scenario: Verify Product Extra Details GET API returns successful response
    When User sends a GET request to the Product Extra Details API
    Then Product Extra Details API response status should be 200

  # PED_TC_002
  Scenario: Verify Product Extra Details API response body is not empty
    When User sends a GET request to the Product Extra Details API
    Then Product Extra Details API response body should not be empty

  # PED_TC_003
  Scenario: Verify Product Extra Details list is returned
    When User sends a GET request to the Product Extra Details API
    Then Product Extra Details list should be returned

  # PED_TC_004
  Scenario: Verify Extra Detail ID is returned correctly
    When User sends a GET request to the Product Extra Details API
    Then Product Extra Details records should contain Extra Detail ID

  # PED_TC_005
  Scenario: Verify Product ID is returned correctly
    When User sends a GET request to the Product Extra Details API
    Then Product Extra Details records should contain Product ID

  # PED_TC_006
  Scenario: Verify Label is returned correctly
    When User sends a GET request to the Product Extra Details API
    Then Product Extra Details records should contain Label

  # PED_TC_007
  Scenario: Verify Value is returned correctly
    When User sends a GET request to the Product Extra Details API
    Then Product Extra Details records should contain Value

  # PED_TC_008
  Scenario: Verify Status is returned correctly
    When User sends a GET request to the Product Extra Details API
    Then Product Extra Details records should contain Status

  # PED_TC_009
  Scenario: Verify multiple Extra Details records are returned
    When User sends a GET request to the Product Extra Details API
    Then Product Extra Details should return multiple records

  # PED_TC_010
  Scenario: Verify required fields are present
    When User sends a GET request to the Product Extra Details API
    Then Product Extra Details records should contain required fields

  # PED_TC_011
  Scenario: Verify Product Extra Details search
    When User sends a GET request to the Product Extra Details API with search criteria
    Then Product Extra Details matching records should be returned

  # PED_TC_012
  Scenario: Verify Product filter
    When User sends a GET request to the Product Extra Details API with Product filter
    Then Product Extra Details should return matching Product records

  # PED_TC_013
  Scenario: Verify Label filter
    When User sends a GET request to the Product Extra Details API with Label filter
    Then Product Extra Details should return matching Label records

  # PED_TC_014
  Scenario: Verify Status filter
    When User sends a GET request to the Product Extra Details API with Status filter
    Then Product Extra Details should return matching Status records

  # PED_TC_015
  Scenario: Verify API handles empty data
    When User sends a GET request to the Product Extra Details API
    Then Product Extra Details API should handle empty data without server error

  # PED_TC_016
  Scenario: Verify Product Extra Details API with valid JWT token
    When User sends a GET request to the Product Extra Details API with valid token
    Then Product Extra Details API should authorize the request

  # PED_TC_017
  Scenario: Verify Product Extra Details API rejects invalid token
    When User sends a GET request to the Product Extra Details API with invalid token
    Then Product Extra Details API should return authorization error

  # PED_TC_018
  Scenario: Verify Product Extra Details API without authorization token
    When User sends a GET request to the Product Extra Details API without token
    Then Product Extra Details API should reject the request

  # PED_TC_019
  Scenario: Verify Product Extra Details API response is valid JSON
    When User sends a GET request to the Product Extra Details API
    Then Product Extra Details API response content type should be application/json

  # PED_TC_020
  Scenario: Verify Product Extra Details API response status code
    When User sends a GET request to the Product Extra Details API
    Then Product Extra Details API response status code should be valid

  # PED_TC_021
  Scenario: Verify Product Extra Details API response headers
    When User sends a GET request to the Product Extra Details API
    Then Product Extra Details API response headers should be present

  # PED_TC_022
  Scenario: Verify Product Extra Details API response time
    When User sends a GET request to the Product Extra Details API
    Then Product Extra Details API response time should be acceptable

  # PED_TC_023
  Scenario: Verify Product Extra Details contains valid data
    When User sends a GET request to the Product Extra Details API
    Then Product Extra Details records should contain valid values

  # PED_TC_024
  Scenario: Verify invalid Product Extra Details endpoint
    When User sends a GET request to an invalid Product Extra Details endpoint
    Then Product Extra Details API should return 404

  # PED_TC_025
  Scenario: Verify Product Extra Details API does not return server error
    When User sends a GET request to the Product Extra Details API
    Then Product Extra Details API should not return 500