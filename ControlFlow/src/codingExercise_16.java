public class codingExercise_16 {

    public static void main(String[] args) {

        System.out.println(isPalindrome (0));

    }


    public static boolean isPalindrome (int number) {
        if (number < 0) {
            number *= -1; // if number is negative -> it's multiplied by -1
        }
        int initNumber = number; // store the initial number
        int reverseNumber = 0;
        int lastDigit = 0;
        while (number > 9) { // if number > 9
            lastDigit = number % 10; // get last digit & store it in the lastDigit variable
            reverseNumber = reverseNumber * 10 + lastDigit; // add the lastDigit to the END of the reverseNumber
            number = number / 10; // update the number by removing the last digit
        }
        reverseNumber = reverseNumber * 10 + number; // when number < 10, add lastDigit or number to the reverseNumber
        return reverseNumber == initNumber; // compare & return true or false
    }
}
