package com.awesome.testing.api.restassuredjsonplaceholder.tests;

import com.awesome.testing.api.restassuredjsonplaceholder.utils.JsonPlaceholderAPI;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

/**
 * See more at http://awesome-testing.blogspot.com/2016/07/restful-api-testing-with-rest-assured-1.html
 */
public class GetTest {

    private JsonPlaceholderAPI jsonPlaceholderAPI = new JsonPlaceholderAPI();

    @Test
    public void testGetPostTitle() {
        jsonPlaceholderAPI.getPostContent(1)

                .then()
                .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }

    @Test
    public void testGetPostBody() {
        jsonPlaceholderAPI.getPostContent(100)

                .then()
                .body("body", containsString("cupiditate quo est a modi"));
    }

    @Test
    public void testGetCommentId() {
        jsonPlaceholderAPI.getCommentContent(6)

                .then()
                .body("id", equalTo(6));
    }

    @Test
    public void testGetAllUsers() {
        jsonPlaceholderAPI.getAllUsers()

                .then()
                .body("findAll {it.id >= 9}.name", hasItems("Glenna Reichert", "Clementina DuBuque"));
    }

}
