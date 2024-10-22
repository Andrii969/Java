import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;

public class Main {

    public static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T asPojo(String jsonString, Class<T> tClass) {
        try {
            return MAPPER.readValue(jsonString, tClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String json = "{\"name\":\"Alice\", \"age\":30}";
        User user = asPojo(json, User.class);
        System.out.println(user);
    }
}

@Data
class User {
    private String name;
    private int age;
}

