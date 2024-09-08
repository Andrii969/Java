package extra.Part2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            students.add(new Student());
        }
        students.add(new LPAStudent()); // we can add any type of Student to this List
        printMoreLists(students);

        List<LPAStudent> LPAStudents = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            LPAStudents.add(new LPAStudent());
        }
        printMoreLists(LPAStudents);

    }

    public static void printMoreLists(List<? extends Student> students) { // works with Student subtypes
        for (var student : students) {
            System.out.println(student);
        }
        System.out.println("-".repeat(46));
    }

//    public static <T extends Student> void printList(List<T> students) { // works with Student subtypes
//        for (var student : students) {
//            System.out.println(student);
//        }
//        System.out.println("-".repeat(46));
//    }
}
