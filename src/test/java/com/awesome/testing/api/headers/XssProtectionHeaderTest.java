package com.awesome.testing.api.headers;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

public class XssProtectionHeaderTest extends AbstractSecurityHeaderTest {

    @Test
    public void shouldHaveXssProtectionHeader() {
        CHECKED_URLS.forEach(url -> {
            String header = given()
                    .when()
                    .get(url)
                    .then()
                    .extract()
                    .header("x-xss-protection");

            assertThat(header)
                    .isNotNull()
                    .isEqualTo("1; mode=block");
        });
    }

}
