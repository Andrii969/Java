package anonymousClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {

    public static void main(String[] args) {

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019,
                        "Target"),
                new StoreEmployee(10515, "Joe", 2021,
                        "Walmart"),
                new StoreEmployee(10105, "Tom", 2020,
                        "Macys"),
                new StoreEmployee(10215, "Marty", 2018,
                        "Walmart"),
                new StoreEmployee(10322, "Bud", 2016,
                        "Target")));

        var c0 = new EmployeeComparator<StoreEmployee>(); // public class EmployeeComparator
        var c1 = new Employee.EmployeeComparator<StoreEmployee>(); // public static class in the Employee class
        var c2 = new StoreEmployee().new StoreComparator<StoreEmployee>(); // inner class in the StoreEmployee class

        // using local class

        class NameSort<T> implements Comparator<StoreEmployee> {

            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }

        var c3 = new NameSort<StoreEmployee>();

        // using anonymous class

//        var c4 = new Comparator<StoreEmployee>(); // ERROR: 'Comparator' is abstract; cannot be instantiated
//        var c4 = new Comparator<StoreEmployee>() {}; // Class 'Anonymous class derived from Comparator' must implement abstract method 'compare(T, T)' in 'Comparator'
        var c4 = new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };


        sortIt(storeEmployees, c0);
        sortIt(storeEmployees, c1);
        sortIt(storeEmployees, c2);
        sortIt(storeEmployees, c3);
        sortIt(storeEmployees, c4);
        sortIt(storeEmployees, new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }); // In other words, I'm using the anonymous class to create a bit of custom functionality and pass that functionality
        // as an argument to a method, via the interface. This code is a little harder to read, but you may see code like this that
        // pre-dates lambda expressions. You should recognize this as an on-the-fly anonymous class, being passed as a method argument.
    }

    public static <T> void sortIt(List<T> list, Comparator<? super T> comparator) {
        // ? super T allows flexibility: By using ? super T, the comparator can handle comparisons between objects of type T or any
        // superclass of T. This gives more flexibility in defining comparators, especially when working with inheritance hierarchies.

        System.out.println("Sorting with Comparator: " + comparator.toString());
        list.sort(comparator);
        for (var employee : list) {
            System.out.println(employee);
        }

    }
}
