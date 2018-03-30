package com.awesome.testing.api.wiremock.test;

import com.awesome.testing.api.wiremock.util.WireMockTest;
import org.junit.Before;
import org.junit.Test;

import javax.json.Json;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * See more at http://www.awesome-testing.com/2017/12/get-rid-of-your-external-dependencies.html
 */
public class BasicGetTest extends WireMockTest {

    @Before
    public void setUp() {
        stubFor(get(urlEqualTo("/ip"))
                .withHeader("Accept", equalTo(JSON.toString()))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", JSON.toString())
                        .withBody(getMockedIpEndpointJson())));
    }

    private String getMockedIpEndpointJson() {
        return Json.createObjectBuilder()
                .add("ip", "127.0.0.1")
                .build().toString();
    }

    @Test
    public void ipTest() {
        given()
                .contentType(JSON)
                .header("Accept", JSON.toString())
                .when()
                .get("/ip")
                .then()
                .body("ip", containsString("127.0.0.1"));
    }

}