package dev.abstractChallenge;

public abstract class Product {

    protected String type; // protected - subclasses can access and modify them directly as well
    protected double price;
    protected String description;

    public Product(String type, String description, double price) {
        this.type = type;
        this.description = description;
        if (price < 0) {
            price = 0;
        }
        this.price = price;
    }

    public double getSalesPrice(int qty) {
        if (qty < 1) {
            qty = 1;
        }
        return qty * price;
    }

    public void printPricedItem(int qty) {
        System.out.printf("%2d qty at $%8.2f each, %-15s %-35s %n", qty, price, type, description);
        // %2d - A two-digit integer for the quantity (qty).
        //     The number will be right-aligned, and if it’s less than two digits, it will be padded with spaces on the left.
        // %8.2f - A floating-point number for the price (price), with a total width of 8 characters, including 2 digits after the decimal point.
        //     The number will be right-aligned, and if it’s less than 8 characters, it will be padded with spaces on the left.
        // %-15s - A string for the type (type) that is left-aligned, with a minimum width of 15 characters.
        //     If the string is shorter than 15 characters, it will be padded with spaces on the right.
        // %-35s - A string for the description (description) that is left-aligned, with a minimum width of 35 characters.
        //     If the string is shorter than 35 characters, it will be padded with spaces on the right.
    }

    public abstract void showDetails();
}
