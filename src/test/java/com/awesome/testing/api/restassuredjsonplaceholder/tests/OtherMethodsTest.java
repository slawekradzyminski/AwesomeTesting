package com.awesome.testing.api.restassuredjsonplaceholder.tests;

import com.awesome.testing.api.restassuredjsonplaceholder.utils.JsonPlaceholderAPI;
import com.awesome.testing.api.restassuredjsonplaceholder.utils.User;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

/**
 * See more at http://awesome-testing.blogspot.com/2016/07/restful-api-testing-with-rest-assured-1.html
 */
public class OtherMethodsTest {

    private JsonPlaceholderAPI jsonPlaceholderAPI = new JsonPlaceholderAPI();

    @Test
    public void testPostMethod() {
        User user = new User("foo", "bar", 144);
        jsonPlaceholderAPI.postNewPost(user)

                .then()
                .statusCode(SC_CREATED);
    }

    @Test
    public void testPutMethod() {
        User user = new User(1, "foo", "bar", 1);
        jsonPlaceholderAPI.putNewPost(user, 1)

                .then()
                .statusCode(SC_OK);
    }

    @Test
    public void testDeleteMethod() {
        jsonPlaceholderAPI.deletePost(1)

                .then()
                .statusCode(SC_OK);
    }


}
