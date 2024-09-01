package dev.interfacesReviewPart4;

public interface OrbitEarth extends FlightEnabled {

    void achieveOrbit();

    void sendData();

    private void log(String description) { // subclasses aren't forced to override this method
                                            // public static methods allow us to include helper methods on the interface type itself
        var currentDate = new java.util.Date();
        System.out.println(currentDate + ": " + description);
    }

    private void logStage(FlightStages stage, String description) {
        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = FlightEnabled.super.transition(stage); // default FlightStages transition(FlightStages stage) {
                                                                        // FlightStages nextStage = stage.getNextStage(); // using method from the FlightStages enum
                                                                                                                                                                     //     public FlightStages getNextStage() {
                                                                                                                                                                     //        FlightStages[] allStages = FlightStages.values();
                                                                                                                                                                     //        return allStages[(ordinal() + 1) % allStages.length]; // (0+1) % 4 -> 1; (1+1) % 4 -> 2; (2+1) % 4 -> 3; (3+1) % 4 -> 0
                                                                                                                                                                     //    }
                                                                        // System.out.println("Transitioning from " + stage + " to " + nextStage);
                                                                        // return nextStage;
                                                                        // }
        logStage(stage, "Beginning Transition to " + nextStage);
        return nextStage;
    }
}
