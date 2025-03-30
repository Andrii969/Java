package challengeTerminalOperations;

import codeSetupStudentEngagementStatistics.Course;
import codeSetupStudentEngagementStatistics.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainPartTwo {

    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        Student[] students = new Student[1000];
        Arrays.setAll(students, i -> Student.getRandomStudent(jmc, pymc));

        var ageStream = Arrays.stream(students)
                .mapToInt(Student::getAgeEnrolled);
        System.out.println("Stats for Enrollment Age = " + ageStream.summaryStatistics());

        var currentAgeStream = Arrays.stream(students)
                .mapToInt(Student::getAge);
        System.out.println("Stats for Current Age = " + currentAgeStream.summaryStatistics());

        Arrays.stream(students)
                .map(Student::getCountryCode)
                .distinct()
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        boolean longTerm = Arrays.stream(students)
                .anyMatch(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12));
        System.out.println("longTerm students? " + longTerm);

        long longTermCount = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .count();
        System.out.println("longTermCount = " + longTermCount);

        List<Student> longTermStudentsWithoutProgrammingExperience = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .sorted(Comparator.comparingLong(Student::getStudentId))
//                .sorted(Comparator.comparing(Student::getCountryCode))
                .limit(10)
                .toList();
        longTermStudentsWithoutProgrammingExperience.forEach(System.out::println);
    }
}
