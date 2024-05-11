public class codingExercise_24 {

    public static void main(String[] args) {

        numberToWords(0);
        System.out.println(getDigitCount(100));
    }

    public static void numberToWords(int number) {
        // The method should print out the passed number using words for the digits.
        if (number < 0) {
            System.out.println("Invalid Value");
        }

        if (number == 0) {
            System.out.println("Zero");
        }

        int initReversedNumber = reverse(number);
        int reversedNumber = reverse(number);
        while (reversedNumber > 0) {
            int lastDigit = reversedNumber % 10;
            switch (lastDigit) {
                case 0 -> System.out.println("Zero");
                case 1 -> System.out.println("One");
                case 2 -> System.out.println("Two");
                case 3 -> System.out.println("Three");
                case 4 -> System.out.println("Four");
                case 5 -> System.out.println("Five");
                case 6 -> System.out.println("Six");
                case 7 -> System.out.println("Seven");
                case 8 -> System.out.println("Eight");
                case 9 -> System.out.println("Nine");
            }
            reversedNumber = reversedNumber / 10;
        }
        if (getDigitCount(number) != getDigitCount(reversedNumber)) {
            int diff = getDigitCount(number) - getDigitCount(initReversedNumber);
            for (int i = diff; i > 0; i--) {
                System.out.println("Zero");
            }
        }

    }

    public static int reverse (int number) {
        // The method reverse should have one int parameter and
        // return the reversed number (int).
        // For example, if the number passed is 234, then the reversed number would be 432.
        // The method  reverse should also reverse negative numbers.
        // Use the method reverse within the method numberToWords in order
        // to print the words in the correct order.
        int reversedNumber = 0;
        while (number != 0) {
            int lastDigit = number % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
            number = number / 10;
        }
        return reversedNumber;
    }

    public static int getDigitCount (int number) {
        // The method getDigitCount should return the count of the digits in that number.
        // If the number is negative, return -1 to indicate an invalid value.
        if (number < 0) {
            return -1;
        }
        if (number == 0) {
            return 1;
        }

        int count = 0;
        while (number > 0) {
            number = number / 10;
            count++;
        }
        return count;
    }

}
