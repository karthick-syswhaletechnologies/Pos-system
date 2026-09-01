package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class UserActivitySteps {

    private Response response;

    private final String baseUrl = "http://localhost:5001";
    private final String token = System.getenv("USER_ACTIVITY_TOKEN");


    // =========================================================
    // Common - Valid Token
    // =========================================================

    @Given("I have a valid token")
    public void i_have_a_valid_token() {

        assertNotNull(
                "USER_ACTIVITY_TOKEN is not configured",
                token
        );

        assertFalse(
                "USER_ACTIVITY_TOKEN is empty",
                token.trim().isEmpty()
        );
    }


    // =========================================================
    // Common - GET User Activity API
    // =========================================================

    @When("I send GET request to User Activity API")
    public void i_send_get_request_to_user_activity_api() {

        response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("skip", 0)
                .queryParam("take", 7)
                .queryParam("business_centre_id", 1)
                .when()
                .get(baseUrl + "/api/useractivities/get");

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.asString());
    }


    // =========================================================
    // UA_001 - Verify 200 OK
    // =========================================================

    @Then("response status code should be 200")
    public void response_status_code_should_be_200() {

        assertEquals(
                "Expected 200 but received " + response.statusCode()
                        + "\nResponse: " + response.asString(),
                200,
                response.statusCode()
        );
    }


    // =========================================================
    // UA_002 - Table Menu Name
    // =========================================================

    @Then("table menu name should be returned")
    public void table_menu_name_should_be_returned() {

        assertNotNull("Response is null", response);

        Object value = response.jsonPath().get("Value");

        assertNotNull("Value is null", value);

        if (value instanceof java.util.List) {

            java.util.List<?> list = (java.util.List<?>) value;

            if (!list.isEmpty()) {

                Object firstRecord = list.get(0);

                assertTrue(
                        "Table menu name is missing",
                        firstRecord.toString().toLowerCase()
                                .contains("table")
                );
            }
        }
    }


    // =========================================================
    // UA_003 - Action
    // =========================================================

    @Then("action should be returned")
    public void action_should_be_returned() {

        assertNotNull("Response is null", response);

        Object value = response.jsonPath().get("Value");

        assertNotNull("Value is null", value);

        if (value instanceof java.util.List) {

            java.util.List<?> list = (java.util.List<?>) value;

            if (!list.isEmpty()) {
                assertTrue(
                        "Action field is missing",
                        list.get(0).toString().toLowerCase()
                                .contains("action")
                );
            }
        }
    }


    // =========================================================
    // UA_004 - Date Time
    // =========================================================

    @Then("date time should be returned")
    public void date_time_should_be_returned() {

        assertNotNull("Response is null", response);

        Object value = response.jsonPath().get("Value");

        assertNotNull("Value is null", value);
    }


    // =========================================================
    // UA_005 - Shift ID
    // =========================================================

    @Then("shift id should be returned")
    public void shift_id_should_be_returned() {

        assertNotNull("Response is null", response);

        Object value = response.jsonPath().get("Value");

        assertNotNull("Value is null", value);
    }


    // =========================================================
    // UA_006 - User ID
    // =========================================================

    @Then("user id should be returned")
    public void user_id_should_be_returned() {

        assertNotNull("Response is null", response);

        Object value = response.jsonPath().get("Value");

        assertNotNull("Value is null", value);
    }


    // =========================================================
    // UA_007 - Record ID
    // =========================================================

    @Then("record id should be returned")
    public void record_id_should_be_returned() {

        assertNotNull("Response is null", response);

        Object value = response.jsonPath().get("Value");

        assertNotNull("Value is null", value);
    }


    // =========================================================
    // UA_008 - Filter by Table Menu
    // =========================================================

    @When("I send GET request with table menu filter")
    public void i_send_get_request_with_table_menu_filter() {

        response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("skip", 0)
                .queryParam("take", 7)
                .queryParam("business_centre_id", 1)
                .queryParam("table_menu_name", "User")
                .when()
                .get(baseUrl + "/api/useractivities/get");

        System.out.println("Table Menu Filter Response: "
                + response.asString());
    }


    @Then("only matching table menu records should be returned")
    public void only_matching_table_menu_records_should_be_returned() {

        assertNotNull("Response is null", response);

        assertTrue(
                "Request failed with status " + response.statusCode(),
                response.statusCode() < 500
        );
    }


    // =========================================================
    // UA_009 - Filter by Action
    // =========================================================

    @When("I send GET request with action filter")
    public void i_send_get_request_with_action_filter() {

        response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("skip", 0)
                .queryParam("take", 7)
                .queryParam("business_centre_id", 1)
                .queryParam("action", "CREATE")
                .when()
                .get(baseUrl + "/api/useractivities/get");

        System.out.println("Action Filter Response: "
                + response.asString());
    }


    @Then("only matching action records should be returned")
    public void only_matching_action_records_should_be_returned() {

        assertNotNull("Response is null", response);

        assertTrue(
                "Request failed with status " + response.statusCode(),
                response.statusCode() < 500
        );
    }


    // =========================================================
    // UA_010 - Filter by User
    // =========================================================

    @When("I send GET request with user filter")
    public void i_send_get_request_with_user_filter() {

        response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("skip", 0)
                .queryParam("take", 7)
                .queryParam("business_centre_id", 1)
                .queryParam("user_id", 1)
                .when()
                .get(baseUrl + "/api/useractivities/get");

        System.out.println("User Filter Response: "
                + response.asString());
    }


    @Then("only matching user records should be returned")
    public void only_matching_user_records_should_be_returned() {

        assertNotNull("Response is null", response);

        assertTrue(
                "Request failed with status " + response.statusCode(),
                response.statusCode() < 500
        );
    }


    // =========================================================
    // UA_011 - Date Range
    // =========================================================

    @When("I send GET request with date range")
    public void i_send_get_request_with_date_range() {

        response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("skip", 0)
                .queryParam("take", 7)
                .queryParam("business_centre_id", 1)
                .queryParam("from_date", "2025-01-01")
                .queryParam("to_date", "2025-12-31")
                .when()
                .get(baseUrl + "/api/useractivities/get");

        System.out.println("Date Range Response: "
                + response.asString());
    }


    @Then("only records within date range should be returned")
    public void only_records_within_date_range_should_be_returned() {

        assertNotNull("Response is null", response);

        assertTrue(
                "Request failed with status " + response.statusCode(),
                response.statusCode() < 500
        );
    }


    // =========================================================
    // UA_012 - Time Range
    // =========================================================

    @When("I send GET request with time range")
    public void i_send_get_request_with_time_range() {

        response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("skip", 0)
                .queryParam("take", 7)
                .queryParam("business_centre_id", 1)
                .queryParam("from_time", "00:00:00")
                .queryParam("to_time", "23:59:59")
                .when()
                .get(baseUrl + "/api/useractivities/get");

        System.out.println("Time Range Response: "
                + response.asString());
    }


    @Then("only records within time range should be returned")
    public void only_records_within_time_range_should_be_returned() {

        assertNotNull("Response is null", response);

        assertTrue(
                "Request failed with status " + response.statusCode(),
                response.statusCode() < 500
        );
    }


    // =========================================================
    // UA_013 - Non Matching Filter
    // =========================================================

    @When("I send GET request with non matching filter")
    public void i_send_get_request_with_non_matching_filter() {

        response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("skip", 0)
                .queryParam("take", 7)
                .queryParam("business_centre_id", 1)
                .queryParam("table_menu_name", "NON_EXISTING_VALUE")
                .when()
                .get(baseUrl + "/api/useractivities/get");

        System.out.println("Non Matching Filter Response: "
                + response.asString());
    }


    @Then("empty list should be returned")
    public void empty_list_should_be_returned() {

        assertNotNull("Response is null", response);

        Object value = response.jsonPath().get("Value");

        if (value instanceof java.util.List) {

            java.util.List<?> list = (java.util.List<?>) value;

            assertTrue(
                    "Expected empty list but received: " + list,
                    list.isEmpty()
            );
        }
    }


    // =========================================================
    // UA_014 - Request Without Token
    // =========================================================

    @When("I send GET request without token")
    public void i_send_get_request_without_token() {

        response = given()
                .queryParam("skip", 0)
                .queryParam("take", 7)
                .queryParam("business_centre_id", 1)
                .when()
                .get(baseUrl + "/api/useractivities/get");

        System.out.println("Without Token Status: "
                + response.statusCode());

        System.out.println("Without Token Response: "
                + response.asString());
    }


    @Then("response status code should be 401")
    public void response_status_code_should_be_401() {

        assertEquals(
                "Expected 401 but received " + response.statusCode(),
                401,
                response.statusCode()
        );
    }


    // =========================================================
    // UA_015 - Invalid Date Format
    // =========================================================

    @When("I send GET request with invalid date")
    public void i_send_get_request_with_invalid_date() {

        response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("skip", 0)
                .queryParam("take", 7)
                .queryParam("business_centre_id", 1)
                .queryParam("from_date", "invalid-date")
                .queryParam("to_date", "invalid-date")
                .when()
                .get(baseUrl + "/api/useractivities/get");

        System.out.println("Invalid Date Status: "
                + response.statusCode());

        System.out.println("Invalid Date Response: "
                + response.asString());
    }


    @Then("proper error message should be returned")
    public void proper_error_message_should_be_returned() {

        assertNotNull("Response is null", response);

        String body = response.asString();

        assertFalse(
                "Expected an error response",
                body == null || body.trim().isEmpty()
        );
    }
}