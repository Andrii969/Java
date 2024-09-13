package localClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Ralph", 2015),
                new Employee(10005, "Carole", 2021),
                new Employee(10022, "Jane", 2013),
                new Employee(13151, "Laura", 2020),
                new Employee(10050, "Jim", 2018) ));

//        var comparator = new EmployeeComparator<>();
//        employees.sort(comparator);

        employees.sort(new Employee.EmployeeComparator<>()
                .reversed());

        for (Employee e : employees) {
            System.out.println(e);
        }

        System.out.println("Store Members");

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

        var comparator = new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(comparator);

        for (StoreEmployee e : storeEmployees) {
            System.out.println(e);
        }

        System.out.println("With Pig Latin Names");
         addPigLatinName(storeEmployees);
    }

    public static void addPigLatinName(List<? extends StoreEmployee> list) {
        // That is a generics wild card, that specifies an upper bound,
        // for this method parameter's type argument. This means this method will only accept
        // a List containing StoreEmployees, or any subtype of StoreEmployee.

        String lastName = "Piggy";

        class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee>{
            // In this case, the only purpose of this class is to add a derived field, the pigLatinName, to an existing set
            // of instances of StoreEmployees. I don't want to reinvent the wheel or add this class to my library of classes.
            // I don't want anyone else to use it or extend it. I only want it to exist for this one specific purpose.

            private String pigLatinName;
            private Employee originalInstance;

            public DecoratedEmployee(String pigLatinname, Employee originalinstance) {
                this.pigLatinName = pigLatinname + " " + lastName;
                this.originalInstance = originalinstance;
            }

            @Override
            public String toString() {
                return originalInstance + " " + pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }

            List<DecoratedEmployee> newList = new ArrayList<>(list.size());
            for (var employee : list) {
                String name = employee.getName();
                String pigLatin = name.substring(1) + name.charAt(0) + "ay";
                newList.add(new DecoratedEmployee(pigLatin, employee));
            }

            newList.sort(Comparator.reverseOrder()); // NOTE: I could use 'null' instead of Comparator.reverseOrder()
            // sorting by the pigLatinname
            for (var dEmployee : newList) {
                System.out.println(dEmployee);
                System.out.println(dEmployee.originalInstance.getName() + " / " + dEmployee.pigLatinName);
            }
    }

}

