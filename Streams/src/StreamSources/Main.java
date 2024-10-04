package StreamSources;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String[] strings = {"One", "Two", "Three"};

        // I can use another helper method on the java.util.Arrays class, called stream
        Arrays.stream(strings)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println("-".repeat(30));

        Stream.of("Six", "Seven", "Eight")
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

        // // // // // // // // // // // // // // // // // // // // //

        var firstStream = Arrays.stream(strings)
                .sorted(Comparator.reverseOrder());

        var secondStream = Stream.of("Six", "Seven", "Eight")
                .map(s -> s.toUpperCase());

//        System.out.println("-".repeat(30));
//        Stream.concat(firstStream, secondStream) // I can use the concat method on Stream, to produce a single Stream, from two streams
//                .forEach(System.out::println);

        // NOTE: The concat() method consumes firstStream and secondStream in this line:
        // After this, both firstStream and secondStream are consumed and cannot be used again.

        System.out.println("-".repeat(30));
        Stream.concat(firstStream, secondStream)
                .map(s -> s.charAt(0) + "-" + s)
                .forEach(System.out::println);


        // // // // // // // // // // // // // // // // //
        System.out.println("-".repeat(30));
        Random random = new Random();
        Stream.generate(() -> random.nextInt(2))
                .limit(10)
                .forEach((s) -> System.out.print(s + " "));

        System.out.println();
        System.out.println("-".repeat(30));
        IntStream.iterate(1, n -> n + 1) // IntStream simply because dealing with integers
                                                // seed it's a starting value, after that is Unary Operator
                .filter(Main::isPrime) // or .filter(n -> isPrime(n))
                .limit(20)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
        System.out.println("-".repeat(30));
        IntStream.iterate(1, n -> n + 1)
                .limit(100)
                .filter(Main::isPrime)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
        System.out.println("-".repeat(30));
        IntStream.iterate(1, n -> n <= 100, n -> n + 1) // iterate(int seed, IntPredicate hasNext, IntUnaryOperator next)
                .filter(Main::isPrime)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
        System.out.println("-".repeat(30));
        IntStream.range(1, 100) // I'll replace iterate with range, which takes a starting and ending value,
                                // and automatically increments by one
                                // Note: range doesn't include the ending value, rangeClosed includes ending value
                .filter(Main::isPrime)
                .forEach(n -> System.out.print(n + " "));

    }

    public static boolean isPrime (int wholeNumber) {
        if (wholeNumber <= 2) {
            return (wholeNumber == 2);
        }
        for (int divisor = 2; divisor < wholeNumber; divisor++) {
            if (wholeNumber % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
