package ChainingLambdas;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

//        String name = "Tim";
//        Function<String,String> uCase = (s) -> s.toUpperCase();
//        name = uCase.apply(name);
//        System.out.println(name);

        String name = "Tim";
        Function<String,String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));

        Function<String,String> lastName = s -> s.concat(" Buchalka");

        Function<String,String> uCaseLastName = uCase.andThen(lastName);
        System.out.println("uCase.andThen(lastName) = " + uCaseLastName.apply(name));

        uCaseLastName = uCase.compose(lastName); // So, what exactly does compose do? The opposite of the andThen method actually.
        // The compose method is only available to lambda expressions, that target either a Function, or a UnaryOperator interface.
        // BiFunction, BinaryOperator, and other function category interfaces that take a primitive, don't support the compose method.
        System.out.println("uCase.compose(lastName) = does reversed order of operations = " + uCaseLastName.apply(name));

        Function<String, String[]> function = uCase
                .andThen((s) -> s.concat(" Buchalka"))
                .andThen((s) -> s.split(" "));
        // Each function just needs to produce a type that the next function can accept as input. Only the last function
        // in the chain needs to return a value that matches the declared return type specified by the Function.
        System.out.println(Arrays.toString(function.apply(name)));

        Function<String, String> function1 = uCase
                .andThen((s) -> s.concat(" Buchalka"))
                .andThen((s) -> s.split(" "))
                .andThen(s -> s[1].toUpperCase() + ", " + s[0]);
        System.out.println(function1.apply(name));

        Function<String, Integer> function2 = uCase
                .andThen((s) -> s.concat(" Buchalka"))
                .andThen((s) -> s.split(" "))
                .andThen((s) -> String.join(", ", s))
                .andThen(String::length);
        System.out.println(function2.apply(name));

        String[] names = {"Anna", "Bob", "Carol"};
        Consumer<String> s0 = (s) -> System.out.print(s.charAt(0));
        Consumer<String> s1 = System.out::println;
        Arrays.asList(names).forEach(s0
                .andThen((s) -> System.out.print(" - "))
                .andThen(s1)
        );

        Predicate<String> p1 = s -> s.equals("TIM");
        Predicate<String> p2 = s -> s.equalsIgnoreCase("Tim");
        Predicate<String> p3 = s -> s.startsWith("T");
        Predicate<String> p4 = s -> s.endsWith("m");

        Predicate<String> combined1 = p1.or(p2);
        System.out.println("combined1 = " + combined1.test(name));

        Predicate<String> combined2 = p1.and(p2);
        System.out.println("combined2 = " + combined2.test(name));

        Predicate<String> combined3 = p3.and(p3);
        System.out.println("combined3 = " + combined3.test(name));

        Predicate<String> combined4 = p3.and(p3).negate();
        // Negate takes no parameters, and simply returns the opposite result of the result from the previous functions.
        System.out.println("combined4 = " + combined4.test(name));





    }
}
