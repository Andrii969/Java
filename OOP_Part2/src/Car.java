public class Car {

    private String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        System.out.println("Car -> The engine is started");
    }

    protected void runEngine() {
        System.out.println("Car -> The engine is Running");
    }

    public void drive() {
        System.out.println("Car -> The car is being driven, type is " + this.getClass().getSimpleName()); // 'this' is optional
        runEngine();
    }
}

class GasPoweredCar extends Car {

    private double avgKmPerLiter;
    private int cylinders;

    public GasPoweredCar(String description) {
        super(description);
    }

    public GasPoweredCar(String description, double avgKmPerLiter, int cylinders) {
        super(description);
        this.avgKmPerLiter = avgKmPerLiter;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        System.out.printf("Gas --> The engine is started, all %d cylinders are fired up!%n", cylinders);
    }

    @Override
    protected void runEngine() {
        System.out.printf("Gas --> The engine is running, usage exceeds the average: %.2f%n", avgKmPerLiter);
    }
}

class ElectricCar extends Car {

    private double avgKmPerCharge;
    private int batterySize;

    public ElectricCar(String description) {
        super(description);
    }

    public ElectricCar(String description, int batterySize, double avgKmPerCharge) {
        super(description);
        this.batterySize = batterySize;
        this.avgKmPerCharge = avgKmPerCharge;
    }

    @Override
    public void startEngine() {
        System.out.printf("Electric --> The %d kWh battery turned on, the engine is started!%n", batterySize);
    }

    @Override
    protected void runEngine() {
        System.out.printf("Electric --> The engine is running, usage under the average: %.2f%n", avgKmPerCharge);
    }
}

class HybridCar extends Car {

    private double avgKmPerLiter;
    private int batterySize;
    private int cylinders;

    public HybridCar(String description) {
        super(description);
    }

    public HybridCar(String description, double avgKmPerLiter, int batterySize, int cylinders) {
        super(description);
        this.avgKmPerLiter = avgKmPerLiter;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        System.out.printf("Hybrid --> The engine is started, all %d cylinders are fired up!%n", cylinders);
        System.out.printf("Hybrid --> The %d kWh battery turned on!%n", batterySize);
    }

    @Override
    protected void runEngine() {
        System.out.printf("Hybrid --> The engine is running, usage under the average: %.2f%n", avgKmPerLiter);
    }
}
