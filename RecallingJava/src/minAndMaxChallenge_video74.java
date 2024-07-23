import java.util.Scanner;

public class minAndMaxChallenge_video74 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int min = 0;
        int max = 0;

        do {
            System.out.println("Enter a number #" + (count + 1) + ":");
            String valueEntered = scanner.nextLine();
            try {
                int number = Integer.parseInt(valueEntered);
                if (number == count || number < min) { // doesn't work very well
                    min = number;
                }
                if (number == count || number > max) {
                    max = number;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("The value entered (" + valueEntered + ") isn't a number, quiting...");
                break;
            }
            count++;
        } while (count < Integer.MAX_VALUE);

        if (count > 0) {
            System.out.println("min = " + min + ", max = " + max);
        } else {
            System.out.println("No valid data entered");

        }
    }
}