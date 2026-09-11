@API
# Staff Details-01
Feature: Staff Details API

  Scenario: Validate Staff Details GET API

    # SD_TC-001 - Validate GET Staff API
    When User sends GET request for staff details
    Then staff response status should be 200

    # SD_TC-002 - Validate Response Body
    Then staff response body should not be empty

    # SD_TC-003 - Validate Staff List
    Then staff records should be returned

    # SD_TC-004 - Validate Staff ID
    Then staff ID should be available

    # SD_TC-005 - Validate Staff Name
    Then staff name should be available

    # SD_TC-006 - Validate Email
    Then staff email should be available

    # SD_TC-007 - Validate Mobile Number
    Then staff mobile number should be available

    # SD_TC-008 - Validate Gender
    Then staff gender should be available

    # SD_TC-009 - Validate Date of Birth
    Then staff date of birth should be available

    # SD_TC-010 - Validate NIC
    Then staff NIC should be available

    # SD_TC-011 - Validate Role
    Then staff role should be available

    # SD_TC-012 - Validate Department
    Then staff department should be available

    # SD_TC-013 - Validate Address
    Then staff address should be available

    # SD_TC-014 - Validate District
    Then staff district should be available

    # SD_TC-015 - Validate Country
    Then staff country should be available

    # SD_TC-016 - Validate Salary Details
    Then staff salary details should be available

    # SD_TC-017 - Validate Commission
    Then staff commission should be available

    # SD_TC-018 - Validate Vehicle Number
    Then staff vehicle number should be available

    # SD_TC-019 - Validate Bank Details
    Then staff bank details should be available

    # SD_TC-020 - Validate Search
    When User sends GET request for staff search
    Then matching staff records should be returned

    # SD_TC-021 - Validate Invalid Search
    When User sends GET request with invalid staff search
    Then empty staff result should be returned

    # SD_TC-022 - Validate Unauthorized Access
    When User sends GET request for staff details without authorization
    Then staff response status should be 401

    # SD_TC-023 - Validate Invalid Token
    When User sends GET request for staff details with invalid token
    Then staff response status should be 401 for invalid token

    # SD_TC-024 - Validate Response Time
    When User sends GET request for staff details
    Then staff response time should be within acceptable limit

    # SD_TC-025 - Validate JSON Response
    Then staff response should be valid JSON