package video2;


import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class postUsingPojoClass {

    private String id;

    @Test(priority = 1)
    void testPostUsingPOJO() { // post using org.json.library

        PojoPostRequest data = new PojoPostRequest(); // alternatively I could create a constructor
        data.setName("Scotty");
        data.setLocation("France");
        data.setPhone("89783463543");
        data.setCourses(new String[] {"C++", "RestAPI"});


        Response response = given()
                .contentType("application/json")
                .body(data) // convert data to string
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
