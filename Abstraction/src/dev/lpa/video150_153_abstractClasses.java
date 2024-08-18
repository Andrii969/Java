package dev.lpa;

import java.util.ArrayList;

public class video150_153_abstractClasses {

    public static void main(String[] args) {

//        Animal animal = new Animal("animal", "big", 100); // 'Animal' is abstract; cannot be instantiated
                                                            // Animal is abstract, and even though we have a constructor and fields,
                                                            //we can't create an instance of an abstract class. This is another advantage of an abstract class.
                                                            //Would you ever want a real instance of Animal, after all?

        Dog dog = new Dog("Wolf", "medium", 45.45);
        dog.makeNoise(); // Howling!
        doAnimalStuff(dog); // Howling! Wolf is walking
        System.out.println("-".repeat(30));


        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard", "big", 150));
        animals.add(new Fish("Goldfish", "small", 1));
        animals.add(new Fish("Barracuda", "big", 75));
        animals.add(new Dog("Pug", "small", 20));
        animals.add(new Horse("Big Horse", "big", 1000));


        for (Animal animal : animals) {
            System.out.println(animal.getClass().getSimpleName() + ":");
            doAnimalStuff(animal);
            if (animal instanceof Mammal currentMammal) { //  check if our loop variable animal is a mammal, if true - get a mammal variable currentMammal
                currentMammal.shedHair(); // animal.shedHair() won't work -> as the method shedHair isn't on the Animal class, but Mammal
            }
            System.out.println("---");
        }
    }

    private static void doAnimalStuff(Animal animal) { // I've said that you can't create an instance of Animal, because it's abstract.
                                                        // That's true, but that doesn't prevent us from using that type in methods, declarations, and lists.
                                                        // In fact, this is what makes the code so flexible and scalable. The abstract class told the world
                                                        // that animals move and make noise, so anyone can use an Animal class and call those methods on the
                                                         // object that it gets at runtime. Regardless of what that object is, as long as it's an Animal,
                                                        // meaning it has the Animal class in its hierarchy, this code will continue to work.

        animal.makeNoise();
        animal.move("slow");
    }
}
