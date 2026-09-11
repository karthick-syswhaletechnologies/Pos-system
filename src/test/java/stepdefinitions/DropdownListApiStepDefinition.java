package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DropdownListApiStepDefinition {

    Response response;

    private final String baseUrl = "http://localhost:5001";
    private final String dropdownEndpoint = "/api/dropdown/getall";

    // Use your valid token here
    private final String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibG9naW5fbmFtZSI6InN1cGVyYWRtaW4iLCJidXNpbmVzc19jZW50cmVfaWQiOjEsImJyYW5jaF9jb2RlIjoiU0EwMDEiLCJzdGFmZl9kZXRhaWxzX2lkIjpudWxsLCJyb2xlIjoiU3VwZXJhZG1pbiIsInNoaWZ0X2lkIjoxNTksImxvZ2luIjoiMjAyNi0wOS0wM1QwNjoxNTo0OC4wMDBaIiwibG9nb3V0IjpudWxsLCJpYXQiOjE3ODg0MTYxNDgsImV4cCI6MTc4ODUwMjU0OH0.YlK9pIF7hZouljehQfvIOsPmSx1CEtNp5jFwm_d11AE";

    @When("User sends a GET request to the Dropdown List API")
    public void userSendsAGetRequestToTheDropdownListAPI() {

        response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseUrl + dropdownEndpoint);


        System.out.println("Dropdown List GET API");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + " ms");
        System.out.println("Response Body:");
        System.out.println(response.getBody().asPrettyString());
    }

    // DL_TC_001
    @Then("Dropdown API response status should be 200")
    public void dropdownAPIResponseStatusShouldBe200() {
        assertEquals(200, response.getStatusCode());
    }

    // DL_TC_002
    @Then("Dropdown API response body should not be empty")
    public void dropdownAPIResponseBodyShouldNotBeEmpty() {

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertFalse(response.getBody().asString().isEmpty());
    }

    // DL_TC_003
    @Then("Dropdown API IsSuccess should be true")
    public void dropdownAPIIsSuccessShouldBeTrue() {

        Boolean isSuccess = response.jsonPath().getBoolean("IsSuccess");

        assertNotNull(isSuccess);
        assertTrue(isSuccess);
    }

    // DL_TC_004
    @Then("Dropdown API should return dropdown records")
    public void dropdownAPIShouldReturnDropdownRecords() {

        List<Map<String, Object>> records =
                response.jsonPath().getList("Value");

        assertNotNull(records);
        assertFalse(records.isEmpty());
    }

    // DL_TC_005
    @Then("Dropdown API records should contain valid IDs")
    public void dropdownAPIRecordsShouldContainValidIDs() {

        List<Integer> ids =
                response.jsonPath().getList("Value.id");

        assertNotNull(ids);
        assertFalse(ids.isEmpty());

        for (Integer id : ids) {
            assertNotNull(id);
            assertTrue(id > 0);
        }
    }

    // DL_TC_006
    @Then("Dropdown API records should contain dropdown type")
    public void dropdownAPIRecordsShouldContainDropdownType() {

        List<String> types =
                response.jsonPath().getList("Value.dropdown_type");

        assertNotNull(types);
        assertFalse(types.isEmpty());

        for (String type : types) {
            assertNotNull(type);
            assertFalse(type.trim().isEmpty());
        }
    }

    // DL_TC_007
    @Then("Dropdown API records should contain item name")
    public void dropdownAPIRecordsShouldContainItemName() {

        List<String> itemNames =
                response.jsonPath().getList("Value.item_name");

        assertNotNull(itemNames);
        assertFalse(itemNames.isEmpty());

        for (String itemName : itemNames) {
            assertNotNull(itemName);
            assertFalse(itemName.trim().isEmpty());
        }
    }

    // DL_TC_008
    @Then("Dropdown API records should contain filter by value")
    public void dropdownAPIRecordsShouldContainFilterByValue() {

        List<Map<String, Object>> records =
                response.jsonPath().getList("Value");

        assertNotNull(records);

        for (Map<String, Object> record : records) {
            assertTrue(record.containsKey("filter_by"));
        }
    }

    // DL_TC_009
    @Then("Dropdown API should contain state records")
    public void dropdownAPIShouldContainStateRecords() {

        List<String> types =
                response.jsonPath().getList("Value.dropdown_type");

        assertTrue(types.contains("state"));
    }

    // DL_TC_010
    @Then("Dropdown API should contain country record")
    public void dropdownAPIShouldContainCountryRecord() {

        List<String> types =
                response.jsonPath().getList("Value.dropdown_type");

        assertTrue(types.contains("country"));
    }

    // DL_TC_011
    @Then("Dropdown API should contain district record")
    public void dropdownAPIShouldContainDistrictRecord() {

        List<String> types =
                response.jsonPath().getList("Value.dropdown_type");

        assertTrue(types.contains("district"));
    }

    // DL_TC_012
    @Then("Dropdown API should contain Tamil Nadu state")
    public void dropdownAPIShouldContainTamilNaduState() {

        List<String> itemNames =
                response.jsonPath().getList("Value.item_name");

        assertTrue(itemNames.contains("Tamil Nadu"));
    }

    // DL_TC_013
    @Then("Dropdown API should contain India country")
    public void dropdownAPIShouldContainIndiaCountry() {

        List<String> itemNames =
                response.jsonPath().getList("Value.item_name");

        assertTrue(itemNames.contains("India"));
    }

    // DL_TC_014
    @Then("Dropdown API should contain Chennai record")
    public void dropdownAPIShouldContainChennaiRecord() {

        List<String> itemNames =
                response.jsonPath().getList("Value.item_name");

        assertTrue(itemNames.contains("Chennai"));
    }

    // DL_TC_015
    @Then("Dropdown API total should be 4")
    public void dropdownAPITotalShouldBe4() {

        Integer total = response.jsonPath().getInt("total");

        assertNotNull(total);
        assertEquals(Integer.valueOf(4), total);
    }

    // DL_TC_016
    @Then("Dropdown API skip should be 0")
    public void dropdownAPISkipShouldBe0() {

        Integer skip = response.jsonPath().getInt("skip");

        assertNotNull(skip);
        assertEquals(Integer.valueOf(0), skip);
    }

    // DL_TC_017
    @Then("Dropdown API take should be 9")
    public void dropdownAPITakeShouldBe9() {

        Integer take = response.jsonPath().getInt("take");

        assertNotNull(take);
        assertEquals(Integer.valueOf(9), take);
    }

    // DL_TC_018
    @Then("Dropdown API records should contain valid date fields")
    public void dropdownAPIRecordsShouldContainValidDateFields() {

        List<Map<String, Object>> records =
                response.jsonPath().getList("Value");

        assertNotNull(records);
        assertFalse(records.isEmpty());

        for (Map<String, Object> record : records) {

            assertTrue(record.containsKey("createdAt"));
            assertTrue(record.containsKey("updatedAt"));

            assertNotNull(record.get("createdAt"));
            assertNotNull(record.get("updatedAt"));
        }
    }

    // DL_TC_019
    @Then("Dropdown API Error should be 0")
    public void dropdownAPIErrorShouldBe0() {

        Integer error = response.jsonPath().getInt("Error");

        assertNotNull(error);
        assertEquals(Integer.valueOf(0), error);
    }

    // DL_TC_020
    @Then("Dropdown API Exception should be null")
    public void dropdownAPIExceptionShouldBeNull() {

        Object exception = response.jsonPath().get("Exception");

        assertNull(exception);
    }
}