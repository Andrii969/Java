public class methodsInJava_video45 {
    public static void main(String[] args) {

        int levelCompleted = 8;

        calculateScore(true, 10000, levelCompleted, 200);

    }
        public static void calculateScore (boolean gameOver, int score, int levelCompleted, int bonus) {
            int finalScore = score;

            if (gameOver == true) { // or 'if (gameOver)'
                finalScore += (levelCompleted * bonus);
                finalScore += 1000;
                System.out.println("Your final score was " + finalScore);
            }
        }
    }
