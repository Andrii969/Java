package LambdaExpressionChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class InstructorsMain {

    private static Random random = new Random();

    public static void main(String[] args) {

        String[] names = {"Anna", "Bob", "Carole", "David", "Ed", "Fred", "Gary"};

        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println(Arrays.toString(names));

        List<String> backedByArray = Arrays.asList(names);
        // creating a list like this gives you the ability to treat an array like a list,
        // except for those operations that change the size, like remove or add.

        backedByArray.replaceAll(s -> s = s + " " + getRandomChar('A', 'D') + ".");
        System.out.println(Arrays.toString(names));

//        backedByArray.replaceAll(s -> { // WORKING OPTION
//            String[] name = s.split(" ");
//            return s + " " + getReversedName(name[0]);}
//        );
        backedByArray.replaceAll(s -> s += " " + getReversedName(s.split(" ")[0])); // BETTER OPTION
        System.out.println(Arrays.toString(names));

        List<String> newList = new ArrayList<>(List.of(names));
//        newList.removeIf(s -> s.split(" ")[0].equalsIgnoreCase(s.split(" ")[2]));
        newList.removeIf(s -> s.substring(0, s.indexOf(" ")).equalsIgnoreCase(s.substring(s.lastIndexOf(" ") + 1)));
        // s.lastIndexOf(" ") finds the index of the last space.
        // s.lastIndexOf(" ") + 1 moves the index to the first letter of the last name.
        // s.substring(...) extracts the substring starting from that index (i.e., the last name).
        System.out.println(newList);


    }

    public static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    private static String getReversedName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }
}
