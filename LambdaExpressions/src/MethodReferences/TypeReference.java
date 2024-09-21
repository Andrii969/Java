package MethodReferences;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class TypeReference {

    public static void main(String[] args) {

        calculator((a, b) -> a + b, "Hello ", "World");
        calculator((a, b) -> a.concat(b), "Hello ", "World");
        calculator(String::concat, "Hello ", "World");

        BinaryOperator<String> bioperator = String::concat;
        String result = bioperator.apply("Hello ", "World");
        System.out.println(result);

        BiFunction<String, String, String> bioperator2 = String::concat;
        String result2 = bioperator2.apply("Hello ", "World");
        System.out.println(result2);

        UnaryOperator<String> unaryOperator = String::toUpperCase;
        String result3 = unaryOperator.apply("Hello ");
        System.out.println(result3);

        String result4 = "World".transform(unaryOperator);
        System.out.println(result4);

        String result5 = "Hello World".transform(String::toUpperCase);
        System.out.println(result5);

        String result6 = "Hello World".toUpperCase();
        System.out.println(result6);

        Function<String, Boolean> function = String::isEmpty;
        boolean result7 = result6.transform(function);
        System.out.println("Result of operation: " + result7);




    }

    public static <T> void calculator(BinaryOperator<T> bioperator, T value1, T value2) {
        T result = bioperator.apply(value1, value2);
        System.out.println("Result of operation: " + result);
    }
}
