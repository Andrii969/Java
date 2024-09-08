import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITests {

    @Test
    void test1(){

        Response response = RestAssured.get("https://swapi.dev/api/planets/3/");

        System.out.println("Response : "+response.asString());
        System.out.println("Status Code : "+response.getStatusCode());
        System.out.println("Body : "+response.getBody().asString());
        System.out.println("Time taken : "+response.getTime());
        System.out.println("Header : "+response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
