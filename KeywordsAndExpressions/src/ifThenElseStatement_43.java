public class ifThenElseStatement_43 {
    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 999;
        int levelCompleted = 5;
        int bonus = 100;

//        if (score < 5000) {
//            System.out.println("Your score was less than 5000");
//        } else {
//            System.out.println("Got here");
//        }

        if (score < 5000 && score >= 1000) {
            System.out.println("Your score was less than 5000 but greater or equal 1000");
        } else if (score < 1000) {
            System.out.println("Your score was less than 1000");
        } else {
            System.out.println("Got here");
        }
    }
}
