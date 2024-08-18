package dev.lpa;

public class Dog extends Mammal { // created a concrete Dog class that extended the abstract class

    // Even though the abstract class won't ever be instantiated, a constructor we declared on it
    // must be called by every subclass constructor. This means we're forcing subclasses
    // to also use this constructor.

    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (speed == "slow") {
            System.out.println(getExplicitType() + " is walking");
        } else {
            System.out.println(getExplicitType()  + " is running");

        }
    }

    @Override
    public void shedHair() {
        System.out.println(getExplicitType() + " sheds hair all the time");
    }

    @Override
    public void makeNoise() {
        if (type == "Wolf") {
            System.out.println("Howling! ");
        } else {
            System.out.println("Woof! ");
        }
    }

//    @Override
//    public String getExplicitType() { // 'getExplicitType()' cannot override 'getExplicitType()' in 'dev.lpa.Animal'; overridden method is final
//        return "";
//    }
}
