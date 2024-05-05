public class codingExercise_18b {

    public static void main(String[] args) {

        int number = 88;
        System.out.println(getEvenDigitSum(number));
    }

    public static int getEvenDigitSum(int number) { // from the row with numbers
        int sum = 0;
        int lastDigit = 0;
        if (number < 0) {
            return -1;
        }
        while (number > 9) {
            lastDigit = number % 10; // get last digit
            number = number / 10; // remove last digit & update number
            if (lastDigit % 2 == 0) { // if lastDigit is even -> add it to sum
                sum += lastDigit;

            }
        }
        if (number % 2 == 0) { // when the (updated) number is even -> add it to sum
            sum += number;
        }
        return sum;
    }
}
