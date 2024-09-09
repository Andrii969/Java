package exploring;

import java.util.Random;

public class Student {
    private String name;
    private int age;
    private int studentId;
    private double grade;

    Random random = new Random();
    private static String[] names = {"Ann", "Bill", "Cathy", "John", "Tim"};
    private static char[] grades = {'A', 'B', 'C', 'D', 'E'};

    private static int lastStudentId = 10000;

    // Constructor
    public Student() {
        this.name = names[random.nextInt(5)];
        this.age = random.nextInt(16, 25);
        this.studentId = lastStudentId++;
        this.grade = grades[random.nextInt(5)];
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getGrade() {
        return grade;
    }

    // Method to display student details
    public void displayStudentInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Student ID: " + studentId + ", Grade: " + grade);
    }
}
