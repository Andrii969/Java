package dev.lpa;

public abstract class Animal {

    protected String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public abstract void move(String speed); // abstract methods can't be declared with a method body.
                                            // When you declare abstract methods, this means you don't provide any default behavior for
                                            // our subclasses. We're actually forcing subclasses to declare and implement these methods.

                                             //  the use of abstract and private modifiers is an illegal combination.
                                            // When you use abstract, you're saying subclasses have to declare this method.
                                            //But if it's private, the subclass wouldn't even see it.

    public abstract void makeNoise();

    public final String getExplicitType() {
        return getClass().getSimpleName() + " (" + type + ")";
    }

}

// Here I am declaring an abstract class Mammal, that extends the abstract class Animal.
//Now, I'm getting an error on this class because of the constructor, so I'll include the constructor
//using code generation. Now, this code compiles.
//But wait a minute! I wasn't forced to create implementations
//for the move and makeNoise methods, like we were for the Dog and Fish class. Why not?
//Well, it turns out, An abstract class that extends another abstract class has some flexibility.
//It can implement all of the parent's abstract methods. It can implement some
//of them. Or it can implement none of them. It can also include additional abstract methods,
//which will force subclasses to implement both Animal's abstract methods, as well as Mammal's.

abstract class Mammal extends Animal {

    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        System.out.println(getExplicitType() + (speed.equals("slow") ? " walks" : " runs"));
    }

    public abstract void shedHair();


}