package dev.abstractClassesReview;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

//        Animal animal = new Animal("animal", "big", 100); // 'Animal' is abstract; cannot be instantiated
        Dog dog = new Dog("Wolf", "big", 100);
//        dog.makeNoise();
//        doAnimalStuff(dog);

        ArrayList<Animal> animals = new ArrayList<>(); //  if I type it with Animal, this list can hold any kind of Animal and that includes both Fish and Dog.
        animals.add(dog);
        animals.add(new Fish("Goldfish", "small", 0.100));

        for (Animal animal : animals) { //  And at runtime, instances that inherit from that class can use polymorphism to execute code specific to the concrete type.
            doAnimalStuff(animal);
            System.out.println("-".repeat(30));
        }
    }

    private static void doAnimalStuff(Animal animal) { // I've said that you can't create an instance of Animal, because it's abstract. That's true,
                                                        // but that doesn't prevent us from using that type in methods, declarations, and lists. In fact,
                                                        // this is what makes the code so flexible and scalable. The abstract class told the world that
                                                        // animals move and make noise, so anyone can use an Animal class and call those methods
                                                        // on the object that it gets at runtime.
        animal.makeNoise();
        animal.move("slow");
    }


}
