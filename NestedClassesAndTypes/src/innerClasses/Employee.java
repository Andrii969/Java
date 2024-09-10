package innerClasses;

import java.util.Comparator;

public class Employee {

    public static class EmployeeComparator<T extends Employee> implements Comparator<Employee> {
        // To create a static nested class, you add a class as part of another class's body, making it static.
        // This lets you access it via the class name, like other static variables.
        // But this nested static class has access to all the outer classes' private members, and vice versa.

        private String sortType;

        public EmployeeComparator() {
            this("employeeId");
        }

        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(Employee o1, Employee o2) {
//        return o1.getName().compareTo(o2.getName());
//        return o1.getYearStarted() - o2.getYearStarted();
            if (sortType.equalsIgnoreCase("yearStarted")) {
                return o1.yearStarted - o2.yearStarted;
            }
            return o1.employeeId - o2.employeeId; // after adding nested class - I can access fields without getters
        }
    }

    private int employeeId;
    private String name;
    private int yearStarted;

    public Employee() {
    }

    public Employee(int employeeId, String name, int yearStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }
}
