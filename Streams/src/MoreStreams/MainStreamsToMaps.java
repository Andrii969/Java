package MoreStreams;

import codeSetupStudentEngagementStatistics.Course;
import codeSetupStudentEngagementStatistics.Student;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class MainStreamsToMaps {

    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(500)
                .toList();

        var mappedStudents = students.stream()
                .collect(groupingBy(Student::getCountryCode)); // returns a map
        mappedStudents.forEach((k, v) -> System.out.println(k + " " + v.size()));
//        mappedStudents.keySet().forEach(k -> {
//            System.out.println("Country Code: " + k);
//            mappedStudents.get(k).forEach(System.out::println);
//        });

        System.out.println("-".repeat(30));

        int minAge = 25;
        var youngerSet = students.stream()
                .collect(groupingBy(Student::getCountryCode,
                        filtering(s -> s.getAge() <= minAge, toList())));
        youngerSet.forEach((k, v) -> System.out.println(k + " " + v.size()));

        var experienced = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience)); // boolean
//        experienced.get(true).forEach(System.out::println);
        System.out.println("Experienced Students = " + experienced.get(true).size());

        var expCount = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience, counting())); // boolean
//        experienced.get(true).forEach(System.out::println);
        System.out.println("Experienced Students = " + expCount.get(true));

        var experiencedAndActive = students.stream()
                .collect(partitioningBy(
                        s -> s.hasProgrammingExperience() &&
                        s.getMonthsSinceActive() == 0,
                        counting()));
        System.out.println("Experienced and Active Students = " + experiencedAndActive.get(true));

        var multiLevel = students.stream()
                .collect(groupingBy(Student::getCountryCode, groupingBy(Student::getGender)));
        multiLevel.forEach((key, value) -> {
            System.out.println(key);
            value.forEach((key1, value1) -> {
                System.out.println(key1 + " " + value1);
            });
        });





    }
}
