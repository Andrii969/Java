package comparableVsComparator.comparable;

public class Student implements Comparable<Student> {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Student s) {
        return name.compareTo(s.name);
    }
}
