package video8;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUserTest {

    static String bearerToken = "02479116bdfd7e14a5965ab7abcff8e691086a98aeeacee4abe679d26e62ac5a";

    @Test(priority = 3)
    void updateUser(ITestContext context) {
        Faker faker = new Faker();
        JSONObject data = new JSONObject();
        data.put("name", faker.name().fullName());
        data.put("gender", "female"); // changed to female
        data.put("email", faker.internet().emailAddress());
        data.put("status", "active"); // changed to active

        int userId = (Integer) context.getAttribute("userId");

        Response response =
        given()
                .headers("Authorization", "Bearer " + bearerToken)
                .pathParam("userId", userId)
                .contentType("application/json")
                .body(data.toString())
        .when()
                .put("https://gorest.co.in/public/v2/users/{userId}");
        response.then().log().all();
        String responseBody = response.getBody().asString();
        JSONObject jsonResponse = new JSONObject(responseBody);
        int id = jsonResponse.getInt("id");
        System.out.println("Generated ID is " + id);

    }
}
