package ProcessingAndTransformingStreamElements;

import codeSetupStudentEngagementStatistics.Course;
import codeSetupStudentEngagementStatistics.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        Student[] students = new Student[1000];
        Arrays.setAll(students, i -> Student.getRandomStudent(jmc, pymc));

        List<Student> longTermStudentsWithoutProgrammingExperience = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .limit(10)
                .toList();
        longTermStudentsWithoutProgrammingExperience.forEach(System.out::println);

        System.out.println("-".repeat(50));

        var longTermStudentsObjectArray = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .limit(10)
                .toArray();
        Arrays.asList(longTermStudentsObjectArray).forEach(System.out::println);

        System.out.println("-".repeat(50));

        var longTermStudentsStudentArray = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .limit(10)
                .toArray(Student[]::new); // .toArray(size -> new Student[size])
        Arrays.asList(longTermStudentsStudentArray).forEach(System.out::println);

        System.out.println("-".repeat(50));

        var longTermStudentsStudentsListOne = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .limit(10)
                .toList(); // when toList() ->>> I can't shuffle this because toList() in this case returns an immutable list
//        Collections.shuffle(longTermStudentsStudentsList);
        longTermStudentsStudentsListOne.forEach(System.out::println);

        System.out.println("-".repeat(50));

        var longTermStudentsStudentsListTwo = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .limit(10)
                .collect(Collectors.toList());
        // By using Collectors.toList(), the result will be a mutable ArrayList, and you can now shuffle it without any issues
        Collections.shuffle(longTermStudentsStudentsListTwo);
        longTermStudentsStudentsListTwo.forEach(System.out::println);

        System.out.println("-".repeat(50));

        List<Student> students2 = new ArrayList<>(List.copyOf(longTermStudentsStudentsListTwo));
        Collections.shuffle(students2);
        students2.forEach(System.out::println);
    }
}
