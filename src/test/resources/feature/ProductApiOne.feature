@API
Feature: Product API

  Scenario: PD_TC_001 - Verify GET Product API returns successful response
    When User sends a GET request to the Product API
    Then Product API response status should be 200

  Scenario: PD_TC_002 - Verify Product API response body is not empty
    When User sends a GET request to the Product API
    Then Product API response body should not be empty

  Scenario: PD_TC_003 - Verify Product list is returned
    When User sends a GET request to the Product API
    Then Product records should be returned

  Scenario: PD_TC_004 - Verify Product ID is returned
    When User sends a GET request to the Product API
    Then Product ID should be available in the response

  Scenario: PD_TC_005 - Verify Product Name is returned
    When User sends a GET request to the Product API
    Then Product Name should be available in the response

  Scenario: PD_TC_006 - Verify Product Code is returned
    When User sends a GET request to the Product API
    Then Product Code should be available in the response

  Scenario: PD_TC_007 - Verify Category is returned
    When User sends a GET request to the Product API
    Then Category should be available in the response

  Scenario: PD_TC_008 - Verify Sub Category is returned
    When User sends a GET request to the Product API
    Then Sub Category should be available in the response

  Scenario: PD_TC_009 - Verify Brand is returned
    When User sends a GET request to the Product API
    Then Brand should be available in the response

  Scenario: PD_TC_010 - Verify Unit is returned
    When User sends a GET request to the Product API
    Then Unit should be available in the response

  Scenario: PD_TC_011 - Verify Minimum Stock is returned
    When User sends a GET request to the Product API
    Then Minimum Stock should be available in the response

  Scenario: PD_TC_012 - Verify Product API response status code
    When User sends a GET request to the Product API
    Then Product API response status should be 200

  Scenario: PD_TC_013 - Verify Product API response is JSON
    When User sends a GET request to the Product API
    Then Product API response content type should be application/json

  Scenario: PD_TC_014 - Verify Product API with valid JWT token
    When User sends a GET request to the Product API with valid token
    Then Product API response status should be 200

  Scenario: PD_TC_015 - Verify Product API rejects invalid token
    When User sends a GET request to the Product API with invalid token
    Then Product API response status should be 401

  Scenario: PD_TC_016 - Verify Product API without authorization token
    When User sends a GET request to the Product API without token
    Then Product API response status should be 401

  Scenario: PD_TC_017 - Verify Product API handles empty Product data
    When User sends a GET request to the Product API
    Then Product API should handle empty Product data

  Scenario: PD_TC_018 - Verify Product API response time
    When User sends a GET request to the Product API
    Then Product API response time should be less than 2000 milliseconds

  Scenario: PD_TC_019 - Verify Product API does not return 500
    When User sends a GET request to the Product API
    Then Product API should not return 500 Internal Server Error

  Scenario: PD_TC_020 - Verify invalid Product endpoint
    When User sends a GET request to an invalid Product API endpoint
    Then Product API response status should be 404