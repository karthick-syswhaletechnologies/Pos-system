package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CustomerDetailsApiSteps {

    private Response response;

    private String baseUrl = "http://127.0.0.1:5001";

    // CHANGE THIS TO YOUR ACTUAL CUSTOMER DETAILS ENDPOINT
    private String endpoint = "/customers/{id}";

    private String validToken = "--------";

    private String customerId;


    // BACKGROUND

    @Given("the Customer Details API is available")
    public void customerDetailsApiIsAvailable() {

        RestAssured.baseURI = baseUrl;
    }


    // GET REQUEST WITH VALID TOKEN

    @When("I send GET request for customer ID {string} with valid authorization")
    public void sendGetRequestWithValidAuthorization(String id) {

        customerId = id;

        response =
                given()
                        .header("Authorization", "Bearer " + validToken)
                        .pathParam("id", customerId)
                        .when()
                        .get(endpoint)
                        .then()
                        .extract()
                        .response();
    }


    // GET REQUEST WITHOUT TOKEN

    @When("I send GET request for customer ID {string} without authorization")
    public void sendGetRequestWithoutAuthorization(String id) {

        customerId = id;

        response =
                given()
                        .pathParam("id", customerId)
                        .when()
                        .get(endpoint)
                        .then()
                        .extract()
                        .response();
    }


    // STATUS CODE

    @Then("the response status code should be {int}")
    public void responseStatusCodeShouldBe(int expectedStatusCode) {

        response.then()
                .statusCode(expectedStatusCode);
    }



    // CONTENT TYPE


    @Then("the response Content-Type should be {string}")
    public void responseContentTypeShouldBe(String expectedContentType) {

        response.then()
                .contentType(expectedContentType);
    }



    // CUSTOMER DETAILS

    @Then("the response should contain customer details")
    public void responseShouldContainCustomerDetails() {

        response.then()
                .body("Value", notNullValue());
    }


    @Then("the response should contain customer ID")
    public void responseShouldContainCustomerId() {

        response.then()
                .body("Value[0].id", notNullValue());
    }


    @Then("the response should contain customer shop name")
    public void responseShouldContainCustomerShopName() {

        response.then()
                .body("Value[0].customer_shop_name", notNullValue());
    }


    @Then("the response should contain customer code number")
    public void responseShouldContainCustomerCodeNumber() {

        response.then()
                .body("Value[0].code_no", notNullValue());
    }


    // --------------------------------------------------
    // CUSTOMER FIELDS
    // --------------------------------------------------

    @Then("the customer ID should be returned correctly")
    public void customerIdShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].id", equalTo(Integer.parseInt(customerId)));
    }


    @Then("the customer shop name should be returned correctly")
    public void customerShopNameShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].customer_shop_name", notNullValue());
    }


    @Then("the customer code number should be returned correctly")
    public void customerCodeNumberShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].code_no", notNullValue());
    }


    @Then("the customer nickname should be returned correctly")
    public void customerNicknameShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].nick_name", notNullValue());
    }


    @Then("the customer mobile number should be returned correctly")
    public void customerMobileNumberShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].mobile_no", notNullValue());
    }


    @Then("the customer telephone number should be returned correctly")
    public void customerTelephoneNumberShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].telephone_no", notNullValue());
    }


    @Then("the customer email should be returned correctly")
    public void customerEmailShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].email", notNullValue());
    }


    @Then("the customer gender should be returned correctly")
    public void customerGenderShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].gender", notNullValue());
    }


    @Then("the customer date of birth should be returned correctly")
    public void customerDateOfBirthShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].dob", notNullValue());
    }


    @Then("the customer NIC should be returned correctly")
    public void customerNICShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].nic", notNullValue());
    }


    @Then("the permanent address should be returned correctly")
    public void permanentAddressShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].permanent_address", notNullValue());
    }


    @Then("the district should be returned correctly")
    public void districtShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].district", notNullValue());
    }


    @Then("the state should be returned correctly")
    public void stateShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].state", notNullValue());
    }


    @Then("the country should be returned correctly")
    public void countryShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].country", notNullValue());
    }


    @Then("the customer join date should be returned correctly")
    public void customerJoinDateShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].join_date", notNullValue());
    }


    @Then("the VAT number should be returned correctly")
    public void vatNumberShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].vat_no", notNullValue());
    }


    @Then("the VAT percentage should be returned correctly")
    public void vatPercentageShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].vat_percentage", notNullValue());
    }


    @Then("the credit limit should be returned correctly")
    public void creditLimitShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].credit_limit", notNullValue());
    }


    @Then("the due days should be returned correctly")
    public void dueDaysShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].due_days", notNullValue());
    }


    @Then("the current credit balance should be returned correctly")
    public void currentCreditBalanceShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].current_credit_balance", notNullValue());
    }


    @Then("the customer status should be returned correctly")
    public void customerStatusShouldBeReturnedCorrectly() {

        response.then()
                .body("Value[0].status", notNullValue());
    }



    // SECURITY

    @Then("customer data should not be exposed")
    public void customerDataShouldNotBeExposed() {

        response.then()
                .body("Value", anyOf(nullValue(), empty()));
    }
}