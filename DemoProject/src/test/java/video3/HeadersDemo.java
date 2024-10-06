package video3;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HeadersDemo {

    @Test(priority = 1)
    void testHeaders() {
        Response response = given()
                .when()
                .get("https://www.google.com/");
        response.then()
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .header("Content-Encoding", "gzip")
                .header("Server", "gws")
                .log().all();

        String headerCacheControl = response.getHeader("Cache-Control");
        System.out.println("headerCacheControl = " + headerCacheControl);
//        response.jsonPath().

        Headers headers = response.getHeaders(); // all headers have name and value
        headers.forEach(header -> System.out.println(header.getName() + ": " + header.getValue()));

    }
}
