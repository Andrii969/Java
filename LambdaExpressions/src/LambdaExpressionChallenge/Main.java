package LambdaExpressionChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        String[] strings = new String[]{"John", "Andrii", "Ted", "Jenny", "Bob", "Jack", "Anna"};

//        Arrays.setAll(strings, (s) -> "first name " + (s + 1));
//        System.out.println(Arrays.toString(strings));

//        Arrays.asList(strings).replaceAll((s -> s.toUpperCase()));
//        System.out.println(Arrays.toString(strings));


        //
        System.out.println("--------- To UpperCase");

        Function<String,String> function = (source) -> source.toUpperCase();
        toUppercase(function, strings);
        Arrays.asList(strings).forEach((s) -> System.out.println(s));

        //
        System.out.println("--------- add Random Middle Name");

        Supplier<String> supplier = () -> {
            String[] lastNames = {"Marie", "Lynn", "Nicole", "Elizabeth", "Michelle"};
            Random random = new Random();
            return lastNames[random.nextInt(0, (lastNames.length - 1))];
        };

        Function<String,String> function1 = (source) -> source + " " + getRandomLastName(supplier);

        addRandomMiddleName(function1, strings);
        Arrays.asList(strings).forEach((s) -> System.out.println(s));

        //
        System.out.println("--------- add Reversed First Name");

        Function<String,String> function2 = (source) -> {
            int firstNameEndIndex = source.indexOf(' '); // Find the first space
            String extractedFirstName = source.substring(0, firstNameEndIndex);
            StringBuilder reversedFirstName = new StringBuilder(extractedFirstName);
            return reversedFirstName.reverse().toString(); // Reverse and return the string
        };

        addReversedLastName(function2, strings);
        Arrays.asList(strings).forEach((s) -> System.out.println(s));

        //
        System.out.println("--------- removing items if last name matches first name");
        List<String> stringList = new ArrayList<>(Arrays.asList(strings));

        stringList.removeIf(s -> {
            String[] nameParts = s.split(" ");
            return nameParts[0].equalsIgnoreCase(nameParts[2]);
        });
        stringList.forEach((s) -> System.out.println(s));

    }


    public static void toUppercase(Function<String, String> function, String[] source) {
        for (int i = 0; i < source.length; i++) {
            source[i] = function.apply(source[i]);
        }
    }

    public static String getRandomLastName(Supplier<String> supplier) {
        return supplier.get();
    };

    public static void addRandomMiddleName(Function<String, String> function, String[] source) {
        for (int i = 0; i < source.length; i++) {
            source[i] = function.apply(source[i]);
        }
    }

    public static void addReversedLastName(Function<String, String> function, String[] source) {
        for (int i = 0; i < source.length; i++) {
            source[i] = source[i] + " " + function.apply(source[i]);
        }
    }
}
