public class Worker_SalariedEmployee extends Worker_Employee {

    private double annualSalary;
    private boolean isRetired; // by default false

    public Worker_SalariedEmployee(String name, String birthDate, String hireDate,
                                   double annualSalary) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
    }

    @Override
    public String toString() {
        return "Worker_SalariedEmployee{" +
                "annualSalary=" + annualSalary +
                ", isRetired=" + isRetired +
                "} " + super.toString();
    }

    @Override
    public double collectPay() {
        double paycheck = annualSalary / 26;
        double adjustedPay = (isRetired) ? 0.9 * paycheck : paycheck;
        return (int) adjustedPay;

    }

    public void retire() {
        terminate("12.12.2025");
        this.isRetired = true;

    }
}
