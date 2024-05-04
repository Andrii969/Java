public class digitSumChallenge_video66 {

    public static void main(String[] args) {

        System.out.println(sumDigits(1234));

    }

        public static int sumDigits (int number) {
        if (number < 0) {
            return -1;
        }
        int sum = 0;
        while (number > 9) {    // if number > 9
            sum += number % 10; // get last digit & sum it
            number = number / 10; // remove last digit & update the number
        }
        sum += number % 10; // if number < 9 -> get single digit & sum it
            // OR sum += number // as the number < 9
        return sum;
    }
}
