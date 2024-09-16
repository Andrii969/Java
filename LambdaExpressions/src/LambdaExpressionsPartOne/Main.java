package LambdaExpressionsPartOne;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));

        for (String s : list) {
            System.out.println(s);
        }

        // Using a method that's a default method on the Iterable interface, which List inherits, called forEach.
        // This method takes a lambda expression, a Consumer type, which I just talked about, as its argument.
        System.out.println("-".repeat(30));
        list.forEach((s) -> System.out.println(s));
//        list.forEach((var s) -> System.out.println(s)); // alternatively
//        list.forEach((String s) -> System.out.println(s)); // alternatively
//        list.forEach(s -> System.out.println(s)); // alternatively


        System.out.println("-".repeat(30));
        String prefix = "nato";
        list.forEach((s) -> {
            char first = s.charAt(0);
            System.out.println(prefix + " " +  first + " means " + s);
        });
//        prefix = "NATO"; // ERROR: Variable used in lambda expression should be final or effectively final

//        System.out.println(s); // Compiler error, because s goes out of scope outside of the lambda expression.






    }
}
