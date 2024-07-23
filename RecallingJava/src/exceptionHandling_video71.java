import java.util.Scanner;

public class exceptionHandling_video71 {

    public static void main(String[] args) {

        int currentYear = 2024;

        try { // try this method
            System.out.println(getInputFromConsole(currentYear));
        } catch (NullPointerException e) { // if there's a NullPointerException, then another method
            System.out.println(getInputFromScanner(currentYear));
        }
    }

    public static String getInputFromConsole(int currentYear) {

        String name = System.console().readLine("Hi, What's your Name? ");
        System.out.println("Hi " + name + ", nice to meet you!");

        String dateOfBirth = System.console().readLine("What year were you born? ");
        int age = currentYear - Integer.parseInt(dateOfBirth);
        System.out.println("So, " + name + ", you are " + age + " years old ;)");

        return "";
    }

    public static String getInputFromScanner(int currentYear) {

        Scanner scanner = new Scanner(System.in); // Scanner - class in Java;
        // scanner - variable name for the Scanner object;
        // new Scanner(System.in): This creates a new Scanner object that reads input from the standard input stream (typically the keyboard).
        System.out.println("Hi, What's your Name? ");
        String name = scanner.nextLine(); // This reads the user's input (name) as a string.
        System.out.println("Hi " + name + ", nice to meet you!");

        System.out.println("What year were you born? ");
        String dateOfBirth = scanner.nextLine(); // This reads the user's input (year of birth) as a string.
        int age = currentYear - Integer.parseInt(dateOfBirth);
        return "So, " + name + ", you are " + age + " years old ;)";
    }
}