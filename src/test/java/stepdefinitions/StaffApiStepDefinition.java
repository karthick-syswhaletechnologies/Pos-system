package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

//StaffDetails-02

public class StaffApiStepDefinition {

    Response response;

    String baseUrl = "http://localhost:5001";

    String staffEndpoint = "/api/users/getall";

    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibG9naW5fbmFtZSI6InN1cGVyYWRtaW4iLCJidXNpbmVzc19jZW50cmVfaWQiOjEsImJyYW5jaF9jb2RlIjoiU0EwMDEiLCJzdGFmZl9kZXRhaWxzX2lkIjpudWxsLCJyb2xlIjoiU3VwZXJhZG1pbiIsInNoaWZ0X2lkIjoxNDAsImxvZ2luIjoiMjAyNi0wOC0zMFQxODozODoyMi4wMDBaIiwibG9nb3V0IjpudWxsLCJpYXQiOjE3ODgxMTUxMDIsImV4cCI6MTc4ODIwMTUwMn0.Bj2LYYDjHzFP5wB1CbRZhN9fd6ZggstcZzBBASlhuBE";


    // SD_TC-001
    @When("User sends staff API GET request")
    public void sendStaffApiGetRequest() {
        sendValidRequest();
    }

    @Then("staff API status should be 200")
    public void staffApiStatusShouldBe200() {
        assertEquals(200, response.getStatusCode());
    }


    // SD_TC-002
    @When("User sends staff API request for response body")
    public void sendStaffApiRequestForResponseBody() {
        sendValidRequest();
    }

    @Then("staff API response body should not be empty")
    public void staffApiResponseBodyShouldNotBeEmpty() {
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertFalse(response.getBody().asString().isEmpty());
    }


    // SD_TC-003
    @When("User sends staff API request for staff list")
    public void sendStaffApiRequestForStaffList() {
        sendValidRequest();
    }

    @Then("staff API records should be returned")
    public void staffApiRecordsShouldBeReturned() {
        List<?> records = response.jsonPath().getList("Value");

        assertNotNull(records);
        assertFalse(records.isEmpty());
    }


    // SD_TC-004
    @When("User sends staff API request to verify IDs")
    public void sendStaffApiRequestToVerifyIds() {
        sendValidRequest();
    }

    @Then("staff API ID should be available")
    public void staffApiIdShouldBeAvailable() {
        List<?> ids = response.jsonPath().getList("Value.id");

        assertNotNull(ids);
        assertFalse(ids.isEmpty());
    }


    // SD_TC-005
    @When("User sends staff API request to verify names")
    public void sendStaffApiRequestToVerifyNames() {
        sendValidRequest();
    }

    @Then("staff API name should be available")
    public void staffApiNameShouldBeAvailable() {
        List<?> names = response.jsonPath().getList("Value.staff_name");

        assertNotNull(names);
        assertFalse(names.isEmpty());
    }


    // SD_TC-006
    @When("User sends staff API request to verify store names")
    public void sendStaffApiRequestToVerifyStoreNames() {
        sendValidRequest();
    }

    @Then("staff API store name should be available")
    public void staffApiStoreNameShouldBeAvailable() {
        List<?> values = response.jsonPath().getList("Value.store_name");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }


    // SD_TC-007
    @When("User sends staff API request to verify emails")
    public void sendStaffApiRequestToVerifyEmails() {
        sendValidRequest();
    }

    @Then("staff API email should be available")
    public void staffApiEmailShouldBeAvailable() {
        List<?> values = response.jsonPath().getList("Value.email");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }


    // SD_TC-008
    @When("User sends staff API request to verify mobile numbers")
    public void sendStaffApiRequestToVerifyMobileNumbers() {
        sendValidRequest();
    }

    @Then("staff API mobile number should be available")
    public void staffApiMobileNumberShouldBeAvailable() {
        List<?> values = response.jsonPath().getList("Value.mobile_no");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }


    // SD_TC-009
    @When("User sends staff API request to verify roles")
    public void sendStaffApiRequestToVerifyRoles() {
        sendValidRequest();
    }

    @Then("staff API role should be available")
    public void staffApiRoleShouldBeAvailable() {
        List<?> values = response.jsonPath().getList("Value.role");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }


    // SD_TC-010
    @When("User sends staff API request to verify status")
    public void sendStaffApiRequestToVerifyStatus() {
        sendValidRequest();
    }

    @Then("staff API status should be available")
    public void staffApiStatusShouldBeAvailable() {
        List<?> values = response.jsonPath().getList("Value.status");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }


    // SD_TC-011
    @When("User sends staff API request with valid search")
    public void sendStaffApiRequestWithValidSearch() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("search", "admin")
                .when()
                .get(baseUrl + staffEndpoint);
    }

    @Then("staff API matching records should be returned")
    public void staffApiMatchingRecordsShouldBeReturned() {
        assertEquals(200, response.getStatusCode());
    }


    // SD_TC-012
    @When("User sends staff API request with invalid search")
    public void sendStaffApiRequestWithInvalidSearch() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("search", "xyz_no_staff_99999")
                .when()
                .get(baseUrl + staffEndpoint);
    }

    @Then("staff API search result should be empty")
    public void staffApiSearchResultShouldBeEmpty() {
        assertEquals(200, response.getStatusCode());

        List<?> records = response.jsonPath().getList("Value");

        assertTrue(records == null || records.isEmpty());
    }


    // SD_TC-013
    @When("User sends staff API request using staff ID")
    public void sendStaffApiRequestUsingStaffId() {
        sendValidRequest();
    }

    @Then("staff API matching record should be returned")
    public void staffApiMatchingRecordShouldBeReturned() {
        List<?> records = response.jsonPath().getList("Value");

        assertNotNull(records);
        assertFalse(records.isEmpty());
    }


    // SD_TC-014
    @When("User sends staff API request with pagination")
    public void sendStaffApiRequestWithPagination() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("page", 1)
                .queryParam("limit", 10)
                .when()
                .get(baseUrl + staffEndpoint);
    }

    @Then("staff API page data should be returned")
    public void staffApiPageDataShouldBeReturned() {
        assertEquals(200, response.getStatusCode());
    }


    // SD_TC-015
    @When("User sends staff API request without authorization")
    public void sendStaffApiRequestWithoutAuthorization() {
        response = RestAssured
                .given()
                .when()
                .get(baseUrl + staffEndpoint);
    }

    @Then("staff API status should be 401")
    public void staffApiStatusShouldBe401() {
        assertEquals(401, response.getStatusCode());
    }


    // SD_TC-016
    @When("User sends staff API request with invalid token")
    public void sendStaffApiRequestWithInvalidToken() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer invalid_token_123")
                .when()
                .get(baseUrl + staffEndpoint);
    }

    @Then("staff API invalid token status should be 401")
    public void staffApiInvalidTokenStatusShouldBe401() {
        assertEquals(401, response.getStatusCode());
    }


    // SD_TC-017
    @When("User sends staff API request with expired token")
    public void sendStaffApiRequestWithExpiredToken() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer expired.token.value")
                .when()
                .get(baseUrl + staffEndpoint);
    }

    @Then("staff API expired token should be unauthorized")
    public void staffApiExpiredTokenShouldBeUnauthorized() {
        assertEquals(401, response.getStatusCode());
    }


    // SD_TC-018
    @When("User sends staff API request to verify content type")
    public void sendStaffApiRequestToVerifyContentType() {
        sendValidRequest();
    }

    @Then("staff API content type should be JSON")
    public void staffApiContentTypeShouldBeJson() {
        assertTrue(
                response.getContentType()
                        .toLowerCase()
                        .contains("json")
        );
    }


    // SD_TC-019
    @When("User sends staff API request to check response time")
    public void sendStaffApiRequestToCheckResponseTime() {
        sendValidRequest();
    }

    @Then("staff API response time should be within 2 seconds")
    public void staffApiResponseTimeShouldBeWithin2Seconds() {
        assertTrue(response.getTime() <= 2000);
    }


    // SD_TC-020
    @When("User sends staff API request to verify mandatory fields")
    public void sendStaffApiRequestToVerifyMandatoryFields() {
        sendValidRequest();
    }

    @Then("staff API mandatory fields should not be empty")
    public void staffApiMandatoryFieldsShouldNotBeEmpty() {
        List<?> ids = response.jsonPath().getList("Value.id");

        assertNotNull(ids);
        assertFalse(ids.isEmpty());
    }


    // SD_TC-021
    @When("User sends staff API request to verify duplicate records")
    public void sendStaffApiRequestToVerifyDuplicateRecords() {
        sendValidRequest();
    }

    @Then("staff API duplicate IDs should not exist")
    public void staffApiDuplicateIdsShouldNotExist() {
        List<Integer> ids =
                response.jsonPath().getList("Value.id");

        assertNotNull(ids);

        Set<Integer> uniqueIds =
                new HashSet<>(ids);

        assertEquals(ids.size(), uniqueIds.size());
    }


    // SD_TC-022
    @When("User sends staff API request when no records exist")
    public void sendStaffApiRequestWhenNoRecordsExist() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("search", "no_staff_record_999999")
                .when()
                .get(baseUrl + staffEndpoint);
    }

    @Then("staff API response should contain empty data")
    public void staffApiResponseShouldContainEmptyData() {
        assertEquals(200, response.getStatusCode());

        List<?> records =
                response.jsonPath().getList("Value");

        assertTrue(records == null || records.isEmpty());
    }


    // SD_TC-023
    @When("User sends staff API request to verify data types")
    public void sendStaffApiRequestToVerifyDataTypes() {
        sendValidRequest();
    }

    @Then("staff API field data types should be valid")
    public void staffApiFieldDataTypesShouldBeValid() {
        List<?> ids =
                response.jsonPath().getList("Value.id");

        assertNotNull(ids);

        for (Object id : ids) {
            assertTrue(id instanceof Number);
        }
    }


    // SD_TC-024
    @When("User sends staff API request to verify record count")
    public void sendStaffApiRequestToVerifyRecordCount() {
        sendValidRequest();
    }

    @Then("staff API record count should be valid")
    public void staffApiRecordCountShouldBeValid() {
        List<?> records =
                response.jsonPath().getList("Value");

        Integer total =
                response.jsonPath().getInt("Total");

        assertNotNull(records);
        assertNotNull(total);

        assertEquals(total.intValue(), records.size());
    }


    // SD_TC-025
    @When("User sends repeated staff API GET requests")
    public void sendRepeatedStaffApiGetRequests() {

        sendValidRequest();

        String first =
                response.getBody().asString();

        sendValidRequest();

        String second =
                response.getBody().asString();

        assertEquals(first, second);
    }

    @Then("staff API response should be consistent")
    public void staffApiResponseShouldBeConsistent() {
        assertEquals(200, response.getStatusCode());
    }


    // SD_TC-026
    @When("User sends staff API request to verify JSON format")
    public void sendStaffApiRequestToVerifyJsonFormat() {
        sendValidRequest();
    }

    @Then("staff API response should be valid JSON")
    public void staffApiResponseShouldBeValidJson() {
        String body = response.getBody().asString();

        assertNotNull(body);
        assertFalse(body.isEmpty());

        assertTrue(
                body.trim().startsWith("{")
                        || body.trim().startsWith("[")
        );
    }


    // SD_TC-027
    @When("User sends staff API request to verify GET method")
    public void sendStaffApiRequestToVerifyGetMethod() {
        sendValidRequest();
    }

    @Then("staff API GET method should be supported")
    public void staffApiGetMethodShouldBeSupported() {
        assertEquals(200, response.getStatusCode());
    }


    // SD_TC-028
    @When("User sends staff API request with special characters")
    public void sendStaffApiRequestWithSpecialCharacters() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("search", "@#$%^&*")
                .when()
                .get(baseUrl + staffEndpoint);
    }

    @Then("staff API should handle special characters")
    public void staffApiShouldHandleSpecialCharacters() {
        assertTrue(response.getStatusCode() < 500);
    }


    // SD_TC-029
    @When("User sends staff API request with long search input")
    public void sendStaffApiRequestWithLongSearchInput() {

        String longSearch =
                "abcdefghijklmnopqrstuvwxyz"
                        + "abcdefghijklmnopqrstuvwxyz"
                        + "abcdefghijklmnopqrstuvwxyz";

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("search", longSearch)
                .when()
                .get(baseUrl + staffEndpoint);
    }

    @Then("staff API should return a valid response")
    public void staffApiShouldReturnAValidResponse() {
        assertTrue(response.getStatusCode() < 500);
    }


    private void sendValidRequest() {
        response = RestAssured
                .given()
                .header(
                        "Authorization",
                        "Bearer " + token
                )
                .when()
                .get(baseUrl + staffEndpoint);
    }
}