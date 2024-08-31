package dev.interfacesReviewPart3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        bird.move(); // Bird flaps wigns!
        animal.move(); // Bird flaps wigns!
        System.out.println("-".repeat(30));
//        flier.move(); // compiler error
//        tracked.move(); // compiler error

        flier.takeOff();
        flier.fly();
        tracked.track();
        flier.land();
        System.out.println("-".repeat(30));

        inFlight(flier);
        System.out.println("-".repeat(30));

        inFlight(new Jet());
        System.out.println("-".repeat(30));
        inFlight(bird);
        System.out.println("-".repeat(30));

        Trackable truck = new Truck();
        truck.track();

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * dev.interfacesReviewPart2.FlightEnabled.KM_TO_MILES;
        System.out.printf("The truck traveled %.2f km or %.2f miles%n", kmsTraveled, milesTraveled);
        System.out.println("-".repeat(60));

        ArrayList<FlightEnabled> fliers = new ArrayList<>();
        fliers.add(bird);

        List<FlightEnabled> betterFliers = new ArrayList<>();
        betterFliers.add(bird);

        List<FlightEnabled> otherFliers = new LinkedList<>();
        betterFliers.add(bird);

        doFlying(fliers);
        System.out.println("-".repeat(30));

//        doFlying(betterFliers); // compiler error
//        doFlying(otherFliers); // compiler error

        doBetterFlying(fliers);
        doBetterFlying(betterFliers);
        doBetterFlying(otherFliers);
    }


    private static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.fly();
        if (flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }

    private static void doFlying(ArrayList<FlightEnabled> fliers) { // not good implementation
        for (var flier : fliers) {
            flier.takeOff();
            flier.fly();
            flier.land();
        }
    }

    private static void doBetterFlying(List<FlightEnabled> fliers) { // good implementation
        for (var flier : fliers) {
            flier.takeOff();
            flier.fly();
            flier.land();
        }
    }
    // Using List (the interface) instead of ArrayList or LinkedList (the concrete implementations) in method signatures is better because:
    // Flexibility: It allows you to pass any List implementation (ArrayList, LinkedList, etc.) to the method.
    // This flexibility means you can change the implementation without modifying the method signature or other code that uses the method.
    // No Refactoring Needed: When you use List, you can swap one type of list implementation (like ArrayList) with another (like LinkedList)
    // without any additional changes. This means you only need to modify the line where the list is declared, without having to refactor
    // other parts of your code that interact with it.


}
