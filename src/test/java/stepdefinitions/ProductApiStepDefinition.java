package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class ProductApiStepDefinition {

    Response response;

    String baseUrl = "http://localhost:5001";

    String productEndpoint = "/api/product/get?business_centre_id=1&skip=0&take=10";

    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibG9naW5fbmFtZSI6InN1cGVyYWRtaW4iLCJidXNpbmVzc19jZW50cmVfaWQiOjEsImJyYW5jaF9jb2RlIjoiU0EwMDEiLCJzdGFmZl9kZXRhaWxzX2lkIjpudWxsLCJyb2xlIjoiU3VwZXJhZG1pbiIsInNoaWZ0X2lkIjoxNjYsImxvZ2luIjoiMjAyNi0wOS0xMFQwNDo0MjozMy4wMDBaIiwibG9nb3V0IjpudWxsLCJpYXQiOjE3ODkwMTUzNTMsImV4cCI6MTc4OTEwMTc1M30.M79MezC2R1XHI942ve-MkWYnNt1pVpyf3c9jPEvJYHU";


    // PD_TC_001
    @When("User sends a GET request to the Product API")
    public void userSendsAGetRequestToTheProductAPI() {
        sendValidRequest();
    }

    @Then("the response status code should be 200")
    public void theResponseStatusCodeShouldBe200() {
        assertEquals(200, response.getStatusCode());
    }


    // PD_TC_002
    @Then("the response body should not be empty")
    public void theResponseBodyShouldNotBeEmpty() {

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertFalse(response.getBody().asString().isEmpty());
    }


    // PD_TC_003
    @Then("product records should be returned")
    public void productRecordsShouldBeReturned() {

        List<?> records =
                response.jsonPath().getList("Value");

        assertNotNull(records);
        assertFalse(records.isEmpty());
    }


    // PD_TC_004
    @Then("Product ID should be available in the response")
    public void productIdShouldBeAvailableInTheResponse() {

        List<?> ids =
                response.jsonPath().getList("Value.id");

        assertNotNull(ids);
        assertFalse(ids.isEmpty());
    }


    // PD_TC_005
    @Then("Product Name should be available in the response")
    public void productNameShouldBeAvailableInTheResponse() {

        List<?> names =
                response.jsonPath().getList("Value.product_name");

        assertNotNull(names);
        assertFalse(names.isEmpty());
    }


    // PD_TC_006
    @Then("Product Code should be available in the response")
    public void productCodeShouldBeAvailableInTheResponse() {

        List<?> codes =
                response.jsonPath().getList("Value.product_code");

        assertNotNull(codes);
        assertFalse(codes.isEmpty());
    }


    // PD_TC_007
    @Then("Category should be available in the response")
    public void categoryShouldBeAvailableInTheResponse() {

        List<?> categories =
                response.jsonPath().getList("Value.category");

        assertNotNull(categories);
        assertFalse(categories.isEmpty());
    }


    // PD_TC_008
    @Then("Sub Category should be available in the response")
    public void subCategoryShouldBeAvailableInTheResponse() {

        List<?> subCategories =
                response.jsonPath().getList("Value.sub_category");

        assertNotNull(subCategories);
        assertFalse(subCategories.isEmpty());
    }


    // PD_TC_009
    @Then("Brand should be available in the response")
    public void brandShouldBeAvailableInTheResponse() {

        List<?> brands =
                response.jsonPath().getList("Value.brand");

        assertNotNull(brands);
        assertFalse(brands.isEmpty());
    }


    // PD_TC_010
    @Then("Product Status should be available in the response")
    public void productStatusShouldBeAvailableInTheResponse() {

        List<?> statuses =
                response.jsonPath().getList("Value.status");

        assertNotNull(statuses);
        assertFalse(statuses.isEmpty());
    }


    // PD_TC_011
    @When("User sends a GET request with a valid product search value")
    public void userSendsAGetRequestWithAValidProductSearchValue() {

        response =
                RestAssured
                        .given()
                        .header(
                                "Authorization",
                                "Bearer " + token
                        )
                        .queryParam("search", "product")
                        .when()
                        .get(baseUrl + productEndpoint);
    }

    @Then("matching product records should be returned")
    public void matchingProductRecordsShouldBeReturned() {

        assertEquals(200, response.getStatusCode());
    }


    // PD_TC_012
    @When("User sends a GET request with a non-existing product value")
    public void userSendsAGetRequestWithANonExistingProductValue() {

        response =
                RestAssured
                        .given()
                        .header(
                                "Authorization",
                                "Bearer " + token
                        )
                        .queryParam(
                                "search",
                                "xyz_no_product_999999"
                        )
                        .when()
                        .get(baseUrl + productEndpoint);
    }

    @Then("empty product result should be returned")
    public void emptyProductResultShouldBeReturned() {

        assertEquals(200, response.getStatusCode());

        List<?> records =
                response.jsonPath().getList("Value");

        assertTrue(
                records == null || records.isEmpty()
        );
    }


    // PD_TC_013
    @When("User sends a GET request without authorization")
    public void userSendsAGetRequestWithoutAuthorization() {

        response =
                RestAssured
                        .given()
                        .when()
                        .get(baseUrl + productEndpoint);
    }

    @Then("the response status code should be 401")
    public void theResponseStatusCodeShouldBe401() {

        assertEquals(401, response.getStatusCode());
    }


    // PD_TC_014
    @When("User sends a GET request with an invalid authorization token")
    public void userSendsAGetRequestWithAnInvalidAuthorizationToken() {

        response =
                RestAssured
                        .given()
                        .header(
                                "Authorization",
                                "Bearer invalid_token_123"
                        )
                        .when()
                        .get(baseUrl + productEndpoint);
    }


    // PD_TC_015
    @Then("the response should be in valid JSON format")
    public void theResponseShouldBeInValidJSONFormat() {

        String body =
                response.getBody().asString();

        assertNotNull(body);
        assertFalse(body.isEmpty());

        try {
            response.jsonPath();
        } catch (Exception e) {
            fail("Response is not valid JSON");
        }
    }

    // PD_TC_016
    @Then("the response content type should be application/json")
    public void theResponseContentTypeShouldBeApplicationJson() {

        String contentType =
                response.getContentType();

        assertNotNull(contentType);

        assertTrue("Expected JSON content type but got"+contentType,
                contentType
                        .toLowerCase()
                        .contains("json")
        );
    }


    // PD_TC_017
    @Then("the response time should be less than 2 seconds")
    public void theResponseTimeShouldBeLessThan2Seconds() {

        assertTrue(
                "Response time exceeded 2 seconds",
                response.getTime() <= 2000
        );
    }


    // PD_TC_018
    @Then("duplicate Product IDs should not exist")
    public void duplicateProductIdsShouldNotExist() {

        List<Integer> ids =
                response.jsonPath().getList("Value.id");

        assertNotNull(ids);

        Set<Integer> uniqueIds =
                new HashSet<>(ids);

        assertEquals(
                "Duplicate Product IDs found",
                ids.size(),
                uniqueIds.size()
        );
    }


    // PD_TC_019
    @Then("Product ID should have the expected data type")
    public void productIdShouldHaveTheExpectedDataType() {

        List<?> ids =
                response.jsonPath().getList("Value.id");

        assertNotNull(ids);

        for (Object id : ids) {
            assertTrue(
                    "Product ID is not a number",
                    id instanceof Number
            );
        }
    }


    // PD_TC_020
    @Then("the returned product record count should be valid")
    public void theReturnedProductRecordCountShouldBeValid() {

        List<?> records =
                response.jsonPath().getList("Value");

        assertNotNull(records);

        int total =
                response.jsonPath().getInt("Total");

        assertEquals(
                (int) total,
                records.size()
        );
    }


    // Common GET request
    private void sendValidRequest() {

        response =
                RestAssured
                        .given()
                        .header(
                                "Authorization",
                                "Bearer " + token
                        )
                        .when()
                        .get(baseUrl + productEndpoint);
        System.out.println("Product GET API");
        System.out.println(
                "Status Code: " +
                        response.getStatusCode()
        );
        System.out.println(
                "Response Time: " +
                        response.getTime() +
                        " ms"
        );
        System.out.println("Response Body:");
        System.out.println(
                response.getBody().asPrettyString()
        );
    }
}