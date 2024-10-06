package video2;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;


public class postJsonLibrary {

    private String id;

    @Test(priority = 1)
    void testPostUsingJsonObject() { // post using org.json.library

        JSONObject data = new JSONObject();
        data.put("name","Scotty");
        data.put("location", "France");
        data.put("phone", "89783463543");
        data.put("courses", new ArrayList<>(List.of("C++", "RestAPI")));
//        String[] courseArr = {"C++", "RestAPI"}; // Alternatively to the 27th row
//        data.put("courses", courseArr); // Alternatively to the 27th row

        Response response = given()
                .contentType("application/json")
                .body(data.toString()) // convert data to string
                    .when()
                        .post("http://localhost:3000/students");

        response.then()
                .statusCode(201)
                .body("name",equalTo("Scotty")) // JSON path name doesn't match.
                .body("location",equalTo("France"))
                .body("phone",equalTo("89783463543"))
                .body("courses", hasItems("C++", "RestAPI"))
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
