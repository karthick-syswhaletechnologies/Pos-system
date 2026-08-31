Feature: Dropdown List Module

  Background:
    Given I open the Dropdown List page

  @FTC001
  Scenario: FTC-001 Verify Item field is mandatory
    When I leave the Item Name field empty
    And I click the Save button
    Then the Item required validation message should be displayed

  @FTC002
  Scenario: FTC-002 Verify duplicate item validation
    When I enter an existing item name
    And I click the Save button
    Then the duplicate item validation message should be displayed

  @FTC003
  Scenario: FTC-003 Verify Item field maximum length validation
    When I enter more than the allowed maximum characters in Item Name
    Then the Item Name field should not accept more than the maximum allowed characters

  @FTC004
  Scenario: FTC-004 Verify edit functionality
    When I click the Edit icon for a record
    And I update the Item Name
    And I click the Save button
    Then the record should be updated successfully

  @FTC005
  Scenario: FTC-005 Verify delete functionality
    When I click the Delete icon for a record
    And I confirm the deletion
    Then the record should be deleted successfully

  @FTC006
  Scenario: FTC-006 Verify delete confirmation popup
    When I click the Delete icon for a record
    Then the delete confirmation popup should be displayed

  @FTC007
  Scenario: FTC-007 Verify view functionality
    When I click the View icon for a record
    Then the record details should be displayed in read-only mode

  @FTC008
  Scenario: FTC-008 Verify reset functionality
    When I enter values in the form
    And I click the Reset button
    Then all entered values should be cleared

  @FTC009
  Scenario: FTC-009 Verify records are displayed in grid
    When I select a Dropdown Type
    Then the available records should be displayed in the grid

  @FTC010
  Scenario: FTC-010 Verify pagination
    When I select a Dropdown Type
    And I scroll to the bottom of the page
    Then pagination should be displayed

  @FTC011
  Scenario: FTC-011 Verify Dropdown Type selection
    When I click the Dropdown Type field
    And I select a Dropdown Type value
    Then the selected value should be displayed in the Dropdown Type field

  @FTC012
  Scenario: FTC-012 Verify Filter By selection
    When I select a Dropdown Type
    And I click the Filter By field
    And I select a Filter By value
    Then the selected value should be displayed in the Filter By field

  @FTC013
  Scenario: FTC-013 Verify Item field accepts valid input
    When I enter a valid item name
    Then the Item Name field should accept the entered value

  @FTC014
  Scenario: FTC-014 Verify Edit icon visibility
    When I select a Dropdown Type
    Then the Edit icon should be displayed for every record

  @FTC015
  Scenario: FTC-015 Verify View option visibility
    When I select a Dropdown Type
    Then the View option should be displayed for every record
