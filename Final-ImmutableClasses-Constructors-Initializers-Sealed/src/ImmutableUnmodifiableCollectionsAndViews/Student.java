package ImmutableUnmodifiableCollectionsAndViews;

public class Student {

    private final String name;
    private final StringBuilder studentNotes;

    public Student(String name, StringBuilder studentNotes) {
        this.name = name;
        this.studentNotes = studentNotes;
    }

//    public Student(Student another) {
//        this(another.getName(), another.getStudentNotes());
//    }

    public String getName() {
        return name;
    }

    public StringBuilder getStudentNotes() {
        return studentNotes; // == null ? null : new StringBuilder(studentNotes);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentNotes=" + studentNotes +
                '}';
    }
}
