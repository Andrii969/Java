public class codingExercise_19 {

    public static void main(String[] args) {

        System.out.println(hasSharedDigit(162345, 677890));

    }

    public static boolean hasSharedDigit(int a, int b) {
//        if (a < 10 || a > 99 || b < 10 || b > 99) {
//            return false;
//        } // optional validation
        int initA = a;
        int initB = b;
        int lastDigitOfA = a % 10;
        int lastDigitOfB = 0;
        while (b > 9) {
            lastDigitOfB = b % 10; // get last digit from B
            if (lastDigitOfA == lastDigitOfB) {
                return true;
            }
            b = b / 10; // update number B
        }
        if (lastDigitOfA == b) {
            return true;
        } else if (lastDigitOfA != b) {
            while (a > 9) {
                lastDigitOfA = a % 10;
                if (lastDigitOfA == lastDigitOfB) {
                    return true;
                }
                a = a / 10;
            }
        }
        return a == b;
    }
}
