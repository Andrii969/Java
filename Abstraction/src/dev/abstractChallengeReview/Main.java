package dev.abstractChallengeReview;

public class Main {

    public static void main(String[] args) {

        Store myStore = new Store();

        Book detectiveBook = new Book("Detective", "Detective", 4.99);
        Book horrorBook = new Book("Horror", "Horror", 5.99);
        Furniture desk = new Furniture("Premium", "Mahogany Desk", 199.99);

        myStore.addProduct(detectiveBook);
        myStore.addProduct(horrorBook);
        myStore.addProduct(desk);

        myStore.listProducts(myStore);

        myStore.placeOrder(1, 0);
        myStore.placeOrder(2, 1);
        myStore.placeOrder(3, 2);

        myStore.listOrders(myStore);






    }
}
