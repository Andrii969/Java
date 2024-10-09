package video8;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTest {

    String bearerToken = "02479116bdfd7e14a5965ab7abcff8e691086a98aeeacee4abe679d26e62ac5a";

    @Test(priority = 1)
    void createUser(ITestContext context)
    {
        Faker faker = new Faker();
        JSONObject data = new JSONObject();
        data.put("name", faker.name().fullName());
        data.put("gender", "male");
        data.put("email", faker.internet().emailAddress());
        data.put("status", "inactive");

// FIRST WAY TO TAKE THE ID
//        int id = given()
//                .headers("Authorization", "Bearer " + bearerToken)
//                .contentType("application/json")
//                .body(data.toString())
//                .when()
//                .post("https://gorest.co.in/public/v2/users")
//                .jsonPath().getInt("id");

// SECOND WAY TO TAKE THE ID
//        Response response = given()
//                .headers("Authorization", "Bearer " + bearerToken)
//                .contentType("application/json")
//                .body(data.toString())
//        .when()
//                .post("https://gorest.co.in/public/v2/users");
//        JsonPath jsonPath = response.jsonPath();
//        int id = jsonPath.getInt("id"); // int id = response.jsonPath().get("id");

// THIRD WAY TO TAKE THE ID (there are other ways)
        Response response = given()
                .headers("Authorization", "Bearer " + bearerToken)
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("https://gorest.co.in/public/v2/users");
        response.then().log().all();
        String responseBody = response.getBody().asString();
        JSONObject jsonResponse = new JSONObject(responseBody);
        int userId = jsonResponse.getInt("id");
        System.out.println("Generated ID is " + userId);

        context.setAttribute("userId", userId);

    }
}
