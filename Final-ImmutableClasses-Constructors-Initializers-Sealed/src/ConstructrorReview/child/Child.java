package ConstructrorReview.child;

import ConstructrorReview.Parent;

import java.util.Random;

public class Child extends Parent {

    private final int birthOrder = getBirthOrder();
    private final String birthOrderString;

    { // Instance initializer
        if (siblings == 0) {
            birthOrderString = "Only";
        } else if (birthOrder == 1) {
            birthOrderString = "First";
        } else if (birthOrder == (siblings + 1)) {
            birthOrderString = "Last";
        } else {
            birthOrderString = "Middle";
        }
        System.out.println("Child: Initializer, birthOrder = " + birthOrder + ", birthOrderString = " + birthOrderString);
    }

    public Child() {
        super("Jane Doe", "11/11/1991", 5);
        System.out.println("Child: Constructor");
    }

    private final int getBirthOrder() {
        if (siblings == 0) return 1;
        return new Random().nextInt(1, siblings + 2);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + birthOrderString + " child, " + birthOrder + " in the order";
    }
}
