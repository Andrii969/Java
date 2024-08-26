package dev.abstractChallengeReview;

public class OrderItem {

    protected int quantity;
    protected ProductForSale product;


    public OrderItem(int quantity, ProductForSale product) {
        this.quantity = quantity;
        this.product = product;
    }
}
