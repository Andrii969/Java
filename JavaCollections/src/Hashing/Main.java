package Hashing;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join(("l"), "He", "lo");
        String dText = "He".concat("llo");
        String eText = "hello";

        List<String> hellos = Arrays.asList(aText, bText, cText, dText, eText);

        hellos.forEach(s -> System.out.println(s + ": " + s.hashCode()));
        // Notice that all 4 of the Strings with a capital H, return the exact same hash code,
        // but the last one is different. Java doesn't care if these are different objects in memory,
        // when it tests the equality of Strings, using the equals method.
        // It just cares that the characters match, in one instance, compared to another instance.

     }
}
