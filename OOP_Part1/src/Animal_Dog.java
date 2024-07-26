public class Animal_Dog extends Animal{

    private String earShape;
    private String tailShape;

    public Animal_Dog() {
        super("Mutt", "Big", 50);
    } // default constructor calls the superclass (Animal)

    public Animal_Dog(String type, double weight) {
        this(type, weight, "Perky", "Curled");
    } // This constructor takes type and weight as parameters and calls another constructor within the same class (this),

    public Animal_Dog(String type, double weight, String earShape, String tailShape) {
        super(type, weight < 15 ? "small" : (weight < 35 ? "medium" : "large"), weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    } // This constructor takes type, weight, earShape, and tailShape as parameters.
    // It calls the superclass (Animal) constructor, determining the size based on the weight

    @Override
    public String toString() {
        return "Animal_Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString();
    } // This method overrides the toString method from the Animal class.
    // It provides a string representation of the Animal_Dog object,
    // and the string representation of the Animal part (obtained by calling super.toString()).

    public void makeNoise() {
        if (type == "Wolf") {
            System.out.println("Ow Woooooo! ");
        }

        bark();
        System.out.println();

    } // overrides the makeNoise method from the Animal class.

    @Override
    public void move(String speed) {
        super.move(speed);
        if (speed == "slow") {
            walk();
            wagTail();
        } else {
            run();
            bark();
        }
        System.out.println();
    } // overrides the move method from the Animal class (uses it, and additionally prints the line)

    private void bark() {
        System.out.print("Woof! ");
    }

    private void run() {
        System.out.print("Dog Running! ");
    }

    private void walk() {
        System.out.print("Dog Walking! ");
    }

    private void wagTail() {
        System.out.print("Tail Wagging! ");
    }




}
