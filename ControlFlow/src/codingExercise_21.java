public class codingExercise_21 {

    public static void main(String[] args) {

        printFactors(-1);

    }

    public static void printFactors (int number) {
        // The method should print all factors of the number.
        // A factor of a number is an integer which divides
        // that number wholly (i.e. without leaving a remainder).

        if (number < 1) {
            System.out.println("Invalid Value");
        }

        int i = 0;
        while (i <= number) {
            i++;
            if (number % i == 0) {
                System.out.println(i);
            }

        }
    }

    // OR

//    public static void printFactors(int number) {
//
//        if (number < 1) {
//            System.out.println("Invalid Value");
//            return;
//        }
//
//        for (int i = 1; i <= number; i++) {
//            if (number % i == 0) {
//                System.out.println(i);
//            }
//        }
//    }
}
