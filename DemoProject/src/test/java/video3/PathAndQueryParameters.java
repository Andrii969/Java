package video3;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameters {

    @Test
    void testQueryAndPathParameters() {
        given()
                .pathParam("path", "users")
                .queryParam("page", 2)
                .queryParam("id", 5)
        .when()
                .log().all()
                .get("https://reqres.in/api/{path}") // if it's a path parameter, it must be specified
        .then()
                .statusCode(200)
                .body("data.id", equalTo(5))
                .log().all();

    }
}
