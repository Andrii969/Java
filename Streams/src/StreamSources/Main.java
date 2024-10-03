package StreamSources;

import java.util.Arrays;
import java.util.Comparator;
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



    }
}
