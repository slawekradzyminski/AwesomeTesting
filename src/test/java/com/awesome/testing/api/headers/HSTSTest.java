package com.awesome.testing.api.headers;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class HSTSTest extends AbstractSecurityHeaderTest {

    @Test
    public void shouldHaveHstsHeader() {
        CHECKED_URLS.forEach(url -> {
            String header = given()
                    .when()
                    .get(url)
                    .then()
                    .extract()
                    .header("strict-transport-security");

            assertThat(header)
                    .isNotNull()
                    .isEqualTo("max-age=31536000; includeSubDomains");
        });
    }

}
