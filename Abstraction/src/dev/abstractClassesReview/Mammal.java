package dev.abstractClassesReview;

public abstract class Mammal extends Animal {
    // An abstract class that extends another abstract class has some flexibility.
    // It can implement all of the parent's abstract methods. It can implement some
    //of them. Or it can implement none of them. It can also include additional abstract methods,
    //which will force subclasses to implement both Animal's abstract methods, as well as Mammal's.
    //Ok, so first, let's create a new class in the dev.lpa package, and I'll call it Horse.

    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) { // concrete method overrides abstract method from Animal, so Mammal's subclasses don't have to override the method
        System.out.print(getExplicitType() + " ");
        System.out.println(speed.equals("slow") ? "walks" : "runs");
    }

    public abstract void shedHair();
}
