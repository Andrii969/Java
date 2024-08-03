public class MealOrder {

    private Burger burger;
    private Drink drink;
    private SideItem sideItem;

    public MealOrder() {
        this(new Burger(), new Drink(), new SideItem());
    }

    public MealOrder(Burger burger, Drink drink, SideItem sideItem) {
        this.burger = burger;
        this.drink = drink;
        this.sideItem = sideItem;
    }

    public double getPrice() {
        return burger.getBurgerPrice() + drink.getDrinkPrice() + sideItem.getSideItemPrice();
    }

    @Override
    public String toString() {
        return "MealOrder{" +
                "burger=" + burger +
                ", drink=" + drink +
                ", sideItem=" + sideItem +
                ", totalPrice=" + String.format("%.2f", getPrice()) +
                '}';
    }
}

class Burger {

    private String type;
    private String size;
    private double price;
    private Topping topping;

    public Burger() {
        this("hamburger", "small");
    }

    public Burger(String type, String size) {
        this.type = type;
        double priceBasedOnType = switch (type) {
            case "burger" -> 1.99;
            case "hamburger" -> 2.99;
            case "cheeseburger" -> 3.99;
            default -> 0.99;
        };
        this.size = size;
        double priceBasedOnSize = switch (size) {
            case "small" -> 1;
            case "medium" -> 1.5;
            case "big" -> 1.75;
            default -> 1;
        };
        this.price = priceBasedOnType * priceBasedOnSize;
    }

    public double getBurgerPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", topping=" + topping +
                '}';
    }
}

class Drink {

    private String type;
    private String size;
    private double price;

    public Drink() {
        this("coke", "small", 0.99);
    }

    public Drink(String type, String size, double price) {
        this.type = type;
        this.price = price;
        this.size = size;
    }

    public double getDrinkPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}

class SideItem {

    private String type;
    private double price;

    public SideItem() {
        this("fries", 1.99);
    }

    public SideItem(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public double getSideItemPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "SideItem{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}

class Topping {

    private String type;
    private double price;

    public Topping(String type, double price) {
        this.type = type;
        this.price = price;
    }
}