package video2;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class postHashMap {

    private String id;

    // Ways to create POST requests

    @Test(priority = 1)
    void testPostUsingHashMap() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("name","Scotty");
        data.put("location", "France");
        data.put("phone", "89783463543");
        data.put("courses", new ArrayList<>(List.of("C++", "RestAPI")));
//        String[] courseArr = {"C++", "RestAPI"}; // Alternatively to the 25th row
//        data.put("courses", courseArr); // Alternatively to the 25th row

        Response response = given()
                .contentType("application/json")
                .body(data)
        .when()
                .post("http://localhost:3000/students");

        response.then()
                .statusCode(201)
                .body("name",equalTo("Scotty"))
                .body("location",equalTo("France"))
                .body("phone",equalTo("89783463543"))
                .body("courses", equalTo(data.get("courses")))
                .body("courses[0]", equalTo("C++"))
                .body("courses[1]", equalTo("RestAPI"))
                .header("Content-Type","application/json")
                .log().all();

        id = response.jsonPath().getString("id");
        System.out.println("Id of the newly created student is " + id);
    }

    @Test(priority = 2)
    void testDeleteCreatedStudent() {

        when()
            .delete("http://localhost:3000/students/" + id)
        .then()
            .statusCode(200);
    }


}
