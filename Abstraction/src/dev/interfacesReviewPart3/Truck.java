package dev.interfacesReviewPart3;

public class Truck implements Trackable {

    @Override // abstract method from Trackable interface
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates recorded!");

    }
}
