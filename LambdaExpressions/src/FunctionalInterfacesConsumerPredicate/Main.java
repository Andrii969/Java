package FunctionalInterfacesConsumerPredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));

        list.sort((o1,o2) -> o1.compareTo(o2));
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

        BinaryOperator<Integer> operator = (a, b) -> a + b;
        int result5 = calculator(operator, 5, 2);

        System.out.println("-".repeat(30));
        var coords = Arrays.asList(
                new double[]{32.3, 23.2},
                new double[]{32.3, 23.2},
                new double[]{32.3, 23.2});
        coords.forEach((d) -> System.out.println(Arrays.toString(d)));

        BiConsumer<Double, Double> consumer = (lan, lng) -> {
            System.out.printf("[lan:%.3f, lng:%.3f]%n", lan, lng);
        };

        consumer.accept(2323.1, 2323.2);

        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], consumer);

        coords.forEach((c) -> processPoint(c[0], c[1], consumer));
        // alternatively
//        coords.forEach((c) -> processPoint(c[0], c[1], (lan, lng) -> {
//            System.out.printf("[lan:%.3f, lng:%.3f]%n", lan, lng);
//        }));

        System.out.println("-".repeat(30));
        list.removeIf((s) -> s.equalsIgnoreCase("bravo"));
        // In this example, the expression takes a String, and tests if it's equal to the literal text "bravo", ignoring case. It returns either true or false.
        // Another method on the List interface called removeIf, which takes a predicate type as an argument, so I'll invoke removeIf on list, and pass a lambda
        // expression. The lambda has one parameter, like a consumer, and in this case, it will be inferred to be a String, because my list is made up of Strings.
        list.forEach((s) -> System.out.println(s));

        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach((s) -> System.out.println(s));

        System.out.println("-".repeat(30));
        list.removeIf((s) -> s.startsWith("ea"));
        list.forEach((s) -> System.out.println(s));

        System.out.println("-".repeat(30));
        BiConsumer<String, Integer> biConsumer = (name, age) -> System.out.println(name + " is " + age + " years old");
        biConsumer.accept("Alice", 30); // Output: Alice is 30 years old
        // BiConsumer<T, U>
        // Purpose: Represents an operation that accepts two input arguments and returns no result. It’s intended for operations that perform
        // some side-effect, like printing or updating a value, but don’t produce a result.
        // Method: The main method of BiConsumer is void accept(T t, U u), which takes two arguments and performs an action.
        // Usage: Typically used when you want to perform an action with two arguments, but you don’t need a return value. For example,
        // you might use a BiConsumer to process or display two values.

        BinaryOperator<Integer> binaryOperator = (a, b) -> a + b;
        Integer result = binaryOperator.apply(5, 3); // Output: 8
        // BinaryOperator<T>
        // Purpose: Represents an operation that takes two operands of the same type and returns a result of the same type.
        // It’s a specialization of BiFunction for cases where the input and output types are the same.
        // Method: The main method of BinaryOperator is T apply(T t1, T t2), which takes two arguments and returns a result of the same type.
        // Usage: Typically used when you want to perform an operation that combines two values of the same type and produces a result of the same type.
        // For example, you might use a BinaryOperator to perform arithmetic operations or concatenate strings.


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

    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer) {
        consumer.accept(t1, t2);
    }
}
