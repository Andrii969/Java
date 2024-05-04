public class theForStatement_video61 {

    // 1st implementation
//    public static void main(String[] args) {
//
//        int testNumber = 5;
//        System.out.println(testNumber + " is " + (isPrime(testNumber) ? "" : "NOT ") + "a prime number");
//    }
//
//    public static boolean isPrime (int wholeNumber) {
//
//        if (wholeNumber == 2 || wholeNumber == 3 || wholeNumber == 5 || wholeNumber == 7) {
//            return true;
//        }
//        else if (wholeNumber % 2 != 0 || wholeNumber % 3 != 0 || wholeNumber % 4 != 0 || wholeNumber % 5 != 0 ||
//                wholeNumber % 6 != 0 || wholeNumber % 7 != 0 || wholeNumber % 8 != 0 || wholeNumber % 9 != 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    // 2nd implementation
        public static void main(String[] args) {
            int testNumber = 56;
            System.out.println(testNumber + " is " + (isPrime(testNumber) ? "" : "NOT ") + "a prime number");
    }

        public static boolean isPrime (int wholeNumber) {

            if (wholeNumber <= 2) {
                return wholeNumber <= 2;
            }

            for (int devisor = 2; devisor < wholeNumber; devisor++) {
                if (wholeNumber % devisor == 0) {
                    return false;
                }
                System.out.println(devisor);
            }

            return true;
        }

}
