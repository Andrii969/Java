package comparableVsComparator.comparable;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Integer five = 5;
        Integer[] others = {0, 5, 10, 50, -50};

        for (Integer i : others) {
            int val = five.compareTo(i); // if bigger = 1, if equals = 0, if less = -1
            System.out.printf("%d %s %d: compareTo=%d %n",five, (val == 0 ? "==" : val < 0 ? "<" : ">"), i, val);
        }

        System.out.println("-".repeat(30));
        // // // // // // // // // //

        String banana = "banana";
        String[] fruits = {"apple", "banana", "pear", "BANANA"};

        for (String j : fruits) {
            int val = banana.compareTo(j);
            System.out.printf("%s %s %s: compareTo=%s %n", banana, (val == 0 ? "==" : val > 0 ? ">" : "<"), j, val);
        }
        // This is how Java implemented the compareTo method on the String class.
        Arrays.sort(fruits);
        System.out.println(Arrays.toString(fruits));

        System.out.println("A:"+(int)'A' + " " + "a:"+(int)'a'); // A:65 a:97
        System.out.println("B:"+(int)'B' + " " + "b:"+(int)'b'); // B:66 b:98
        System.out.println("C:"+(int)'C' + " " + "c:"+(int)'c'); // C:67 c:99
        System.out.println("P:"+(int)'P' + " " + "p:"+(int)'p'); // P:80 p:112

        System.out.println("-".repeat(30));
        // // // // // // // // // //

        Student tim = new Student("Tim");
        Student marry = new Student("Marry");
        Student[] students = {new Student("Zach"),new Student("Tim"), new Student("Ann")};

        Arrays.sort(students); // class should implement Comparable,
                                // otherwise ERROR: class revisitingComparable.Student cannot be cast to class java.lang.Comparable
        System.out.println(Arrays.toString(students));

        System.out.println("result = " + tim.compareTo(marry)); // works fine when comparing Student objects
        System.out.println("result = " + tim.compareTo(new Student("TIM")));



    }
}
