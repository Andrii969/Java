package dev.lpa;

public class Horse extends Mammal { // Class 'Horse' must either be declared abstract or implement abstract methods in 'Animal'


    public Horse(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void makeNoise() {
    }

    @Override
    public void shedHair() {
        System.out.println(getExplicitType() + " sheds in the spring");
    }
}
