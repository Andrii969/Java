public class codingExercise_19a {

    public static void main(String[] args) {

        System.out.println(hasSharedDigit(162345, 677890));

    }

    public static boolean hasSharedDigit(int a, int b) {
        int initA = a;
        int initB = b;

        while (a > 0) {
            int digitA = a % 10; // Get the rightmost digit of a
            int tempB = initB; // Reset tempB for each digit of a
            while (tempB > 0) {
                int digitB = tempB % 10; // Get the rightmost digit of b
                if (digitA == digitB) {
                    return true; // If any digits match, return true
                }
                tempB /= 10; // Move to the next digit of b
            }
            a /= 10; // Move to the next digit of a
        }

        return false; // No shared digits found
    }

}