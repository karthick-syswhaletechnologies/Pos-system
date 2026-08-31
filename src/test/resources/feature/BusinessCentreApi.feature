@API
Feature: Business Centre API

  Scenario: Validate Business Centre GET API

    # BC_TC_001 - Validate Business Centre GET API
    When User sends GET request for business centre

    # BC_TC_002 - Validate Response Body
    Then business centre response body should not be empty

    # BC_TC_003 - Validate JSON Response
    Then business centre response should be valid JSON

    # BC_TC_004 - Validate Business Centre Records
    Then business centre records should be returned

    # BC_TC_005 - Validate Business Centre ID
    Then business centre ID should be available

    # BC_TC_006 - Validate Business Centre Name
    Then business centre name should be available

    # BC_TC_007 - Validate Address
    Then address should be available

    # BC_TC_008 - Validate Location
    Then location should be available

    # BC_TC_009 - Validate State
    Then state should be available

    # BC_TC_010 - Validate Country
    Then country should be available

    # BC_TC_011 - Validate Postal Code
    Then postal code should be available

    # BC_TC_012 - Validate Contact
    Then contact should be available

    # BC_TC_013 - Validate Email
    Then email should be available

    # BC_TC_014 - Validate Status
    Then status should be returned

    # BC_TC_015 - Validate Created Date
    Then created date should be available

    # BC_TC_016 - Validate Updated Date
    Then updated date should be available

    # BC_TC_017 - Validate Mandatory Fields
    Then mandatory fields should not be empty

    # BC_TC_019 - Validate Duplicate Business IDs
    Then duplicate business IDs should not exist

    # BC_TC_025 - Validate Response Time
    Then response time should be within 2 seconds

    # BC_TC_026 - Validate Response Content Type
    Then response content type should be JSON

    # BC_TC_031 - Validate Response Headers
    Then response headers should be available

    # BC_TC_032 - Validate Large Number of Business Records
    Then large number of business records should be returned

    # BC_TC_034 - Validate Business Centre Data
    Then business centre data should be retrieved successfully


  # BC_TC_020
  Scenario: Validate Business Centre API without authorization

    When User sends GET request for business centre without authorization
    Then business centre response status should be 401


  # BC_TC_021
  Scenario: Validate Business Centre API with invalid token

    When User sends GET request for business centre with invalid token
    Then business centre response status should be 401 for invalid token


  # BC_TC_022
  Scenario: Validate Business Centre API with expired token

    When User sends GET request for business centre with expired token
    Then business centre response status should be 401 for expired token


  # BC_TC_023
  Scenario: Validate Invalid Business Centre Endpoint

    When User sends GET request to invalid business centre endpoint
    Then business centre response status should be 404


  # BC_TC_024
  Scenario: Validate Unsupported Method

    When User sends POST request to business centre getall endpoint
    Then business centre response status should be rejected