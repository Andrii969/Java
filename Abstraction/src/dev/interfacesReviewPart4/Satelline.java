package dev.interfacesReviewPart4;

public class Satelline implements OrbitEarth {

    FlightStages stage = FlightStages.GROUNDED;

    @Override
    public void achieveOrbit() { // because this method is really public on the OrbitEarth interface, I need to specify public here.
        transition("Orbit achieved!"); // using transition method from this class
    }

    @Override
    public void sendData() {
        transition("Sending Data!"); // using transition method from this class
        System.out.println("Data is successfully sent!");
    }

    @Override
    public void takeOff() { // abstract method from FlightEnabled interface (I need to specify public here)
        transition("Taking off"); // using transition method from this class
    }

    @Override // abstract method from FlightEnabled interface (I need to specify public here)
    public void fly() {
        achieveOrbit();
        transition("Data Collection while Orbiting"); // using transition method from this class
        sendData();
    }

    @Override // abstract method from FlightEnabled interface (I need to specify public here)
    public void land() {
        transition("Landing");

    }

    public void transition(String description) {
        System.out.println(description);
        stage = transition(stage);  // method from OrbitEarth interface
        stage.track(); // method from FlightStages enum

    }
}
