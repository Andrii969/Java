public class codingExercise6_19 {

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(8, 8));
    }

    public static boolean hasSharedDigit(int a, int b) {
        boolean firstValid = a > 9 && a < 100;
        boolean secondValid = b > 9 && b < 100;

        if (!firstValid || !secondValid) {
            return false;
        }

        for (int i = a; i > 0; i /= 10) {
            int lastDigitA = i % 10;
            for (int j = b; j > 0; j /= 10) {
                int lastDigitB = j % 10;
                if (lastDigitB == lastDigitA) {
                    return true;
                }
            }
        }
        return false;
    }
}

//////// TASK DESCRIPTION
//Shared Digit
//Write a method named hasSharedDigit with two parameters of type int.
//Each number should be within the range of 10 (inclusive) - 99 (inclusive). If one of the numbers is not within the range, the method should return false.
//The method should return true if there is a digit that appears in both numbers, such as 2 in 12 and 23; otherwise, the method should return false.
