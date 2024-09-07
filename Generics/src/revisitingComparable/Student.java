package revisitingComparable;

public class Student implements Comparable {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) { // works for Student class, but it's not a good implementation,
                                    // I get another ClassCastException. This is because my compareTo method
                                    // on the Student class is trying to cast a String to a Student.
        Student other = (Student) o;
        return name.compareTo(other.name);
    }
}
