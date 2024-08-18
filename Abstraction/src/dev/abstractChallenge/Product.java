package dev.abstractChallenge;

public abstract class Product { // IN PROGRESS


    private String name;
    private String description;
    private String type;
    private double price;

    public Product(String name, String type, String description, double price) {
        this.name = name;
        this.type = type;
        this.description = description;
        if (price < 0) {
            price = 0;
        }
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getSalesPrice(int quantity) {
        if (quantity < 1) {
            quantity = 1;
        }
        return quantity * price;

    }

    public void printPricedItem(int quantity) {

    }

    public abstract void showDetails();
}
