package comparableVsComparator.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Student tim = new Student("Tim");

        Student[] students = {new Student("Zach"),new Student("Tim"), new Student("Ann")};

        Arrays.sort(students); // uses Student's method 'compareTo(Student s)'
        System.out.println(Arrays.toString(students));

        System.out.println("result = " + tim.compareTo(new Student("TIM"))); // result = -1
                                // (because the first tim's id is always less than the new Tim's id)

        Comparator<Student> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students, gpaSorter);
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, gpaSorter.reversed());
        System.out.println(Arrays.toString(students));



    }
}
