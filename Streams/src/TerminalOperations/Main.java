package TerminalOperations;

import java.util.Arrays;
import java.util.Random;

record Seat(char rowMarker, int seatNumber, boolean isReserved) {
    public Seat(char rowMarker, int seatNumber) {
        this(rowMarker, seatNumber, new Random().nextBoolean());
    }
}

public class Main {

    public static void main(String[] args) {

//        var result = IntStream
//                .iterate(0, i -> i <= 1000, i -> i + 3)
//                .summaryStatistics();
//        System.out.println("Result = " + result);
//
//
//        var result2 = IntStream
//                .iterate(2000, i -> i <= 2025, i -> i + 1)
//                .filter(i -> i % 4 == 0)
//                .peek(System.out::println)
//                .summaryStatistics();
//        System.out.println("Leap Year Data = " + result2);

        Seat[] seats = new Seat[100];
        Arrays.setAll(seats, i -> new Seat((char) ('A' + i / 10), i % 10 + 1));
        Arrays.asList(seats).forEach(System.out::println);

        long reservationCount = Arrays
                .stream(seats)
                .filter(Seat::isReserved)
                .count();
        System.out.println("reservationCount = " + reservationCount);

        boolean hasBookings = Arrays
                .stream(seats)
                .anyMatch(Seat::isReserved);
        System.out.println("hasBookings = " + hasBookings);

        boolean allBooked = Arrays
                .stream(seats)
                .allMatch(Seat::isReserved);
        System.out.println("allBooked = " + allBooked);

        boolean noneBooked = Arrays
                .stream(seats)
                .noneMatch(Seat::isReserved);
        System.out.println("noneBooked = " + noneBooked);
    }
}
