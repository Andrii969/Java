package StreamSourceChallenge;

import java.util.Arrays;
import java.util.stream.Stream;

public class MainBingoInstructor {

    static int counter = 0;

    public static void main(String[] args) {

        int seed = 1;
        var streamB = Stream.iterate(seed, i -> i <= 15, i -> i + 1)
                .map(i -> "B" + i);

        seed += 15;
        var streamI = Stream.iterate(seed, i -> i + 1)
                .limit(15)
                .map(i -> "I" + i);

        seed += 15;
        int nSeed = seed;
        String[] nLabels = new String[15];
        Arrays.setAll(nLabels, i -> "N" + (nSeed + i));
        var streamN = Arrays.stream(nLabels);

        seed += 15;
        var streamG = Stream.of("G46", "G47", "G48", "G49", "G50", "G51", "G52", "G53", "G54",
                "G55", "G56", "G57", "G58", "G59", "G60");

        seed += 15;
        int rSeed = seed;
        var streamO = Stream.generate(() -> getCounter())
                .limit(15)
                .map(i -> "O" + (rSeed + i));

        var streamBI = Stream.concat(streamB, streamI);
        var streamNG = Stream.concat(streamN, streamG);
        var streamBING = Stream.concat(streamBI, streamNG);
        Stream.concat(streamBING, streamO)
                .forEach(System.out::println);


//        streamO.forEach(System.out::println); // can't use already used stream pipeline
    }

    private static int getCounter() {
        return counter++;
    }
}

