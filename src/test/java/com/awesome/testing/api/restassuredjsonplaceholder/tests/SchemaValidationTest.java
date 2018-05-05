package com.awesome.testing.api.restassuredjsonplaceholder.tests;

import com.awesome.testing.api.restassuredjsonplaceholder.utils.JsonPlaceholderAPI;
import org.junit.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


/**
 * See more at http://awesome-testing.blogspot.com/2016/07/restful-api-testing-with-rest-assured-1.html
 */
public class SchemaValidationTest {

    private JsonPlaceholderAPI jsonPlaceholderAPI = new JsonPlaceholderAPI();

    @Test
    public void schemaValidation() {
        jsonPlaceholderAPI.getPostContent(1)

                .then()
                .body(matchesJsonSchemaInClasspath("jsonplaceholder-posts-schema.json"));
    }

}
