package IntermediateOperations;

import java.util.Comparator;
import java.util.stream.Stream;

record Seat(char rowMarker, int seatNumber, double price) {

    public Seat(char rowMarker, int seatNumber) {
        this(rowMarker, seatNumber, rowMarker > 'C' && (seatNumber <= 2 || seatNumber >= 9) ? 50 : 75);
    }

    @Override
    public String toString() {
        return "%c%03d %.0f".formatted(rowMarker, seatNumber, price);
    }
}

public class MapPeekSorted {

    public static void main(String[] args) {

        int maxSeats = 100;
        int seatsInRow = 10;
//        var streamA = Stream.iterate(0, i -> i < maxSeats, i -> i + 1)
//                .map(i -> new Seat((char) ('A' + i / seatsInRow), i % seatsInRow + 1))
//                .mapToDouble(Seat::price) // or .map(Seat::rowMarker) // .map(Seat::seatNumber) // .map(Seat::toString)
//                .mapToObj("%.2f"::formatted); // or .boxed() .map("%.2f"::formatted);
//        streamA.forEach(System.out::println);
//
//        System.out.println("-".repeat(30));
//
//        var streamB = Stream.iterate(0, i -> i < maxSeats, i -> i + 1)
//                .map(i -> new Seat((char) ('A' + i / seatsInRow), i % seatsInRow + 1))
//                .sorted(Comparator.comparing(Seat::price).thenComparing(Seat::toString));
//        streamB.forEach(System.out::println);

        System.out.println("-".repeat(30));

        var streamC = Stream.iterate(0, i -> i < maxSeats, i -> i + 1)
                .map(i -> new Seat((char) ('A' + i / seatsInRow), i % seatsInRow + 1))
                .skip(5)
                .limit(10)
                .peek(s -> System.out.println("--> " + s))
                .sorted(Comparator.comparing(Seat::price).thenComparing(Seat::toString));
        streamC.forEach(System.out::println);
    }
}
