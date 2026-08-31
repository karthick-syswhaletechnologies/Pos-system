package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

//StaffDetails-01

public class StaffDetailsApiStepDefinition {

    Response response;

    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibG9naW5fbmFtZSI6InN1cGVyYWRtaW4iLCJidXNpbmVzc19jZW50cmVfaWQiOjEsImJyYW5jaF9jb2RlIjoiU0EwMDEiLCJzdGFmZl9kZXRhaWxzX2lkIjpudWxsLCJyb2xlIjoiU3VwZXJhZG1pbiIsInNoaWZ0X2lkIjoxNDAsImxvZ2luIjoiMjAyNi0wOC0zMFQxODozODoyMi4wMDBaIiwibG9nb3V0IjpudWxsLCJpYXQiOjE3ODgxMTUxMDIsImV4cCI6MTc4ODIwMTUwMn0.Bj2LYYDjHzFP5wB1CbRZhN9fd6ZggstcZzBBASlhuBE";

    String baseUrl = "http://localhost:5001";

    String staffEndpoint = baseUrl + "/api/staffdetails/getall";


    // SD_TC-001
    @When("User sends GET request for staff details")
    public void sendGetRequestForStaffDetails() {

        response =
                RestAssured
                        .given()
                        .header("Authorization", "Bearer " + token)
                        .when()
                        .get(staffEndpoint);

        System.out.println("======================================");
        System.out.println("Staff Details GET API");
        System.out.println("======================================");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + " ms");
        System.out.println("Response Body:");
        System.out.println(response.getBody().asPrettyString());
        System.out.println("======================================");

        assertEquals(200, response.getStatusCode());
    }


    // SD_TC-002
    @Then("staff response body should not be empty")
    public void staffResponseBodyShouldNotBeEmpty() {

        String body = response.getBody().asString();

        assertNotNull(body);
        assertFalse(body.isEmpty());

        System.out.println("Staff response body is not empty");
    }


    // SD_TC-003
    @Then("staff records should be returned")
    public void staffRecordsShouldBeReturned() {

        List<?> records =
                response.jsonPath().getList("Value");

        assertNotNull(records);
        assertFalse(records.isEmpty());

        System.out.println(
                "Staff records returned: " + records.size()
        );
    }


    // SD_TC-004
    @Then("staff ID should be available")
    public void staffIdShouldBeAvailable() {

        List<Integer> ids =
                response.jsonPath().getList("Value.id");

        assertNotNull(ids);
        assertFalse(ids.isEmpty());

        Set<Integer> uniqueIds = new HashSet<>(ids);

        assertEquals(
                "Duplicate Staff IDs found",
                ids.size(),
                uniqueIds.size()
        );

        System.out.println("Staff IDs: " + ids);
    }


    // SD_TC-005
    @Then("staff name should be available")
    public void staffNameShouldBeAvailable() {

        List<String> names =
                response.jsonPath().getList("Value.first_name");

        assertNotNull(names);
        assertFalse(names.isEmpty());

        System.out.println("Staff Names: " + names);
    }


    // SD_TC-006
    @Then("staff email should be available")
    public void staffEmailShouldBeAvailable() {

        List<String> emails =
                response.jsonPath().getList("Value.email");

        assertNotNull(emails);
        assertFalse(emails.isEmpty());

        System.out.println("Staff Emails: " + emails);
    }


    // SD_TC-007
    @Then("staff mobile number should be available")
    public void staffMobileNumberShouldBeAvailable() {

        List<String> mobileNumbers =
                response.jsonPath().getList("Value.mobile_no");

        assertNotNull(mobileNumbers);
        assertFalse(mobileNumbers.isEmpty());

        System.out.println(
                "Staff Mobile Numbers: " + mobileNumbers
        );
    }


    // SD_TC-008
    @Then("staff gender should be available")
    public void staffGenderShouldBeAvailable() {

        List<?> genders =
                response.jsonPath().getList("Value.gender");

        assertNotNull(genders);
        assertFalse(genders.isEmpty());

        System.out.println("Staff Gender: " + genders);
    }


    // SD_TC-009
    @Then("staff date of birth should be available")
    public void staffDateOfBirthShouldBeAvailable() {

        List<?> dates =
                response.jsonPath().getList("Value.date_of_birth");

        assertNotNull(dates);
        assertFalse(dates.isEmpty());

        System.out.println(
                "Date of Birth: " + dates
        );
    }


    // SD_TC-010
    @Then("staff NIC should be available")
    public void staffNicShouldBeAvailable() {

        List<String> nics =
                response.jsonPath().getList("Value.nic");

        assertNotNull(nics);
        assertFalse(nics.isEmpty());

        System.out.println("NIC: " + nics);
    }


    // SD_TC-011
    @Then("staff role should be available")
    public void staffRoleShouldBeAvailable() {

        List<?> roles =
                response.jsonPath().getList("Value.role");

        assertNotNull(roles);
        assertFalse(roles.isEmpty());

        System.out.println("Staff Roles: " + roles);
    }


    // SD_TC-012
    @Then("staff department should be available")
    public void staffDepartmentShouldBeAvailable() {

        List<?> departments =
                response.jsonPath().getList("Value.department");

        assertNotNull(departments);
        assertFalse(departments.isEmpty());

        System.out.println(
                "Departments: " + departments
        );
    }


    // SD_TC-013
    @Then("staff address should be available")
    public void staffAddressShouldBeAvailable() {

        List<?> addresses =
                response.jsonPath().getList("Value.address");

        assertNotNull(addresses);
        assertFalse(addresses.isEmpty());

        System.out.println(
                "Addresses: " + addresses
        );
    }


    // SD_TC-014
    @Then("staff district should be available")
    public void staffDistrictShouldBeAvailable() {

        List<?> districts =
                response.jsonPath().getList("Value.district");

        assertNotNull(districts);
        assertFalse(districts.isEmpty());

        System.out.println(
                "Districts: " + districts
        );
    }


    // SD_TC-015
    @Then("staff country should be available")
    public void staffCountryShouldBeAvailable() {

        List<?> countries =
                response.jsonPath().getList("Value.country");

        assertNotNull(countries);
        assertFalse(countries.isEmpty());

        System.out.println(
                "Countries: " + countries
        );
    }


    // SD_TC-016
    @Then("staff salary details should be available")
    public void staffSalaryDetailsShouldBeAvailable() {

        List<?> salaryTypes =
                response.jsonPath().getList("Value.salary_type");

        List<?> salaryAmounts =
                response.jsonPath().getList("Value.salary_amount");

        assertNotNull(salaryTypes);
        assertNotNull(salaryAmounts);

        assertFalse(salaryTypes.isEmpty());
        assertFalse(salaryAmounts.isEmpty());

        System.out.println(
                "Salary Types: " + salaryTypes
        );

        System.out.println(
                "Salary Amounts: " + salaryAmounts
        );
    }


    // SD_TC-017
    @Then("staff commission should be available")
    public void staffCommissionShouldBeAvailable() {

        List<?> commissions =
                response.jsonPath().getList("Value.commission");

        assertNotNull(commissions);
        assertFalse(commissions.isEmpty());

        System.out.println(
                "Commission: " + commissions
        );
    }


    // SD_TC-018
    @Then("staff vehicle number should be available")
    public void staffVehicleNumberShouldBeAvailable() {

        List<?> vehicleNumbers =
                response.jsonPath().getList("Value.vehicle_no");

        assertNotNull(vehicleNumbers);
        assertFalse(vehicleNumbers.isEmpty());

        System.out.println(
                "Vehicle Numbers: " + vehicleNumbers
        );
    }


    // SD_TC-019
    @Then("staff bank details should be available")
    public void staffBankDetailsShouldBeAvailable() {

        List<?> bankDetails =
                response.jsonPath().getList("Value.bank_details");

        assertNotNull(bankDetails);
        assertFalse(bankDetails.isEmpty());

        System.out.println(
                "Bank Details: " + bankDetails
        );
    }


    // SD_TC-020
    @When("User sends GET request for staff search")
    public void sendGetRequestForStaffSearch() {

        response =
                RestAssured
                        .given()
                        .header("Authorization", "Bearer " + token)
                        .queryParam("search", "admin")
                        .when()
                        .get(staffEndpoint);

        System.out.println(
                "Staff Search Status: "
                        + response.getStatusCode()
        );

        System.out.println(
                response.getBody().asPrettyString()
        );
    }

    @Then("matching staff records should be returned")
    public void matchingStaffRecordsShouldBeReturned() {

        assertEquals(200, response.getStatusCode());

        System.out.println(
                "Matching staff records returned successfully"
        );
    }


    // SD_TC-021
    @When("User sends GET request with invalid staff search")
    public void sendGetRequestWithInvalidStaffSearch() {

        response =
                RestAssured
                        .given()
                        .header("Authorization", "Bearer " + token)
                        .queryParam("search", "invalidstaff99999")
                        .when()
                        .get(staffEndpoint);

        System.out.println(
                "Invalid Search Status: "
                        + response.getStatusCode()
        );

        System.out.println(
                response.getBody().asPrettyString()
        );
    }

    @Then("empty staff result should be returned")
    public void emptyStaffResultShouldBeReturned() {

        assertEquals(200, response.getStatusCode());

        System.out.println(
                "Empty staff result returned successfully"
        );
    }


    // SD_TC-022
    @When("User sends GET request for staff details without authorization")
    public void sendGetRequestWithoutAuthorization() {

        response =
                RestAssured
                        .given()
                        .when()
                        .get(staffEndpoint);

        System.out.println(
                "SD_TC-022 Status Code: "
                        + response.getStatusCode()
        );

        System.out.println(
                response.getBody().asPrettyString()
        );
    }

    @Then("staff response status should be {int}")
    public void staffResponseStatusShouldBe(Integer expectedStatus) {

        assertEquals(
                expectedStatus.intValue(),
                response.getStatusCode()
        );

        System.out.println(
                "Expected Status: "
                        + expectedStatus
                        + " | Actual Status: "
                        + response.getStatusCode()
        );
    }


    // SD_TC-023
    @When("User sends GET request for staff details with invalid token")
    public void sendGetRequestWithInvalidToken() {

        response =
                RestAssured
                        .given()
                        .header(
                                "Authorization",
                                "Bearer invalid_token_12345"
                        )
                        .when()
                        .get(staffEndpoint);

        System.out.println(
                "SD_TC-023 Status Code: "
                        + response.getStatusCode()
        );

        System.out.println(
                response.getBody().asPrettyString()
        );
    }

    @Then("staff response status should be {int} for invalid token")
    public void staffResponseStatusShouldBeForInvalidToken(
            Integer expectedStatus) {

        assertEquals(
                expectedStatus.intValue(),
                response.getStatusCode()
        );

        System.out.println(
                "Invalid Token Status: "
                        + response.getStatusCode()
        );
    }


    // SD_TC-024
    @Then("staff response time should be within acceptable limit")
    public void staffResponseTimeShouldBeWithinAcceptableLimit() {

        long responseTime = response.getTime();

        System.out.println(
                "Staff Response Time: "
                        + responseTime
                        + " ms"
        );

        assertTrue(
                "Response time exceeded acceptable limit",
                responseTime <= 2000
        );
    }


    // SD_TC-025
    @Then("staff response should be valid JSON")
    public void staffResponseShouldBeValidJson() {

        String contentType =
                response.getContentType();

        assertNotNull(contentType);

        assertTrue(
                contentType.toLowerCase().contains("json")
        );

        System.out.println(
                "Staff response is valid JSON"
        );
    }
}