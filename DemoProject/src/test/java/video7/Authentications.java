package video7;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Authentications {

    @Test
    void testBasicAuthentication() { // basic auth
        given()
                .auth().basic("postman","password")
        .when()
                .get("https://postman-echo.com/basic-auth")
        .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }

    @Test
    void testDigestAuthentication() { // digest auth
        given()
                .auth().digest("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }

    @Test
    void testPreemptiveAuthentication() {
        given()
                .auth().preemptive().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }

//    @Test
    void testTokenAuthentication() {
        String bearerToken = "token value";
        given()
                .headers("Authorization", "Bearer " + bearerToken)
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200)
                .log().all();
    }

//    @Test
    void testOAuth1Authentication() {
        given()
                .auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecret")
                .when()
                .get("url")
                .then()
                .statusCode(200)
                .log().all();
    }

//    @Test
    void testOAuth2Authentication() {
        given()
                .auth().oauth2("accessToken")
                .when()
                .get("url")
                .then()
                .statusCode(200)
                .log().all();
    }

//    @Test
    void testAPIKeyAuthentication() {
        given()
                .queryParam("apiKey", "value")
                .when()
                .get("url")
                .then()
                .log().all();
    }




}
