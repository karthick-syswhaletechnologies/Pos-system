package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ProductApiOneStepDefinition {

    Response response;

    private final String baseUrl = "http://localhost:5001";
    private final String productEndpoint = "/api/product/get?business_centre_id=1&skip=0&take=10";
    private final String validToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibG9naW5fbmFtZSI6InN1cGVyYWRtaW4iLCJidXNpbmVzc19jZW50cmVfaWQiOjEsImJyYW5jaF9jb2RlIjoiU0EwMDEiLCJzdGFmZl9kZXRhaWxzX2lkIjpudWxsLCJyb2xlIjoiU3VwZXJhZG1pbiIsInNoaWZ0X2lkIjoxNjEsImxvZ2luIjoiMjAyNi0wOS0wN1QwNjo0NjowMi4wMDBaIiwibG9nb3V0IjpudWxsLCJpYXQiOjE3ODg3NjM1NjIsImV4cCI6MTc4ODg0OTk2Mn0.i5hLFBe2-dPMqJYHdXihD2ctWty0iPAZ1VwL6xH_P5c";

    // PD_TC_001
    @When("User sends a GET request to the Product API")
    public void userSendsAGetRequestToTheProductAPI() {

        String url = baseUrl
                + productEndpoint
                + "?business_centre_id=1&skip=0&take=10";

        response = RestAssured.given()
                .header("Authorization", "Bearer " + validToken)
                .when()
                .get(url);

        printResponse();
    }


    // PD_TC_001
    @Then("Product API response status should be 200")
    public void productAPIResponseStatusShouldBe200() {
        assertEquals(200,
                response.getStatusCode());
    }

    // PD_TC_002
    @Then("Product API response body should not be empty")
    public void productAPIResponseBodyShouldNotBeEmpty() {

        assertNotNull(response);
        assertNotNull(response.getBody());

        String responseBody = response.getBody().asString();

        assertFalse(
                "Product API response body is empty",
                responseBody.trim().isEmpty()
        );
    }

    // PD_TC_003
    @Then("Product records should be returned")
    public void productRecordsShouldBeReturned() {

        List<Map<String, Object>> products =
                response.jsonPath().getList("Value");

        assertNotNull(products);
        assertFalse(
                "Product API returned empty Product list",
                products.isEmpty()
        );
    }

    // PD_TC_004
    @Then("Product ID should be available in the response")
    public void productIdShouldBeAvailableInTheResponse() {

        List<Object> ids =
                response.jsonPath().getList("Value.id");

        assertNotNull(ids);
        assertFalse("Product ID is not available", ids.isEmpty());

        for (Object id : ids) {
            assertNotNull(id);
        }
    }

    // PD_TC_005
    @Then("Product Name should be available in the response")
    public void productNameShouldBeAvailableInTheResponse() {

        List<String> productNames =
                response.jsonPath().getList("Value.product_name");

        assertNotNull(productNames);
        assertFalse(
                "Product Name is not available",
                productNames.isEmpty()
        );

        for (String name : productNames) {
            assertNotNull(name);
            assertFalse(name.trim().isEmpty());
        }
    }

    // PD_TC_006
    @Then("Product Code should be available in the response")
    public void productCodeShouldBeAvailableInTheResponse() {

        List<String> productCodes =
                response.jsonPath().getList("Value.product_code");

        assertNotNull(productCodes);
        assertFalse(
                "Product Code is not available",
                productCodes.isEmpty()
        );

        for (String code : productCodes) {
            assertNotNull(code);
            assertFalse(code.trim().isEmpty());
        }
    }

    // PD_TC_007
    @Then("Category should be available in the response")
    public void categoryShouldBeAvailableInTheResponse() {

        List<String> categories =
                response.jsonPath().getList("Value.category");

        assertNotNull(categories);
        assertFalse(
                "Category is not available",
                categories.isEmpty()
        );

        for (String category : categories) {
            assertNotNull(category);
            assertFalse(category.trim().isEmpty());
        }
    }

    // PD_TC_008
    @Then("Sub Category should be available in the response")
    public void subCategoryShouldBeAvailableInTheResponse() {

        List<String> subCategories =
                response.jsonPath().getList("Value.sub_category");

        assertNotNull(subCategories);
        assertFalse(
                "Sub Category is not available",
                subCategories.isEmpty()
        );

        for (String subCategory : subCategories) {
            assertNotNull(subCategory);
            assertFalse(subCategory.trim().isEmpty());
        }
    }

    // PD_TC_009
    @Then("Brand should be available in the response")
    public void brandShouldBeAvailableInTheResponse() {

        List<String> brands =
                response.jsonPath().getList("Value.brand");

        assertNotNull(brands);
        assertFalse("Brand is not available", brands.isEmpty());

        for (String brand : brands) {
            assertNotNull(brand);
            assertFalse(brand.trim().isEmpty());
        }
    }

    // PD_TC_010
    @Then("Unit should be available in the response")
    public void unitShouldBeAvailableInTheResponse() {

        List<String> units =
                response.jsonPath().getList("Value.unit");

        assertNotNull(units);
        assertFalse("Unit is not available", units.isEmpty());

        for (String unit : units) {
            assertNotNull(unit);
            assertFalse(unit.trim().isEmpty());
        }
    }

    // PD_TC_011
    @Then("Minimum Stock should be available in the response")
    public void minimumStockShouldBeAvailableInTheResponse() {

        List<Object> minimumStocks =
                response.jsonPath().getList("Value.minimum_stock");

        assertNotNull(minimumStocks);
        assertFalse(
                "Minimum Stock is not available",
                minimumStocks.isEmpty()
        );

        for (Object stock : minimumStocks) {
            assertNotNull(stock);
        }
    }

    // PD_TC_012
    // Uses PD_TC_001 status validation
    // Product API response status should be 200

    // PD_TC_013
    @Then("Product API response content type should be application/json")
    public void productAPIResponseContentTypeShouldBeApplicationJson() {

        String contentType = response.getContentType();

        assertNotNull(contentType);

        assertTrue(
                "Expected JSON content type but got: " + contentType,
                contentType.toLowerCase().contains("json")
        );
    }

    // PD_TC_014
    @When("User sends a GET request to the Product API with valid token")
    public void userSendsAGetRequestToTheProductAPIWithValidToken() {

        String url = baseUrl
                + productEndpoint
                + "?business_centre_id=1&skip=0&take=10";

        response = RestAssured.given()
                .header("Authorization", "Bearer " + validToken)
                .when()
                .get(url);

        printResponse();
    }
    // PD_TC_015
    @When("User sends a GET request to the Product API with invalid token")
    public void userSendsAGetRequestToTheProductAPIWithInvalidToken() {

        response = RestAssured.given()
                .header("Authorization", "Bearer INVALID_TOKEN")
                .queryParam("business_centre_id", 1)
                .queryParam("skip", 0)
                .queryParam("take", 10)
                .when()
                .get(baseUrl + productEndpoint);

        printResponse();
    }

    // PD_TC_016
    @When("User sends a GET request to the Product API without token")
    public void userSendsAGetRequestToTheProductAPIWithoutToken() {

        response = RestAssured.given()
                .queryParam("business_centre_id", 1)
                .queryParam("skip", 0)
                .queryParam("take", 10)
                .when()
                .get(baseUrl + productEndpoint);

        printResponse();
    }

    // PD_TC_015 and PD_TC_016
    @Then("Product API response status should be 401")
    public void productAPIResponseStatusShouldBe401() {
        assertEquals(401, response.getStatusCode());
    }

    // PD_TC_017
    @Then("Product API should handle empty Product data")
    public void productAPIShouldHandleEmptyProductData() {

        List<Map<String, Object>> products =
                response.jsonPath().getList("Value");

        assertNotNull(products);

        assertNotEquals(
                "API should not return 500 for empty Product data",
                500,
                response.getStatusCode()
        );
    }

    // PD_TC_018
    @Then("Product API response time should be less than 2000 milliseconds")
    public void productAPIResponseTimeShouldBeLessThan2000Milliseconds() {

        long responseTime = response.getTime();

        assertTrue(
                "Product API response time is greater than 2000 ms. Actual: "
                        + responseTime + " ms",
                responseTime < 2000
        );
    }

    // PD_TC_019
    @Then("Product API should not return 500 Internal Server Error")
    public void productAPIShouldNotReturn500InternalServerError() {

        assertNotEquals(
                "Product API returned 500 Internal Server Error",
                500,
                response.getStatusCode()
        );
    }

    // PD_TC_020
    @When("User sends a GET request to an invalid Product API endpoint")
    public void userSendsAGetRequestToAnInvalidProductAPIEndpoint() {

        response = RestAssured.given()
                .header("Authorization", "Bearer " + validToken)
                .queryParam("business_centre_id", 1)
                .queryParam("skip", 0)
                .queryParam("take", 10)
                .when()
                .get(baseUrl + "/api/product/invalid");

        printResponse();
    }

    // PD_TC_020
    @Then("Product API response status should be 404")
    public void productAPIResponseStatusShouldBe404() {
        assertEquals(404, response.getStatusCode());
    }

    private void printResponse() {

        System.out.println();
        System.out.println("Product GET API");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + " ms");
        System.out.println("Response Body:");
        System.out.println(response.getBody().asPrettyString());
    }
}