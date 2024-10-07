package video4;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParsingJsonResponse {

    @Test(priority = 1)
    void testJsonResponse1() { // approach 1
        Response response = given()
                .contentType("application/json")
        .when()
                .get("http://localhost:3000/students");
        response.then()
                .statusCode(200)
                .body("[2].name", equalTo("Scott edited"))
                .log().all();
    }

    @Test(priority = 2)
    void testJsonResponse2() { // approach 2
        Response response = given()
                .contentType("application/json")
                .when()
                .get("http://localhost:3000/students");

        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getHeader("X-Powered-By"), "tinyhttp");

        JsonPath responseBody = response.jsonPath();
//        System.out.println(responseBody.get("[2].name").toString());
        String nameScott = responseBody.get("[2].name");
//        System.out.println(nameScott);
        Assert.assertEquals(nameScott,"Scott edited");

//        // Convert the response body to a JSONArray
        JSONArray jsonArray = new JSONArray(response.getBody().asString());
        System.out.println("-".repeat(30));
        System.out.println(jsonArray.toString(2)); // Indent with 2 spaces for better readability

        boolean status = false;

//        JSONObject jsonObject = new JSONObject(response.toString()); // not applicable for my API
//        JSONArray jsonArray = jsonObject.getJSONArray("students");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i); // Cast to JSONObject
            String studentName = object.getString("name"); // Use getString() to retrieve the name
            System.out.println("Student Name: " + studentName); // Print each student's name
            if (studentName.equals("Scott edited")) {
                status = true;
                break;
            }
        }
        Assert.assertTrue(status);
//        Assert.assertEquals(status,true); // it's also correct


        // checking the order of Ids
        List<Integer> ids = response.jsonPath().getList("id");
        List<Integer> sortedIds = ids.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(ids, sortedIds);



    }
}
