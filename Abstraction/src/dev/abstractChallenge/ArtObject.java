package dev.abstractChallenge;

public class ArtObject extends Product{


    public ArtObject(String type, String description, double price) {
        super(type, description, price);
    }

    @Override
    public void showDetails() {
        System.out.println("Type of the art product: " + type);
        System.out.printf("The price of the product is $%6.2f %n", price);
        System.out.println(description);
    }
}
