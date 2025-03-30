package ConstructrorReview;

public class Parent {

    // This block of code lets us initialize static variables and is called as part of the Class construction.
    static {
        System.out.println("Parent static initializer: class being constructed");
    }
    // A static initializer is called the first time a class is referenced or constructed.
    // A class can have any number of static initialization blocks.
    // They can be declared anywhere in the class body.
    // You might use this to set up some environment data or log information,that's related to the class before it can be used.
    // Remember, this will get executed only during the class's construction and not each instance's construction.

    private final String name; // final thus setters can't be used
    private final String dob;
    protected final int siblings;

    { // can be initialized in this way, called Instance initializer
        // Instance initializers are executed before any code in class constructors is executed.
//        name = "Jim";
//        dob = "12/12/2021";
        System.out.println("In Parent Initializer");
    }

//    public Parent() {
//        System.out.println("In Parent's No Args Constructor");
//    }

    public Parent(String name, String dob, int siblings) {
        this.name = name;
        this.dob = dob;
        this.siblings = siblings;
        System.out.println("In Parent Constructor");
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", dob='" + dob + '\'';
    }
}
