package staticNestedClasses.Part2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(1, "Tim", 2018),
                new Employee(3, "Anna", 2017),
                new Employee(2, "Henry", 2016),
                new Employee(4, "Harry", 2016)));

        var comparator = new Employee.EmployeeComparator<>("yearStarted");
        employees.sort(comparator);
        System.out.println("Sorted ASC");
        for (var employee : employees) {
            System.out.println(employee);
        }

        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());
        // The reversed method will reverse the sort for any Comparator.
        System.out.println("Sorted DESC");
        for (var employee : employees) {
            System.out.println(employee);
        }

        // // // // // // // // // // //





    }
}
