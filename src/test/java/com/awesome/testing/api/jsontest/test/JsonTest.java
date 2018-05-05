package com.awesome.testing.api.jsontest.test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.awesome.testing.api.jsontest.util.JsonExample.NON_TRIVIAL_JSON;
import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.http.ContentType.XML;
import static java.lang.String.format;
import static org.apache.commons.codec.digest.DigestUtils.md5Hex;
import static org.hamcrest.CoreMatchers.*;

/**
 * See more at http://www.awesome-testing.com/2017/06/rest-assured-integration-tests-for.html
 */
public class JsonTest {

    @Test
    public void ipTest() {
        String partOfMyIp = "142";

        given().contentType(JSON)
                .when().get("http://ip.jsontest.com")
                .then()
                .body("ip", containsString(partOfMyIp));
    }

    @Test
    public void printSentHeaders() {

        RestAssuredConfig utf8Config
                = RestAssured.config().encoderConfig(encoderConfig().defaultContentCharset("UTF-8"));

        given().config(utf8Config).contentType(XML)
                .when().get("http://headers.jsontest.com")
                .then()
                .body("Content-Type", equalTo("application/xml; charset=UTF-8"));
    }

    @Test
    public void dateTest() {

        Date date = new Date();
        String dateMMddyyyy = new SimpleDateFormat("MM-dd-yyyy").format(date);

        given().contentType(JSON)
                .when().get("http://date.jsontest.com")
                .then()
                .body("date", equalTo(dateMMddyyyy));
    }

    @Test
    public void mirrorTest() {

        String firstKey = "firstKey";
        String firstValue = "firstValue";
        String secondKey = "secondKey";
        String secondValue = "secondValue";

        given().contentType(JSON)
                .when().get(format("http://%s/%s/%s/%s/%s",
                "echo.jsontest.com", firstKey, firstValue, secondKey, secondValue))

                .then()
                .body(firstKey, equalTo(firstValue))
                .body(secondKey, equalTo(secondValue));
    }

    @Test
    public void postSuccessfulBasicValidationTest() {
        String parsableJson = "{\"key\":\"value\"}";

        given().contentType(JSON)
                .queryParam("json", parsableJson)
                .when().post(" http://validate.jsontest.com")
                .then()
                .body("validate", equalTo(true));
    }

    @Test
    public void postSuccessfulNonBasicValidationTest() {

        given().contentType(JSON)
                .queryParam("json", NON_TRIVIAL_JSON)
                .when().post(" http://validate.jsontest.com")
                .then()
                .body("size", equalTo(4));
    }

    @Test
    public void postFailedValidationTest() {
        String nonParsableJson = "{\"key\":\"value";

        given().contentType(JSON)
                .queryParam("json", nonParsableJson)
                .when().post(" http://validate.jsontest.com")
                .then()
                .body("validate", equalTo(false));
    }

    @Test
    public void cookieTest() {
        given().contentType(JSON)
                .when().get("http://cookie.jsontest.com")
                .then()
                .cookie("jsontestdotcom", is(notNullValue()));
    }

    @Test
    public void shouldPrintMd5() {
        String myRandomText = "My random text";
        String md5 = md5Hex(myRandomText);

        given().contentType(JSON)
                .queryParam("text", myRandomText)
                .when().post("http://md5.jsontest.com")
                .then()
                .body("md5", equalTo(md5))
                .body("original", equalTo(myRandomText));
    }

}