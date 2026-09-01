package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class DropdownSteps {

    // =========================================================
    // CONFIGURATION
    // =========================================================

    private static final String BASE_URL = "http://localhost:5001";
    private static final String DROPDOWN_ENDPOINT = "/dropdown";

    private String token;
    private Response response;


    // =========================================================
    // BACKGROUND
    // =========================================================

    @Given("I have a valid authorization token")
    public void i_have_a_valid_authorization_token() {

        token = System.getenv("USER_ACTIVITY_TOKEN");

        assertNotNull(
                "Authorization token should not be null",
                token
        );

        assertFalse(
                "Authorization token should not be empty",
                token.trim().isEmpty()
        );
    }


    // =========================================================
    // COMMON GET REQUEST
    // =========================================================

    @When("I send GET request to Dropdown API")
    public void i_send_get_request_to_dropdown_api() {

        response = given()
                .header(
                        "Authorization",
                        "Bearer " + token
                )
                .header(
                        "Accept",
                        "application/json"
                )
                .when()
                .get(BASE_URL + DROPDOWN_ENDPOINT)
                .then()
                .extract()
                .response();

        System.out.println(
                "Dropdown API Status Code: "
                        + response.getStatusCode()
        );

        System.out.println(
                "Dropdown API Response Body: "
                        + response.asString()
        );
    }


    // =========================================================
    // FTC-001
    // Verify Dropdown API returns 200 OK
    // =========================================================

    @Then("Dropdown response status code should be 200")
    public void dropdown_response_status_code_should_be_200() {

        assertNotNull(
                "Dropdown API response should not be null",
                response
        );

        assertEquals(
                "Expected status code 200 but received: "
                        + response.getStatusCode(),
                200,
                response.getStatusCode()
        );
    }


    // =========================================================
    // FTC-002
    // Verify valid authorization
    // =========================================================

    @Then("Dropdown response should be successfully received")
    public void dropdown_response_should_be_successfully_received() {

        assertNotNull(
                "Dropdown API response should not be null",
                response
        );

        int statusCode = response.getStatusCode();

        assertTrue(
                "Expected successful response but received: "
                        + statusCode,
                statusCode >= 200 && statusCode < 300
        );

        assertNotNull(
                "Response body should not be null",
                response.getBody()
        );
    }


    // =========================================================
    // FTC-003
    // Verify IsSuccess
    // =========================================================

    @Then("IsSuccess should be true")
    public void is_success_should_be_true() {

        assertNotNull(
                "Dropdown API response should not be null",
                response
        );

        assertTrue(
                "Response Content-Type should be JSON. Actual: "
                        + response.getContentType(),
                response.getContentType() != null
                        && response.getContentType()
                        .toLowerCase()
                        .contains("json")
        );

        Object isSuccess =
                response.jsonPath().get("IsSuccess");

        assertNotNull(
                "IsSuccess field should be present",
                isSuccess
        );

        String value =
                String.valueOf(isSuccess);

        assertTrue(
                "IsSuccess should be true or 1. Actual: "
                        + value,
                value.equalsIgnoreCase("true")
                        || value.equals("1")
        );
    }


    // =========================================================
    // FTC-004
    // Verify Value field
    // =========================================================

    @Then("Value field should be present")
    public void value_field_should_be_present() {

        assertNotNull(
                "Dropdown API response should not be null",
                response
        );

        Object value =
                response.jsonPath().get("Value");

        assertNotNull(
                "Value field should be present",
                value
        );
    }


    // =========================================================
    // FTC-005
    // Verify id
    // =========================================================

    @Then("every dropdown record should contain a valid id")
    public void every_dropdown_record_should_contain_a_valid_id() {

        List<Map<String, Object>> records =
                getDropdownRecords();

        for (Map<String, Object> record : records) {

            assertTrue(
                    "Each dropdown record should contain id",
                    record.containsKey("id")
            );

            Object id = record.get("id");

            assertNotNull(
                    "id should not be null",
                    id
            );
        }
    }


    // =========================================================
    // FTC-006
    // Verify dropdown_type
    // =========================================================

    @Then("every dropdown record should contain dropdown_type")
    public void every_dropdown_record_should_contain_dropdown_type() {

        List<Map<String, Object>> records =
                getDropdownRecords();

        for (Map<String, Object> record : records) {

            assertTrue(
                    "Each record should contain dropdown_type",
                    record.containsKey("dropdown_type")
            );

            assertNotNull(
                    "dropdown_type should not be null",
                    record.get("dropdown_type")
            );
        }
    }


    // =========================================================
    // FTC-007
    // Verify item_name
    // =========================================================

    @Then("every dropdown record should contain item_name")
    public void every_dropdown_record_should_contain_item_name() {

        List<Map<String, Object>> records =
                getDropdownRecords();

        for (Map<String, Object> record : records) {

            assertTrue(
                    "Each record should contain item_name",
                    record.containsKey("item_name")
            );

            Object itemName =
                    record.get("item_name");

            assertNotNull(
                    "item_name should not be null",
                    itemName
            );

            assertFalse(
                    "item_name should not be empty",
                    itemName.toString().trim().isEmpty()
            );
        }
    }


    // =========================================================
    // FTC-008
    // Verify filter_by
    // =========================================================

    @Then("filter_by field should be available in every dropdown record")
    public void filter_by_field_should_be_available_in_every_dropdown_record() {

        List<Map<String, Object>> records =
                getDropdownRecords();

        for (Map<String, Object> record : records) {

            assertTrue(
                    "Each record should contain filter_by",
                    record.containsKey("filter_by")
            );
        }
    }


    // =========================================================
    // FTC-009
    // Verify dropdown types
    // =========================================================

    @Then("response should contain configured dropdown types")
    public void response_should_contain_configured_dropdown_types() {

        List<Map<String, Object>> records =
                getDropdownRecords();

        assertFalse(
                "Dropdown API should return at least one record",
                records.isEmpty()
        );

        for (Map<String, Object> record : records) {

            assertTrue(
                    "Record should contain dropdown_type",
                    record.containsKey("dropdown_type")
            );

            Object dropdownType =
                    record.get("dropdown_type");

            assertNotNull(
                    "dropdown_type should not be null",
                    dropdownType
            );

            assertFalse(
                    "dropdown_type should not be empty",
                    dropdownType.toString()
                            .trim()
                            .isEmpty()
            );
        }
    }


    // =========================================================
    // FTC-010
    // Verify skip=0 and take=1000
    // =========================================================

    @When("I send GET request to Dropdown API with skip 0 and take 1000")
    public void i_send_get_request_to_dropdown_api_with_skip_0_and_take_1000() {

        response = given()
                .header(
                        "Authorization",
                        "Bearer " + token
                )
                .header(
                        "Accept",
                        "application/json"
                )
                .queryParam("skip", 0)
                .queryParam("take", 1000)
                .when()
                .get(BASE_URL + DROPDOWN_ENDPOINT)
                .then()
                .extract()
                .response();

        System.out.println(
                "FTC-010 Status: "
                        + response.getStatusCode()
        );
    }


    @Then("response should contain records according to pagination")
    public void response_should_contain_records_according_to_pagination() {

        assertNotNull(
                "Dropdown API response should not be null",
                response
        );

        assertTrue(
                "Pagination request should return successful response. Actual: "
                        + response.getStatusCode(),
                response.getStatusCode() >= 200
                        && response.getStatusCode() < 300
        );

        List<Map<String, Object>> records =
                getDropdownRecords();

        assertTrue(
                "Response should not contain more than 1000 records",
                records.size() <= 1000
        );
    }


    // =========================================================
    // FTC-011
    // Verify skip=1
    // =========================================================

    @When("I send GET request to Dropdown API with skip 1 and take 1000")
    public void i_send_get_request_to_dropdown_api_with_skip_1_and_take_1000() {

        response = given()
                .header(
                        "Authorization",
                        "Bearer " + token
                )
                .header(
                        "Accept",
                        "application/json"
                )
                .queryParam("skip", 1)
                .queryParam("take", 1000)
                .when()
                .get(BASE_URL + DROPDOWN_ENDPOINT)
                .then()
                .extract()
                .response();

        System.out.println(
                "FTC-011 Status: "
                        + response.getStatusCode()
        );
    }


    @Then("API should process the skip parameter successfully")
    public void api_should_process_the_skip_parameter_successfully() {

        assertNotNull(
                "Dropdown API response should not be null",
                response
        );

        assertTrue(
                "API should process valid skip parameter. Actual: "
                        + response.getStatusCode(),
                response.getStatusCode() >= 200
                        && response.getStatusCode() < 300
        );
    }


    // =========================================================
    // FTC-012
    // Verify take=2
    // =========================================================

    @When("I send GET request to Dropdown API with skip 0 and take 2")
    public void i_send_get_request_to_dropdown_api_with_skip_0_and_take_2() {

        response = given()
                .header(
                        "Authorization",
                        "Bearer " + token
                )
                .header(
                        "Accept",
                        "application/json"
                )
                .queryParam("skip", 0)
                .queryParam("take", 2)
                .when()
                .get(BASE_URL + DROPDOWN_ENDPOINT)
                .then()
                .extract()
                .response();

        System.out.println(
                "FTC-012 Status: "
                        + response.getStatusCode()
        );
    }


    @Then("response should not contain more than 2 records")
    public void response_should_not_contain_more_than_2_records() {

        assertNotNull(
                "Dropdown API response should not be null",
                response
        );

        assertTrue(
                "Expected successful response. Actual: "
                        + response.getStatusCode(),
                response.getStatusCode() >= 200
                        && response.getStatusCode() < 300
        );

        List<Map<String, Object>> records =
                getDropdownRecords();

        assertTrue(
                "Response should not contain more than 2 records",
                records.size() <= 2
        );
    }


    // =========================================================
    // FTC-013
    // Verify createdAt and updatedAt
    // =========================================================

    @Then("every dropdown record should contain valid date fields")
    public void every_dropdown_record_should_contain_valid_date_fields() {

        List<Map<String, Object>> records =
                getDropdownRecords();

        for (Map<String, Object> record : records) {

            assertTrue(
                    "createdAt field should be present",
                    record.containsKey("createdAt")
                            && record.get("createdAt") != null
            );

            assertTrue(
                    "updatedAt field should be present",
                    record.containsKey("updatedAt")
                            && record.get("updatedAt") != null
            );
        }
    }


    // =========================================================
    // FTC-014
    // Verify invalid authorization
    // =========================================================

    @When("I send GET request to Dropdown API with invalid token")
    public void i_send_get_request_to_dropdown_api_with_invalid_token() {

        response = given()
                .header(
                        "Authorization",
                        "Bearer invalid_token_for_testing"
                )
                .header(
                        "Accept",
                        "application/json"
                )
                .queryParam("skip", 0)
                .queryParam("take", 1000)
                .when()
                .get(BASE_URL + DROPDOWN_ENDPOINT)
                .then()
                .extract()
                .response();

        System.out.println(
                "FTC-014 Status: "
                        + response.getStatusCode()
        );
    }


    @Then("response status code should be a 4xx status")
    public void response_status_code_should_be_a_4xx_status() {

        assertNotNull(
                "Dropdown API response should not be null",
                response
        );

        int statusCode =
                response.getStatusCode();

        assertTrue(
                "Expected 4xx status code but received: "
                        + statusCode,
                statusCode >= 400
                        && statusCode < 500
        );
    }


    // =========================================================
    // FTC-015
    // Verify invalid pagination
    // =========================================================

    @When("I send GET request to Dropdown API with invalid pagination")
    public void i_send_get_request_to_dropdown_api_with_invalid_pagination() {

        response = given()
                .header(
                        "Authorization",
                        "Bearer " + token
                )
                .header(
                        "Accept",
                        "application/json"
                )
                .queryParam("skip", -1)
                .queryParam("take", -1)
                .when()
                .get(BASE_URL + DROPDOWN_ENDPOINT)
                .then()
                .extract()
                .response();

        System.out.println(
                "FTC-015 Status: "
                        + response.getStatusCode()
        );
    }


    @Then("response should return a client error")
    public void response_should_return_a_client_error() {

        assertNotNull(
                "Dropdown API response should not be null",
                response
        );

        int statusCode =
                response.getStatusCode();

        assertTrue(
                "Expected client error 4xx but received: "
                        + statusCode,
                statusCode >= 400
                        && statusCode < 500
        );
    }


    // =========================================================
    // COMMON HELPER METHOD
    // =========================================================

    private List<Map<String, Object>> getDropdownRecords() {

        assertNotNull(
                "Dropdown API response should not be null",
                response
        );

        assertTrue(
                "Expected JSON response. Actual Content-Type: "
                        + response.getContentType(),
                response.getContentType() != null
                        && response.getContentType()
                        .toLowerCase()
                        .contains("json")
        );

        List<Map<String, Object>> records =
                response.jsonPath().getList("Value");

        assertNotNull(
                "Value should contain dropdown records",
                records
        );

        return records;
    }
}
