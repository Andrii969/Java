package FunctionalInterfacesConsumerPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));

        list.sort((o1,o2) -> o2.compareTo(o1));
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

        System.out.println("-".repeat(30));
        int result0 = calculator((a,b) -> a + b, 5, 2);
        int result1 = calculator((var a, var b) -> {return a + b;},5, 3);
        var result2 = calculator((var a, var b) -> a / b,10.0, 3.0);
        var result3 = calculator((Double a, Double b) -> a / b,11.0, 3.0);
        var result4 = calculator((a,b) -> a.toUpperCase() + " " + b.toUpperCase(), "Ralph", "Kradmen");
    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }
    // Instead of my own interface, which I called Operation, I'm going to make the first parameter, a BinaryOperator.
    // This gives me an error on the first statement, where I'm executing operate, which was the functional method name,
    // on my own interface. The functional method name on the BinaryOperator is apply, so I'll change operate, to apply.
    // With those two changes, my code compiles, and if I run it. I get the exact same results. I didn't really need to
    // create this Operation interface at all. As it turns out, a lot can be accomplished with just a few different types
    // of interfaces, and Java gives us a library of these.
}
