import java.util.Scanner;

public class readingUserInputChallenge_73 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberCount = 1;
        double sumEnteredNumbers = 0;

//        while (numberCount <= 5) {
//            System.out.println("Enter number #" + numberCount + ":");
//            String enteredNumber = scanner.nextLine();
//            try {
//                double userNumber = Double.parseDouble(enteredNumber);
//                sumEnteredNumbers += userNumber;
//                numberCount++;
//            } catch (NumberFormatException badUserData) {
//                System.out.println("Please, provide a valid number. The '" + enteredNumber + "' value is invalid." );
//            }
//        }

        do {
            System.out.println("Enter number #" + numberCount + ":");
            String enteredNumber = scanner.nextLine();
            try {
                double userNumber = Double.parseDouble(enteredNumber);
                sumEnteredNumbers += userNumber;
                numberCount++;
            } catch (NumberFormatException badUserData) {
                System.out.println("Please, provide a valid number. The '" + enteredNumber + "' value is invalid." );
            }
        } while (numberCount <= 5);

        System.out.println("The sum of entered numbers is " + sumEnteredNumbers);
    }
}
