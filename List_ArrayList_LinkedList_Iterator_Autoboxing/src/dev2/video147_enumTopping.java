package dev2;

public class video147_enumTopping {

    public static void main(String[] args) {

        for (Topping topping : Topping.values()) {
            System.out.println(topping.name() + " : " + topping.getPrice());
        }
    }
}
