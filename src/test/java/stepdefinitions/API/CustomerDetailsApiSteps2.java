package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CustomerDetailsApiSteps2 {

    private Response response;


//     Change this to your actual API base URL

    private final String BASE_URL = "http://127.0.0.1:5001";

    /*
     * Change this to your actual Customer Details endpoint
     *

     * /api/customers/{id}
     */
    private final String CUSTOMER_ENDPOINT = "/api/customers/{id}";

    /*
     * Replace with your actual token
     */
    private final String TOKEN = "-----------";

    private String customerId;



    // BACKGROUND

    @Given("Customer Details API is available")
    public void customerDetailsApiIsAvailable() {

        RestAssured.baseURI = BASE_URL;
    }



    // GET REQUEST WITH AUTHORIZATION


    @When("I send GET request for customer ID {string}")
    public void sendGetRequestForCustomerId(String id) {

        customerId = id;

        response =
                given()
                        .header(
                                "Authorization",
                                "Bearer " + TOKEN
                        )
                        .pathParam(
                                "id",
                                customerId
                        )
                        .when()
                        .get(CUSTOMER_ENDPOINT)
                        .then()
                        .extract()
                        .response();
    }



    // GET REQUEST WITHOUT AUTHORIZATION


    @When("I send GET request for customer ID {string} without authorization")
    public void sendGetRequestWithoutAuthorization(String id) {

        customerId = id;

        response =
                given()
                        .pathParam(
                                "id",
                                customerId
                        )
                        .when()
                        .get(CUSTOMER_ENDPOINT)
                        .then()
                        .extract()
                        .response();
    }



    // STATUS CODE

    @Then("response status code should be {int}")
    public void responseStatusCodeShouldBe(int statusCode) {

        response.then()
                .statusCode(statusCode);
    }



    // CONTENT TYPE

    @Then("response Content-Type should be {string}")
    public void responseContentTypeShouldBe(String contentType) {

        response.then()
                .contentType(contentType);
    }



    // CUSTOMER DETAILS

    @Then("customer details should be returned")
    public void customerDetailsShouldBeReturned() {

        response.then()
                .body("Value", notNullValue())
                .body("Value", not(empty()));
    }


    // GENERIC FIELD VALIDATION

    @Then("response field {string} should be present")
    public void responseFieldShouldBePresent(String fieldName) {

        response.then()
                .body(
                        "Value[0]." + fieldName,
                        notNullValue()
                );
    }


    // AUTHORIZATION VALIDATION

    @Then("customer data should not be exposed")
    public void customerDataShouldNotBeExposed() {

        response.then()
                .body(
                        "Value",
                        anyOf(
                                nullValue(),
                                empty()
                        )
                );
    }
}