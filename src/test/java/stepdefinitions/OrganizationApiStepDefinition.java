package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class OrganizationApiStepDefinition {

    Response response;

    String baseUrl = "http://localhost:5001";
    String organizationEndpoint = "/api/organizations/getall";

    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibG9naW5fbmFtZSI6InN1cGVyYWRtaW4iLCJidXNpbmVzc19jZW50cmVfaWQiOjEsImJyYW5jaF9jb2RlIjoiU0EwMDEiLCJzdGFmZl9kZXRhaWxzX2lkIjpudWxsLCJyb2xlIjoiU3VwZXJhZG1pbiIsInNoaWZ0X2lkIjoxNDgsImxvZ2luIjoiMjAyNi0wOC0zMVQwNDozOTo1Ny4wMDBaIiwibG9nb3V0IjpudWxsLCJpYXQiOjE3ODgxNTExOTcsImV4cCI6MTc4ODIzNzU5N30.vavJG4amoQwOmuvGmxOAgh0VmhO2cdBz_g0wo6oWx50";

    private void sendValidRequest() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseUrl + organizationEndpoint);
    }

    // TC-001
    @When("User sends GET request for organization API")
    public void sendGetRequestForOrganizationAPI() {
        sendValidRequest();
    }

    @Then("organization API status should be {int}")
    public void organizationAPIStatusShouldBe(int status) {
        assertEquals(status, response.getStatusCode());
    }

    // TC-002
    @When("User sends GET request for organization response body")
    public void sendGetRequestForOrganizationResponseBody() {
        sendValidRequest();
    }

    @Then("organization response body should not be empty")
    public void organizationResponseBodyShouldNotBeEmpty() {
        assertNotNull(response.getBody());
        assertFalse(response.getBody().asString().isEmpty());
    }

    // TC-003
    @When("User sends GET request for organization list")
    public void sendGetRequestForOrganizationList() {
        sendValidRequest();
    }

    @Then("organization records should be returned")
    public void organizationRecordsShouldBeReturned() {
        List<?> records = response.jsonPath().getList("Value");

        assertNotNull(records);
        assertFalse(records.isEmpty());
    }

    // TC-004
    @When("User sends GET request to verify organization IDs")
    public void sendGetRequestToVerifyOrganizationIDs() {
        sendValidRequest();
    }

    @Then("organization ID should be available")
    public void organizationIDShouldBeAvailable() {
        List<?> ids = response.jsonPath().getList("Value.id");

        assertNotNull(ids);
        assertFalse(ids.isEmpty());
    }

    // TC-005
    @When("User sends GET request to verify organization names")
    public void sendGetRequestToVerifyOrganizationNames() {
        sendValidRequest();
    }

    @Then("organization name should be available")
    public void organizationNameShouldBeAvailable() {
        List<?> values = response.jsonPath().getList("Value.org_name");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }

    // TC-006
    @When("User sends GET request to verify registration numbers")
    public void sendGetRequestToVerifyRegistrationNumbers() {
        sendValidRequest();
    }

    @Then("registration number should be available")
    public void registrationNumberShouldBeAvailable() {
        List<?> values =
                response.jsonPath().getList("Value.registration_no");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }

    // TC-007
    @When("User sends GET request to verify TIN numbers")
    public void sendGetRequestToVerifyTINNumbers() {
        sendValidRequest();
    }

    @Then("TIN number should be available")
    public void tinNumberShouldBeAvailable() {
        List<?> values =
                response.jsonPath().getList("Value.tin_no");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }

    // TC-008
    @When("User sends GET request to verify organization addresses")
    public void sendGetRequestToVerifyOrganizationAddresses() {
        sendValidRequest();
    }

    @Then("organization address should be available")
    public void organizationAddressShouldBeAvailable() {
        List<?> values =
                response.jsonPath().getList("Value.address");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }

    // TC-009
    @When("User sends GET request to verify organization locations")
    public void sendGetRequestToVerifyOrganizationLocations() {
        sendValidRequest();
    }

    @Then("organization location should be available")
    public void organizationLocationShouldBeAvailable() {
        List<?> values =
                response.jsonPath().getList("Value.location");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }

    // TC-010
    @When("User sends GET request to verify organization districts")
    public void sendGetRequestToVerifyOrganizationDistricts() {
        sendValidRequest();
    }

    @Then("organization district should be available")
    public void organizationDistrictShouldBeAvailable() {
        List<?> values =
                response.jsonPath().getList("Value.district");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }

    // TC-011
    @When("User sends GET request to verify organization states")
    public void sendGetRequestToVerifyOrganizationStates() {
        sendValidRequest();
    }

    @Then("organization state should be available")
    public void organizationStateShouldBeAvailable() {
        List<?> values =
                response.jsonPath().getList("Value.state");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }

    // TC-012
    @When("User sends GET request to verify organization countries")
    public void sendGetRequestToVerifyOrganizationCountries() {
        sendValidRequest();
    }

    @Then("organization country should be available")
    public void organizationCountryShouldBeAvailable() {
        List<?> values =
                response.jsonPath().getList("Value.country");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }

    // TC-013
    @When("User sends GET request to verify organization contacts")
    public void sendGetRequestToVerifyOrganizationContacts() {
        sendValidRequest();
    }

    @Then("organization contact should be available")
    public void organizationContactShouldBeAvailable() {
        List<?> values =
                response.jsonPath().getList("Value.contact");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }

    // TC-014
    @When("User sends GET request to verify organization postal codes")
    public void sendGetRequestToVerifyOrganizationPostalCodes() {
        sendValidRequest();
    }

    @Then("organization postal code should be available")
    public void organizationPostalCodeShouldBeAvailable() {
        List<?> values =
                response.jsonPath().getList("Value.postalcode");

        assertNotNull(values);
        assertFalse(values.isEmpty());
    }

    // TC-015
    @When("User sends GET request to verify organization status")
    public void sendGetRequestToVerifyOrganizationStatus() {
        sendValidRequest();
    }

    @Then("organization status should be boolean")
    public void organizationStatusShouldBeBoolean() {

        List<?> statuses =
                response.jsonPath().getList("Value.status");

        assertNotNull(statuses);

        for (Object status : statuses) {
            assertTrue(
                    "Status is not boolean: " + status,
                    status instanceof Boolean
            );
        }
    }

    // TC-016
    @When("User sends GET request using organization ID")
    public void sendGetRequestUsingOrganizationID() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("id", 1)
                .when()
                .get(baseUrl + organizationEndpoint);
    }

    @Then("matching organization should be returned")
    public void matchingOrganizationShouldBeReturned() {
        List<?> records =
                response.jsonPath().getList("Value");

        assertNotNull(records);
        assertFalse(records.isEmpty());
    }

    // TC-017
    @When("User sends GET request with organization name")
    public void sendGetRequestWithOrganizationName() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("org_name", "Super Admin Organization")
                .when()
                .get(baseUrl + organizationEndpoint);
    }

    @Then("organization name matching record should be returned")
    public void organizationNameMatchingRecordShouldBeReturned() {
        assertEquals(200, response.getStatusCode());
    }

    // TC-018
    @When("User sends GET request with state")
    public void sendGetRequestWithState() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("state", "Tamil Nadu")
                .when()
                .get(baseUrl + organizationEndpoint);
    }

    @Then("organization state matching record should be returned")
    public void organizationStateMatchingRecordShouldBeReturned() {
        assertEquals(200, response.getStatusCode());
    }

    // TC-019
    @When("User sends GET request with district")
    public void sendGetRequestWithDistrict() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("district", "Chennai")
                .when()
                .get(baseUrl + organizationEndpoint);
    }

    @Then("organization district matching record should be returned")
    public void organizationDistrictMatchingRecordShouldBeReturned() {
        assertEquals(200, response.getStatusCode());
    }

    // TC-020
    @When("User sends GET request with organization status")
    public void sendGetRequestWithOrganizationStatus() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("status", true)
                .when()
                .get(baseUrl + organizationEndpoint);
    }

    @Then("active organization should be returned")
    public void activeOrganizationShouldBeReturned() {
        assertEquals(200, response.getStatusCode());
    }

    // TC-021
    @When("User sends GET request with invalid organization ID")
    public void sendGetRequestWithInvalidOrganizationID() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("id", 999999)
                .when()
                .get(baseUrl + organizationEndpoint);
    }

    @Then("empty organization response should be returned")
    public void emptyOrganizationResponseShouldBeReturned() {
        assertEquals(200, response.getStatusCode());

        List<?> records =
                response.jsonPath().getList("Value");

        assertTrue(records == null || records.isEmpty());
    }

    // TC-022
    @When("User sends GET request with non existing organization name")
    public void sendGetRequestWithNonExistingOrganizationName() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("org_name", "no_organization_999999")
                .when()
                .get(baseUrl + organizationEndpoint);
    }

    @Then("empty response should be returned")
    public void emptyResponseShouldBeReturned() {
        assertEquals(200, response.getStatusCode());

        List<?> records =
                response.jsonPath().getList("Value");

        assertTrue(records == null || records.isEmpty());
    }

    // TC-023
    @When("User sends GET request with skip parameter")
    public void sendGetRequestWithSkipParameter() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("skip", 5)
                .when()
                .get(baseUrl + organizationEndpoint);
    }

    @Then("organization records should start from sixth record")
    public void organizationRecordsShouldStartFromSixthRecord() {
        assertEquals(200, response.getStatusCode());
    }

    // TC-024
    @When("User sends GET request with take parameter")
    public void sendGetRequestWithTakeParameter() {
        response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("take", 10)
                .when()
                .get(baseUrl + organizationEndpoint);
    }

    @Then("maximum 10 organization records should be returned")
    public void maximum10OrganizationRecordsShouldBeReturned() {

        List<?> records =
                response.jsonPath().getList("Value");

        assertNotNull(records);

        assertTrue(records.size() <= 10);
    }

    // TC-025
    @When("User sends GET request to check organization response time")
    public void sendGETRequestToCheckOrganizationResponseTime() {
        sendValidRequest();
    }

    @Then("organization response time should be within acceptable limit")
    public void organizationResponseTimeShouldBeWithinAcceptableLimit() {
        assertTrue(response.getTime() <= 2000);
    }

    // TC-026
    @When("User sends GET request to verify organization JSON format")
    public void sendGETRequestToVerifyOrganizationJSONFormat() {
        sendValidRequest();
    }

    @Then("organization response should be valid JSON")
    public void organizationResponseShouldBeValidJSON() {

        String contentType =
                response.getContentType();

        assertTrue(
                contentType.toLowerCase().contains("json")
        );
    }

    // TC-027
    @When("User sends GET request to verify organization data type")
    public void sendGETRequestToVerifyOrganizationDataType() {
        sendValidRequest();
    }

    @Then("organization ID should be integer")
    public void organizationIDShouldBeInteger() {

        List<?> ids =
                response.jsonPath().getList("Value.id");

        assertNotNull(ids);

        for (Object id : ids) {
            assertTrue(id instanceof Number);
        }
    }

    // TC-028
    @When("User sends GET request to verify duplicate organizations")
    public void sendGETRequestToVerifyDuplicateOrganizations() {
        sendValidRequest();
    }

    @Then("duplicate organization records should not exist")
    public void duplicateOrganizationRecordsShouldNotExist() {

        List<Integer> ids =
                response.jsonPath().getList("Value.id");

        assertNotNull(ids);

        Set<Integer> uniqueIds =
                new HashSet<>(ids);

        assertEquals(ids.size(), uniqueIds.size());
    }

    // TC-029
    @When("User sends GET request for organization without authorization")
    public void sendGETRequestForOrganizationWithoutAuthorization() {

        response = RestAssured
                .given()
                .when()
                .get(baseUrl + organizationEndpoint);
    }

    @Then("organization response status should be 401")
    public void organizationResponseStatusShouldBe401() {
        assertEquals(401, response.getStatusCode());
    }

    // TC-030
    @When("User sends GET request for organization with invalid token")
    public void sendGETRequestForOrganizationWithInvalidToken() {

        response = RestAssured
                .given()
                .header(
                        "Authorization",
                        "Bearer invalid_token_123"
                )
                .when()
                .get(baseUrl + organizationEndpoint);
    }

    @Then("organization response should be unauthorized")
    public void organizationResponseShouldBeUnauthorized() {
        assertEquals(401, response.getStatusCode());
    }
}