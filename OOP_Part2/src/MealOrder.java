//public class MealOrder {
//
//    private Burger burger;
//    private Drink drink;
//    private SideItem sideItem;
//
//    public MealOrder() {
//        this(new Burger(), new Drink(), new SideItem());
//    }
//
//    public MealOrder(Burger burger, Drink drink, SideItem sideItem) {
//        this.burger = burger;
//        this.drink = drink;
//        this.sideItem = sideItem;
//    }
//
//    public double getPrice() {
//        return burger.getBurgerPrice() + drink.getDrinkPrice() + sideItem.getSideItemPrice();
//    }
//
//    @Override
//    public String toString() {
//        return "MealOrder{" +
//                "burger=" + burger +
//                ", drink=" + drink +
//                ", sideItem=" + sideItem +
//                ", totalPrice=" + String.format("%.2f", getPrice()) +
//                '}';
//    }
//}
//
//class Burger {
//
//    private String type;
//    private String size;
//    private double price;
//    private Topping topping;
//
//    public Burger() {
//        this("hamburger", "small");
//    }
//
//    public Burger(String type, String size) {
//        this.type = type;
//        double priceBasedOnType = switch (type) {
//            case "burger" -> 1.99;
//            case "hamburger" -> 2.99;
//            case "cheeseburger" -> 3.99;
//            case "deluxe" -> 4.99;
//            default -> 0.99;
//        };
//        this.size = size;
//        double priceBasedOnSize = switch (size) {
//            case "small" -> 1;
//            case "medium" -> 1.5;
//            case "big" -> 1.75;
//            default -> 1;
//        };
//        this.price = type.equals("deluxe") ? priceBasedOnType : priceBasedOnType * priceBasedOnSize;
//    }
//
//    int toppingsAdded = 0;
//
//    public void addTopping(Topping topping) {
//        if (toppingsAdded > 2) {
//            return;
//        }
//        this.topping = topping;
//        if (!type.equals("deluxe")) {
//            this.price += topping.getPrice();
//        }
//        toppingsAdded++;
//    }
//
//    public double getBurgerPrice() {
//        return price;
//    }
//
//    @Override
//    public String toString() {
//        return "Burger{" +
//                "type='" + type + '\'' +
//                ", size='" + size + '\'' +
//                ", price=" + price +
//                ", topping=" + topping +
//                '}';
//    }
//}
//
//class Drink {
//
//    private String type;
//    private String size;
//    private double price;
//
//    public Drink() {
//        this("coke", "small");
//    }
//
//    public Drink(String type, String size) {
//        this.type = type;
//        this.size = size;
//        double priceBasedOnSize = switch (size) {
//            case "small" -> 0.49;
//            case "medium" -> 0.99;
//            case "big" -> 1.49;
//            default -> 0.49;
//        };
//        this.price = priceBasedOnSize;
//    }
//
//    public void changeSize(String size) {
//        this.size = size;
//        double priceBasedOnSize = switch (size) {
//            case "small" -> 0.49;
//            case "medium" -> 0.99;
//            case "big" -> 1.49;
//            default -> 0.49;
//        };
//        this.price = priceBasedOnSize;
//    }
//
//    public double getDrinkPrice() {
//        return price;
//    }
//
//    @Override
//    public String toString() {
//        return "Drink{" +
//                "type='" + type + '\'' +
//                ", size='" + size + '\'' +
//                ", price=" + price +
//                '}';
//    }
//}
//
//class SideItem {
//
//    private String type;
//    private double price;
//
//    public SideItem() {
//        this("fries");
//    }
//
//    public SideItem(String type) {
//        this.type = type;
//        double priceBasedOnType = switch (type) {
//            case "fries" -> 0.99;
//            case "village fries" -> 1.49;
//            case "nuggets" -> 1.99;
//            default -> 0.99;
//        };
//        this.price = priceBasedOnType;
//    }
//
//    public double getSideItemPrice() {
//        return price;
//    }
//
//    @Override
//    public String toString() {
//        return "SideItem{" +
//                "type='" + type + '\'' +
//                ", price=" + price +
//                '}';
//    }
//}
//
//class Topping {
//
//    private String type;
//    private double price;
//
//    public Topping(String type) {
//        this.type = type;
//        this.price = 0.25;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    @Override
//    public String toString() {
//        return "Topping{" +
//                "type='" + type + '\'' +
//                ", price=" + price +
//                '}';
//    }
//}