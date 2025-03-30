package MoreStreams;

import codeSetupStudentEngagementStatistics.Course;
import codeSetupStudentEngagementStatistics.Student;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

public class MainMapsToStreams {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(500)
                .toList();

        long studentsCount = students.size();

        var experienced = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience));
        // divides students into two lists: true hasProgrammingExperience and false !hasProgrammingExperience
        System.out.println("Experienced Students (hasProgrammingExperience) = " + experienced.get(true).size());

        long notExperiencedStudents = experienced.get(false).size();
        System.out.println("notExperiencedStudents (!hasProgrammingExperience) = " + notExperiencedStudents);

        long studentBodyCount = 0;
        for (var list : experienced.values()) {
            studentBodyCount += list.size();
        }
        System.out.println("studentBodyCount (hasProgrammingExperience + !hasProgrammingExperience) = " + studentBodyCount);

        studentBodyCount = experienced.values().stream()
                .mapToInt(List::size) // .mapToInt(l -> l.size())
                .sum();
        System.out.println("studentBodyCount (hasProgrammingExperience + !hasProgrammingExperience) = " + studentBodyCount);

        long countActive = experienced.values().stream()
                .flatMap(l -> l.stream())
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("Active Students = " + countActive);

        long countInactive = experienced.values().stream()
                .flatMap(l -> l.stream())
                .filter(s -> s.getMonthsSinceActive() > 3)
                .count();
        System.out.println("Inactive Students = " + countInactive);

        // here are 2 lists
        var exStudents = experienced.values().stream()
                // experienced.values() returns a Collection<List<Student>>, which contains two lists (one for true and one for false keys)
                // .stream() creates a Stream<List<Student>>, meaning each element in the stream is a List<Student>
                .flatMap(l -> l.stream())
                // flatMap(l -> l.stream()) takes each List<Student> and converts it into a Stream<Student>,
                // then merges (or “flattens”) all these Stream<Student> elements into a single Stream<Student>.
                // Here flatMap takes the stream of lists of students and combines it into one continuous stream of students.
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .toList();
//        exStudents.forEach(System.out::println);

        List<List<String>> listOfLists = List.of(List.of("A", "B"), List.of("C", "D"));
        List<String> flattenedList = listOfLists.stream()
                .flatMap(List::stream) // Stream<String> // .flatMap(l -> l.stream())
                .toList(); // ["A", "B", "C", "D"]
        flattenedList.forEach(l -> System.out.print(l + " ")); // A B C D

        System.out.println();

        var multiLevel = students.stream()
                .collect(groupingBy(Student::getCountryCode, groupingBy(Student::getGender)));

        countActive = multiLevel.values().stream()
                .flatMap(map -> map.values().stream())
                .flatMap(l -> l.stream())
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("Active Students = " + countActive);



    }
}
