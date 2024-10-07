package video6;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JSONSchemaValidation {

    @Test
    void jsonSchemaValidation() {

        given()
        .when()
                .get("http://localhost:3000/students")
        .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("studentsJsonSchema.json"));
                                                                                        // the file should be present in the resources

    }
}
