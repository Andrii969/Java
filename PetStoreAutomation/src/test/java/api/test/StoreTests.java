package api.test;

import api.endpoinds.StoreEndpoints;
import api.payload.Order;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.equalTo;

public class StoreTests {

    Faker faker;
    Order orderPayload;

    @BeforeClass
    public void setupData() {
        faker = new Faker();
        orderPayload = new Order();

        orderPayload.setId(faker.idNumber().hashCode());
        orderPayload.setQuantity(faker.number().numberBetween(1, 10));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        OffsetDateTime shipDate = OffsetDateTime.now(ZoneOffset.UTC);
        String formattedDate = shipDate.format(formatter);

        orderPayload.setShipDate(formattedDate);
    }

    @Test(priority = 1)
    public void testGetInventory() {
        Response response = StoreEndpoints.getInventory();

        response
        .then().log().all()
        .statusCode(200);
    }

    @Test(priority = 2)
    public void testPlaceOrder() {
        Response response = StoreEndpoints.placeOrder(this.orderPayload);

        response
        .then().log().all()
        .statusCode(200)
        .body("id", equalTo(this.orderPayload.getId()))
        .body("petId", equalTo(this.orderPayload.getPetId()))
        .body("quantity", equalTo(this.orderPayload.getQuantity()))
        .body("shipDate", equalTo(this.orderPayload.getShipDate()))
        .body("status", equalTo(this.orderPayload.getStatus()))
        .body("complete", equalTo(this.orderPayload.isComplete()));

        Map<String, Object> responseBody = response.jsonPath().getMap("$"); // the $ symbol represents the root element of the JSON structure
        assert responseBody.keySet().equals(Set.of("id", "petId", "quantity", "shipDate", "status", "complete"))
                : "Unexpected fields found in response";
    }

    @Test(priority = 3)
    public void testGetOrder() {
        Response response = StoreEndpoints.getOrder(this.orderPayload.getId());

        response
        .then().log().all()
        .statusCode(200)
        .body("id", equalTo(this.orderPayload.getId()))
        .body("petId", equalTo(this.orderPayload.getPetId()))
        .body("quantity", equalTo(this.orderPayload.getQuantity()))
        .body("shipDate", equalTo(this.orderPayload.getShipDate()))
        .body("status", equalTo(this.orderPayload.getStatus()))
        .body("complete", equalTo(this.orderPayload.isComplete()));

        Map<String, Object> responseBody = response.jsonPath().getMap("$"); // the $ symbol represents the root element of the JSON structure
        assert responseBody.keySet().equals(Set.of("id", "petId", "quantity", "shipDate", "status", "complete"))
                : "Unexpected fields found in response";
    }

    @Test(priority = 4)
    public void testDeleteOrder() {
        Response response = StoreEndpoints.deleteOrder(this.orderPayload.getId());

        response
        .then().log().all()
        .statusCode(200)
        .body("code", equalTo(200))
        .body("type", equalTo("unknown"))
        .body("message", equalTo(String.valueOf(this.orderPayload.getId())));

        Map<String, Object> responseBody = response.jsonPath().getMap("$"); // the $ symbol represents the root element of the JSON structure
        assert responseBody.containsKey("code") : "Response should contain 'code'";
        assert responseBody.containsKey("type") : "Response should contain 'type'";
        assert responseBody.containsKey("message") : "Response should contain 'message'";
        assert responseBody.keySet().equals(Set.of("code", "type", "message")) : "Unexpected fields found in response";
    }


}
