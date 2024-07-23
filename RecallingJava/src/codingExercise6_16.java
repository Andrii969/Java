public class codingExercise6_16 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome (int number) {
        if (number < 0) {
            number *= -1;
        }
        int reverse = 0;
        int initialNumber = number;
        while (number > 9) {
            reverse = reverse * 10 + (number % 10);
            number = number / 10;
        }
        reverse = reverse * 10 + (number % 10);
        return initialNumber == reverse;
    }
}


//////// TASK DESCRIPTION
//Number Palindrome
//Write a method called isPalindrome with one int parameter called number.
//The method needs to return a boolean.
//It should return true if the number is a palindrome number otherwise it should return false.