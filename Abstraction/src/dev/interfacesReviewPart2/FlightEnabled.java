package dev.interfacesReviewPart2;

public interface FlightEnabled {

    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;
    // Any fields declared on an interface, are not really instance fields.
    // They're implicitly public, static, and final. Which means they're really constants.

    public abstract void takeOff();
    abstract void land();
    void fly();

}
