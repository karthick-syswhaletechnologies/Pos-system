package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

import static org.junit.Assert.*;

public class ProductExtraDetailsApiStepDefinition {

    Response response;

    String baseUrl = "http://localhost:5001";

    String productExtraDetailsEndpoint =
            "/api/productextradetails/getall";

    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibG9naW5fbmFtZSI6InN1cGVyYWRtaW4iLCJidXNpbmVzc19jZW50cmVfaWQiOjEsImJyYW5jaF9jb2RlIjoiU0EwMDEiLCJzdGFmZl9kZXRhaWxzX2lkIjpudWxsLCJyb2xlIjoiU3VwZXJhZG1pbiIsInNoaWZ0X2lkIjoxNjcsImxvZ2luIjoiMjAyNi0wOS0xMFQwNToxNToyOS4wMDBaIiwibG9nb3V0IjpudWxsLCJpYXQiOjE3ODkwMTczMjksImV4cCI6MTc4OTEwMzcyOX0.DLbc22_OBF9JJp7CnxhRnJ2keuYwyTF2phfqiV7hp_I";


    // PED_TC_001
    @When("User sends a GET request to the Product Extra Details API")
    public void userSendsGetRequestToProductExtraDetailsAPI() {

        String url = baseUrl + productExtraDetailsEndpoint;

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(url);

        System.out.println("Product Extra Details API Response:");
        System.out.println(response.asPrettyString());
    }

    // PED_TC_001
    @Then("Product Extra Details API response status should be 200")
    public void productExtraDetailsAPIResponseStatusShouldBe200() {

        assertEquals(200, response.getStatusCode());
    }


    // PED_TC_002
    @Then("Product Extra Details API response body should not be empty")
    public void productExtraDetailsAPIResponseBodyShouldNotBeEmpty() {

        assertNotNull(response.getBody());

        assertFalse(
                response.getBody().asString().isEmpty()
        );
    }


    // PED_TC_003
    @Then("Product Extra Details list should be returned")
    public void productExtraDetailsListShouldBeReturned() {

        List<Object> records =
                response.jsonPath().getList("Value");

        assertNotNull(records);

        System.out.println(
                "Product Extra Details List: " + records
        );
    }


    // PED_TC_004
    @Then("Product Extra Details records should contain Extra Detail ID")
    public void productExtraDetailsRecordsShouldContainExtraDetailID() {

        validateField("id", "Extra Detail ID");
    }


    // PED_TC_005
    @Then("Product Extra Details records should contain Product ID")
    public void productExtraDetailsRecordsShouldContainProductID() {

        validateField("product_id", "Product ID");
    }


    // PED_TC_006
    @Then("Product Extra Details records should contain Label")
    public void productExtraDetailsRecordsShouldContainLabel() {

        validateField("label", "Label");
    }


    // PED_TC_007
    @Then("Product Extra Details records should contain Value")
    public void productExtraDetailsRecordsShouldContainValue() {

        validateField("value", "Value");
    }


    // PED_TC_008
    @Then("Product Extra Details records should contain Status")
    public void productExtraDetailsRecordsShouldContainStatus() {

        validateField("status", "Status");
    }


    // PED_TC_009
    @Then("Product Extra Details should return multiple records")
    public void productExtraDetailsShouldReturnMultipleRecords() {

        List<Object> records =
                response.jsonPath().getList("Value");

        assertNotNull(records);

        assertTrue(
                "Expected multiple Product Extra Details records, but found "
                        + records.size(),
                records.size() > 1
        );

        System.out.println(
                "Number of records: " + records.size()
        );
    }


    // PED_TC_010
    @Then("Product Extra Details records should contain required fields")
    public void productExtraDetailsRecordsShouldContainRequiredFields() {

        List<Object> records =
                response.jsonPath().getList("Value");

        assertNotNull(records);

        if (records.isEmpty()) {
            fail("No Product Extra Details records available");
        }

        assertNotNull(
                response.jsonPath().get("Value[0].id")
        );

        assertNotNull(
                response.jsonPath().get("Value[0].product_id")
        );

        assertNotNull(
                response.jsonPath().get("Value[0].label")
        );

        assertNotNull(
                response.jsonPath().get("Value[0].value")
        );

        assertNotNull(
                response.jsonPath().get("Value[0].status")
        );
    }


    // PED_TC_011
    @When("User sends a GET request to the Product Extra Details API with search criteria")
    public void userSendsGetRequestWithSearchCriteria() {

        String url =
                baseUrl
                        + productExtraDetailsEndpoint
                        + "?search=Test";

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(url);

        System.out.println("Search Response:");
        System.out.println(response.asPrettyString());
    }


    // PED_TC_011
    @Then("Product Extra Details matching records should be returned")
    public void productExtraDetailsMatchingRecordsShouldBeReturned() {

        assertNotEquals(
                500,
                response.getStatusCode()
        );
    }


    // PED_TC_012
    @When("User sends a GET request to the Product Extra Details API with Product filter")
    public void userSendsGetRequestWithProductFilter() {

        String url =
                baseUrl
                        + productExtraDetailsEndpoint
                        + "?product_id=1";

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(url);

        System.out.println("Product Filter Response:");
        System.out.println(response.asPrettyString());
    }


    // PED_TC_012
    @Then("Product Extra Details should return matching Product records")
    public void productExtraDetailsShouldReturnMatchingProductRecords() {

        assertNotEquals(
                500,
                response.getStatusCode()
        );
    }


    // PED_TC_013
    @When("User sends a GET request to the Product Extra Details API with Label filter")
    public void userSendsGetRequestWithLabelFilter() {

        String url =
                baseUrl
                        + productExtraDetailsEndpoint
                        + "?label=Color";

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(url);

        System.out.println("Label Filter Response:");
        System.out.println(response.asPrettyString());
    }


    // PED_TC_013
    @Then("Product Extra Details should return matching Label records")
    public void productExtraDetailsShouldReturnMatchingLabelRecords() {

        assertNotEquals(
                500,
                response.getStatusCode()
        );
    }


    // PED_TC_014
    @When("User sends a GET request to the Product Extra Details API with Status filter")
    public void userSendsGetRequestWithStatusFilter() {

        String url =
                baseUrl
                        + productExtraDetailsEndpoint
                        + "?status=1";

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(url);

        System.out.println("Status Filter Response:");
        System.out.println(response.asPrettyString());
    }


    // PED_TC_014
    @Then("Product Extra Details should return matching Status records")
    public void productExtraDetailsShouldReturnMatchingStatusRecords() {

        assertNotEquals(
                500,
                response.getStatusCode()
        );
    }


    // PED_TC_015
    @Then("Product Extra Details API should handle empty data without server error")
    public void productExtraDetailsAPIShouldHandleEmptyDataWithoutServerError() {

        assertNotEquals(
                500,
                response.getStatusCode()
        );

        System.out.println(
                "Value: "
                        + response.jsonPath().get("Value")
        );
    }


    // PED_TC_016
    @When("User sends a GET request to the Product Extra Details API with valid token")
    public void userSendsGetRequestWithValidToken() {

        String url =
                baseUrl + productExtraDetailsEndpoint;

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(url);
    }


    // PED_TC_016
    @Then("Product Extra Details API should authorize the request")
    public void productExtraDetailsAPIShouldAuthorizeTheRequest() {

        assertNotEquals(
                401,
                response.getStatusCode()
        );

        assertNotEquals(
                403,
                response.getStatusCode()
        );
    }


    // PED_TC_017
    @When("User sends a GET request to the Product Extra Details API with invalid token")
    public void userSendsGetRequestWithInvalidToken() {

        String url =
                baseUrl + productExtraDetailsEndpoint;

        response = RestAssured
                .given()
                .header(
                        "Authorization",
                        "Bearer invalid_token"
                )
                .when()
                .get(url);

        System.out.println(
                response.asPrettyString()
        );
    }


    // PED_TC_017
    @Then("Product Extra Details API should return authorization error")
    public void productExtraDetailsAPIShouldReturnAuthorizationError() {

        assertTrue(
                response.getStatusCode() == 401
                        || response.getStatusCode() == 403
        );
    }


    // PED_TC_018
    @When("User sends a GET request to the Product Extra Details API without token")
    public void userSendsGetRequestWithoutToken() {

        String url =
                baseUrl + productExtraDetailsEndpoint;

        response = RestAssured
                .given()
                .when()
                .get(url);

        System.out.println(
                response.asPrettyString()
        );
    }


    // PED_TC_018
    @Then("Product Extra Details API should reject the request")
    public void productExtraDetailsAPIShouldRejectTheRequest() {

        assertTrue(
                response.getStatusCode() == 401
                        || response.getStatusCode() == 403
        );
    }


    // PED_TC_019
    @Then("Product Extra Details API response content type should be application/json")
    public void productExtraDetailsAPIResponseContentTypeShouldBeApplicationJson() {

        String contentType =
                response.getContentType();

        assertNotNull(contentType);

        assertTrue(
                "Expected JSON content type but got: "
                        + contentType,
                contentType.toLowerCase().contains("json")
        );
    }


    // PED_TC_020
    @Then("Product Extra Details API response status code should be valid")
    public void productExtraDetailsAPIResponseStatusCodeShouldBeValid() {

        int statusCode =
                response.getStatusCode();

        assertTrue(
                statusCode >= 200
                        && statusCode < 500
        );
    }


    // PED_TC_021
    @Then("Product Extra Details API response headers should be present")
    public void productExtraDetailsAPIResponseHeadersShouldBePresent() {

        assertNotNull(
                response.getHeaders()
        );

        assertFalse(
                response.getHeaders()
                        .asList()
                        .isEmpty()
        );
    }


    // PED_TC_022
    @Then("Product Extra Details API response time should be acceptable")
    public void productExtraDetailsAPIResponseTimeShouldBeAcceptable() {

        long responseTime =
                response.getTime();

        System.out.println(
                "Response Time: "
                        + responseTime
                        + " ms"
        );

        assertTrue(
                "Response time exceeded 5000 ms",
                responseTime < 5000
        );
    }


    // PED_TC_023
    @Then("Product Extra Details records should contain valid values")
    public void productExtraDetailsRecordsShouldContainValidValues() {

        List<Object> records =
                response.jsonPath().getList("Value");

        assertNotNull(records);

        if (records.isEmpty()) {
            fail(
                    "No Product Extra Details data available"
            );
        }

        System.out.println(
                "Valid Product Extra Details data found"
        );
    }


    // PED_TC_024
    @When("User sends a GET request to an invalid Product Extra Details endpoint")
    public void userSendsGetRequestToInvalidProductExtraDetailsEndpoint() {

        String url =
                baseUrl
                        + "/api/productExtra/invalid";

        response = RestAssured
                .given()
                .header(
                        "Authorization",
                        "Bearer " + token
                )
                .when()
                .get(url);

        System.out.println(
                "Invalid Endpoint Response:"
        );

        System.out.println(
                response.asPrettyString()
        );
    }


    // PED_TC_024
    @Then("Product Extra Details API should return 404")
    public void productExtraDetailsAPIShouldReturn404() {

        assertEquals(
                404,
                response.getStatusCode()
        );
    }


    // PED_TC_025
    @Then("Product Extra Details API should not return 500")
    public void productExtraDetailsAPIShouldNotReturn500() {

        assertNotEquals(
                500,
                response.getStatusCode()
        );
    }


    // Common validation method
    private void validateField(
            String fieldName,
            String fieldDisplayName) {

        assertNotNull(
                "Value field is missing",
                response.jsonPath().get("Value")
        );

        List<Object> records =
                response.jsonPath().getList("Value");

        if (records.isEmpty()) {
            fail(
                    "No Product Extra Details records available. "
                            + fieldDisplayName
                            + " cannot be validated."
            );
        }

        Object fieldValue =
                response.jsonPath().get(
                        "Value[0]." + fieldName
                );

        assertNotNull(
                fieldDisplayName + " is missing",
                fieldValue
        );

        System.out.println(
                fieldDisplayName
                        + ": "
                        + fieldValue
        );
    }
}