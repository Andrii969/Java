package MoreStreams;

import codeSetupStudentEngagementStatistics.Course;
import codeSetupStudentEngagementStatistics.CourseEngagement;
import codeSetupStudentEngagementStatistics.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamsChallenge {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");
        Course cpp = new Course("CPP", "C++ Masterclass");

        int currentYear = LocalDate.now().getYear();
        List<Student> students = Stream.generate(() -> Student.getRandomStudent(pymc, jmc, cpp))
                .filter(s -> s.getYearEnrolled() >= (currentYear - 4))
                .limit(10000)
                .toList();

        System.out.println("statistics1 >>>");

        var statistics1 = students.stream()
                .mapToInt(Student::getYearEnrolled)
                .summaryStatistics();
        System.out.println(statistics1);

        students.subList(0, 10).forEach(System.out::println);

        System.out.println("statistics2 >>>");

        var statistics2 = students.stream()
                .mapToInt(s -> s.getEngagementMap().size())
                .summaryStatistics();
        System.out.println(statistics2);

        System.out.println("statistics3 >>>");

        var statistics3 = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(groupingBy(CourseEngagement::getCourseCode,
                        counting()));
        statistics3.forEach((k,v) -> System.out.println(k + " " + v));

        System.out.println("statistics4 >>>");

        var statistics4 = students.stream()
                .collect(groupingBy(s -> s.getEngagementMap().size(),
                        counting()));
        statistics4.forEach((k,v) -> System.out.println(k + " " + v));

        System.out.println("statistics5 >>>");

        var statistics5 = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(groupingBy(CourseEngagement::getCourseCode,
                        averagingDouble(CourseEngagement::getPercentComplete)));
        statistics5.forEach((k,v) -> System.out.println(k + " " + v));

        System.out.println("statistics6 >>>");

        var statistics6 = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(groupingBy(CourseEngagement::getCourseCode,
                        summarizingDouble(CourseEngagement::getPercentComplete)));
        statistics6.forEach((k,v) -> System.out.println(k + " " + v));

        System.out.println("statistics7 >>>");

        var statistics7 = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(groupingBy(CourseEngagement::getCourseCode,
                        groupingBy(CourseEngagement::getLastActivityYear,
                                counting())));
        statistics7.forEach((k,v) -> System.out.println(k + " " + v));

        System.out.println("statistics8 >>>");

        var statistics8 = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(groupingBy(CourseEngagement::getEnrollmentYear,
                        groupingBy(CourseEngagement::getCourseCode,
                                counting())));
        statistics8.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}
