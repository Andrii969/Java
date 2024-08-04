//public class MealOrder_Main {
//
//    public static void main(String[] args) {
//        // Default Meal Order
//        MealOrder defaultMealOrder = new MealOrder();
//        System.out.println(defaultMealOrder);
//        System.out.println();
//
//        // Custom Meal Order
//        Burger burgerA = new Burger("burger", "medium");
//        Drink drinkA = new Drink("sprite", "medium");
//        SideItem sideItemA = new SideItem("village fries");
//        MealOrder mealOrderA = new MealOrder(burgerA, drinkA, sideItemA);
//        System.out.println(mealOrderA);
//        drinkA.changeSize("big");
//        System.out.println(mealOrderA);
//        System.out.printf("Total price = %.2f %n%n", mealOrderA.getPrice());
//
//        // Custom Meal Order with Deluxe burger
//        Burger burgerB = new Burger("hamburger", "big");
//        Drink drinkB = new Drink("sprite", "medium");
//        SideItem sideItemB = new SideItem("village fries");
//        MealOrder mealOrderB = new MealOrder(burgerB, drinkB, sideItemB);
//        System.out.println(mealOrderB);
//        Topping toppingOne = new Topping("souse");
//        Topping toppingTwo = new Topping("cheese");
//        burgerB.addTopping(toppingOne);
//        burgerB.addTopping(toppingTwo);
//        System.out.println(mealOrderB);
//    }
//}
