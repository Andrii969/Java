package dev.interfacesReviewPart2;
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

        inFlight(new Jet());                        // You can see that we're able to pass both a Jet and a Bird to a method that can use them
        System.out.println("-".repeat(30));  // because both of these classes implement FlightEnabled and Trackable.
        inFlight(bird);                             // What's really nice is that you can mix and match interfaces as you need them
        System.out.println("-".repeat(30));

        Trackable truck = new Truck(); // truck can ONLY use methods defined in the Trackable interface (not even from Truck)
                                        // IF --> Truck truck = new Truck(); could use methods from Truck class and Trackable interface (as it implements it)
        truck.track(); // a Truck can only be tracked because it implements the Trackable interface

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;
        System.out.printf("The truck traveled %.2f km or %.2f miles%n", kmsTraveled, milesTraveled);

    }


    private static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.fly();
        if (flier instanceof Trackable tracked) { // If the object is a class that implements Trackable, then a local variable is set up named tracked,
            tracked.track();                      // with the type Trackable. And because of that, I can call the track method on that variable.
                                                // This allows the method to accept any object that implements the FlightEnabled interface,
                                                // not just Bird objects. It gives you more flexibility and demonstrates polymorphism.
        }
        flier.land();
    }

//    private static void inFlight2(Trackable tracked) { // works as above, but the right object should be passed (tracked or jet or bird)
//        if (tracked instanceof FlightEnabled flier) {
//            flier.takeOff();
//            flier.fly();
//            tracked.track();
//            flier.land();
//        }
//    }


}
