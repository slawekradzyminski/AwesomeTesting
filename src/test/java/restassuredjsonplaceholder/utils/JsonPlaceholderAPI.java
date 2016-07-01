package restassuredjsonplaceholder.utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.config.EncoderConfig.encoderConfig;
import static com.jayway.restassured.http.ContentType.JSON;
import static java.lang.String.format;

public class JsonPlaceholderAPI {

    private static final String URL = "http://jsonplaceholder.typicode.com/";

    private final RestAssuredConfig restAssuredConfig = RestAssured.config().encoderConfig(encoderConfig().defaultContentCharset("UTF-8"));

    public Response getPostContent(int postNumber) {
        return given()
                .contentType(JSON)

                .when()
                .get(URL + format("posts/%s", Integer.toString(postNumber)));
    }

    public Response getCommentContent(int postNumber) {
        return given()
                .contentType(JSON)

                .when()
                .get(URL + format("comments/%s", Integer.toString(postNumber)));
    }

    public Response getAllUsers() {
        return given()
                .contentType(JSON)

                .when()
                .get(URL + "users");
    }

    public Response postNewPost(User user) {

        return given()
                .config(restAssuredConfig)
                .contentType(JSON)
                .body(user)

                .when()
                .post(URL + "posts");
    }

    public Response putNewPost(User user, int postNumber) {
        return given()
                .config(restAssuredConfig)
                .contentType(JSON)
                .body(user)

                .when()
                .put(URL + format("posts/%s", Integer.toString(postNumber)));
    }

    public Response deletePost(int postNumber) {
        return given()
                .config(restAssuredConfig)
                .contentType(JSON)

                .when()
                .delete(URL + format("posts/%s", Integer.toString(postNumber)));
    }

}
