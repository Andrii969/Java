package dev.interfaces;

public class test {

    public static void main(String[] args) {

//        inFlight(new Jet());

//        OrbitEarth.log("Testing " + new Satelline());

        orbit(new Satelline());

    }

    private static void inFlight(FlightEnabled flier) { // only classes that implement the FlightEnabled interface can be passed to this method.
        flier.takeoff();
        flier.transition(FlightStages.LAUNCH);
        flier.fly();
        if (flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }

    private static void orbit(OrbitEarth flier) { // only classes that implement the FlightEnabled interface can be passed to this method.
        flier.takeoff();
        flier.fly();
        if (flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }
}
