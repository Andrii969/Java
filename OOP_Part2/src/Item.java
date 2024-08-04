public class Item {

    private String type;
    private String name;
    private double price;
    private String size = "MEDIUM";

    public Item (String type, String name, double price) {
        this.type = type.toUpperCase();
        this.name = name.toUpperCase();
        this.price = price;
    }

    public String getName() {
        if (type.equals("SIDE") || type.equals("DRINK")) {
            return size + " " + name;
        }
        return name;
    }

    public double getBasePrice() {
        return price;
    }

    public double getAdjustedPrice() { // price based on size
        return switch (size) {
            case "SMALL" -> getBasePrice() - 0.5;
            case "LARGE" -> getBasePrice() + 1;
            default -> getBasePrice();
        };
    }

    public void setSize(String size) { // for changing the default MEDIUM size (for SIDE and DRINK)
        this.size = size;
    }

    public static void printItem(String name, double price) { // method is declared as static because it does not depend on the
                                                            // instance variables of the Item class. Instead, it performs a generic operation
        System.out.printf("%20s:%6.2f%n", name, price);
    }

    public void printItem() {
        printItem(getName(), getAdjustedPrice());
    }
}
