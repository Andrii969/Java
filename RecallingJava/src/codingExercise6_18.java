public class codingExercise6_18 {

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(2000032323));

    }

    public static int getEvenDigitSum(int number) {

        if (number < 0) {
            return -1;
        }

        int evenDigitSum = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 == 0) {
                evenDigitSum += lastDigit;
            }
            number = number / 10;
        }

//        == alternative using while loop ==
//        for (int i = number; i > 0; i /= 10) {
//            int lastDigit = i % 10;
//            if (lastDigit % 2 == 0) {
//                evenDigitSum += lastDigit;
//            }
//        }


        return evenDigitSum;
    }
}


//////// TASK DESCRIPTION
//Even Digit Sum
//Write a method named getEvenDigitSum with one parameter of type int called number.
//The method should return the sum of the even digits within the number.
//If the number is negative, the method should return -1 to indicate an invalid value.