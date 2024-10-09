package video8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserTest {

    String bearerToken = "02479116bdfd7e14a5965ab7abcff8e691086a98aeeacee4abe679d26e62ac5a";

    @Test(priority = 2)
    void getUser(ITestContext context)
    {

        int userId = (Integer) context.getAttribute("userId");
        given()
                .headers("Authorization", "Bearer " + bearerToken)
                .pathParam("userId", userId)
        .when()
                .get("https://gorest.co.in/public/v2/users/{userId}")

        .then()
                .statusCode(200)
                .log().all();
    }
}
