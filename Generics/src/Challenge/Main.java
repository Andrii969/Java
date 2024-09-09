package Challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int studentCount = 25;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
        students.add(new LPAStudent());
//        printList(students);
        printMoreLists(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
//        printList(lpaStudents);
        printMoreLists(lpaStudents);
        lpaStudents.sort(Comparator.naturalOrder());
        printMoreLists(lpaStudents);

        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches("percentComplete", "15");
        printMoreLists(matches);
        matches.sort(Comparator.reverseOrder());
        printMoreLists(matches);

        var students2021 = QueryList.getMatches(students, "YearStarted", "2021");
        printMoreLists(students2021);

//        QueryList<Employee> employeeList = new QueryList<>();

        System.out.println("-=-==-=-=-=-=-=-");

        QueryList<LPAStudent> queryList1 = new QueryList<>();
        for (int i = 0; i < 5; i++) {
            queryList1.add(new LPAStudent());
        }
        System.out.println("Ordered");
        queryList1.sort(Comparator.naturalOrder());
        printMoreLists(queryList1);
        System.out.println("Matches");
        var matches1 = queryList1.getMatches("PercentComplete", "50").getMatches("PercentComplete", "50");
        printMoreLists(matches1);
    }

    public static void printMoreLists(List<? extends Student> students) {

        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

}

