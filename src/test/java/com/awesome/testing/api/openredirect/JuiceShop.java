package com.awesome.testing.api.openredirect;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

public class JuiceShop {

    @Test
    public void shouldNotRedirectToKraqa() {
        String localhost = "http://localhost:3000";
        String attackersUrl = "http://kraqa.pl";
        String whitelistedUrl = "https://github.com/bkimminich/juice-shop";

        String maliciousUrl =
                String.format("%s/redirect?to=%s?pwned=%s",
                        localhost, attackersUrl, whitelistedUrl);

        given()
                .when()
                .get(maliciousUrl)
                .then()
                .body("html.head.title", not(containsString("KRAQA")));
    }

}
