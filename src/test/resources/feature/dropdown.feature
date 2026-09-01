Feature: Dropdown API

  Background:
    Given I have a valid authorization token

  @FTC001
  Scenario: FTC-001 Verify Dropdown API returns 200 OK
    When I send GET request to Dropdown API
    Then Dropdown response status code should be 200

  @FTC002
  Scenario: FTC-002 Verify API accepts valid authorization token
    When I send GET request to Dropdown API
    Then Dropdown response should be successfully received

  @FTC003
  Scenario: FTC-003 Verify IsSuccess field
    When I send GET request to Dropdown API
    Then IsSuccess should be true

  @FTC004
  Scenario: FTC-004 Verify Value field is returned
    When I send GET request to Dropdown API
    Then Value field should be present

  @FTC005
  Scenario: FTC-005 Verify id is returned for each dropdown record
    When I send GET request to Dropdown API
    Then every dropdown record should contain a valid id

  @FTC006
  Scenario: FTC-006 Verify dropdown_type is returned
    When I send GET request to Dropdown API
    Then every dropdown record should contain dropdown_type

  @FTC007
  Scenario: FTC-007 Verify item_name is returned
    When I send GET request to Dropdown API
    Then every dropdown record should contain item_name

  @FTC008
  Scenario: FTC-008 Verify filter_by is returned
    When I send GET request to Dropdown API
    Then filter_by field should be available in every dropdown record

  @FTC009
  Scenario: FTC-009 Verify different dropdown types are returned
    When I send GET request to Dropdown API
    Then response should contain configured dropdown types

  @FTC010
  Scenario: FTC-010 Verify pagination using skip and take
    When I send GET request to Dropdown API with skip 0 and take 1000
    Then response should contain records according to pagination

  @FTC011
  Scenario: FTC-011 Verify skip parameter
    When I send GET request to Dropdown API with skip 1 and take 1000
    Then API should process the skip parameter successfully

  @FTC012
  Scenario: FTC-012 Verify take parameter
    When I send GET request to Dropdown API with skip 0 and take 2
    Then response should not contain more than 2 records

  @FTC013
  Scenario: FTC-013 Verify createdAt and updatedAt fields
    When I send GET request to Dropdown API
    Then every dropdown record should contain valid date fields

  @FTC014
  Scenario: FTC-014 Verify API rejects invalid authorization
    When I send GET request to Dropdown API with invalid token
    Then response status code should be a 4xx status

  @FTC015
  Scenario: FTC-015 Verify API handles invalid pagination
    When I send GET request to Dropdown API with invalid pagination
    Then response should return a client error
