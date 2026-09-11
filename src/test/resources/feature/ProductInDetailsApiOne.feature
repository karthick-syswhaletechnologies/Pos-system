@API
Feature: Product In Details API

  # PI_TC_001
  Scenario: Verify Product In Details GET API returns successful response
    When User sends a GET request to the Product In Details API
    Then Product In Details API response status should be 200

  # PI_TC_002
  Scenario: Verify Product In Details API response body is not empty
    When User sends a GET request to the Product In Details API
    Then Product In Details API response body should not be empty

  # PI_TC_003
  Scenario: Verify Product In Details list is returned
    When User sends a GET request to the Product In Details API
    Then Product In Details list should be returned

  # PI_TC_004
  Scenario: Verify Product ID is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details records should contain Product ID

  # PI_TC_005
  Scenario: Verify Category is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details records should contain Category

  # PI_TC_006
  Scenario: Verify Sub Category is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details records should contain Sub Category

  # PI_TC_007
  Scenario: Verify Product Code is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details records should contain Product Code

  # PI_TC_008
  Scenario: Verify Product Name is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details records should contain Product Name

  # PI_TC_009
  Scenario: Verify Brand is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details records should contain Brand

  # PI_TC_010
  Scenario: Verify Supplier is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details records should contain Supplier

  # PI_TC_011
  Scenario: Verify In Quantity is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details records should contain In Quantity

  # PI_TC_012
  Scenario: Verify Unit is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details records should contain Unit

  # PI_TC_013
  Scenario: Verify Available Quantity is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details records should contain Available Quantity

  # PI_TC_014
  Scenario: Verify In Date is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details records should contain In Date

  # PI_TC_015
  Scenario: Verify Expire Date is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details records should contain Expire Date

  # PI_TC_016
  Scenario: Verify Product In Details can be filtered using valid search criteria
    When User sends a GET request to the Product In Details API with search criteria
    Then Product In Details matching records should be returned

  # PI_TC_017
  Scenario: Verify filtering by Category returns correct records
    When User sends a GET request to the Product In Details API with Category filter
    Then Product In Details should return matching Category records

  # PI_TC_018
  Scenario: Verify filtering by Supplier returns correct records
    When User sends a GET request to the Product In Details API with Supplier filter
    Then Product In Details should return matching Supplier records

  # PI_TC_019
  Scenario: Verify filtering by Arrival Date works correctly
    When User sends a GET request to the Product In Details API with Arrival Date filter
    Then Product In Details should return records within Arrival Date range

  # PI_TC_020
  Scenario: Verify filtering by Expiry Date works correctly
    When User sends a GET request to the Product In Details API with Expiry Date filter
    Then Product In Details should return records within Expiry Date range

  # PI_TC_021
  Scenario: Verify Product In Details API with valid JWT token
    When User sends a GET request to the Product In Details API with valid token
    Then Product In Details API should authorize the request

  # PI_TC_022
  Scenario: Verify Product In Details API rejects invalid token
    When User sends a GET request to the Product In Details API with invalid token
    Then Product In Details API should return authorization error

  # PI_TC_023
  Scenario: Verify Product In Details API without authorization token
    When User sends a GET request to the Product In Details API without token
    Then Product In Details API should reject the request

  # PI_TC_024
  Scenario: Verify Product In Details API response is valid JSON
    When User sends a GET request to the Product In Details API
    Then Product In Details API response content type should be application/json

  # PI_TC_025
  Scenario: Verify invalid Product In Details endpoint is handled
    When User sends a GET request to an invalid Product In Details endpoint
    Then Product In Details API should return 404