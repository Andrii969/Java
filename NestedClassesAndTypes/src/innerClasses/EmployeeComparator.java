package innerClasses;

import java.util.Comparator;

public class EmployeeComparator<T extends Employee> implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
//        return o1.getName().compareTo(o2.getName());
//        return o1.getYearStarted() - o2.getYearStarted();
        return o1.getEmployeeId() - o2.getEmployeeId();

    }
    // I want this to be generic and accept any Employee or sub type of Employee.
    // To do that I need to include a type parameter, so T extends Employee.
    // I'll add implements Comparator for that, using Employee as the type argument
}
