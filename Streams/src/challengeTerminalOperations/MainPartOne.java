package challengeTerminalOperations;

import codeSetupStudentEngagementStatistics.Course;
import codeSetupStudentEngagementStatistics.Student;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class MainPartOne {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        Student[] students = new Student[1000];
        Arrays.setAll(students, i -> Student.getRandomStudent(jmc, pymc));

        var maleStudents = Arrays.stream(students)
                .filter(student -> student.getGender().equals("M"));
        var femaleStudents = Arrays.stream(students)
                .filter(student -> student.getGender().equals("F"));

        System.out.println("# of male students " + maleStudents.count());
        System.out.println("# of female students " + femaleStudents.count());

        for (String gender : List.of("M", "F", "U")) {
            var myStudents = Arrays.stream(students)
                    .filter(student -> student.getGender().equals(gender));
            System.out.println("# of " + gender + " students " + myStudents.count());
        }

        // // // // // // // // // // // // // //
        System.out.println("-".repeat(30));

        // Predicate<Student>: A Predicate is a functional interface in Java, representing a boolean-valued function
        // (a function that returns true or false). In this case, each Predicate<Student> takes a Student object as input
        // and returns a boolean result based on some condition involving the Student.

        List<Predicate<Student>> list = List.of(
                (s) -> s.getAge() < 30,
                (s) -> s.getAge() >= 30 && s.getAge() < 60
        );

        long total = 0;
        for (int i = 0; i < list.size(); i++) {
            var myStudents = Arrays.stream(students).filter(list.get(i));
            long cnt = myStudents.count();
            total += cnt;
            System.out.printf("# of students (%s) = %d%n", i == 0 ? " < 30" : ">= 30 & < 60", cnt);
        }
        System.out.println("# of students >= 60 = " + (students.length - total));

        // // // // // // // // // // // // // //
        System.out.println("ANOTHER APPROACH >>>>>>");

//        Map<String, Predicate<Student>> ageGroups = Map.of(
//                "Age < 30", (s) -> s.getAge() < 30,
//                "30 <= Age < 60", (s) -> s.getAge() >= 30 && s.getAge() < 60,
//                "Age >= 60", (s) -> s.getAge() >= 60
//        );

        Map<String, Predicate<Student>> ageGroups = new LinkedHashMap<>();
        ageGroups.put("Age < 30", (s) -> s.getAge() < 30);
        ageGroups.put("30 <= Age < 60", (s) -> s.getAge() >= 30 && s.getAge() < 60);
        ageGroups.put("Age >= 60", (s) -> s.getAge() >= 60);

        for (Map.Entry<String, Predicate<Student>> entry : ageGroups.entrySet()) {
            String label = entry.getKey();
            Predicate<Student> predicate = entry.getValue();

            var myStudents = Arrays.stream(students).filter(predicate);
            System.out.printf("# of students (%s) = %d%n", label, myStudents.count());
        }
    }
}
