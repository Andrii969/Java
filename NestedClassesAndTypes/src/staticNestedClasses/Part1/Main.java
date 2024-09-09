package staticNestedClasses.Part1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        var comparator = new EmployeeComparator<>();

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(1, "Tim", 2018),
                new Employee(3, "Anna", 2017),
                new Employee(2, "Henry", 2016),
                new Employee(4, "Harry", 2016)));

        employees.sort(comparator);

        System.out.println("Sorted");
        for (var employee : employees) {
            System.out.println(employee);
        }

    }
}
