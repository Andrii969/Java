public class codingExercise6_17 {
    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(93434349));
    }

    public static int sumFirstAndLastDigit (int number) {
        if (number < 0) {
            return -1;
        }

        int lastDigit = number % 10;
        int firstDigit = 0;
        while (number > 9) {
            number = number / 10;
        }

        firstDigit = number;

        return firstDigit + lastDigit;
    }
}

//////// TASK DESCRIPTION
//First And Last Digit Sum
//Write a method named sumFirstAndLastDigit with one parameter of type int called number.
//The method needs to find the first and the last digit of the parameter number passed to the method, using a loop and return the sum of the first and the last digit of that number.
//If the number is negative then the method needs to return -1 to indicate an invalid value.

