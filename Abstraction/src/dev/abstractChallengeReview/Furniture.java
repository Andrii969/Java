package dev.abstractChallengeReview;

public class Furniture extends ProductForSale {

    public Furniture(String type, String description, double price) {
        super(type, description, price);
    }

    @Override
    public void showDetails() {
        System.out.printf("Furniture type of %s, made of %s, costs %.2f", type, description, price);
        System.out.println();
    }
}
