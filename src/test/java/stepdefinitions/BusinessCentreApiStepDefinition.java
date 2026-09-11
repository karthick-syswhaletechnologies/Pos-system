package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class BusinessCentreApiStepDefinition {

    Response response;
    String token;

    String baseUrl = "http://localhost:5001";


    @When("User sends GET request for business centre")
    public void sendGetRequestForBusinessCentre() {

        // BC_TC_001 - Validate Business Centre GET API
        token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibG9naW5fbmFtZSI6InN1cGVyYWRtaW4iLCJidXNpbmVzc19jZW50cmVfaWQiOjEsImJyYW5jaF9jb2RlIjoiU0EwMDEiLCJzdGFmZl9kZXRhaWxzX2lkIjpudWxsLCJyb2xlIjoiU3VwZXJhZG1pbiIsInNoaWZ0X2lkIjoxMzgsImxvZ2luIjoiMjAyNi0wOC0zMFQwOTozMjowMy4wMDBaIiwibG9nb3V0IjpudWxsLCJpYXQiOjE3ODgwODIzMjMsImV4cCI6MTc4ODE2ODcyM30.82HrNF1GWV0RQ8_9BS0q5jIeZey6iFd4omgWQZGrQmU";

        response =
                RestAssured
                        .given()
                        .header("Authorization", "Bearer " + token)
                        .when()
                        .get(baseUrl + "/api/businesscentres/getall");


        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + " ms");

        System.out.println(response.getBody().asPrettyString());

        assertEquals(200, response.getStatusCode());
    }


    // BC_TC_002
    @Then("business centre response body should not be empty")
    public void responseBodyShouldNotBeEmpty() {

        String body = response.getBody().asString();

        assertNotNull(body);
        assertFalse(body.isEmpty());

        System.out.println("Response body is not empty");
    }


    // BC_TC_003
    @Then("business centre response should be valid JSON")
    public void responseShouldBeValidJson() {

        String contentType = response.getContentType();

        assertNotNull(contentType);
        assertTrue(contentType.toLowerCase().contains("json"));

        System.out.println("Response is valid JSON");
    }


    // BC_TC_004
    @Then("business centre records should be returned")
    public void businessCentreRecordsShouldBeReturned() {

        List<?> records =
                response.jsonPath().getList("Value");

        assertNotNull(records);
        assertFalse(records.isEmpty());

        System.out.println(
                "Business Centre records returned: "
                        + records.size()
        );
    }


    // BC_TC_005
    @Then("business centre ID should be available")
    public void businessCentreIdShouldBeAvailable() {

        List<Integer> ids =
                response.jsonPath().getList("Value.id");

        assertNotNull(ids);
        assertFalse(ids.isEmpty());

        System.out.println("Business Centre IDs: " + ids);
    }


    // BC_TC_006
    @Then("business centre name should be available")
    public void businessCentreNameShouldBeAvailable() {

        List<String> names =
                response.jsonPath().getList("Value.branch_name");

        assertNotNull(names);
        assertFalse(names.isEmpty());

        System.out.println(
                "Business Centre Names: " + names
        );
    }


    // BC_TC_007
    @Then("address should be available")
    public void addressShouldBeAvailable() {

        List<String> values =
                response.jsonPath().getList("Value.address");

        assertNotNull(values);
        assertFalse(values.isEmpty());

        System.out.println("Address returned successfully");
    }


    // BC_TC_008
    @Then("location should be available")
    public void locationShouldBeAvailable() {

        List<String> values =
                response.jsonPath().getList("Value.location");

        assertNotNull(values);
        assertFalse(values.isEmpty());

        System.out.println("Location returned successfully");
    }


    // BC_TC_009
    @Then("state should be available")
    public void stateShouldBeAvailable() {

        List<String> values =
                response.jsonPath().getList("Value.state");

        assertNotNull(values);
        assertFalse(values.isEmpty());

        System.out.println("State returned successfully");
    }


    // BC_TC_010
    @Then("country should be available")
    public void countryShouldBeAvailable() {

        List<String> values =
                response.jsonPath().getList("Value.country");

        assertNotNull(values);
        assertFalse(values.isEmpty());

        System.out.println("Country returned successfully");
    }


    // BC_TC_011
    @Then("postal code should be available")
    public void postalCodeShouldBeAvailable() {

        List<String> values =
                response.jsonPath().getList("Value.postalcode");

        assertNotNull(values);
        assertFalse(values.isEmpty());

        System.out.println("Postal Code returned successfully");
    }


    // BC_TC_012
    @Then("contact should be available")
    public void contactShouldBeAvailable() {

        List<String> values =
                response.jsonPath().getList("Value.contact");

        assertNotNull(values);
        assertFalse(values.isEmpty());

        System.out.println("Contact returned successfully");
    }


    // BC_TC_013
    @Then("email should be available")
    public void emailShouldBeAvailable() {

        List<String> values =
                response.jsonPath().getList("Value.email");

        assertNotNull(values);
        assertFalse(values.isEmpty());

        System.out.println("Email returned successfully");
    }


    // BC_TC_014
    @Then("status should be returned")
    public void statusShouldBeReturned() {

        List<Integer> values =
                response.jsonPath().getList("Value.status");

        assertNotNull(values);
        assertFalse(values.isEmpty());

        System.out.println("Status returned: " + values);
    }


    // BC_TC_015
    @Then("created date should be available")
    public void createdDateShouldBeAvailable() {

        List<String> values =
                response.jsonPath().getList("Value.createdAt");

        assertNotNull(values);
        assertFalse(values.isEmpty());

        System.out.println(
                "Created Date returned successfully"
        );
    }


    // BC_TC_016
    @Then("updated date should be available")
    public void updatedDateShouldBeAvailable() {

        List<String> values =
                response.jsonPath().getList("Value.updatedAt");

        assertNotNull(values);
        assertFalse(values.isEmpty());

        System.out.println(
                "Updated Date returned successfully"
        );
    }


    // BC_TC_017
    @Then("mandatory fields should not be empty")
    public void mandatoryFieldsShouldNotBeEmpty() {

        List<?> ids =
                response.jsonPath().getList("Value.id");

        List<?> names =
                response.jsonPath().getList("Value.branch_name");

        List<?> branchCodes =
                response.jsonPath().getList("Value.branch_code");

        assertNotNull(ids);
        assertNotNull(names);
        assertNotNull(branchCodes);

        assertFalse(ids.isEmpty());
        assertFalse(names.isEmpty());
        assertFalse(branchCodes.isEmpty());

        System.out.println(
                "Mandatory fields are available"
        );
    }


    // BC_TC_025
    @Then("response time should be within {int} seconds")
    public void responseTimeShouldBeWithinSeconds(Integer seconds) {

        long responseTime = response.getTime();

        System.out.println(
                "Response Time: "
                        + responseTime
                        + " ms"
        );

        assertTrue(
                "Response time exceeded "
                        + seconds
                        + " seconds",
                responseTime <= seconds * 1000L
        );
    }


    // BC_TC_019
    @Then("duplicate business IDs should not exist")
    public void duplicateBusinessIdsShouldNotExist() {

        List<Integer> ids =
                response.jsonPath().getList("Value.id");

        assertNotNull(ids);

        Set<Integer> uniqueIds =
                new HashSet<>(ids);

        assertEquals(
                "Duplicate Business Centre IDs found",
                ids.size(),
                uniqueIds.size()
        );

        System.out.println(
                "No duplicate Business IDs found"
        );
    }


    // BC_TC_026
    @Then("response content type should be JSON")
    public void responseContentTypeShouldBeJson() {

        String contentType =
                response.getContentType();

        assertNotNull(contentType);

        assertTrue(
                contentType
                        .toLowerCase()
                        .contains("json")
        );

        System.out.println(
                "Response Content-Type: "
                        + contentType
        );
    }


    // BC_TC_031
    @Then("response headers should be available")
    public void responseHeadersShouldBeAvailable() {

        assertNotNull(response.getHeaders());

        System.out.println("Response Headers:");
        System.out.println(response.getHeaders());
    }


    // BC_TC_032
    @Then("large number of business records should be returned")
    public void largeNumberOfBusinessRecordsShouldBeReturned() {

        List<?> records =
                response.jsonPath().getList("Value");

        assertNotNull(records);

        System.out.println(
                "Business Centre records returned: "
                        + records.size()
        );
    }


    // BC_TC_034
    @Then("business centre data should be retrieved successfully")
    public void businessCentreDataShouldBeRetrievedSuccessfully() {

        assertEquals(
                200,
                response.getStatusCode()
        );

        List<?> records =
                response.jsonPath().getList("Value");

        assertNotNull(records);
        assertFalse(records.isEmpty());

        System.out.println(
                "Business Centre data retrieved successfully"
        );
    }


    // BC_TC_020
    @When("User sends GET request for business centre without authorization")
    public void sendGetRequestWithoutAuthorization() {

        response =
                RestAssured
                        .given()
                        .when()
                        .get(baseUrl + "/api/businesscentres/getall");

        System.out.println("BC_TC_020 Status Code: "
                + response.getStatusCode());
    }

    @Then("business centre response status should be 401")
    public void businessCentreResponseStatusShouldBe401() {

        assertEquals(401, response.getStatusCode());

        System.out.println("Unauthorized request returned 401");
    }


    // BC_TC_021
    @When("User sends GET request for business centre with invalid token")
    public void sendGetRequestWithInvalidToken() {

        response =
                RestAssured
                        .given()
                        .header(
                                "Authorization",
                                "Bearer invalid-token"
                        )
                        .when()
                        .get(baseUrl + "/api/businesscentres/getall");

        System.out.println("BC_TC_021 Status Code: "
                + response.getStatusCode());
    }

    @Then("business centre response status should be 401 for invalid token")
    public void businessCentreResponseStatusShouldBe401ForInvalidToken() {

        assertEquals(401, response.getStatusCode());

        System.out.println("Invalid token returned 401");
    }


    // BC_TC_022
    @When("User sends GET request for business centre with expired token")
    public void sendGetRequestWithExpiredToken() {

        String expiredToken = "expired-token";

        response =
                RestAssured
                        .given()
                        .header(
                                "Authorization",
                                "Bearer " + expiredToken
                        )
                        .when()
                        .get(baseUrl + "/api/businesscentres/getall");

        System.out.println("BC_TC_022 Status Code: "
                + response.getStatusCode());
    }

    @Then("business centre response status should be 401 for expired token")
    public void businessCentreResponseStatusShouldBe401ForExpiredToken() {

        assertEquals(401, response.getStatusCode());

        System.out.println("Expired token returned 401");
    }


    // BC_TC_023
    @When("User sends GET request to invalid business centre endpoint")
    public void sendGetRequestToInvalidBusinessCentreEndpoint() {

        response =
                RestAssured
                        .given()
                        .header(
                                "Authorization",
                                "Bearer " + token
                        )
                        .when()
                        .get(baseUrl + "/api/businesscentres/invalid");

        System.out.println("BC_TC_023 Status Code: "
                + response.getStatusCode());
    }

    @Then("business centre response status should be 404")
    public void businessCentreResponseStatusShouldBe404() {

        assertEquals(404, response.getStatusCode());

        System.out.println("Invalid endpoint returned 404");
    }


    // BC_TC_024
    @When("User sends POST request to business centre getall endpoint")
    public void sendPostRequestToBusinessCentreGetallEndpoint() {

        response =
                RestAssured
                        .given()
                        .header(
                                "Authorization",
                                "Bearer " + token
                        )
                        .contentType("application/json")
                        .when()
                        .post(baseUrl + "/api/businesscentres/getall");

        System.out.println("BC_TC_024 Status Code: "
                + response.getStatusCode());
    }

    @Then("business centre response status should be rejected")
    public void businessCentreResponseStatusShouldBeRejected() {

        int statusCode = response.getStatusCode();

        assertTrue(
                statusCode == 404 || statusCode == 405
        );

        System.out.println(
                "POST request rejected with status: "
                        + statusCode
        );
    }
}
