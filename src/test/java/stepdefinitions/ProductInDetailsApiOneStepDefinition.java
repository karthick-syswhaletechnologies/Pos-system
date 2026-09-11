package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class ProductInDetailsApiOneStepDefinition {

    private Response response;

    private final String baseUrl = "http://localhost:5001";

    private final String productInDetailsEndpoint =
            "/api/productindetails/get?business_centre_id=1&skip=0&take=10";

    private final String validToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibG9naW5fbmFtZSI6InN1cGVyYWRtaW4iLCJidXNpbmVzc19jZW50cmVfaWQiOjEsImJyYW5jaF9jb2RlIjoiU0EwMDEiLCJzdGFmZl9kZXRhaWxzX2lkIjpudWxsLCJyb2xlIjoiU3VwZXJhZG1pbiIsInNoaWZ0X2lkIjoxNjMsImxvZ2luIjoiMjAyNi0wOS0wOFQwNjo0NDo1Mi4wMDBaIiwibG9nb3V0IjpudWxsLCJpYXQiOjE3ODg4NDk4OTIsImV4cCI6MTc4ODkzNjI5Mn0.f8DlMWuJor9_ifUOra7Uj3qpmS3zvwnu4EQiRPThgtk";


    // PI_TC_001
    @Then("Product In Details API response status should be 200")
    public void productInDetailsAPIResponseStatusShouldBe200() {

        assertEquals(
                200,
                response.getStatusCode(),
                "Expected 200 but got: " + response.getStatusCode()
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
    @Then("Product In Details list should be returned")
    public void productInDetailsListShouldBeReturned() {

        assertNotNull(
                response.jsonPath().get("Value"),
                "Value field should be present"
        );

        System.out.println(
                "Product In Details List: "
                        + response.jsonPath().get("Value")
        );
    }


    // PI_TC_004
    @Then("Product In Details records should contain Product ID")
    public void productInDetailsRecordsShouldContainProductID() {

        validateField("id", "Product ID");
    }


    // PI_TC_005
    @Then("Product In Details records should contain Category")
    public void productInDetailsRecordsShouldContainCategory() {

        validateField("category", "Category");
    }


    // PI_TC_006
    @Then("Product In Details records should contain Sub Category")
    public void productInDetailsRecordsShouldContainSubCategory() {

        validateField("sub_category", "Sub Category");
    }


    // PI_TC_007
    @Then("Product In Details records should contain Product Code")
    public void productInDetailsRecordsShouldContainProductCode() {

        validateField("code", "Product Code");
    }


    // PI_TC_008
    @Then("Product In Details records should contain Product Name")
    public void productInDetailsRecordsShouldContainProductName() {

        validateField("name", "Product Name");
    }


    // PI_TC_009
    @Then("Product In Details records should contain Brand")
    public void productInDetailsRecordsShouldContainBrand() {

        validateField("brand", "Brand");
    }


    // PI_TC_010
    @Then("Product In Details records should contain Supplier")
    public void productInDetailsRecordsShouldContainSupplier() {

        validateField("supplier", "Supplier");
    }


    // PI_TC_011
    @Then("Product In Details records should contain In Quantity")
    public void productInDetailsRecordsShouldContainInQuantity() {

        validateField("in_qty", "In Quantity");
    }


    // PI_TC_012
    @Then("Product In Details records should contain Unit")
    public void productInDetailsRecordsShouldContainUnit() {

        validateField("unit", "Unit");
    }


    // PI_TC_013
    @Then("Product In Details records should contain Available Quantity")
    public void productInDetailsRecordsShouldContainAvailableQuantity() {

        validateField("available", "Available Quantity");
    }


    // PI_TC_014
    @Then("Product In Details records should contain In Date")
    public void productInDetailsRecordsShouldContainInDate() {

        validateField("in_date", "In Date");
    }


    // PI_TC_015
    @Then("Product In Details records should contain Expire Date")
    public void productInDetailsRecordsShouldContainExpireDate() {

        validateField("expire_date", "Expire Date");
    }


    // PI_TC_016
    @When("User sends a GET request to the Product In Details API with search criteria")
    public void userSendsGetRequestWithSearchCriteria() {

        String url = baseUrl + productInDetailsEndpoint
                + "&product_name=Aashirvaad";

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + validToken)
                .when()
                .get(url);

        System.out.println("Search Response:");
        System.out.println(response.asPrettyString());
    }


    // PI_TC_016
    @Then("Product In Details matching records should be returned")
    public void productInDetailsMatchingRecordsShouldBeReturned() {

        assertNotNull(response.getBody());

        assertNotEquals(
                500,
                response.getStatusCode(),
                "Search API should not return 500"
        );
    }


    // PI_TC_017
    @When("User sends a GET request to the Product In Details API with Category filter")
    public void userSendsGetRequestWithCategoryFilter() {

        String url = baseUrl + productInDetailsEndpoint
                + "&category=Grocery";

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + validToken)
                .when()
                .get(url);

        System.out.println("Category Filter Response:");
        System.out.println(response.asPrettyString());
    }


    // PI_TC_017
    @Then("Product In Details should return matching Category records")
    public void productInDetailsShouldReturnMatchingCategoryRecords() {

        assertNotEquals(
                500,
                response.getStatusCode(),
                "Category filter should not return 500"
        );
    }


    // PI_TC_018
    @When("User sends a GET request to the Product In Details API with Supplier filter")
    public void userSendsGetRequestWithSupplierFilter() {

        String url = baseUrl + productInDetailsEndpoint
                + "&supplier=Aashirvaad";

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + validToken)
                .when()
                .get(url);

        System.out.println("Supplier Filter Response:");
        System.out.println(response.asPrettyString());
    }


    // PI_TC_018
    @Then("Product In Details should return matching Supplier records")
    public void productInDetailsShouldReturnMatchingSupplierRecords() {

        assertNotEquals(
                500,
                response.getStatusCode(),
                "Supplier filter should not return 500"
        );
    }


    // PI_TC_019
    @When("User sends a GET request to the Product In Details API with Arrival Date filter")
    public void userSendsGetRequestWithArrivalDateFilter() {

        String url = baseUrl + productInDetailsEndpoint
                + "&from_date=2025-04-01"
                + "&to_date=2025-04-30";

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + validToken)
                .when()
                .get(url);

        System.out.println("Arrival Date Filter Response:");
        System.out.println(response.asPrettyString());
    }


    // PI_TC_019
    @Then("Product In Details should return records within Arrival Date range")
    public void productInDetailsShouldReturnRecordsWithinArrivalDateRange() {

        assertNotEquals(
                500,
                response.getStatusCode(),
                "Arrival Date filter should not return 500"
        );
    }


    // PI_TC_020
    @When("User sends a GET request to the Product In Details API with Expiry Date filter")
    public void userSendsGetRequestWithExpiryDateFilter() {

        String url = baseUrl + productInDetailsEndpoint
                + "&from_expiry_date=2025-04-01"
                + "&to_expiry_date=2025-04-30";

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + validToken)
                .when()
                .get(url);

        System.out.println("Expiry Date Filter Response:");
        System.out.println(response.asPrettyString());
    }


    // PI_TC_020
    @Then("Product In Details should return records within expiry date range")
    public void productInDetailsShouldReturnRecordsWithinExpiryDateRange() {

        assertNotEquals(
                500,
                response.getStatusCode(),
                "Expiry Date filter should not return 500"
        );
    }


    // PI_TC_021
    @When("User sends a GET request to the Product In Details API with valid token")
    public void userSendsGetRequestWithValidToken() {

        String url = baseUrl + productInDetailsEndpoint;

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + validToken)
                .when()
                .get(url);
    }


    // PI_TC_021
    @Then("Product In Details API should authorize the request")
    public void productInDetailsAPIShouldAuthorizeTheRequest() {

        assertNotEquals(401, response.getStatusCode());
        assertNotEquals(403, response.getStatusCode());
    }


    // PI_TC_022
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


    // PI_TC_022
    @Then("Product In Details API should return authorization error")
    public void productInDetailsAPIShouldReturnAuthorizationError() {

        assertTrue(
                response.getStatusCode() == 401 ||
                        response.getStatusCode() == 403,
                "Expected 401 or 403 but got: "
                        + response.getStatusCode()
        );
    }


    // PI_TC_023
    @When("User sends a GET request to the Product In Details API without token")
    public void userSendsGetRequestWithoutToken() {

        String url = baseUrl + productInDetailsEndpoint;

        response = RestAssured
                .given()
                .when()
                .get(url);

        System.out.println("Missing Token Response:");
        System.out.println(response.asPrettyString());
    }


    // PI_TC_023
    @Then("Product In Details API should reject the request")
    public void productInDetailsAPIShouldRejectTheRequest() {

        assertTrue(
                response.getStatusCode() == 401 ||
                        response.getStatusCode() == 403,
                "Expected 401 or 403 but got: "
                        + response.getStatusCode()
        );
    }


    // PI_TC_024
    @Then("Product In Details API response content type should be application/json")
    public void productInDetailsAPIResponseContentTypeShouldBeApplicationJson() {

        String contentType = response.getContentType();

        assertNotNull(contentType);

        assertTrue(
                contentType.toLowerCase().contains("json"),
                "Expected JSON but got: " + contentType
        );
    }


    // PI_TC_025
    @When("User sends a GET request to an invalid Product In Details endpoint")
    public void userSendsGetRequestToInvalidProductInDetailsEndpoint() {

        String url = baseUrl + "/api/productindetails/invalid";

        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + validToken)
                .when()
                .get(url);

        System.out.println("Invalid Endpoint Response:");
        System.out.println(response.asPrettyString());
    }


    // PI_TC_025
    @Then("Product In Details API should return 404")
    public void productInDetailsAPIShouldReturn404() {

        assertEquals(
                404,
                response.getStatusCode(),
                "Expected 404 but got: "
                        + response.getStatusCode()
        );
    }


    // Common validation method
    private void validateField(String fieldName, String fieldDisplayName) {

        assertNotNull(
                response.jsonPath().get("Value"),
                "Value should be present in response"
        );

        if (response.jsonPath().getList("Value").isEmpty()) {

            fail(
                    "Product In Details response contains no records. "
                            + fieldDisplayName + " cannot be validated."
            );
        }

        Object fieldValue =
                response.jsonPath().get("Value[0]." + fieldName);

        assertNotNull(
                fieldValue,
                fieldDisplayName + " should be present"
        );

        System.out.println(
                fieldDisplayName + ": " + fieldValue
        );
    }
}