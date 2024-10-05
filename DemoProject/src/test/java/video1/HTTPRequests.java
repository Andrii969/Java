package video1;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class HTTPRequests {

    int userId;

    @Test
    void getUsers() {
//        given()
        when()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();
    }

    @Test
    void createUser() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "Andrii");
        data.put("job", "QA");

        Response response = given() // OR userId = given()...
                .contentType("application/json")
                .body(data)
            .when()
                .post("https://reqres.in/api/users");
              //.jsonPath().getInt("id");

        // Assert the response status code and log the response
        response.then()
                .statusCode(201)
                .log().all();

        userId = response.jsonPath().getInt("id");
        System.out.println("Created user ID: " + userId);
    }

    @Test(dependsOnMethods = {"createUser"}) // Ensures createUser runs first
    void updateUser() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "Andrii edited");
        data.put("job", "QA edited");

        given()
                .contentType("application/json")
                .body(data);
        when()
                .put("https://reqres.in/api/users/" + userId)
            .then()
                .statusCode(200)
                .log().all();
    }

    @Test(dependsOnMethods = {"updateUser"})
    void deleteUser() {
        when()
                .delete("https://reqres.in/api/users/" + userId)
        .then()
                .statusCode(204)
                .log().all();
    }


}
