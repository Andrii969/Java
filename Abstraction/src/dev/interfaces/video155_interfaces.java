package dev.interfaces;

public class video155_interfaces {

    public static void main(String[] args) {

        Bird bird = new Bird();
//        if (bird instanceof Bird && bird instanceof Animal && bird instanceof Trackable && bird instanceof FlightEnabled) {
//            System.out.println("bird instanceof Bird & Animal & Trackable & FlightEnabled"); // bird instanceof Bird & Animal & Trackable & Bird
//        }

        Animal animal = bird;
//        System.out.println(animal.getClass().getSimpleName()); // Bird

        FlightEnabled flier = bird;
//        System.out.println(flier.getClass().getSimpleName()); // Bird

        Trackable tracked = bird;
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

    private static void inFlight(FlightEnabled flier) {
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
}
