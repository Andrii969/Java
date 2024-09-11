package innerClasses;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(1, "Tim", 2018),
                new Employee(3, "Anna", 2017),
                new Employee(2, "Henry", 2016),
                new Employee(4, "Harry", 2016)));

        //        var comparator = new EmployeeComparator<>();
        employees.sort(new Employee.EmployeeComparator<>("yearStarted"));
        // I could use comparator var here employees.sort(comparator);
        // OR I could use employees.sort(new EmployeeComparator<>());

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

//        Employee testEmployee1 = new Employee(5, "Test1", 2323);
//        Employee testEmployee2 = new Employee(6, "Test2", 2323);
//        var comparator = new Employee.EmployeeComparator<>().compare(testEmployee1, testEmployee2);
//        System.out.println(comparator); // -1

        System.out.println("Store Members");
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(5, "Meg", 2019, "Target"),
                new StoreEmployee(7, "Joe", 2018, "Walmart"),
                new StoreEmployee(6, "Tom", 2021, "Macys"),
                new StoreEmployee(8, "Marty", 2020, "Walmart")));

        // !!!
//        var comparator = new StoreEmployee.StoreComparator<>();// ERROR 'innerClasses.StoreEmployee' is not an enclosing class
        var genericStoreEmployee = new StoreEmployee();
        var comparator = genericStoreEmployee.new StoreComparator<>(); // alternatively, new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(comparator); // sorted firstly by store, then by the yearStarted

        for (StoreEmployee e : storeEmployees) {
            System.out.println(e);
        }

    }
}
