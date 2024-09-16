package LambdaExpressionsPartTwo;

import java.util.ArrayList;
import java.util.List;

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

    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        T result = function.operate(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }
    // <T> (Generic Type Declaration):
    // This declares that the method is generic and can work with any type. The T is a placeholder for the actual type,
    // and it can represent any class, primitive, or other types.
    // The <T> declaration is placed before the return type T, telling the compiler that T is a type parameter for this method.
    // Operation<T> function:
    // The first parameter, Operation<T> function, is an instance of the Operation interface, which also uses the generic type T.
    // Since Operation is a functional interface, a lambda expression that conforms to the operate(T, T) method signature
    // can be passed in.
    // T here refers to whatever type is used when calling the method, such as Integer, String, Double, etc.
    //T value1, T value2:
    // These are the two values that will be passed to the operate(T, T) method of the Operation interface.
    // Both of these values must be of the same type T.
    // These values can be anything: integers, doubles, strings, etc., depending on the type T.
}
