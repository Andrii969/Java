package exploring;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

            List<Student> students = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                    students.add(new Student());
            }

            // Sort by Name
            students.sort(Comparator.comparing(Student::getName));
            System.out.println("Sorted by Name:");
            students.forEach(Student::displayStudentInfo);

            // Sort by Age
            students.sort(Comparator.comparingInt(Student::getAge));
            System.out.println("\nSorted by Age:");
            students.forEach(Student::displayStudentInfo);

            // Sort by Student ID
            students.sort(Comparator.comparing(Student::getStudentId));
            System.out.println("\nSorted by Student ID:");
            students.forEach(Student::displayStudentInfo);

            // Sort by Grade
            students.sort(Comparator.comparingDouble(Student::getGrade));
            System.out.println("\nSorted by Grade:");
            students.forEach(Student::displayStudentInfo);
    }
}
