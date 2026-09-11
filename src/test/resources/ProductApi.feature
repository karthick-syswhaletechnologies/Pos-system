@API
Feature: Product API GET Automation

  #PD_TC_001
  Scenario: Verify GET Product API returns 200
    When User sends a GET request to the Product API
    Then the response status code should be 200

  #PD_TC_002
  Scenario: Verify Product API response body is not empty
    When User sends a GET request to the Product API
    Then the response body should not be empty

  #PD_TC_003
  Scenario: Verify product records are returned
    When User sends a GET request to the Product API
    Then product records should be returned

  #PD_TC_004
  Scenario: Verify Product ID is available
    When User sends a GET request to the Product API
    Then Product ID should be available in the response

  #PD_TC_005
  Scenario: Verify Product Name is available
    When User sends a GET request to the Product API
    Then Product Name should be available in the response

  #PD_TC_006
  Scenario: Verify Product Code is available
    When User sends a GET request to the Product API
    Then Product Code should be available in the response

  #PD_TC_007
  Scenario: Verify Category is available
    When User sends a GET request to the Product API
    Then Category should be available in the response

  #PD_TC_008
  Scenario: Verify Sub Category is available
    When User sends a GET request to the Product API
    Then Sub Category should be available in the response

  #PD_TC_009
  Scenario: Verify Brand is available
    When User sends a GET request to the Product API
    Then Brand should be available in the response

  #PD_TC_010
  Scenario: Verify Product Status is available
    When User sends a GET request to the Product API
    Then Product Status should be available in the response

  #PD_TC_011
  Scenario: Verify product search with valid value
    When User sends a GET request with a valid product search value
    Then matching product records should be returned

  #PD_TC_012
  Scenario: Verify product search with invalid value
    When User sends a GET request with a non-existing product value
    Then empty product result should be returned

  #PD_TC_013
  Scenario: Verify Product API without authorization
    When User sends a GET request without authorization
    Then the response status code should be 401

  #PD_TC_014
  Scenario: Verify Product API with invalid token
    When User sends a GET request with an invalid authorization token
    Then the response status code should be 401

  #PD_TC_015
  Scenario: Verify Product API returns valid JSON
    When User sends a GET request to the Product API
    Then the response should be in valid JSON format

  #PD_TC_016
  Scenario: Verify Product API response content type
    When User sends a GET request to the Product API
    Then the response content type should be application/json

  #PD_TC_017
  Scenario: Verify Product API response time
    When User sends a GET request to the Product API
    Then the response time should be less than 2 seconds

  #PD_TC_018
  Scenario: Verify duplicate Product IDs do not exist
    When User sends a GET request to the Product API
    Then duplicate Product IDs should not exist

  #PD_TC_019
  Scenario: Verify Product ID data type
    When User sends a GET request to the Product API
    Then Product ID should have the expected data type

  #PD_TC_020
  Scenario: Verify Product API record count
    When User sends a GET request to the Product API
    Then the returned product record count should be valid