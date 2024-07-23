public class whileDoWhileStatements_video64 {

//    public static void main(String[] args) { // while loop
//        int j = 1;
//        while (j <= 10) {
//            System.out.println(j);
//            j++;
//        };
//    }

//    public static void main(String[] args) { // do while loop
//        int j = 1;
//        do {
//            System.out.println(j);
//            j++;
//        } while (j < 10);
//    }

//    public static void main(String[] args) { // do while loop - note it executes at least once - even if the condition is false
//        int j = 1;
//        do {
//            System.out.println(j);
//            j++;
//        } while (j < 10);
//    }

//    public static void main(String[] args) {
//        int j = 1;
//        boolean isReady = false;
//        do {
//            if (j > 5) {
//                break;
//            }
//            System.out.println(j);
//            j++;
//            isReady = (j > 0);
//        } while (isReady);
//    }

    public static void main(String[] args) {
        int number = 0;
        while (number < 50) {
            number += 5;
            if (number % 25 == 0) {
                continue;
            }
            System.out.print(number + "_");
            }
    }

}
