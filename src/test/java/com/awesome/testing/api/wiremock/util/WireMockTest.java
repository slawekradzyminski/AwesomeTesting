package com.awesome.testing.api.wiremock.util;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static io.restassured.http.ContentType.JSON;

public class WireMockTest {

    @Rule
    public WireMockRule wireMockRule =
            new WireMockRule(wireMockConfig().dynamicPort().portNumber());

    @Before
    public void configureRestAssured() {
        RestAssured.port = wireMockRule.port();
        RestAssured.registerParser(JSON.toString(), Parser.JSON);
    }

    @After
    public void cleanUp() {
        wireMockRule.resetAll();
    }

}
