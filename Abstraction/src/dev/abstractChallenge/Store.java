package dev.abstractChallenge;

import java.util.ArrayList;

public class Store { // IN PROGRESS

    private String storeName;
    private ArrayList<Product> products;
    private ArrayList<Product> orderItems;

    public Store(String storeName) {
        this.storeName = storeName;
        products = new ArrayList<Product>();
        orderItems = new ArrayList<Product>();
    }

    private Product findProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }
}
