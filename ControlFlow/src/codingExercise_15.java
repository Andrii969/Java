public class codingExercise_15 {

    public static void main(String[] args) {

        System.out.println(sumOdd(100, 1000));

    }

    public static boolean isOdd(int number) {
        return (number > 0 && number % 2 != 0) ? true : false;
        // OR return number > 0 && number % 2 != 0;
    }

    // 1st option
//    public static int sumOdd(int start, int end) {
//
//        if (start < 0 || end < 0 || end < start) {
//            return -1;
//        } else {
//            int sumOddNumbers = 0;
//            for (int i = start; i <= end; i++) {
//                if (isOdd(i)) {
//                    sumOddNumbers += i;
//                }
//            }
//            return sumOddNumbers;
//        }
//    }

    // 2nd option
    public static int sumOdd(int start, int end) {

        if (start < 0 || end < 0 || end < start) {
            return -1;
        }

        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (isOdd(i)) {
                sum += i;
            }
        }
        return sum;
    }

}

