Feature: Customer Details API

  Background:
    Given Customer Details API is available

  @CD_GET_001
  Scenario: Verify customer details with valid Customer ID
    When I send GET request for customer ID "1"
    Then response status code should be 200
    And response Content-Type should be "application/json"
    And customer details should be returned

  @CD_GET_002
  Scenario: Verify Customer ID
    When I send GET request for customer ID "1"
    Then response status code should be 200
    And response field "id" should be present

  @CD_GET_003
  Scenario: Verify Customer Shop Name
    When I send GET request for customer ID "1"
    Then response field "customer_shop_name" should be present

  @CD_GET_004
  Scenario: Verify Customer Code Number
    When I send GET request for customer ID "1"
    Then response field "code_no" should be present

  @CD_GET_005
  Scenario: Verify Customer Nick Name
    When I send GET request for customer ID "1"
    Then response field "nick_name" should be present

  @CD_GET_006
  Scenario: Verify Customer Type
    When I send GET request for customer ID "1"
    Then response field "customer_type" should be present

  @CD_GET_007
  Scenario: Verify Customer Gender
    When I send GET request for customer ID "1"
    Then response field "gender" should be present

  @CD_GET_008
  Scenario: Verify Customer Date of Birth
    When I send GET request for customer ID "1"
    Then response field "dob" should be present

  @CD_GET_009
  Scenario: Verify Customer NIC
    When I send GET request for customer ID "1"
    Then response field "nic" should be present

  @CD_GET_010
  Scenario: Verify Permanent Address
    When I send GET request for customer ID "1"
    Then response field "permanent_address" should be present

  @CD_GET_011
  Scenario: Verify Mobile Number
    When I send GET request for customer ID "1"
    Then response field "mobile_no" should be present

  @CD_GET_012
  Scenario: Verify Telephone Number
    When I send GET request for customer ID "1"
    Then response field "telephone_no" should be present

  @CD_GET_013
  Scenario: Verify Customer Email
    When I send GET request for customer ID "1"
    Then response field "email" should be present

  @CD_GET_014
  Scenario: Verify Country
    When I send GET request for customer ID "1"
    Then response field "country" should be present

  @CD_GET_015
  Scenario: Verify State
    When I send GET request for customer ID "1"
    Then response field "state" should be present

  @CD_GET_016
  Scenario: Verify District
    When I send GET request for customer ID "1"
    Then response field "district" should be present

  @CD_GET_017
  Scenario: Verify Join Date
    When I send GET request for customer ID "1"
    Then response field "join_date" should be present

  @CD_GET_018
  Scenario: Verify Sales Representative
    When I send GET request for customer ID "1"
    Then response field "sales_rep" should be present

  @CD_GET_019
  Scenario: Verify Discount Level
    When I send GET request for customer ID "1"
    Then response field "discount_level" should be present

  @CD_GET_020
  Scenario: Verify VAT Number
    When I send GET request for customer ID "1"
    Then response field "vat_no" should be present

  @CD_GET_021
  Scenario: Verify VAT Percentage
    When I send GET request for customer ID "1"
    Then response field "vat_percentage" should be present

  @CD_GET_022
  Scenario: Verify Credit Limit
    When I send GET request for customer ID "1"
    Then response field "credit_limit" should be present

  @CD_GET_023
  Scenario: Verify Due Days
    When I send GET request for customer ID "1"
    Then response field "due_days" should be present

  @CD_GET_024
  Scenario: Verify Current Credit Balance
    When I send GET request for customer ID "1"
    Then response field "current_credit_balance" should be present

  @CD_GET_025
  Scenario: Verify Customer Status
    When I send GET request for customer ID "1"
    Then response field "status" should be present

  @CD_GET_026
  Scenario: Verify non-existing Customer ID
    When I send GET request for customer ID "999999"
    Then response status code should be 404

  @CD_GET_027
  Scenario: Verify Customer ID as zero
    When I send GET request for customer ID "0"
    Then response status code should be 400

  @CD_GET_028
  Scenario: Verify negative Customer ID
    When I send GET request for customer ID "-1"
    Then response status code should be 400

  @CD_GET_029
  Scenario: Verify GET request without Authorization
    When I send GET request for customer ID "1" without authorization
    Then response status code should be 401
    And customer data should not be exposed

  @CD_GET_030
  Scenario: Verify invalid Customer ID format
    When I send GET request for customer ID "ABCD"
    Then response status code should be 400