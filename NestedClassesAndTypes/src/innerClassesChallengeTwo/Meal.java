package innerClassesChallengeTwo;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    // One bonus for nested classes is that both the inner class and the outer class have
    // direct access to the other's instance members.

//    private double base = 5.0;

    private double price = 5.0;

    private Burger burger;
    private Item drink;
    private Item side;

    private double conversionRate;
    private double total;

    public Meal() {
        this(1);
    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        burger = new Burger("regular");
        drink = new Item("coke", "drink", 1.5);
        System.out.println(drink.name); // enclosing Meal class has direct access to the Item's attributes,
                                        // without getters or setters, even though those attributes are private
        side = new Item("fries", "side", 2.0);
    }

    public double getTotal() {
        double total = burger.getPrice() + drink.price + side.price;
        // burger.getPrice() -> this wouldn't work if Item wasn't an inner
        // class of Meal, because price is private on Item
        return Item.getPrice(total, conversionRate);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%27s%.2f".formatted(burger, drink, side, "Total Due $", getTotal());
    }

    public void addToppings(String... selectedToppings) {
        burger.addToppings(selectedToppings);
        // The Meal class is able to call a private method on the burger class.
    }

    public class Item {

        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            this(name, type, type.equals("burger") ? Meal.this.price : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name, getPrice(price, conversionRate));
        }

        public static double getPrice(double price, double rate) {
            return price * rate;
        }
    }

    private class Burger extends Item{

        private enum Extra {AVOCADO, BACON, CHEESE, KETCHUP, MAYO, MUSTARD, PICKLES;

            private double getPrice() {
                return switch (this) {
                    case AVOCADO -> 1.0;
                    case BACON, CHEESE -> 1.5;
                    default -> 0;
                };
            }

            // Notice I'm switching on the keyword, "this". When the getPrice method gets called,
            // it will be called from an instance of one of these extra constants, so I can use this as my switch expression.

        };

        private List<Item> toppings = new ArrayList<>();

        Burger(String name) {
            super(name, "burger");
        }

        public double getPrice() {
            double burgerPriceWithToppings = super.price;
            for (Item topping : toppings) {
                burgerPriceWithToppings += topping.price;
            }
            return burgerPriceWithToppings;
        }

        private void addToppings(String... selectedToppings) {
            for (String selectedTopping : selectedToppings) {
                try {
                    Extra topping = Extra.valueOf(selectedTopping.toUpperCase());
                    toppings.add(new Item(topping.name(), "TOPPING", topping.getPrice()));
                } catch (IllegalArgumentException iae) {
                    System.out.println("No topping found for " + selectedTopping);
                }
                // Why can I access a private method on the enum from this code? Again,
                // this has to do with the special nature of inner types. Private attributes and methods are available
                // to the enclosing class, and this is true for inner types like enums and records, as well as inner classes.
                // I want to invoke this from a method on my Meal class, and just use the same signature.
            }
        }

        @Override
        public String toString() {
            StringBuilder burgerDetails = new StringBuilder(super.toString());
            for (Item topping : toppings) {
                burgerDetails.append("\n").append(topping);
            }
            return burgerDetails.toString();
        }
    }
}