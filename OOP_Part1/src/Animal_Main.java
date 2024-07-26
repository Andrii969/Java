public class Animal_Main {

    public static void main(String[] args) {

        Animal myAnimal = new Animal("myType", "customSize", 55);
        doAnimalStuff(myAnimal, "34 km per hour");

        Animal_Dog myDog = new Animal_Dog();
        doAnimalStuff(myDog, "44 km per hour");

        Animal_Dog yorkie = new Animal_Dog("Yorkie", 15);
        doAnimalStuff(yorkie, "fast");

        Animal_Dog retriever = new Animal_Dog("Labrador Retriever", 65, "Floppy", "Swimmer");
        doAnimalStuff(retriever, "slow");

        Animal_Dog wolf = new Animal_Dog("Wolf", 40);
        doAnimalStuff(wolf, "slow");

        Animal_Fish fish = new Animal_Fish("Fish", 0.5, 2, 3);
        doAnimalStuff(fish, "fast");

    }

    public static void doAnimalStuff(Animal animal, String speed) {

        animal.makeNoise();
        animal.move(speed);
        System.out.println(animal);
        System.out.println("_ _ _ _");
    }
}
