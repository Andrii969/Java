package StreamSourceChallenge;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainBingo {

    public static void main(String[] args) {

        var streamB = IntStream.rangeClosed(1,15)
                .mapToObj(n -> "B" + n);
        var streamI =IntStream.rangeClosed(16,30)
                .mapToObj(n -> "I" + n);
        var streamN =IntStream.rangeClosed(31,45)
                .mapToObj(n -> "N" + n);
        var streamG =IntStream.rangeClosed(46,60)
                .mapToObj(n -> "G" + n);
        var streamO =IntStream.rangeClosed(61,75)
                .mapToObj(n -> "O" + n);

        Stream.of(streamB, streamI, streamN, streamG, streamO)
                .flatMap(s -> s)
                .forEach(System.out::println);
    }
}
