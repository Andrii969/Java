package dev.interfacesReviewPart3;

public record DragonFly(String name, String type) implements FlightEnabled {
    // Both records and enums can implement interfaces. But they can't extend classes, abstract or not.

    // Normally, records wouldn't have class bodies, but because
    // I'm implementing FlightEnabled, this record needs to implement
    // FlightEnabled's abstract methods.

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}
