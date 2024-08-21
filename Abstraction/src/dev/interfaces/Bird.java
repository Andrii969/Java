package dev.interfaces;

public class Bird extends Animal implements FlightEnabled, Trackable { // class can extend only one class, but implement multiple interfaces
    // This class, because it implements these two interfaces,
    // now has to implement the methods on FlightEnabled and Trackable,
    // as well as methods from the Animal abstract class.

    @Override
    public void move() {
        System.out.println("Flaps wings");
    }

    @Override
    public void takeoff() {
        System.out.println(getClass().getSimpleName() + " is taking off.");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName() + " is landing.");
    }

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " is flying.");
    }

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates recorded.");
    }
}
