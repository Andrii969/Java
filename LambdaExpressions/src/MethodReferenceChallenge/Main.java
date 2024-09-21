package MethodReferenceChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Main {

    private static Random random = new Random();

    private record Person(String firstName) {

        public String last(String s) {
            return firstName + " " + s.substring(s.indexOf(" "), s.lastIndexOf(" "));
        }
    }

    public static void main(String[] args) {

        String[] names = {"James", "Harry", "Dave", "David", "Bob", "Anna", "Charlotte"};

        Person tim = new Person("Tim");

//        Arrays.setAll(names, i -> names[i].toUpperCase());
//        System.out.println(Arrays.toString(names));

        List<UnaryOperator<String>> listOfFunctions = new ArrayList<>(List.of(
                String::toUpperCase,
                s -> s += " " + addRandomCharacter('A', 'F') + ".",
                s -> s + " " + getReversedName(s),
                tim::last,
                (new Person("Marry")::last)
        ));

        applyChanges(names, listOfFunctions);

    }

    private static void applyChanges(String[] names, List<UnaryOperator<String>> stringFunctions) {
        List<String> backedByArray = Arrays.asList(names);
        for (var function : stringFunctions) {
            backedByArray.replaceAll((s) -> s.transform(function));
            System.out.println(Arrays.toString(names));

        }
    }

    private static char addRandomCharacter(char startChar, char lastChar) {
        return (char) random.nextInt((int) startChar, (int) lastChar + 1);
    }

    private static String getReversedName(String fullName) {
        return new StringBuilder(fullName.substring(0, fullName.indexOf(" "))).reverse().toString();
    }


}
