public class codingExercise6_22 {

    public static void main(String[] args) {
        int greatestCommonDivisor = getGreatestCommonDivisor(162, 81);
        System.out.println(greatestCommonDivisor);
    }

    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        }

        for (int i = first; i > 0; i--) {
            if (first % i == 0 && second % i == 0) {
                return i;
            }
        }
        return -1;
    }
}

//////////// ANOTHER VERSION
//public static int getGreatestCommonDivisor(int first, int second) {
//
//    if (first < 10 || second < 10) {
//        return -1;
//    }
//
//    int min = first < second ? first : second;
//    int gcd = 1;
//    for (int j = 1; j <= min; j++) {
//        if (first % j == 0 && second % j == 0) {
//            gcd = j;
//        }
//    }
//    return gcd;
//}
//



//////// TASK DESCRIPTION
//Greatest Common Divisor
//Write a method named getGreatestCommonDivisor with two parameters of type int named first and second.
//If one of the parameters is < 10, the method should return -1 to indicate an invalid value.
//The method should return the greatest common divisor of the two numbers (int).
//The greatest common divisor is the largest positive integer that can fully divide each of the integers (i.e. without leaving a remainder).
//For example 12 and 30:
//        12 can be divided by 1, 2, 3, 4, 6, 12
//        30 can be divided by 1, 2, 3, 5, 6, 10, 15, 30
//The greatest common divisor is 6 since both 12 and 30 can be divided by 6, and there is no resulting remainder.
