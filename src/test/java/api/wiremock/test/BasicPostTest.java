package api.wiremock.test;

import api.wiremock.util.WireMockTest;
import org.junit.Before;
import org.junit.Test;

import javax.json.Json;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_OK;

public class BasicPostTest extends WireMockTest {

    @Before
    public void setUp() {
        stubFor(post(urlEqualTo("/addPerson"))
                .withHeader("Accept", equalTo(JSON.toString()))
                .withRequestBody(equalToJson(getUserJson()))
                .willReturn(ok()));
    }

    private String getUserJson() {
        return Json.createObjectBuilder()
                .add("firstName", "Slawomir")
                .add("lastName", "Radzyminski")
                .add("age", "18")
                .build().toString();
    }

    @Test
    public void postTest() {
        given()
                .contentType(JSON)
                .header("Accept", JSON.toString())
                .body(getUserJson())
                .when()
                .post("/addPerson")
                .then()
                .statusCode(SC_OK);
    }

}
