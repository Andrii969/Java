public class codingExercise_17 {

    public static void main(String[] args) {

        int number = 10;
        System.out.println(sumFirstAndLastDigit(number));

    }

    public static int sumFirstAndLastDigit (int number) {
        if (number < 0) {
            return -1;
        }
        int lastDigit = number % 10; // get last digit in a number
        while (number > 9) {
            number = number / 10; // divide with 10 until there is 1 digit left to get 1st digit
        }
        return number + lastDigit; // here the number is the 1st digit (that has been left) + lastDigit
    }


}
