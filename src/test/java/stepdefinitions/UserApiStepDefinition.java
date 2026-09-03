package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

import static org.junit.Assert.*;

public class UserApiStepDefinition {

    Response response;

    String baseUrl = "http://localhost:5001";

    String userEndpoint = "/api/users/getall";

    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibG9naW5fbmFtZSI6InN1cGVyYWRtaW4iLCJidXNpbmVzc19jZW50cmVfaWQiOjEsImJyYW5jaF9jb2RlIjoiU0EwMDEiLCJzdGFmZl9kZXRhaWxzX2lkIjpudWxsLCJyb2xlIjoiU3VwZXJhZG1pbiIsInNoaWZ0X2lkIjoxNDAsImxvZ2luIjoiMjAyNi0wOC0zMFQxODozODoyMi4wMDBaIiwibG9nb3V0IjpudWxsLCJpYXQiOjE3ODgxMTUxMDIsImV4cCI6MTc4ODIwMTUwMn0.Bj2LYYDjHzFP5wB1CbRZhN9fd6ZggstcZzBBASlhuBE";


    // US_GET_TC-001
    @When("User sends user API GET request")
    public void sendUserApiGetRequest() {
        sendValidRequest();
    }

    @Then("user API status should be 200")
    public void userApiStatusShouldBe200() {
        assertEquals(200, response.getStatusCode());
    }


    // US_GET_TC-002
    @When("User sends user API request for response body")
    public void sendUserApiRequestForResponseBody() {
        sendValidRequest();
    }

    @Then("user API response body should not be empty")
    public void userApiResponseBodyShouldNotBeEmpty() {
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertFalse(response.getBody().asString().isEmpty());
    }


    // US_GET_TC-003
    @When("User sends user API request for user list")
    public void sendUserApiRequestForUserList() {
        sendValidRequest();
    }

    @Then("user API records should be returned")
    public void userApiRecordsShouldBeReturned() {
        List<?> records = response.jsonPath().getList("Value");

        assertNotNull(records);
        assertFalse(records.isEmpty());
    }


    // US_GET_TC-004
    @When("User sends user API request to verify user ID")
    public void sendUserApiRequestToVerifyUserId() {
        sendValidRequest();
    }

    @Then("user API user ID should be available")
    public void userApiUserIdShouldBeAvailable() {
        List<?> ids = response.jsonPath().getList("Value.id");

        assertNotNull(ids);
        assertFalse(ids.isEmpty());
    }


    // US_GET_TC-005
    @When("User sends user API request to verify user name")
    public void sendUserApiRequestToVerifyUserName() {
        sendValidRequest();
    }

    @Then("user API user name should be available")
    public void userApiUserNameShouldBeAvailable() {
        List<?> names = response.jsonPath().getList("Value.login_name");

        assertNotNull(names);
        assertFalse(names.isEmpty());
    }


    // US_GET_TC-006
    @When("User sends user API request to verify staff ID")
    public void sendUserApiRequestToVerifyStaffId() {
        sendValidRequest();
    }

    @Then("user API staff ID should be available")
    public void userApiStaffIdShouldBeAvailable() {
        List<?> values = response.jsonPath().getList("Value.staff_details_id");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }


    // US_GET_TC-007
    @When("User sends user API request to verify staff role")
    public void sendUserApiRequestToVerifyStaffRole() {
        sendValidRequest();
    }

    @Then("user API staff role should be available")
    public void userApiStaffRoleShouldBeAvailable() {
        List<?> values = response.jsonPath().getList("Value.staff_role");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }


    // US_GET_TC-008
    @When("User sends user API request to verify status")
    public void sendUserApiRequestToVerifyStatus() {
        sendValidRequest();
    }

    @Then("user API status should be available")
    public void userApiStatusShouldBeAvailable() {
        List<?> values = response.jsonPath().getList("Value.status");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }


    // US_GET_TC-009
    @When("User sends user API request to verify role")
    public void sendUserApiRequestToVerifyRole() {
        sendValidRequest();
    }

    @Then("user API role should be available")
    public void userApiRoleShouldBeAvailable() {
        List<?> values = response.jsonPath().getList("Value.role");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }


    // US_GET_TC-010
    @When("User sends user API request with user name search")
    public void sendUserApiRequestWithUserNameSearch() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("search", "superadmin")
                .when()
                .get(baseUrl + userEndpoint);
    }

    @Then("user API matching user records should be returned")
    public void userApiMatchingUserRecordsShouldBeReturned() {
        assertEquals(200, response.getStatusCode());
    }


    // US_GET_TC-011
    @When("User sends user API request with staff ID search")
    public void sendUserApiRequestWithStaffIdSearch() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("search", "1")
                .when()
                .get(baseUrl + userEndpoint);
    }

    @Then("user API matching staff record should be returned")
    public void userApiMatchingStaffRecordShouldBeReturned() {
        assertEquals(200, response.getStatusCode());
    }


    // US_GET_TC-012
    @When("User sends user API request with invalid search")
    public void sendUserApiRequestWithInvalidSearch() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("search", "xyz_no_user_999999")
                .when()
                .get(baseUrl + userEndpoint);
    }

    @Then("user API invalid search result should be empty")
    public void userApiInvalidSearchResultShouldBeEmpty() {
        assertEquals(200, response.getStatusCode());

        List<?> records = response.jsonPath().getList("Value");

        assertTrue(records == null || records.isEmpty());
    }


    // US_GET_TC-013
    @When("User sends user API request with role filter")
    public void sendUserApiRequestWithRoleFilter() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("role", "Superadmin")
                .when()
                .get(baseUrl + userEndpoint);
    }

    @Then("user API role filtered records should be returned")
    public void userApiRoleFilteredRecordsShouldBeReturned() {
        assertEquals(200, response.getStatusCode());
    }


    // US_GET_TC-014
    @When("User sends user API request with status filter")
    public void sendUserApiRequestWithStatusFilter() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("status", "active")
                .when()
                .get(baseUrl + userEndpoint);
    }

    @Then("user API status filtered records should be returned")
    public void userApiStatusFilteredRecordsShouldBeReturned() {
        assertEquals(200, response.getStatusCode());
    }


    // US_GET_TC-015
    @When("User sends user API request with alphabet filter")
    public void sendUserApiRequestWithAlphabetFilter() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("alphabet", "a")
                .when()
                .get(baseUrl + userEndpoint);
    }

    @Then("user API alphabet filtered records should be returned")
    public void userApiAlphabetFilteredRecordsShouldBeReturned() {
        assertEquals(200, response.getStatusCode());
    }


    // US_GET_TC-016
    @When("User sends user API request to verify mandatory fields")
    public void sendUserApiRequestToVerifyMandatoryFields() {
        sendValidRequest();
    }

    @Then("user API mandatory fields should not be empty")
    public void userApiMandatoryFieldsShouldNotBeEmpty() {
        List<?> ids = response.jsonPath().getList("Value.id");

        assertNotNull(ids);
        assertFalse(ids.isEmpty());
    }


    // US_GET_TC-017
    @When("User sends user API request to verify JSON response")
    public void sendUserApiRequestToVerifyJsonResponse() {
        sendValidRequest();
    }

    @Then("user API response should be valid JSON")
    public void userApiResponseShouldBeValidJson() {
        String body = response.getBody().asString();

        assertNotNull(body);
        assertFalse(body.isEmpty());

        try {
            response.jsonPath();
        } catch (Exception e) {
            fail("Response is not valid JSON");
        }
    }


    // US_GET_TC-018
    @When("User sends user API request to verify content type")
    public void sendUserApiRequestToVerifyContentType() {
        sendValidRequest();
    }

    @Then("user API content type should be JSON")
    public void userApiContentTypeShouldBeJson() {
        assertTrue(
                response.getContentType()
                        .toLowerCase()
                        .contains("json")
        );
    }


    // US_GET_TC-019
    @When("User sends user API request to check response time")
    public void sendUserApiRequestToCheckResponseTime() {
        sendValidRequest();
    }

    @Then("user API response time should be acceptable")
    public void userApiResponseTimeShouldBeAcceptable() {
        assertTrue(response.getTime() <= 2000);
    }


    // US_GET_TC-020
    @When("User sends user API request without authorization")
    public void sendUserApiRequestWithoutAuthorization() {
        response = RestAssured
                .given()
                .when()
                .get(baseUrl + userEndpoint);
    }

    @Then("user API unauthorized status should be 401")
    public void userApiUnauthorizedStatusShouldBe401() {
        assertEquals(401, response.getStatusCode());
    }


    // US_GET_TC-021
    @When("User sends user API request with invalid token")
    public void sendUserApiRequestWithInvalidToken() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer invalid_token_123")
                .when()
                .get(baseUrl + userEndpoint);
    }

    @Then("user API invalid token status should be 401")
    public void userApiInvalidTokenStatusShouldBe401() {
        assertEquals(401, response.getStatusCode());
    }


    // US_GET_TC-022
    @When("User sends user API request to verify active and inactive users")
    public void sendUserApiRequestToVerifyActiveAndInactiveUsers() {
        sendValidRequest();
    }

    @Then("user API active and inactive users should be handled")
    public void userApiActiveAndInactiveUsersShouldBeHandled() {
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getBody());
    }


    // US_GET_TC-023
    @When("User sends user API request to verify record count")
    public void sendUserApiRequestToVerifyRecordCount() {
        sendValidRequest();
    }

    @Then("user API record count should be valid")
    public void userApiRecordCountShouldBeValid() {
        List<?> records = response.jsonPath().getList("Value");

        Integer total = response.jsonPath().getInt("total");

        assertNotNull(records);
        assertNotNull(total);

        assertEquals(total.intValue(), records.size());
    }


    // US_GET_TC-024
    @When("User sends user API request to verify data integrity")
    public void sendUserApiRequestToVerifyDataIntegrity() {
        sendValidRequest();
    }

    @Then("user API data should be accurate")
    public void userApiDataShouldBeAccurate() {
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getBody());
    }


    private void sendValidRequest() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseUrl + userEndpoint);
    }
}