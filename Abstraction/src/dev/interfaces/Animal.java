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

    public FlightStages getNextStage() {

        FlightStages[] allStages = values();
        return allStages[(ordinal() + 1) % allStages.length];
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

    FlightStages stage = FlightStages.GROUNDED;

    @Override
    public void achieveOrbit() {
        transition("Orbit achieved!");
    }

    @Override
    public void takeoff() {
        transition("Taking Off");
    }

    @Override
    public void land() {
        transition("Landing");

    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data Collection while Orbiting");
    }

    public void transition(String description) {
        System.out.println(description);
        stage = transition(stage);
        stage.track();

    }
}

interface OrbitEarth extends FlightEnabled { // this interface requires to implement both OrbitEarth and FlightEnabled abstract methods

    void achieveOrbit();

    private static void log(String description) {

        var today = new java.util.Date();
        System.out.println(today + ": " + description);
    }

    private void logStage(FlightStages stage, String description) {
        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning transition to " + nextStage);
        return nextStage;
    }
}

interface FlightEnabled { // interface never gets instantiated

    double MILES_TO_KM = 1.60934; // any fields declared on the interface, aren't instance fields, but those are public static final
    double KM_TO_MILES = 0.621371; // == double or final double or public final double or public static final double

    public abstract void takeoff(); // public and abstract modifiers are redundant, meaning unnecessary to declare

    abstract void land();           // abstract modifier is redundant, meaning unnecessary to declare

    void fly();                     // This is PREFERRED declaration, public and abstract are implied.

//    FlightStages transition(FlightStages stage); // Unfortunately, this one change means every class that implements this interface, won't compile.
                                // but, adding a default method doesn't break any classes currently implementing the interface.
    default FlightStages transition(FlightStages stage) {
//        System.out.println("Transition not implemented on " + getClass().getName());
//        return null;
        FlightStages nextStage = stage.getNextStage();
        System.out.println("Transitioning from " + stage + " to " + nextStage);
        return nextStage;
    }

}

interface Trackable {

    void track();
}

public abstract class Animal {

    public abstract void move();
}
