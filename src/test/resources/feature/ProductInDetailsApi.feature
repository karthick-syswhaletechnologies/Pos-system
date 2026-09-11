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
    Then Product In Details API should return product details list

  # PI_TC_004
  Scenario: Verify Product ID is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details API records should contain Product ID

  # PI_TC_005
  Scenario: Verify Category is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details API records should contain Category

  # PI_TC_006
  Scenario: Verify Sub Category is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details API records should contain Sub Category

  # PI_TC_007
  Scenario: Verify Product Code is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details API records should contain Product Code

  # PI_TC_008
  Scenario: Verify Product Name is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details API records should contain Product Name

  # PI_TC_009
  Scenario: Verify Brand is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details API records should contain Brand

  # PI_TC_010
  Scenario: Verify In Quantity is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details API records should contain In Quantity

  # PI_TC_011
  Scenario: Verify Unit is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details API records should contain Unit

  # PI_TC_012
  Scenario: Verify Available Quantity is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details API records should contain Available Quantity

  # PI_TC_013
  Scenario: Verify In Date is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details API records should contain In Date

  # PI_TC_014
  Scenario: Verify Expire Date is returned correctly
    When User sends a GET request to the Product In Details API
    Then Product In Details API records should contain Expire Date

  # PI_TC_015
  Scenario: Verify Supplier details are returned
    When User sends a GET request to the Product In Details API
    Then Product In Details API records should contain Supplier

  # PI_TC_016
  Scenario: Verify Product In Details API with valid JWT token
    When User sends a GET request to the Product In Details API with valid token
    Then Product In Details API should authorize the request

  # PI_TC_017
  Scenario: Verify Product In Details API rejects invalid token
    When User sends a GET request to the Product In Details API with invalid token
    Then Product In Details API should return authorization error

  # PI_TC_018
  Scenario: Verify Product In Details API without authorization token
    When User sends a GET request to the Product In Details API without token
    Then Product In Details API should reject the request

  # PI_TC_019
  Scenario: Verify Product In Details API handles empty data
    When User sends a GET request to the Product In Details API
    Then Product In Details API should handle empty data without server error

  # PI_TC_020
  Scenario: Verify Product In Details API response is valid JSON
    When User sends a GET request to the Product In Details API
    Then Product In Details API response content type should be application/json

  # PI_TC_021
  Scenario: Verify Product In Details API response status code
    When User sends a GET request to the Product In Details API
    Then Product In Details API response status code should be valid

  # PI_TC_022
  Scenario: Verify Product In Details API response headers
    When User sends a GET request to the Product In Details API
    Then Product In Details API response headers should be present

  # PI_TC_023
  Scenario: Verify Product In Details API response time
    When User sends a GET request to the Product In Details API
    Then Product In Details API response time should be acceptable

  # PI_TC_024
  Scenario: Verify invalid Product In Details endpoint
    When User sends a GET request to an invalid Product In Details endpoint
    Then Product In Details API should return 404

  # PI_TC_025
  Scenario: Verify Product In Details API does not return server error
    When User sends a GET request to the Product In Details API
    Then Product In Details API should not return 500