package util;

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
        System.out.println("-".repeat(30));

        List<LPAStudent> LPAStudents = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            LPAStudents.add(new LPAStudent());
        }
        printMoreLists(LPAStudents);
        System.out.println("-".repeat(30));

        var queryList = new QueryList<>(LPAStudents);
        var matches = queryList.getMatches("COURSE", "Java");
        printMoreLists(matches);

        var students2021 = QueryList.getMatches(LPAStudents, "YearStarted", "2021");
        printMoreLists(students2021);

        var students2022 = QueryList.<Student>getMatches(new ArrayList<>(), "YearStarted", "2021");
                    // This is saying, the new list that will get created in the getMatches method, will be a list of Students now.
        printMoreLists(students2022);

//        QueryList<Employee> employees = new QueryList<>();
                // ERROR: Type parameter 'util.Employee' is not within its bound; should extend 'util.Student'

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
