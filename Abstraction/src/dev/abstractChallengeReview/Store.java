package dev.abstractChallengeReview;

import java.util.ArrayList;

public class Store {

    // a lot of validation is ommited here for simplicity

    private ArrayList<ProductForSale> productsForSale;
    private ArrayList<OrderItem> orderItems;

    public Store() {
        this.productsForSale = new ArrayList<>();
        this.orderItems = new ArrayList<>();
    };

    public void addProduct(ProductForSale product) {
        productsForSale.add(product);
    }

    public void listProducts(Store store) {
        for(ProductForSale product : store.productsForSale) {
            product.showDetails();
        }
    }

    public void placeOrder(int quantity, int productIndex) {
        orderItems.add(new OrderItem(quantity, productsForSale.get(productIndex)));
    }

    public void listOrders(Store store) {
        System.out.println("Ordered:");
        double totalPrice = 0;
        for(OrderItem item : store.orderItems) {
            item.product.printPricedItem(item.quantity);
            System.out.println();
            totalPrice += item.product.getSalesPrice(item.quantity);
        }
        System.out.println("Total: " + totalPrice);

    }









}
