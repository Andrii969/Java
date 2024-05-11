public class codingExercise_22 {

    public static void main(String[] args) {

        System.out.println(getGreatestCommonDivisor(25, 15));

    }


    // Greatest Common Divisor
    // Write a method named getGreatestCommonDivisor with two parameters
    // of type int named first and second.
    // If one of the parameters is < 10, the method should return -1 to indicate an invalid value.
    // The method should return the greatest common divisor of the two numbers (int).
    // The greatest common divisor is the largest positive integer that can fully divide
    // each of the integers (i.e. without leaving a remainder).

    public static int getGreatestCommonDivisor(int a, int b) {
        if (a < 10 || b < 10) {
           return -1;
        }

        int i = 0;
        boolean AisSmallerNumber = a < b;
        int smallerNumber = AisSmallerNumber ? a : b;
        int greatestCommonDivisor = 0;
        while (i <= smallerNumber) {
            i++;
            if ((a % i == 0) && (b % i == 0)) {
                greatestCommonDivisor = i;
            }
        }
        return greatestCommonDivisor;
    }

    // OR
//    public static int getGreatestCommonDivisor(int first, int second) {
//
//        if (first < 10 || second < 10) {
//            return -1;
//        }
//
//        int min = first < second ? first : second;
//        int gcd = 1;
//        for (int j = 1; j <= min; j++) {
//            if (first % j == 0 && second % j == 0) {
//                gcd = j;
//            }
//        }
//        return gcd;
//    }




}
