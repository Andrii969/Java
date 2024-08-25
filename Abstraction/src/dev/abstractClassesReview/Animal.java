package dev.abstractClassesReview;

public abstract class Animal {

    protected String type; // protected means subclasses can access type without getters
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public abstract void move(String speed);
    public abstract void makeNoise();

    public final String getExplicitType() { // a concrete method on an abstract class, with a body. Like any method on a parent class, that's a method we can use in subclasses.
                                    // Concrete Methods: These provide a default implementation in the abstract parent class.
                                // Subclasses can override these methods if they need to change or extend the behavior, but they are not required to do so.
                                // NOTE: if final, it prevents from overriding (subclass can't change it)
        return getClass().getSimpleName() + " (" + type + ") ";
    }
}
