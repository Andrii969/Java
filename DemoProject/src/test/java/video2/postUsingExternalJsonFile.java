package video2;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class postUsingExternalJsonFile {

    private String id;

    @Test(priority = 1)
    void testUsingExternalJsonFile() throws FileNotFoundException {

        File file = new File("testData/body.json");
        FileReader fr = new FileReader(file);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);

        Response response = given()
                .contentType("application/json")
                .body(data.toString()) // convert data to string
                .when()
                .post("http://localhost:3000/students");

        response.then()
                .statusCode(201)
                .body("name",equalTo("Mark"))
                .body("location",equalTo("Florida"))
                .body("phone",equalTo("0987654322"))
                .body("courses", hasItems("C++", "Java"))
                .body("courses[0]", equalTo("C++"))
                .body("courses[1]", equalTo("Java"))
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
