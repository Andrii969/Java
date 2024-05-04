public class whileLoopChallenge_video65 {

    // 1st option
//    public static void main(String[] args) {
//
//        int input = 5;
//        while (input <= 20) {
//            if (isEvenNumber(input)) {
//                System.out.println(input);
//            }
//            input++;
//        }
//    }

    // 2nd option
    public static void main(String[] args) {

        int input = 5;
        while (input <= 20) {
            input++;
            if (!isEvenNumber(input)) {
               continue;
            }
            System.out.println(input);
        }
    }

    public static boolean isEvenNumber (int input) {
        return input % 2 == 0 ? true : false;
    }
}
