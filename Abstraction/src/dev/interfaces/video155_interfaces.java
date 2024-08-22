package dev.interfaces;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class video155_interfaces {

    public static void main(String[] args) {

        Bird bird = new Bird();
//        if (bird instanceof Bird && bird instanceof Animal && bird instanceof Trackable && bird instanceof FlightEnabled) {
//            System.out.println("bird instanceof Bird & Animal & Trackable & FlightEnabled"); // bird instanceof Bird & Animal & Trackable & Bird
//        }

        Animal animal = bird;
//        if (animal instanceof Bird && bird instanceof Animal && bird instanceof Trackable && bird instanceof FlightEnabled) {
//            System.out.println("animal instanceof Bird & Animal & Trackable & FlightEnabled"); // animal instanceof Bird & Animal & Trackable & Bird
//        }
//        System.out.println(animal.getClass().getSimpleName()); // Bird

        FlightEnabled flier = bird; // FlightEnabled flier = new FlightEnabled(); // 'FlightEnabled' is abstract; cannot be instantiated
//        if (flier instanceof Bird && bird instanceof Animal && bird instanceof Trackable && bird instanceof FlightEnabled) {
//            System.out.println("flier instanceof Bird & Animal & Trackable & FlightEnabled"); // flier instanceof Bird & Animal & Trackable & Bird
//        }
//        System.out.println(flier.getClass().getSimpleName()); // Bird

        Trackable tracked = bird;
//        if (tracked instanceof Bird && bird instanceof Animal && bird instanceof Trackable && bird instanceof FlightEnabled) {
//            System.out.println("tracked instanceof Bird & Animal & Trackable & FlightEnabled"); // tracked instanceof Bird & Animal & Trackable & Bird
//        }
//        System.out.println(tracked.getClass().getSimpleName()); // Bird


//        bird.move(); // Flaps wings
//        animal.move(); // Flaps wings

        inFlight(flier);
        System.out.println("-".repeat(30));

        inFlight2(tracked);
        System.out.println("-".repeat(30));

        inFlight(new Jet());
        System.out.println("-".repeat(30));

        Truck truck = new Truck(); // OR Trackable truck = new Truck();
        truck.track();

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;
        System.out.printf("The truck traveled %.2f km or %.2f miles %n", kmsTraveled, milesTraveled);

        LinkedList<FlightEnabled> fliers = new LinkedList<>();
        fliers.add(bird);

        List<FlightEnabled> betterFliers = new ArrayList<>(); // is an ArrayList that can hold objects of any type that implements the FlightEnabled interface.
        betterFliers.add(bird);

        triggerFliers(fliers);
        flyFliers(fliers);
        landFliers(fliers);

        triggerFliers(betterFliers);
        flyFliers(betterFliers);
        landFliers(betterFliers);


//        When we assigned the bird object to the FlightEnabled and Trackable variables,
//        those types don't have a move method on them, so this is why we get this error.

//        flier.move(); // compiler error
//        tracked.move(); // compiler error


//        You can see that all of Bird's methods were called.
//        In this code, we have a variable, flier, of type FlightEnabled, and when we call any FlightEnabled
//        methods on that variable, it executes bird's methods, because bird is our runtime object.
//        And the same thing with Trackable. We can describe a bird in many ways now,
//        in the code, treating it as a member of multiple, and quite different groups.

//        flier.takeoff(); // Bird is taking off.
//        flier.fly(); // Bird is flying.
//        tracked.track(); // Bird's coordinates recorded.
//        flier.land(); // Bird is landing.

    }

    private static void inFlight(FlightEnabled flier) { // only classes that implement the FlightEnabled interface can be passed to this method.
        flier.takeoff();
        flier.fly();
        if (flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    } // Bird is taking off.
    // Bird is flying.
    // Bird's coordinates recorded.
    // Bird is landing.

    private static void inFlight2(Trackable tracked) {
        if (tracked instanceof FlightEnabled flier) {
            flier.takeoff();
            flier.fly();
            flier.land();
        }
        tracked.track();
    } // Bird is taking off.
    // Bird is flying.
    // Bird is landing.
    // Bird's coordinates recorded.


    // You can't pass a List or LinkedList to a method where an ArrayList is declared ↓, so let's change to List below.

    private static void triggerFliers (List<FlightEnabled> fliers) { // was ArrayList

        for (var flier : fliers) {
            flier.takeoff();
        }
    }

    private static void flyFliers (List<FlightEnabled> fliers) { // was ArrayList

        for (var flier : fliers) {
            flier.fly();
        }
    }

    private static void landFliers (List<FlightEnabled> fliers) { // was ArrayList

        for (var flier : fliers) {
            flier.land();
        }
    }






}