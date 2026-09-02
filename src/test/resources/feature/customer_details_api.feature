Feature: Customer Details API

  Background:
    Given the Customer Details API is available

  @CD_GET_001
  Scenario: Verify customer details with valid Customer ID
    When I send GET request for customer ID "1" with valid authorization
    Then the response status code should be 200
    And the response should contain customer details

  @CD_GET_002
  Scenario: Verify customer response data
    When I send GET request for customer ID "1" with valid authorization
    Then the response status code should be 200
    And the response should contain customer ID
    And the response should contain customer shop name
    And the response should contain customer code number

  @CD_GET_003
  Scenario: Verify response status code for valid request
    When I send GET request for customer ID "1" with valid authorization
    Then the response status code should be 200

  @CD_GET_004
  Scenario: Verify response Content-Type
    When I send GET request for customer ID "1" with valid authorization
    Then the response Content-Type should be "application/json"

  @CD_GET_005
  Scenario: Verify Customer ID
    When I send GET request for customer ID "1" with valid authorization
    Then the customer ID should be returned correctly

  @CD_GET_006
  Scenario: Verify Customer Shop Name
    When I send GET request for customer ID "1" with valid authorization
    Then the customer shop name should be returned correctly

  @CD_GET_007
  Scenario: Verify Customer Code Number
    When I send GET request for customer ID "1" with valid authorization
    Then the customer code number should be returned correctly

  @CD_GET_008
  Scenario: Verify Customer Nick Name
    When I send GET request for customer ID "1" with valid authorization
    Then the customer nickname should be returned correctly

  @CD_GET_009
  Scenario: Verify Customer Mobile Number
    When I send GET request for customer ID "1" with valid authorization
    Then the customer mobile number should be returned correctly

  @CD_GET_010
  Scenario: Verify Customer Telephone Number
    When I send GET request for customer ID "1" with valid authorization
    Then the customer telephone number should be returned correctly

  @CD_GET_011
  Scenario: Verify Customer Email
    When I send GET request for customer ID "1" with valid authorization
    Then the customer email should be returned correctly

  @CD_GET_012
  Scenario: Verify Customer Gender
    When I send GET request for customer ID "1" with valid authorization
    Then the customer gender should be returned correctly

  @CD_GET_013
  Scenario: Verify Customer Date of Birth
    When I send GET request for customer ID "1" with valid authorization
    Then the customer date of birth should be returned correctly

  @CD_GET_014
  Scenario: Verify Customer NIC
    When I send GET request for customer ID "1" with valid authorization
    Then the customer NIC should be returned correctly

  @CD_GET_015
  Scenario: Verify Permanent Address
    When I send GET request for customer ID "1" with valid authorization
    Then the permanent address should be returned correctly

  @CD_GET_016
  Scenario: Verify District
    When I send GET request for customer ID "1" with valid authorization
    Then the district should be returned correctly

  @CD_GET_017
  Scenario: Verify State
    When I send GET request for customer ID "1" with valid authorization
    Then the state should be returned correctly

  @CD_GET_018
  Scenario: Verify Country
    When I send GET request for customer ID "1" with valid authorization
    Then the country should be returned correctly

  @CD_GET_019
  Scenario: Verify Customer Join Date
    When I send GET request for customer ID "1" with valid authorization
    Then the customer join date should be returned correctly

  @CD_GET_020
  Scenario: Verify VAT Number
    When I send GET request for customer ID "1" with valid authorization
    Then the VAT number should be returned correctly

  @CD_GET_021
  Scenario: Verify VAT Percentage
    When I send GET request for customer ID "1" with valid authorization
    Then the VAT percentage should be returned correctly

  @CD_GET_022
  Scenario: Verify Credit Limit
    When I send GET request for customer ID "1" with valid authorization
    Then the credit limit should be returned correctly

  @CD_GET_023
  Scenario: Verify Due Days
    When I send GET request for customer ID "1" with valid authorization
    Then the due days should be returned correctly

  @CD_GET_024
  Scenario: Verify Current Credit Balance
    When I send GET request for customer ID "1" with valid authorization
    Then the current credit balance should be returned correctly

  @CD_GET_025
  Scenario: Verify Customer Status
    When I send GET request for customer ID "1" with valid authorization
    Then the customer status should be returned correctly

  @CD_GET_026
  Scenario: Verify GET request with non-existing Customer ID
    When I send GET request for customer ID "999999" with valid authorization
    Then the response status code should be 404

  @CD_GET_027
  Scenario: Verify GET request with Customer ID zero
    When I send GET request for customer ID "0" with valid authorization
    Then the response status code should be 400

  @CD_GET_028
  Scenario: Verify GET request with negative Customer ID
    When I send GET request for customer ID "-1" with valid authorization
    Then the response status code should be 400

  @CD_GET_029
  Scenario: Verify GET request without Authorization token
    When I send GET request for customer ID "1" without authorization
    Then the response status code should be 401
    And customer data should not be exposed

  @CD_GET_030
  Scenario: Verify GET request with invalid Customer ID format
    When I send GET request for customer ID "ABCD" with valid authorization
    Then the response status code should be 400