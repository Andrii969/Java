package video3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoggingDemo {

    @Test
    void testQueryAndPathParameters() {
        given()
                .pathParam("path", "users")
                .queryParam("page", 2)
                .queryParam("id", 5)
                .when()
//                .log().all()
                .get("https://reqres.in/api/{path}") // if it's a path parameter, it must be specified
                .then()
//                .log().all()
//                .log().body()
//                .log().cookies()
                .log().headers();

    }
}
