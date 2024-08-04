public class Burger extends Item{

    private Item extra1;
    private Item extra2;
    private Item extra3;

    public Burger(String name, double price) {
        super("Burger", name, price);
    }

    @Override
    public String getName() {
        return super.getName() + " BURGER";
    }

    @Override
    public double getAdjustedPrice() {  // returns the burger price + toppings
        return getBasePrice() +
                ((extra1 == null) ? 0 : extra1.getBasePrice()) +
                ((extra2 == null) ? 0 : extra2.getBasePrice()) +
                ((extra3 == null) ? 0 : extra3.getBasePrice());
    }

    public double getExtraPrice (String toppingName) { // sets the price for toppings, called by addToppings
        return switch (toppingName) {
            case "AVOCADO", "CHEESE" -> 1.0;
            case "BACON", "HAM", "SALAMI" -> 1.5;
            default -> 0.0;
        };
    }

    public void addToppings (String extra1, String extra2, String extra3) { // creates TOPPING items
        this.extra1 = new Item("TOPPING", extra1, getExtraPrice(extra1));
        this.extra2 = new Item("TOPPING", extra2, getExtraPrice(extra2));
        this.extra3 = new Item("TOPPING", extra3, getExtraPrice(extra3));
    }

    public void printItemizedList() {
        printItem("BASE BURGER", getBasePrice()); // prints the name and basePrice for burger
        if (extra1 != null) {
            extra1.printItem(); // prints the name and basePrice for topping extra1
        }
        if (extra2 != null) {
            extra2.printItem(); // prints the name and basePrice for topping extra2
        }
        if (extra3 != null) {
            extra3.printItem(); // prints the name and basePrice for topping extra3
        }
    }

    @Override
    public void printItem() {
        printItemizedList(); // prints the name and basePrice for each topping
        System.out.println("-".repeat(30)); // prints line
        super.printItem(); // prints the name and adjustedPrice (burger + toppings)
    }
}

class DeluxeBurger extends Burger {

    Item deluxe1;
    Item deluxe2;

    public DeluxeBurger(String name, double price) {
        super(name, price);
    }

    public void addToppings(String extra1, String extra2, String extra3, String extra4, String extra5) {
        super.addToppings(extra1, extra2, extra3); // Uses Burger's method to set extra1, extra2, and extra3
        this.deluxe1 = new Item("TOPPING", extra4, 0); // Sets additional deluxe toppings
        this.deluxe2 = new Item("TOPPING", extra5, 0);
    }

    @Override
    public void printItemizedList() {
        super.printItemizedList(); // Prints base burger and standard toppings
        if (deluxe1 != null) {
            deluxe1.printItem(); // Prints deluxe topping 1
        }
        if (deluxe2 != null) {
            deluxe2.printItem(); // Prints deluxe topping 2
        }
    }

    @Override
    public double getExtraPrice (String toppingName) {
        return 0; // Deluxe toppings are free
    }
}
