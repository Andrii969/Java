public class methodsInJava_video46 {
    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 8;
        int bonus = 100;

        calculateScore(gameOver, score, levelCompleted, bonus);

        score = 900;
        levelCompleted = 8;
        bonus = 100;

        calculateScore(gameOver, score, levelCompleted, bonus);

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
