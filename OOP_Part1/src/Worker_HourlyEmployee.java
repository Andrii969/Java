public class Worker_HourlyEmployee extends Worker_Employee {

    private double hourlyPayRate;

    public Worker_HourlyEmployee(String name, String birthDate, String hireDate,
                                   double hourlyPayRate) {
        super(name, birthDate, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public String toString() {
        return "Worker_HourlyEmployee{" +
                "hourlyPayRate=" + hourlyPayRate +
                "} " + super.toString();
    }

    @Override
    public double collectPay() {
        return 40 * hourlyPayRate;
    }

    public double getDoublePay() {
        return 2 * collectPay();
    }
}
