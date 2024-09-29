package MapInterfaceAndFunctionality;

import java.util.HashMap;
import java.util.Map;

public class test {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Alice", "alice@example.com");
        map.put("Bob", "bob@example.com");

// First merge, no duplicate:
        map.merge("Charlie", "charlie@example.com", (prev, curr) -> {
            System.out.println("prev: " + prev + ", curr: " + curr);
            return curr; // This won't be executed since there's no duplicate.
        });

// Second merge, with duplicate:
        map.merge("Alice", "alice@newdomain.com", (prev, curr) -> {
            System.out.println("prev: " + prev + ", curr: " + curr);
            return curr; // This will return the new email address.
        });

// Printing the map
        map.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));
    }
}
