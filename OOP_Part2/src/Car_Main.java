public class Car_Main {

    public static void main(String[] args) {
        Car car = new Car("Unknown car");
        runRace(car);
        System.out.println();

        Car ferrari = new GasPoweredCar("Blue Ferrari 296 GTS", 15.4, 6);
        runRace(ferrari);
        System.out.println();

        Car audi = new ElectricCar("Red Tesla Model 3", 75, 568);
        runRace(audi);
        System.out.println();

        Car toyota = new HybridCar("Toyota Traveller", 16, 8, 8);
        runRace(toyota);
        System.out.println();

    }

    public static void runRace(Car car) {
        car.startEngine();
        car.drive();
    }
}