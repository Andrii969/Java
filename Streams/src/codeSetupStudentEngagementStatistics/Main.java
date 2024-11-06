package codeSetupStudentEngagementStatistics;

import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");
        Student tim = new Student("AU", 2019, 30, "M", true, pymc, jmc);
//        System.out.println(tim);
//
//        tim.watchLecture("JMC", 10, 5, 2019);
//        tim.watchLecture("PYMC", 7, 7, 2020);
//        System.out.println(tim);

        var students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(100);

        var maleStudents = students.filter(student -> student.getGender().equals("M"));
        System.out.println("# of male students " + maleStudents.count());

        // // // // // // // // // // // // // // // // // // //

        List<Student> students2 = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(100)
                .toList();

        int femaleStudentsNumber = students2
                .stream()
                .filter(student -> student.getGender().equals("F"))
                .toList()
                .size();

        int maleStudentsNumber = students2
                .stream()
                .filter(student -> student.getGender().equals("M"))
                .toList()
                .size();

        int enrolledBefore30 = students2
                .stream()
                .filter(student -> student.getAgeEnrolled() < 30)
                .toList()
                .size();

        int enrolledBetween30And60 = students2
                .stream()
                .filter(student -> student.getAgeEnrolled() >= 30 && student.getAgeEnrolled() <= 60)
                .toList()
                .size();

        int enrolledAfter60 = students2
                .stream()
                .filter(student -> student.getAgeEnrolled() > 60)
                .toList()
                .size();

        System.out.println("femaleStudentsNumber = " + femaleStudentsNumber);
        System.out.println("maleStudentsNumber = " + maleStudentsNumber);
        System.out.println("enrolledBefore30 = " + enrolledBefore30);
        System.out.println("enrolledBetween30And60 = " + enrolledBetween30And60);
        System.out.println("enrolledAfter60 = " + enrolledAfter60);
    }
}
