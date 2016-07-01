package restassuredjsonplaceholder.utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.config.EncoderConfig.encoderConfig;
import static com.jayway.restassured.http.ContentType.JSON;
import static java.lang.String.format;

public class JsonPlaceholderAPI {

    private static final String URL = "http://jsonplaceholder.typicode.com";

    private final RestAssuredConfig restAssuredConfig = RestAssured.config().encoderConfig(encoderConfig().defaultContentCharset("UTF-8"));

    public Response getPostContent(int postNumber) {
        return given()
                .contentType(JSON)

                .when()
                .get(format("%s/posts/%s", URL, Integer.toString(postNumber)));
    }

    public Response getCommentContent(int postNumber) {
        return given()
                .contentType(JSON)

                .when()
                .get(format("%s/comments/%s", URL, Integer.toString(postNumber)));
    }

    public Response getAllUsers() {
        return given()
                .contentType(JSON)

                .when()
                .get(format("%s/users", URL));
    }

    public Response postNewPost(User user) {

        return given()
                .config(restAssuredConfig)
                .contentType(JSON)
                .body(user)

                .when()
                .post(format("%s/posts", URL));
    }

    public Response putNewPost(User user, int postNumber) {
        return given()
                .config(restAssuredConfig)
                .contentType(JSON)
                .body(user)

                .when()
                .put(format("%s/posts/%s", URL, Integer.toString(postNumber)));
    }

    public Response deletePost(int postNumber) {
        return given()
                .config(restAssuredConfig)
                .contentType(JSON)

                .when()
                .delete(format("%s/posts/%s", URL, Integer.toString(postNumber)));
    }

}
