import java.util.Scanner;

public class codingExercise6_28 {

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

    public static void inputThenPrintSumAndAverage() {

        Scanner scanner = new Scanner(System.in);
        int SUM = 0;
        long AVG = 0;
        int counter = 0;

        while (true) {
            System.out.println("Enter a number #" + (counter + 1) + ":");
            String numberEntered = scanner.nextLine();
            try {
                int number = Integer.parseInt(numberEntered);
                SUM += number;
            } catch (NumberFormatException nfe) {
                break;
            }
            counter++;
        }
        if (counter > 0) {
            AVG = Math.round((double) SUM / counter);
        }
        System.out.println("SUM = " + SUM + " AVG = " + AVG);
    }
}

/////// ANOTHER VERSION
//public static void inputThenPrintSumAndAverage() {
//    Scanner scanner = new Scanner(System.in);
//    int sum = 0;
//    int count = 0;
//    long avg = 0;
//    while (true) {
//        boolean hasNextInt = scanner.hasNextInt();
//        if (!hasNextInt) {
//            // break the loop on invalid input
//            break;
//        }
//        sum += scanner.nextInt();
//        count++;
//        // clear buffer e.g. remove line separator
//        scanner.nextLine();
//    }
//    if (count > 0) {
//        avg = Math.round((double) sum / count);
//    }
//    System.out.println("SUM = " + sum + " AVG = " + avg);
//    scanner.close();
//}



///////// TASK DESCRIPTION
//Input Calculator
//Write a method called inputThenPrintSumAndAverage that does not have any parameters.
//The method should not return anything (void) and it needs to keep reading int numbers from the keyboard.
//When the user enters something that is not an int then it needs to print a message in the format "SUM = XX AVG = YY".
//XX represents the sum of all entered numbers of type int.
//YY represents the calculated average of all numbers of type long.
