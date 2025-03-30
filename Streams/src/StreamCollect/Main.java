package StreamCollect;

import codeSetupStudentEngagementStatistics.Course;
import codeSetupStudentEngagementStatistics.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                        .limit(500)
                        .toList();

        Set<Student> australianStudents = students.stream()
                .filter((s) -> s.getCountryCode().equals("AU"))
                .collect(Collectors.toSet());
        System.out.println("# of Australian Students = " + australianStudents.size());

        Set<Student> underThirty = students.stream()
                .filter((s) -> s.getAgeEnrolled() < 30)
                .collect(Collectors.toSet());
        System.out.println("# of Under Thirty Students = " + underThirty.size());

        Set<Student> setOne = new TreeSet<>(Comparator.comparing(Student::getStudentId));
        setOne.addAll(australianStudents);
        setOne.retainAll(underThirty);
        setOne.forEach((s) -> System.out.print(s.getStudentId() + " "));

        System.out.println();

        Set<Student> setTwo = students.stream()
                .filter((s) -> s.getAgeEnrolled() < 30)
                .filter((s) -> s.getCountryCode().equals("AU"))
                .sorted(Comparator.comparing(Student::getStudentId))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        setTwo.forEach((s) -> System.out.print(s.getStudentId() + " "));

        System.out.println();

        Set<Student> setThree = students.stream()
                .filter((s) -> s.getAgeEnrolled() < 30)
                .filter((s) -> s.getCountryCode().equals("AU"))
                .collect(() -> new TreeSet<>(Comparator.comparing(Student::getStudentId)), TreeSet::add, TreeSet::addAll);
        setThree.forEach((s) -> System.out.print(s.getStudentId() + " "));

        System.out.println();

        String countrySet = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .reduce("", (r, v) -> r + " " + v);
        System.out.println(countrySet);


    }
}
