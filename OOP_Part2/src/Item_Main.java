public class Item_Main {

    public static void main(String[] args) {

//        Item coke = new Item("drink", "coke", 1.50);
//        coke.printItem();
//        coke.setSize("LARGE");
//        coke.printItem();

        Burger burger = new Burger("cheeseburger", 1.99);
        burger.addToppings("CHEESE", "AVOCADO", "TOMATO"); // create instances with the 'topping' type ("TOPPING", name, price)
        burger.printItem(); // prints the name and basePrice for each item
                            // prints line
                            // prints the name and adjustedPrice (burger + toppings)
        System.out.println("-".repeat(120));

        MealOrdering myMeal = new MealOrdering();
        myMeal.addBurgerToppings("BACON", "CHEESE", "AVOCADO");
        myMeal.setDrinkSize("LARGE");
        myMeal.printItemizedList();
        System.out.println("-".repeat(120));

        MealOrdering customMeal = new MealOrdering("hamburger", "pepsi", "village fries");
        customMeal.addBurgerToppings("BACON", "CHEESE", "AVOCADO");
        customMeal.setDrinkSize("SMALL");
        customMeal.printItemizedList();
        System.out.println("-".repeat(120));

        MealOrdering deluxeMeal = new MealOrdering("deluxe", "7-up", "chili");
        deluxeMeal.addBurgerToppings("AVOCADO", "BACON", "LETTUCE", "CHEESE", "MAYO");
        deluxeMeal.setDrinkSize("SMALL");
        deluxeMeal.printItemizedList();




    }
}
