package dev.interfacesReview;

public class Main {

    public static void main(String[] args) {

        Bird bird = new Bird();
        // Also we can say a Bird is an Animal, and that it's also FlightEnabled and Trackable.
        //That means I can assign my bird object to different reference types.
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        bird.move(); // Bird flaps wigns!
        animal.move(); // Bird flaps wigns!

//        flier.move(); // compiler error
//        tracked.move(); // compiler error
        // When we assigned the bird object to the FlightEnabled and Trackable variables,
        //those types don't have a move method on them, so this is why we get this error.
        //The compiler only cares about the declared type

        flier.takeOff();
        flier.fly();
        tracked.track();
        flier.land();
        // You can see that all of Bird's methods were called.
        //In this code, we have a variable, flier, of type FlightEnabled, and when we call any FlightEnabled
        //methods on that variable, it executes bird's methods, because bird is our runtime object.
        //And the same thing with Trackable. We can describe a bird in many ways now,
        //in the code, treating it as a member of multiple, and quite different groups.
    }


}
