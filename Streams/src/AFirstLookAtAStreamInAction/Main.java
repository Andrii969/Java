package AFirstLookAtAStreamInAction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> bingoPool = new ArrayList<>(75);

        int start = 1;
        for (char c : "BINGO".toCharArray()) {
            for (int i = start; i < (start + 15); i++) {
                bingoPool.add("" + c + i);
//                System.out.println("" + c + i);
            }
            start += 15;
        }

        Collections.shuffle(bingoPool);
        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }

        System.out.println("-".repeat(30));

//        List<String> firstOnes = bingoPool.subList(0, 15);
        List<String> firstOnes = new ArrayList<>(bingoPool.subList(0, 15)); // copy (doesn't affect original pool)
        firstOnes.sort(Comparator.naturalOrder());
        firstOnes.replaceAll((s) -> {
            if (s.indexOf('G') == 0 || s.indexOf('O') == 0) {
                String updated = s.charAt(0) + "-" + s.substring(1);
                System.out.println("updated " + updated);
                return updated; // Updated and returned if starts with 'G' or 'O'
            }
            return s; // // Returned as-is for all other cases
        });
        System.out.println("-".repeat(30));

        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }

        // // // // // // // // // // // // // // // // // // // // // // // //
        // USING STREAMS

        bingoPool.stream() // it's stream pipeline // in this case void
                .limit(15)
                .filter(s -> s.indexOf('G') == 0 || s.indexOf('O') == 0)
                .map(s -> s.charAt(0) + "-" + s.substring(1)) // similar to the replaceAll on Collections
                .sorted()
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        System.out.println("-".repeat(90));

        var tempStream = bingoPool.stream() // it's stream pipeline // in this case void
                .limit(15)
                .filter(s -> s.indexOf('G') == 0 || s.indexOf('O') == 0)
                .map(s -> s.charAt(0) + "-" + s.substring(1)) // similar to the replaceAll on Collections
                .sorted();

        tempStream.forEach(s -> System.out.print(s + " "));
    }
}
