package dev.interfacesReviewPart4;

public class test {

    public static void main(String[] args) {

//        inFlight(new Jet());
//        System.out.println("-".repeat(30));

//        OrbitEarth.log("Testing " + new Satelline());
//        System.out.println("-".repeat(30));

        Satelline satelline = new Satelline();
        testSatelliteStages(satelline);

    }

    private static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.transition(FlightStages.DATA_COLLECTION);
        flier.fly();
        if (flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }

    private static void orbit(OrbitEarth flier) {
        flier.takeOff();
        flier.fly();
        flier.land();
    }

    private static void testSatelliteStages(Satelline satellite) {
        // Start from GROUNDED and go through each stage
        System.out.println("=== Starting Test for Satellite ===");

        // Taking off from GROUNDED to LAUNCH
        satellite.takeOff(); // Transition from GROUNDED to LAUNCH

        // Flying in orbit (transition to CRUISE)
        satellite.fly(); // Transition from LAUNCH to CRUISE
                        // Transition from CRUISE to DATA_COLLECTION

        // Landing back to GROUNDED (transition back to GROUNDED)
        satellite.land(); // Transition from DATA_COLLECTION to GROUNDED

        System.out.println("=== Test Completed ===");
    }
}
