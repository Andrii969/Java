package video7;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerDataGenerator {

    @Test
    void testGenerateDummyData() {
        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userName = faker.name().username();
        String password = faker.internet().password();
        String phoneNumber = faker.phoneNumber().cellPhone();
        String email = faker.internet().safeEmailAddress();
        System.out.println(fullName + " | " + firstName + " | " + lastName + " | " + userName + " | " + password + " | " + phoneNumber + " | " + email);
    }


}
