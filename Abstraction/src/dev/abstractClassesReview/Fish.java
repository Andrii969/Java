package dev.abstractClassesReview;

public class Fish extends Animal {

    // Even though the abstract class won't ever be instantiated, a constructor we declared on it
    // must be called by every subclass constructor. This means we're forcing subclasses
    // to also use this constructor.


    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (speed == "slow") {
            System.out.println(getExplicitType() + " lazily moving");
        } else {
            System.out.println(getExplicitType() + " moving fast");
        }
    }

    @Override
    public void makeNoise() {
        if (type == "Goldfish") {
            System.out.println("swish ");
        } else {
            System.out.println("splash ");
        }
    }
}
