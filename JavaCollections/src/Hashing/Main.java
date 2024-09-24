package Hashing;

import java.util.Arrays;
import java.util.HashSet;
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

        HashSet<String> mySet = new HashSet<>(hellos);
        // A HashSet is a class that implements the Set interface, and tracks duplicates by their hash code.
        // Most collections allow the creation of another collection type, by passing a different collection
        // to the constructor as I'm doing here, but a Set's constructor allows any instance that
        //implements Collection to be passed to it.
        System.out.println("mySet = " + mySet);
        System.out.println("# of elements = " + mySet.size());

        for (String setValue : mySet) {
            System.out.print(setValue + ": ");
            for (int i = 0; i < hellos.size(); i++) {
                if (setValue == hellos.get(i)) {
                    System.out.print(i + ", ");
                }
            }
            System.out.println(" ");
            // cText and dText, however, are constructed using String.join() and concat(), respectively,
            // which creates new String objects. These new objects contain the same characters as aText and bText,
            // but they are different objects in memory, so == fails for them.
            // The for loop is using ==, which compares memory addresses, and not .equals(),
            // which compares the content of the strings.
        }




     }
}
