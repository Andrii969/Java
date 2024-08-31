package dev.interfacesReviewPart4;

public class Jet implements FlightEnabled, Trackable {

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

    @Override
    public FlightStages transition(FlightStages stage) { // overriding a default method from the FlightEnabled interface
        System.out.println(getClass().getSimpleName() + " transitioning");
        return FlightEnabled.super.transition(stage); // using method from the FlightEnabled interface
                                        // when calling a default method from an overridden method, you need to qualify super with the interface type
    }
}


// green icon means that we implement an abstract method
// blue icon implies an override