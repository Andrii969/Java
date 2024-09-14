package localAndAnonymousClassChallenge.MyCode;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

record Employee(String firstName, String lastName, Date hireDate) {

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}

public class Main {

    public static void main(String[] args) {
        // Create employees with different hire dates
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("John", "Smith",
                        Date.from(LocalDate.of(2023, 8, 24).atStartOfDay(ZoneId.systemDefault()).toInstant())),
                new Employee("Jane", "Doe",
                        Date.from(LocalDate.of(2022, 5, 15).atStartOfDay(ZoneId.systemDefault()).toInstant())),
                new Employee("Alex", "Jones",
                        Date.from(LocalDate.of(2024, 1, 30).atStartOfDay(ZoneId.systemDefault()).toInstant()))
        ));

        List<UpdatedEmployee> updatedEmployees = updateEmployeeFormat(employees);
        for (UpdatedEmployee ue : updatedEmployees) {
            System.out.println(ue);
        }
        System.out.println("Sorted by Full Name");
        updatedEmployees.sort(new Comparator<UpdatedEmployee>() {
            @Override
            public int compare(UpdatedEmployee o1, UpdatedEmployee o2) {
//                return o1.fullName.compareTo(o2.fullName);
                return Long.compare(o1.yearsWorked, o2.yearsWorked);
            }
        });
        for (UpdatedEmployee ue : updatedEmployees) {
            System.out.println(ue);
        }

    }

    public static List<UpdatedEmployee> updateEmployeeFormat(List<? extends Employee> list) {
        System.out.println("Updated Employees");
        var newList = new ArrayList<UpdatedEmployee>(list.size());
        for (Employee e : list) {
            newList.add(new UpdatedEmployee(e));
        }
        return newList;
    }

    public static class UpdatedEmployee {

        Employee employee;
        String fullName;
        long yearsWorked;

        public UpdatedEmployee(Employee employee) {
            this.employee = employee;
            this.fullName = employee.firstName() + " " + employee.lastName();
            // Convert Date to LocalDate
            LocalDate hireDate = employee.hireDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            // Calculate years worked
            this.yearsWorked = ChronoUnit.YEARS.between(hireDate, LocalDate.now());
        }

        @Override
        public String toString() {
            return "Updated Employee: " +
                    "Full Name = '" + fullName + '\'' +
                    ", Years Worked = " + yearsWorked;
        }
    }
}
