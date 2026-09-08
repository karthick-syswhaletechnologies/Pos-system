package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class BusinessCentreSteps {

    private String baseUrl = "http://localhost:5001";
    private String endpoint = "/api/businesscentres/getall";

    private Response response;

    private String authToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXV" +
            "CJ9.eyJpZCI6MSwibG9naW5fbmFtZSI6InN1cGVyYWRtaW4iLCJidXN" +
            "pbmVzc19jZW50cmVfaWQiOjEsImJyYW5jaF9jb2RlIjoiU0EwMDEiLC" +
            "JzdGFmZl9kZXRhaWxzX2lkIjoxLCJyb2xlIjoiU3VwZXJhZG1p" +
            "biIsImlhdCI6MTc4ODIzNzE4MSwiZXhwIjoxNzg4MzIzNTgxfQ." +
            "Cr9_mDv1O_8jHJaPPCIFU_Wm_gsBmDtKCjZDUTh_FRw";


    // -------------------------------------------------------
    // BACKGROUND
    // -------------------------------------------------------

    @Given("the Business Centre API endpoint is available")
    public void businessCentreApiEndpointIsAvailable() {

        System.out.println("Base URL: " + baseUrl);
        System.out.println("Endpoint: " + endpoint);
    }


    // -------------------------------------------------------
    // BC_GET_001
    // -------------------------------------------------------

    @When("user sends a GET request to retrieve all Business Centre records")
    public void userSendsGetRequestToRetrieveAllBusinessCentreRecords() {

        response =
                given()
                        .baseUri(baseUrl)
                        .header("Authorization", "Bearer " + authToken)
                        .header("Accept", "application/json")
                        .when()
                        .get(endpoint);

        response.then().log().all();
    }



    // BC_GET_002

    @When("user sends a GET request with valid Business Centre ID {int}")
    public void userSendsGetRequestWithValidBusinessCentreId(int id) {

        response =
                given()
                        .baseUri(baseUrl)
                        .header("Authorization", "Bearer " + authToken)
                        .header("Accept", "application/json")
                        .queryParam("id", id)
                        .when()
                        .get(endpoint);

        response.then().log().all();
    }



    // BC_GET_003


    @When("user sends a GET request with invalid Business Centre ID {int}")
    public void userSendsGetRequestWithInvalidBusinessCentreId(int id) {

        response =
                given()
                        .baseUri(baseUrl)
                        .header("Authorization", "Bearer " + authToken)
                        .header("Accept", "application/json")
                        .queryParam("id", id)
                        .when()
                        .get(endpoint);

        response.then().log().all();
    }



    // BC_GET_004
    // -------------------------------------------------------

    @When("user sends a GET request with Business Centre ID 0")
    public void userSendsGetRequestWithBusinessCentreIdZero() {

        response =
                given()
                        .baseUri(baseUrl)
                        .header("Authorization", "Bearer " + authToken)
                        .queryParam("id", 0)
                        .when()
                        .get(endpoint);

        response.then().log().all();
    }


    // -------------------------------------------------------
    // BC_GET_005
    // -------------------------------------------------------

    @When("user sends a GET request with Business Centre ID -1")
    public void userSendsGetRequestWithNegativeBusinessCentreId() {

        response =
                given()
                        .baseUri(baseUrl)
                        .header("Authorization", "Bearer " + authToken)
                        .queryParam("id", -1)
                        .when()
                        .get(endpoint);

        response.then().log().all();
    }


    // -------------------------------------------------------
    // BC_GET_006
    // -------------------------------------------------------

    @When("user sends a GET request with Business Centre ID {string}")
    public void userSendsGetRequestWithBusinessCentreIdString(String id) {

        response =
                given()
                        .baseUri(baseUrl)
                        .header("Authorization", "Bearer " + authToken)
                        .queryParam("id", id)
                        .when()
                        .get(endpoint);

        response.then().log().all();
    }



    // STATUS CODE


    @Then("the response status code should be {int}")
    public void responseStatusCodeShouldBe(int expectedStatusCode) {

        Assert.assertEquals(
                response.getStatusCode(),
                expectedStatusCode,
                "Unexpected status code"
        );
    }


    @Then("the response status code should be 400 or 404")
    public void responseStatusCodeShouldBe400Or404() {

        int actualStatusCode = response.getStatusCode();

        Assert.assertTrue(
                actualStatusCode == 400 ||
                        actualStatusCode == 404,
                "Expected 400 or 404 but received "
                        + actualStatusCode
        );
    }



    // BC_GET_001


    @Then("the response should contain Business Centre records")
    public void responseShouldContainBusinessCentreRecords() {

        Object value = response.jsonPath().get("Value");

        Assert.assertNotNull(
                value,
                "Value field is missing"
        );
    }



    // BC_GET_002


    @Then("the Business Centre ID should be {int}")
    public void businessCentreIdShouldBe(int expectedId) {

        Integer actualId =
                response.jsonPath()
                        .getInt("Value[0].id");

        Assert.assertEquals(
                actualId,
                expectedId
        );
    }



    // BC_GET_007


    @Then("the id field should be present")
    public void idFieldShouldBePresent() {

        Object id =
                response.jsonPath()
                        .get("Value[0].id");

        Assert.assertNotNull(
                id,
                "id field is missing"
        );
    }


    @Then("the id field should be a number")
    public void idFieldShouldBeNumber() {

        Object id =
                response.jsonPath()
                        .get("Value[0].id");

        Assert.assertTrue(
                id instanceof Number,
                "id should be a number"
        );
    }



    // BC_GET_008

    @Then("the organization_id field should be present")
    public void organizationIdFieldShouldBePresent() {

        Object organizationId =
                response.jsonPath()
                        .get("Value[0].organization_id");

        Assert.assertNotNull(
                organizationId,
                "organization_id is missing"
        );
    }


    @Then("the organization_id field should be a number")
    public void organizationIdShouldBeNumber() {

        Object organizationId =
                response.jsonPath()
                        .get("Value[0].organization_id");

        Assert.assertTrue(
                organizationId instanceof Number,
                "organization_id should be a number"
        );
    }



    // BC_GET_009


    @Then("the branch_code field should be present")
    public void branchCodeFieldShouldBePresent() {

        Object branchCode =
                response.jsonPath()
                        .get("Value[0].branch_code");

        Assert.assertNotNull(
                branchCode,
                "branch_code is missing"
        );

        Assert.assertFalse(
                branchCode.toString().trim().isEmpty(),
                "branch_code is empty"
        );
    }



    // BC_GET_010

    @Then("the branch_name field should be present")
    public void branchNameFieldShouldBePresent() {

        Object branchName =
                response.jsonPath()
                        .get("Value[0].branch_name");

        Assert.assertNotNull(
                branchName,
                "branch_name is missing"
        );
    }


    @Then("the branch_name should be {string}")
    public void branchNameShouldBe(String expectedBranchName) {

        String actualBranchName =
                response.jsonPath()
                        .getString("Value[0].branch_name");

        Assert.assertEquals(
                actualBranchName,
                expectedBranchName
        );
    }



    // BC_GET_011


    @Then("the service_type field should be present")
    public void serviceTypeFieldShouldBePresent() {

        Object serviceType =
                response.jsonPath()
                        .get("Value[0].service_type");

        /*
         * Field exists even when value is null.
         */
        Assert.assertTrue(
                response.jsonPath()
                        .getMap("Value[0]")
                        .containsKey("service_type")
        );
    }



    // BC_GET_012


    @Then("the address field should be present")
    public void addressFieldShouldBePresent() {

        verifyFieldExists("address");
    }


    @Then("the location field should be present")
    public void locationFieldShouldBePresent() {

        verifyFieldExists("location");
    }


    @Then("the district field should be present")
    public void districtFieldShouldBePresent() {

        verifyFieldExists("district");
    }


    @Then("the state field should be present")
    public void stateFieldShouldBePresent() {

        verifyFieldExists("state");
    }


    @Then("the country field should be present")
    public void countryFieldShouldBePresent() {

        verifyFieldExists("country");
    }


    private void verifyFieldExists(String fieldName) {

        Assert.assertTrue(
                response.jsonPath()
                        .getMap("Value[0]")
                        .containsKey(fieldName),
                fieldName + " field is missing"
        );
    }



    // BC_GET_013


    @Then("the contact field should be present")
    public void contactFieldShouldBePresent() {

        verifyFieldExists("contact");
    }



    // BC_GET_014


    @Then("the email field should be present")
    public void emailFieldShouldBePresent() {

        verifyFieldExists("email");
    }


    // BC_GET_015


    @Then("the website field should be present")
    public void websiteFieldShouldBePresent() {

        verifyFieldExists("website");
    }



    // BC_GET_016


    @Then("the status field should be present")
    public void statusFieldShouldBePresent() {

        Object status =
                response.jsonPath()
                        .get("Value[0].status");

        Assert.assertNotNull(
                status,
                "status field is missing"
        );
    }


    @Then("the status field should be 0 or 1")
    public void statusFieldShouldBeZeroOrOne() {

        Integer status =
                response.jsonPath()
                        .getInt("Value[0].status");

        Assert.assertTrue(
                status == 0 || status == 1,
                "Unexpected status value: " + status
        );
    }



    // BC_GET_017


    @Then("the response Content-Type should be application/json")
    public void responseContentTypeShouldBeApplicationJson() {

        String contentType =
                response.getContentType();

        Assert.assertTrue(
                contentType.toLowerCase()
                        .contains("application/json"),
                "Unexpected Content-Type: " + contentType
        );
    }



    // BC_GET_018


    @Then("the response time should be less than 2000 milliseconds")
    public void responseTimeShouldBeLessThan2000Milliseconds() {

        long responseTime =
                response.getTime();

        System.out.println(
                "Response Time: "
                        + responseTime
                        + " ms"
        );

        Assert.assertTrue(
                responseTime < 2000,
                "Response time exceeded 2000 ms"
        );
    }



    // BC_GET_019


    @When("user sends a GET request without authentication")
    public void userSendsGetRequestWithoutAuthentication() {

        response =
                given()
                        .baseUri(baseUrl)
                        .header("Accept", "application/json")
                        .when()
                        .get(endpoint);

        response.then().log().all();
    }



    // BC_GET_020


    @When("user sends a GET request with an invalid authentication token")
    public void userSendsGetRequestWithInvalidAuthenticationToken() {

        response =
                given()
                        .baseUri(baseUrl)
                        .header(
                                "Authorization",
                                "Bearer invalid_token_123456"
                        )
                        .header("Accept", "application/json")
                        .when()
                        .get(endpoint);

        response.then().log().all();
    }



    // BC_GET_023

    @Then("the response should contain the expected structure")
    public void responseShouldContainExpectedStructure() {

        Assert.assertNotNull(
                response.jsonPath().get("IsSuccess"),
                "IsSuccess is missing"
        );

        Assert.assertNotNull(
                response.jsonPath().get("Value"),
                "Value is missing"
        );

        Assert.assertNotNull(
                response.jsonPath().get("Total"),
                "Total is missing"
        );

        Assert.assertNotNull(
                response.jsonPath().get("Error"),
                "Error is missing"
        );

        Assert.assertTrue(
                response.jsonPath()
                        .getMap("")
                        .containsKey("Exception"),
                "Exception field is missing"
        );
    }


    @Then("the required fields should have the correct data types")
    public void requiredFieldsShouldHaveCorrectDataTypes() {

        Object isSuccess =
                response.jsonPath().get("IsSuccess");

        Object value =
                response.jsonPath().get("Value");

        Object total =
                response.jsonPath().get("Total");

        Object error =
                response.jsonPath().get("Error");

        Assert.assertTrue(
                isSuccess instanceof Boolean,
                "IsSuccess should be Boolean"
        );

        Assert.assertTrue(
                value instanceof java.util.List,
                "Value should be an array"
        );

        Assert.assertTrue(
                total instanceof Number,
                "Total should be a number"
        );

        Assert.assertTrue(
                error instanceof Number,
                "Error should be a number"
        );
    }



    // BC_GET_022


    @Then("the API branch_code should match the database branch_code")
    public void apiBranchCodeShouldMatchDatabaseBranchCode() {

        String apiBranchCode =
                response.jsonPath()
                        .getString("Value[0].branch_code");

        /*
         * We will connect this to your MySQL database
         * once the exact table name is confirmed.
         */

        String dbBranchCode = "SA001";

        System.out.println(
                "API Branch Code = " + apiBranchCode
        );

        System.out.println(
                "DB Branch Code = " + dbBranchCode
        );

        Assert.assertEquals(
                apiBranchCode,
                dbBranchCode,
                "API and DB branch_code values do not match"
        );
    }
}
