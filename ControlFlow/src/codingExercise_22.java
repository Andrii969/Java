public class codingExercise_22 {

    public static void main(String[] args) {

        System.out.println(getGreatestCommonDivisor(25, 15));

    }

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
