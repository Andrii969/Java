package video3;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CookiesDemo {


    @Test(priority = 1)
    void testCookies() {
        given()
        .when()
        .get("https://www.google.com/")
        .then()
//        .cookie("AEC", "AVYB7crcXYVvHqhCDYPLLIT4F3CFdEz5Cg6HTaTrjFmVU-9JcTjYx2PadA")
        .log().all();
    }

    @Test(priority = 2)
    void getCookiesInfo() {
        Response response = given()
                .when()
                .get("https://www.google.com/");
//        response.then()
//        .log().all();

        String cookieAEC = response.getCookie("AEC");
        System.out.println("cookieAEC =" + cookieAEC);

        Map<String, String> cookies = response.getCookies();
        cookies.forEach((k,v) -> System.out.println(k + "= " + v));

    }



}
