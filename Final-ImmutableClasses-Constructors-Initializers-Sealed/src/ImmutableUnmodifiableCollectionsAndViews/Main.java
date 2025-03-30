package ImmutableUnmodifiableCollectionsAndViews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) { // continue from 233

        StringBuilder bobsNotes = new StringBuilder();
        StringBuilder billsNotes = new StringBuilder("Bill struggles with generics");

        Student bob = new Student("Bob", bobsNotes);
        Student bill = new Student("Bill", billsNotes);

        List<Student> students = new ArrayList<>(List.of(bob, bill));
        List<Student> studentsFirstCopy = new ArrayList<>(students); // shallow list, is modifiable,
        // affects original (only to changes in the shared object properties, not the list structure)
        studentsFirstCopy.remove(1);
        List<Student> studentsSecondCopy = List.copyOf(students); // shallow list, is modifiable (but can't add/remove/sort elements), affects original
//        studentsSecondCopy.remove(1); // compilation error UnsupportedOperationException
//        studentsSecondCopy.add(new Student("Bonnie", new StringBuilder())); // compilation error UnsupportedOperationException
        bobsNotes.append("Bob was one of my first students");
//        studentsFirstCopy.get(1).getStudentNotes().append(" copy edited as well as an original");
//        studentsSecondCopy.get(1).getStudentNotes().append(" copy edited as well as an original");

        List<Student> studentsThirdCopy = Collections.unmodifiableList(students); // returns an unmodifiable VIEW
//        studentsThirdCopy.add(new Student("Bonnie", new StringBuilder())); // compilation error UnsupportedOperationException

        students.add(new Student("Bonnie", new StringBuilder())); // here a new student added to original, BUT it is also added to the unmodifiableList


        students.forEach(System.out::println);
        System.out.println("-".repeat(50));
        studentsFirstCopy.forEach(System.out::println);
        System.out.println("-".repeat(50));
        studentsSecondCopy.forEach(System.out::println);
        System.out.println("-".repeat(50));
        studentsThirdCopy.forEach(System.out::println);
        System.out.println("-".repeat(50));
    }
}
