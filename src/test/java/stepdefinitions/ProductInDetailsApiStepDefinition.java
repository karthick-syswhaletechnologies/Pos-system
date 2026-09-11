package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class ProductInDetailsApiStepDefinition {

    private Response response;

    private final String baseUrl = "http://localhost:5001";

    private final String productInDetailsEndpoint =
            "/api/productIN/get?business_centre_id=1&skip=0&take=10";

    private final String validToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibG9naW5fbmFtZSI6InN1cGVyYWRtaW4iLCJidXNpbmVzc19jZW50cmVfaWQiOjEsImJyYW5jaF9jb2RlIjoiU0EwMDEiLCJzdGFmZl9kZXRhaWxzX2lkIjpudWxsLCJyb2xlIjoiU3VwZXJhZG1pbiIsInNoaWZ0X2lkIjoxNjMsImxvZ2luIjoiMjAyNi0wOS0wOFQwNjo0NDo1Mi4wMDBaIiwibG9nb3V0IjpudWxsLCJpYXQiOjE3ODg4NDk4OTIsImV4cCI6MTc4ODkzNjI5Mn0.f8DlMWuJor9_ifUOra7Uj3qpmS3zvwnu4EQiRPThgtk";

    // PI_TC_001
    @When("User sends a GET request to the Product In Details API")
    public void userSendsGetRequestToProductInDetailsAPI() {

        String url = baseUrl + productInDetailsEndpoint;

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + validToken)
                .when()
                .get(url);

        System.out.println("Product In Details API Response:");
        System.out.println(response.asPrettyString());
    }

    // PI_TC_001
    @Then("Product In Details API response status should be 200")
    public void productInDetailsAPIResponseStatusShouldBe200() {

        assertEquals(
                200,
                response.getStatusCode(),
                "Expected status 200 but got: " + response.getStatusCode()
        );
    }

    // PI_TC_002
    @Then("Product In Details API response body should not be empty")
    public void productInDetailsAPIResponseBodyShouldNotBeEmpty() {

        assertNotNull(response.getBody());
        assertFalse(
                response.getBody().asString().isEmpty(),
                "Response body should not be empty"
        );
    }

    // PI_TC_003
    @Then("Product In Details API should return product details list")
    public void productInDetailsAPIShouldReturnProductDetailsList() {

        assertNotNull(response.jsonPath().get("Value"));

        System.out.println("Product Details Value: "
                + response.jsonPath().get("Value"));
    }

    // PI_TC_004
    @Then("Product In Details API records should contain Product ID")
    public void productInDetailsAPIRecordsShouldContainProductID() {

        Object value = response.jsonPath().get("Value");

        assertNotNull(value);

        if (!response.jsonPath().getList("Value").isEmpty()) {
            Object productId =
                    response.jsonPath().get("Value[0].id");

            assertNotNull(productId, "Product ID should be present");
        } else {
            fail("Product In Details response contains no records");
        }
    }

    // PI_TC_005
    @Then("Product In Details API records should contain Category")
    public void productInDetailsAPIRecordsShouldContainCategory() {

        validateField("category", "Category");
    }

    // PI_TC_006
    @Then("Product In Details API records should contain Sub Category")
    public void productInDetailsAPIRecordsShouldContainSubCategory() {

        validateField("sub_category", "Sub Category");
    }

    // PI_TC_007
    @Then("Product In Details API records should contain Product Code")
    public void productInDetailsAPIRecordsShouldContainProductCode() {

        validateField("code", "Product Code");
    }

    // PI_TC_008
    @Then("Product In Details API records should contain Product Name")
    public void productInDetailsAPIRecordsShouldContainProductName() {

        validateField("name", "Product Name");
    }

    // PI_TC_009
    @Then("Product In Details API records should contain Brand")
    public void productInDetailsAPIRecordsShouldContainBrand() {

        validateField("brand", "Brand");
    }

    // PI_TC_010
    @Then("Product In Details API records should contain In Quantity")
    public void productInDetailsAPIRecordsShouldContainInQuantity() {

        validateField("in_qty", "In Quantity");
    }

    // PI_TC_011
    @Then("Product In Details API records should contain Unit")
    public void productInDetailsAPIRecordsShouldContainUnit() {

        validateField("unit", "Unit");
    }

    // PI_TC_012
    @Then("Product In Details API records should contain Available Quantity")
    public void productInDetailsAPIRecordsShouldContainAvailableQuantity() {

        validateField("available", "Available Quantity");
    }

    // PI_TC_013
    @Then("Product In Details API records should contain In Date")
    public void productInDetailsAPIRecordsShouldContainInDate() {

        validateField("in_date", "In Date");
    }

    // PI_TC_014
    @Then("Product In Details API records should contain Expire Date")
    public void productInDetailsAPIRecordsShouldContainExpireDate() {

        validateField("expire_date", "Expire Date");
    }

    // PI_TC_015
    @Then("Product In Details API records should contain Supplier")
    public void productInDetailsAPIRecordsShouldContainSupplier() {

        validateField("supplier", "Supplier");
    }

    // PI_TC_016
    @When("User sends a GET request to the Product In Details API with valid token")
    public void userSendsGetRequestWithValidToken() {

        String url = baseUrl + productInDetailsEndpoint;

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + validToken)
                .when()
                .get(url);
    }

    // PI_TC_016
    @Then("Product In Details API should authorize the request")
    public void productInDetailsAPIShouldAuthorizeTheRequest() {

        assertNotEquals(
                401,
                response.getStatusCode(),
                "Valid token should authorize the request"
        );

        assertNotEquals(
                403,
                response.getStatusCode(),
                "Valid token should authorize the request"
        );
    }

    // PI_TC_017
    @When("User sends a GET request to the Product In Details API with invalid token")
    public void userSendsGetRequestWithInvalidToken() {

        String url = baseUrl + productInDetailsEndpoint;

        response = RestAssured
                .given()
                .header("Authorization", "Bearer invalid_token")
                .when()
                .get(url);

        System.out.println("Invalid Token Response:");
        System.out.println(response.asPrettyString());
    }

    // PI_TC_017
    @Then("Product In Details API should return authorization error")
    public void productInDetailsAPIShouldReturnAuthorizationError() {

        assertTrue(
                response.getStatusCode() == 401 ||
                        response.getStatusCode() == 403,
                "Expected 401 or 403 but got: "
                        + response.getStatusCode()
        );
    }

    // PI_TC_018
    @When("User sends a GET request to the Product In Details API without token")
    public void userSendsGetRequestWithoutToken() {

        String url = baseUrl + productInDetailsEndpoint;

        response = RestAssured
                .given()
                .when()
                .get(url);

        System.out.println("No Token Response:");
        System.out.println(response.asPrettyString());
    }

    // PI_TC_018
    @Then("Product In Details API should reject the request")
    public void productInDetailsAPIShouldRejectTheRequest() {

        assertTrue(
                response.getStatusCode() == 401 ||
                        response.getStatusCode() == 403,
                "Expected authorization error but got: "
                        + response.getStatusCode()
        );
    }

    // PI_TC_019
    @Then("Product In Details API should handle empty data without server error")
    public void productInDetailsAPIShouldHandleEmptyDataWithoutServerError() {

        assertNotEquals(
                500,
                response.getStatusCode(),
                "API should not return 500 when data is empty"
        );

        if (response.getStatusCode() == 200) {
            System.out.println(
                    "API returned 200. Value: "
                            + response.jsonPath().get("Value")
            );
        }
    }

    // PI_TC_020
    @Then("Product In Details API response content type should be application/json")
    public void productInDetailsAPIResponseContentTypeShouldBeApplicationJson() {

        String contentType = response.getContentType();

        assertNotNull(contentType);

        assertTrue(
                contentType.toLowerCase().contains("json"),
                "Expected JSON content type but got: " + contentType
        );
    }

    // PI_TC_021
    @Then("Product In Details API response status code should be valid")
    public void productInDetailsAPIResponseStatusCodeShouldBeValid() {

        int statusCode = response.getStatusCode();

        assertTrue(
                statusCode >= 200 && statusCode < 500,
                "Unexpected HTTP status code: " + statusCode
        );
    }

    // PI_TC_022
    @Then("Product In Details API response headers should be present")
    public void productInDetailsAPIResponseHeadersShouldBePresent() {

        assertNotNull(
                response.getHeaders(),
                "Response headers should be present"
        );

        assertFalse(
                response.getHeaders().asList().isEmpty(),
                "Response headers should not be empty"
        );
    }

    // PI_TC_023
    @Then("Product In Details API response time should be acceptable")
    public void productInDetailsAPIResponseTimeShouldBeAcceptable() {

        long responseTime = response.getTime();

        System.out.println(
                "Product In Details API Response Time: "
                        + responseTime + " ms"
        );

        assertTrue(
                responseTime < 5000,
                "Response time exceeded 5 seconds: "
                        + responseTime + " ms"
        );
    }

    // PI_TC_024
    @When("User sends a GET request to an invalid Product In Details endpoint")
    public void userSendsGetRequestToInvalidProductInDetailsEndpoint() {

        String invalidUrl =
                baseUrl + "/api/productindetails/invalid";

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + validToken)
                .when()
                .get(invalidUrl);

        System.out.println("Invalid Endpoint Response:");
        System.out.println(response.asPrettyString());
    }

    // PI_TC_024
    @Then("Product In Details API should return 404")
    public void productInDetailsAPIShouldReturn404() {

        assertEquals(
                404,
                response.getStatusCode(),
                "Expected 404 but got: "
                        + response.getStatusCode()
        );
    }

    // PI_TC_025
    @Then("Product In Details API should not return 500")
    public void productInDetailsAPIShouldNotReturn500() {

        assertNotEquals(
                500,
                response.getStatusCode(),
                "API returned 500 Internal Server Error"
        );
    }

    // Common field validation method
    private void validateField(String fieldName, String displayName) {

        assertNotNull(
                response.jsonPath().get("Value"),
                "Value should be present in response"
        );

        if (response.jsonPath().getList("Value").isEmpty()) {
            fail(
                    "Product In Details response contains no records. "
                            + displayName + " cannot be validated."
            );
        }

        Object fieldValue =
                response.jsonPath().get("Value[0]." + fieldName);

        assertNotNull(
                fieldValue,
                displayName + " should be present"
        );

        System.out.println(
                displayName + ": " + fieldValue
        );
    }
}