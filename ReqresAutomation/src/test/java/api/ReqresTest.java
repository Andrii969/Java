package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class ReqresTest {

    @Test
    public void checkAvatarAndIdTest() {
        List<UserData> users = given()
                .contentType(JSON)
                .baseUri("https://reqres.in/")
                .queryParam("page", 2)
                .when()
                .get("/api/users")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        users.forEach(u -> Assert.assertTrue(u.getAvatar().contains(u.getId().toString())));
        users.forEach(u -> Assert.assertTrue(u.getAvatar().endsWith("image.jpg")));
        Assert.assertTrue(users.stream().allMatch(u -> u.getEmail().endsWith("@reqres.in")));

        List<Integer> ids = users.stream().map(UserData::getId).collect(Collectors.toList());
        List<Integer> sortedIds = ids.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        Assert.assertEquals(ids, sortedIds, "IDs are not sorted in ascending order!");

        List<String> avatars = users.stream().map(UserData::getAvatar).toList();
        List<String> idS = users.stream().map(i -> i.getId().toString()).toList();
    }
}
