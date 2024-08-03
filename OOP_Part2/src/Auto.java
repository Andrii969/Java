public class Auto {

    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Auto(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
        this.engine = true;
    }

    public int getCylinders() {
        return this.cylinders;
    }

    public String getName() {
        return this.name;
    }

    public String startEngine() {
        return String.format("%s -> startEngine()", this.getClass().getSimpleName());
    }

    public String accelerate() {
        return String.format("%s -> accelerate()", this.getClass().getSimpleName());
    }

    public String brake() {
        return String.format("%s -> brake()", this.getClass().getSimpleName());
    }

}
