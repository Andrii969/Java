package comparableVsComparator.comparator;

import java.util.Comparator;

public class StudentGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) { // I want to compare gpa scores, but if there's a tie,
        // meaning two students have the same GPA, I'll sort alphabetically after that.
        return (s1.gpa + s1.name).compareTo(s2.gpa + s2.name);
    }
}

// In Java, a Comparator is used to define an ordering of objects that don't have a natural ordering
// or to define an alternative ordering for objects that do. Here is a class StudentGPAComparator
// that implements the Comparator<Student> interface and provides a custom implementation of the compare method.