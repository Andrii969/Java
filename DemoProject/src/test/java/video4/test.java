package video4;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class test {

    @Test
    void parsingData() {
        Response response = given()
        .when()
            .get("https://run.mocky.io/v3/55f5f5d9-2e47-4a32-b0d8-aea230a21e3e");
        response.then()
            .log().all();


        JSONObject jo = new JSONObject(response.asString()); // toString() doesn't work here
        JSONArray ja = new JSONArray(jo.getJSONArray("students"));
        System.out.println(ja);
        for (int i = 0; i < ja.length(); i++) {
            JSONObject object = ja.getJSONObject(i);
            System.out.println("object = " + object);
            System.out.println(object.get("id").toString());
            System.out.println(object.getString("name"));
            System.out.println(object.getString("location"));
            System.out.println(object.getString("phone"));
            System.out.println(object.getJSONArray("courses"));

        }



    }
}
