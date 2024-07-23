public class Car {

    private String make = "Tesla";
    private String model = "Model X";
    private String color = "Gray";
    private int doors = 2;
    private boolean isConvertible = true;

    public String getMake() {
        return make;
    }
    public int getDoors() {
        return doors;
    }
    public String getModel() {
        return model;
    }
    public String getColor() {
        return color;
    }
    public boolean isConvertible() {
        return isConvertible;
    }

    public void setMake(String make) {
        if (make == null) {
            make = "Unknown";
        }
        String lowercaseMake = make.toLowerCase();
        switch (lowercaseMake) {
            case "porsche", "audi", "reno" -> this.make = lowercaseMake;
            default -> {
                this.make = "Unsupported";
            }
        };
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setDoors(int doors) {
        this.doors = doors;
    }
    public void setConvertible(boolean convertible) {
        isConvertible = convertible;
    }

    public void describeCar() {
        System.out.println(
                doors + "-Door " +
                        color + " " +
                        make + " " +
                        model + " " +
                        (isConvertible ? "Convertible" : "")
        );
    }
}
