public class Animal_Dog extends Animal{

    private String earShape;
    private String tailShape;

    public Animal_Dog() {
        super("Mutt", "Big", 50);
    }

    public Animal_Dog(String type, double weight) {
        this(type, weight, "Perky", "Curled");
    }

    public Animal_Dog(String type, double weight, String earShape, String tailShape) {
        super(type, weight < 15 ? "small" : (weight < 35 ? "medium" : "large"), weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    @Override
    public String toString() {
        return "Animal_Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString();
    }

    public void makeNoise() {}

    @Override
    public void move(String speed) {
        super.move(speed);
        System.out.println("Dogs walk, run and wag their tail");
    }
}
