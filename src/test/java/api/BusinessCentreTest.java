package api;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.JwtUtil;

import static io.restassured.RestAssured.given;

public class BusinessCentreTest {

    @Test
    public void getAllBusinessCentres() {

        // Generate JWT automatically
        String token = JwtUtil.generateToken();

        System.out.println("Generated JWT:");
        System.out.println(token);

        // Call API
        Response response =
                given()
                        .baseUri("http://localhost:5001")
                        .header("Authorization", "Bearer " + token)
                        .header("Accept", "application/json")

                        .when()
                        .get("/api/businesscentres/getall");

        // Print response
        response.prettyPrint();

        // Validate status code
        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "API should return 200 OK"
        );
    }
}