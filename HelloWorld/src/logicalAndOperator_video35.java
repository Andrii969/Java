public class logicalAndOperator_video35 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        boolean isAlien = false;
        if (isAlien == false) {
            System.out.println("It's not an alien!");
            System.out.println("I'm scared of aliens!");
        }

//        int topScore = 100;
//        if (topScore == 100) {
//            System.out.println("You got the high score!"); // printed
//        }
//
//        int topScore = 100;
//        if (topScore != 100) {
//            System.out.println("You got the high score!"); // not printed
//        }
//
//        int topScore = 100;
//        if (topScore >= 100) {
//            System.out.println("You got the high score!"); // printed
//        }

        int topScore = 80;
        if (topScore >= 100) {
            System.out.println("You got the high score!");
        }

        int secondTopScore = 60;
        if (topScore > secondTopScore && topScore < 100) {
            System.out.println("Greater than second top score and less then 100"); //printed
        }

    }
}
