package dev.interfaces;

enum FlightStages implements Trackable {GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;
    // After the enum name, I'll add implements Trackable, before the constants list.
    // For the list, I'll add grounded, launch, cruise, and data collection.
    // This enum describes four stages of a satellite launch.
    //What I'm saying by doing this is that I really want each of these stages to be trackable.

    @Override
    public void track() {
        if (this != GROUNDED) {
            System.out.println("Monitoring " + this);
        }
    }
};

record DragonFly(String name, String type) implements FlightEnabled {
    // Normally, records wouldn't have
    // class bodies, but because I'm implementing FlightEnabled, this record needs to implement
    // FlightEnabled abstract methods.

    @Override
    public void takeoff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

class Satelline implements OrbitEarth { // must implement all the methods on OrbitEarth and FlightEnabled

    @Override
    public void achieveOrbit() {
        System.out.println("Orbit achieved!");
    }

    @Override
    public void takeoff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

interface OrbitEarth extends FlightEnabled { // this interface requires to implement both OrbitEarth and FlightEnabled abstract methods

    void achieveOrbit();
}

interface FlightEnabled { // interface never gets instantiated

    double MILES_TO_KM = 1.60934; // any fields declared on the interface, aren't instance fields, but those are public static final
    double KM_TO_MILES = 0.621371; // == double or final double or public final double or public static final double

    public abstract void takeoff(); // public and abstract modifiers are redundant, meaning unnecessary to declare

    abstract void land();           // abstract modifier is redundant, meaning unnecessary to declare

    void fly();                     // This is PREFERRED declaration, public and abstract are implied.
}

interface Trackable {

    void track();
}

public abstract class Animal {

    public abstract void move();
}
