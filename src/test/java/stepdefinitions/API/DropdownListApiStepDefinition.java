package stepdefinitions.API;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DropdownListStepDefinition {

    private Response response;

    // Change this to your actual base URL
    private final String baseUrl = "http://localhost;5001";

    // Change this to your actual POST endpoint
    private final String endpoint = "/api/dropdown";

    @Given("the Dropdown List API is available")
    public void dropdownListApiIsAvailable() {

        RestAssured.baseURI = baseUrl;

        System.out.println("Base URL: " + RestAssured.baseURI);
    }

    @When("I send a POST request to create dropdown item with the following details")
    public void sendPostRequestToCreateDropdownItem(DataTable dataTable) {

        Map<String, String> data = dataTable.asMap(String.class, String.class);

        String dropdownType = data.get("dropdownType");
        String filterBy = data.get("filterBy");
        String itemName = data.get("itemName");

        String requestBody = "{"
                + "\"dropdown_type\":\"" + dropdownType + "\","
                + "\"filter_by\":\"" + filterBy + "\","
                + "\"item_name\":\"" + itemName + "\""
                + "}";

        System.out.println("Request Body:");
        System.out.println(requestBody);

        response =
                given()
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .body(requestBody)
                        .when()
                        .post(endpoint)
                        .then()
                        .extract()
                        .response();

        System.out.println("Status Code: "
                + response.getStatusCode());

        System.out.println("Response:");
        System.out.println(response.asPrettyString());
    }

    @Then("the response status code should be {int}")
    public void responseStatusCodeShouldBe(int expectedStatusCode) {

        response.then()
                .statusCode(expectedStatusCode);
    }

    @Then("the response should indicate success")
    public void responseShouldIndicateSuccess() {

        response.then()
                .body("IsSuccess", equalTo(true));
    }

    @Then("the response should contain the dropdown item {string}")
    public void responseShouldContainDropdownItem(String itemName) {

        String responseBody = response.asString();

        assert responseBody.contains(itemName) :
                "Response does not contain item: " + itemName;
    }
}