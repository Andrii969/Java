package LambdaChallenges;

import java.util.function.*;

public class LambdaExamples {

    public static void main(String[] args) {

        // 1. Consumer<T>
        // Accepts a single argument of type T and performs an action. It does not return any result.
        Consumer<String> printMessage = msg -> System.out.println(msg);
        printMessage.accept("Hello, Consumer!");  // Output: Hello, Consumer!

        // 2. BiConsumer<T, U>
        // Accepts two arguments of types T and U and performs an action. It does not return any result.
        BiConsumer<String, Integer> printKeyValue = (key, value) ->
                System.out.println("Key: " + key + ", Value: " + value);
        printKeyValue.accept("Apple", 5);  // Output: Key: Apple, Value: 5

        // 3. Function<T, R>
        // Accepts one argument of type T and returns a result of type R. Often used for data transformation.
        Function<Integer, String> intToString = num -> "Number: " + num;
        System.out.println(intToString.apply(5));  // Output: Number: 5

        // 4. BiFunction<T, U, R>
        // Accepts two arguments of types T and U and returns a result of type R. Useful for combining two inputs.
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(10, 20));  // Output: 30

        // 5. UnaryOperator<T>
        // A specialized version of Function<T, R> where the input and output types are the same.
        // It performs an operation and returns a result of the same type as the input.
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(4));  // Output: 16

        // 6. BinaryOperator<T>
        // A specialized version of BiFunction<T, U, R> where both arguments and the return type are the same.
        // It takes two arguments of the same type and combines them to return the same type.
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println(multiply.apply(5, 3));  // Output: 15

        // 7. Predicate<T>
        // Accepts one argument of type T and returns a boolean result. Often used for condition checks or filtering.
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(4));  // Output: true
        System.out.println(isEven.test(5));  // Output: false

        // 8. BiPredicate<T, U>
        // Accepts two arguments of types T and U and returns a boolean result. Useful for checking conditions that involve two inputs.
        BiPredicate<String, Integer> hasLength = (str, len) -> str.length() == len;
        System.out.println(hasLength.test("Hello", 5));  // Output: true
        System.out.println(hasLength.test("World", 3));  // Output: false

        // 9. Supplier<T>
        // Takes no arguments and returns a result of type T. Often used for supplying or generating values.
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println(randomValue.get());  // Output: Random number (e.g., 0.1234)

        // 10. ToIntFunction<T>
        // Accepts one argument of type T and returns an int. Useful for extracting integer values from objects.
        ToIntFunction<String> lengthOfString = str -> str.length();
        System.out.println(lengthOfString.applyAsInt("Lambda"));  // Output: 6
    }
}
