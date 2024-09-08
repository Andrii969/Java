package extra.Part1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            students.add(new Student());
        }
        students.add(new LPAStudent()); // we can add any type of Student to this List
        printList(students);

        List<LPAStudent> LPAStudents = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            LPAStudents.add(new LPAStudent());
        }
//        printList(LPAStudents); // the error on that last statement, the call to the static method here.
                                // Hovering over that, you can see that the required type is a List of Student,
                                // and I'm providing an ArrayList of LpaStudent.

    }

    public static void printList(List<Student> students) { //
        for (var student : students) {
            System.out.println(student);
        }
        System.out.println("-".repeat(46));
    }
}
