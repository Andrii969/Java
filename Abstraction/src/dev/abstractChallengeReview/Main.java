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

        myStore.placeOrder(1, desk);
        myStore.placeOrder(2, detectiveBook);
        myStore.placeOrder(3, horrorBook);

        myStore.listOrders(myStore);






    }
}
