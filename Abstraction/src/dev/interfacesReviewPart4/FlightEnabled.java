package dev.interfacesReviewPart4;

public interface FlightEnabled {

    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    public abstract void takeOff(); // Modifier 'public' is redundant for interface members
    abstract void land(); // Modifier 'abstract' is redundant for interface methods
    void fly();

//    default FlightStages checkTransition(FlightStages stage) { //
//        System.out.println("transition not implemented on " + getClass().getSimpleName());
//                   // It's common practice to write a statement like this, or throw an exception, to confirm
//                  //that a default method isn't implemented. This means I really want every class using
//                  //this interface to override this method, before they actually use it in code.
//        return null;
//    };
    // Adding a default method doesn't break any classes currently implementing the interface.
    // This method is a concrete method, meaning it has a code block, and we can add statements to it.

    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = stage.getNextStage(); // using method from the FlightStages enum
        System.out.println("Transitioning from " + stage + " to " + nextStage);
        return nextStage;
    }


}
