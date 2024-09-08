package comparableVsComparator.comparator;

import java.util.Random;

public class Student implements Comparable<Student> {

    private static int LAST_ID = 1000;
    private static Random random = new Random();

    String name; // package private
    private int id;
    protected double gpa;

    public Student(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0); // lower and upper range of the doubles I want back.
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }

    @Override
    public int compareTo(Student s) { // need this method for proper sorting of the instances by certain fields (e.g. id)
        return Integer.valueOf(id).compareTo(Integer.valueOf(s.id)); // OR Integer.compare(id, s.id);
        // Since my id field is a primitive int, I'll need to box those in wrappers, to compare the id's.
    }
}
