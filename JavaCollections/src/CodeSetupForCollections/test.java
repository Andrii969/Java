package CodeSetupForCollections;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {

        List<String> numbers = new ArrayList<>(List.of("First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh"));
        numbers.subList(0, 3).forEach((n) -> System.out.print(n + " "));

    }
}
