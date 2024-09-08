package comparableVsComparator.comparator;

import java.util.Comparator;

public class StudentGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) { // I want to compare gpa scores, but if there's a tie,
        // meaning two students have the same GPA, I'll sort alphabetically after that.
        return (s1.gpa + s1.name).compareTo(s2.gpa + s2.name);
    }
}