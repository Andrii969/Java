package dev.interfacesReviewPart3;

public interface FlightEnabled {

    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    public abstract void takeOff();
    abstract void land();
    void fly();

}
