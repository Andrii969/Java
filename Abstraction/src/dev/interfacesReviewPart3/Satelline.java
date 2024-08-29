package dev.interfacesReviewPart3;

public class Satelline implements OrbitEarth{


    @Override
    public void achieveOrbit() { // because this method is really public on the OrbitEarth interface, I need to specify public here.
        System.out.println("Orbit achieved!");
    }

    @Override
    public void takeOff() { // abstract method from FlightEnabled interface (I need to specify public here)

    }

    @Override // abstract method from FlightEnabled interface (I need to specify public here)
    public void fly() {

    }

    @Override // abstract method from FlightEnabled interface (I need to specify public here)
    public void land() {

    }
}
