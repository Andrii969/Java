package StreamCollect;

import codeSetupStudentEngagementStatistics.Course;
import codeSetupStudentEngagementStatistics.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MainChallenge {

    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);
        Course cgj = new Course("CGJ", "Creating Games in Java");

//        List<Student> students1 = IntStream.rangeClosed(1, 500)
//                .mapToObj(s -> Student.getRandomStudent(pymc, jmc))
//                .toList();

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(pymc, jmc))
                .limit(1000)
                .toList();

        double totalPercent = students.stream()
                .mapToDouble(s -> s.getPercentComplete("JMC"))
                .reduce(0, Double::sum); // .reduce(0, (a, b) -> a + b); OR use .sum();
        // .reduce(0, Double::sum) sums up all the completion percentages in the stream. 0 is the starting value,
        // and Double::sum is a method reference that adds each percentage to the running total.

        double avePercent = totalPercent / students.size();
        System.out.printf("Average Percent Complete = %.2f%% %n", avePercent);

        int topPercent = (int) (1.25 * avePercent);
        System.out.printf("Best Percentage Complete = %d%% %n", topPercent);

        Comparator<Student> longTermStudent = Comparator.comparing(Student::getYearEnrolled);

        List<Student> hardWorkers = students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudent)
                .limit(10)
                .toList();

        hardWorkers.forEach(s -> {
            s.addCourse(cgj);
            System.out.println(s);
        });
    }
}
