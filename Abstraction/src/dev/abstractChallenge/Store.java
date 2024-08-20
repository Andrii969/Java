package dev.abstractChallenge;

import java.util.ArrayList;

record OrderItem(int qty, Product product) {}

public class Store {

    private static ArrayList<Product> storeProducts = new ArrayList<>();

    public static void main(String[] args) {

        storeProducts.add(new ArtObject("Oil Painting", "Painted in 2010", 1350));
        storeProducts.add(new ArtObject("Sculpture", "Produced in 1950", 2000));
        storeProducts.add(new Furniture("Desk", "Mahogany Desk", 3000));

        listProducts();

        System.out.println("\nOrder 1");
        var order1 = new ArrayList<OrderItem>();
//        order1.add(new OrderItem(2, storeProducts.get(0)));
        addItemToOrder(order1, 0, 1);
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 2, 1);

        printOrder(order1);
//        Order 1
//         1 qty at $ 1350.00 each, Oil Painting    Painted in 2010
//         2 qty at $ 2000.00 each, Sculpture       Produced in 1950
//        Sales Total = $5350.00

    }

    public static void listProducts() {
        for (var item : storeProducts) { // usually var used for the places that are very general
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex, int qty) {
        order.add(new OrderItem(qty, storeProducts.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order) {
        double salesTotal = 0;
        for (var item : order) {
            item.product().printPricedItem(item.qty());
            salesTotal += item.product().getSalesPrice(item.qty());
        }
        System.out.printf("Sales Total = $%6.2f %n", salesTotal);
    }


}
