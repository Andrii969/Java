public class Worker_Employee extends Worker {

    private long employeeId;
    private String hireDate;

    private static int employeeNo = 1;

    public Worker_Employee(String name, String birthDate, String hireDate) {
        super(name, birthDate); // has to be first statement
        this.employeeId = Worker_Employee.employeeNo++; // paste here the class name for more clarity (optional)
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Worker_Employee{" +
                "employeeId=" + employeeId +
                ", hireDate='" + hireDate + '\'' +
                "} " + super.toString();
    }
}