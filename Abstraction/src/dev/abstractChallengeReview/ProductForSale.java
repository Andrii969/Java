package dev.abstractChallengeReview;

public abstract class ProductForSale {

    protected String type;
    protected String description;
    protected double price;

    public ProductForSale(String type, String description, double price) {
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public double getSalesPrice (int quantity) {
        return this.price * quantity;
    }

    public void printPricedItem (int quantity) {
        System.out.printf("Product costs %.2f for each. Total price for %d pieces is %.2f", price, quantity, getSalesPrice(quantity));
    }

    public abstract void showDetails();

}
