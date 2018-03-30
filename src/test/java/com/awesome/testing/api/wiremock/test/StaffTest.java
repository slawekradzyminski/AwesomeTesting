package com.awesome.testing.api.wiremock.test;

import com.awesome.testing.api.wiremock.util.WireMockTest;
import org.junit.Before;
import org.junit.Test;

import javax.json.Json;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

/**
 * See more at http://www.awesome-testing.com/2017/12/get-rid-of-your-external-dependencies.html
 */
public class StaffTest extends WireMockTest {

    private static final String EMPLOYEES = "employees";
    private static final String MANAGER = "managers";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    @Before
    public void setUp() {
        stubFor(get(urlEqualTo("/staff"))
                .withHeader("Accept", equalTo(JSON.toString()))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", JSON.toString())
                        .withBody(getMockedStaffEndpointJson())));
    }

    private String getMockedStaffEndpointJson() {
        return Json.createObjectBuilder()
                .add(EMPLOYEES, Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add(FIRST_NAME, "John").add(LAST_NAME, "Doe"))
                        .add(Json.createObjectBuilder()
                                .add(FIRST_NAME, "Jessica").add(LAST_NAME, "Alba"))
                        .add(Json.createObjectBuilder()
                                .add(FIRST_NAME, "Emma").add(LAST_NAME, "Stone")))
                .add(MANAGER, Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add(FIRST_NAME, "Janusz").add(LAST_NAME, "Biznesu")))
                .build().toString();
    }

    @Test
    public void staffTest() {
        given()
                .contentType(JSON)
                .header("Accept", JSON.toString())
                .when()
                .get("/staff")
                .then()
                .body("employees[0].lastName", containsString("Doe"))
                .body("employees.size()", is(3))
                .body("managers.size()", is(1))
                .body("employees.firstName", containsInAnyOrder("John", "Jessica", "Emma"));
    }

}
