package dev.abstractChallengeReview;

public class Book extends ProductForSale {

    public Book(String type, String description, double price) {
        super(type, description, price);
    }

    @Override
    public void showDetails() {
        System.out.printf("Book type of %s, about %s, costs %.2f", type, description, price);
        System.out.println();
    }
}
