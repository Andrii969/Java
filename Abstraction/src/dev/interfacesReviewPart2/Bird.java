package dev.interfacesReviewPart2;

public class Bird extends Animal implements FlightEnabled, Trackable {

    @Override // abstract method from Animal abstract class
    public void move() {
        System.out.println(getClass().getSimpleName() + " flaps wigns!");
    }

    @Override // abstract method from FlightEnabled interface
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " is taking off!");
    }

    @Override // abstract method from FlightEnabled interface
    public void land() {
        System.out.println(getClass().getSimpleName() + " is landing!");

    }

    @Override // abstract method from FlightEnabled interface
    public void fly() {
        System.out.println(getClass().getSimpleName() + " is flying!");

    }

    @Override // abstract method from Trackable interface
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates recorded!");

    }

    public void doSmth(){
        System.out.println("doing smth");
    }
}


// The Bird Class inherits behavior and
//attributes from Animal, because I used the extends keyword in the declaration of Bird.
//Because the move method was abstract on Animal, Bird was required to implement it.
//The Bird Class implements the FlightEnabled interface.
//This required the Bird class to implement the takeOff, fly, and land methods which were the
//abstract methods on FlightEnabled. The Bird Class also implements
//the Trackable interface. This required the Bird class
//to implement the track method, which was the abstract method declared on Trackable.
//Because of these declarations, any instance of the Bird class can be treated as a Bird.

// This means it has access to all of Bird's methods, including all those from Animal,
//FlightEnabled, and Trackable. An instance of Bird can be
//treated like or declared as an Animal, with access to the Animal functionality described
//in that class, but customized to Bird. It can be used as a FlightEnabled type,
//with just the methods a FlightEnabled type needs but again customized for the Bird.
//Or it can take the form of a Trackable object, and be tracked with specifics for the Bird class.

// Summary of Bird Inheritance and Interface Implementation
//Bird Class Definition:
//
//Bird extends Animal and implements FlightEnabled and Trackable.
//This means a Bird object can use methods from its superclass (Animal), its own class (Bird), and any interfaces it implements (FlightEnabled and Trackable).
//Bird bird = new Bird();:
//
//This creates a Bird object and references it with a Bird type variable.
//Access:
//bird can call all methods defined in:
//The Bird class.
//The Animal superclass.
//The FlightEnabled and Trackable interfaces.
//
//FlightEnabled flyThing = new Bird();:
//
//This creates a Bird object but references it with a FlightEnabled type variable.
//Access:
//flyThing can only use methods defined in the FlightEnabled interface.
//It cannot directly access:
//Methods from Bird that are not part of FlightEnabled.
//Methods from the Animal superclass unless they are also part of FlightEnabled.
//Methods from the Trackable interface.

// !!!!!
// You might ask, isn't a Bird an instance of FlightEnabled?
//The answer is No, not really. Bird is an instance of a class
//that implements FlightEnabled's methods. Bird doesn't inherit traits from FlightEnabled,
//it just agrees to behave a certain way as defined in the abstract class.