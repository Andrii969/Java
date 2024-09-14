package localAndAnonymousClassChallenge.InstructorCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Employee e1 = new Employee("Minnie", "Mouse", "01/02/2015");
        Employee e2 = new Employee("Mickie", "Mouse", "05/08/2000");
        Employee e3 = new Employee("Daffy", "Duck", "11/02/2011");
        Employee e4 = new Employee("Daisy", "Duck", "05/03/2013");
        Employee e5 = new Employee("Goofy", "Dog", "23/07/2020");

        List<Employee> list = new ArrayList<>(Arrays.asList(e1,e2,e3,e4,e5));
        printOrderedList(list, "fullName");
        System.out.println();
        printOrderedList(list, "yearsWorked");
        System.out.println();

    }

    public static void printOrderedList(List<Employee> elist, String sortField) {

        int currentYear = LocalDate.now().getYear();

        class MyEmployee {

            Employee containedEmployee;
            int yearsWorked;
            String fullName;

            public MyEmployee(Employee containedEmployee) {
                this.containedEmployee = containedEmployee;
                yearsWorked = currentYear - Integer.parseInt(containedEmployee.hireDate().split("/")[2]);
                // In this code, I'm splitting my string by the forward slash, and then the third split should be the year.
                fullName = String.join(" ", containedEmployee.firstname(), containedEmployee.lastName());
            }

            @Override
            public String toString() {
                return "%s has been an employee for %d years".formatted(fullName, yearsWorked);
            }
        }

            List<MyEmployee> list = new ArrayList<>();
            for (Employee employee : elist) {
                list.add(new MyEmployee(employee));
            }

            var comparator = new Comparator<MyEmployee>() {
                @Override
                public int compare(MyEmployee o1, MyEmployee o2) {
                    if (sortField.equals("fullName")) {
                        return o1.fullName.compareTo(o2.fullName);
                    }
                    return o1.yearsWorked - o2.yearsWorked;
                }
            };

            list.sort(comparator);

            for(MyEmployee me : list) {
                System.out.println(me);
            }
    }
}
