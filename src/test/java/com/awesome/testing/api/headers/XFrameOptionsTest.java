package com.awesome.testing.api.headers;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class XFrameOptionsTest extends AbstractSecurityHeaderTest {

    @Test
    public void shouldHaveXFrameOptionsHeader() {
        CHECKED_URLS.forEach(url -> {
            String header = given()
                    .when()
                    .get(url)
                    .then()
                    .extract()
                    .header("x-frame-options");

            assertThat(header)
                    .isNotNull()
                    .isEqualTo("deny");
        });
    }

}
