package dev.interfacesReviewPart2;
public class Main {

    public static void main(String[] args) {

        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        bird.move(); // Bird flaps wigns!
        animal.move(); // Bird flaps wigns!
//        flier.move(); // compiler error
//        tracked.move(); // compiler error

        flier.takeOff();
        flier.fly();
        tracked.track();
        flier.land();
    }


}
