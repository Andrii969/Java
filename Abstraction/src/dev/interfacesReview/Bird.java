package dev.interfacesReview;

public class Bird extends Animal implements FlightEnabled, Trackable {

    @Override // abstract method from Animal abstract class
    public void move() {
        System.out.println(getClass().getSimpleName() + " flaps wigns!");
    }

    @Override // abstract method from FlightEnabled interface
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " is taking off!");
    }

    @Override // abstract method from FlightEnabled interface
    public void land() {
        System.out.println(getClass().getSimpleName() + " is landing!");

    }

    @Override // abstract method from FlightEnabled interface
    public void fly() {
        System.out.println(getClass().getSimpleName() + " is flying!");

    }

    @Override // abstract method from Trackable interface
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates recorded!");
    }
}
