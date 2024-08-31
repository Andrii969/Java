package dev.interfacesReviewPart4;

public enum FlightStages implements Trackable {GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION, DATA_SENDING;
    // Both records and enums can implement interfaces. But they can't extend classes, abstract or not.

    @Override
    public void track() {

        if (this != GROUNDED) {
            System.out.println("Monitoring " + this);
        }
    }
    // The track() method checks whether the current enum instance (this) is not equal to GROUNDED.
    //If it's any stage other than GROUNDED, it prints out a monitoring message, like "Monitoring LAUNCH", "Monitoring CRUISE", etc.

    public FlightStages getNextStage() {
        FlightStages[] allStages = FlightStages.values();
        return allStages[(ordinal() + 1) % allStages.length]; // (0+1) % 4 -> 1; (1+1) % 4 -> 2; (2+1) % 4 -> 3; (3+1) % 4 -> 0
    }
}
