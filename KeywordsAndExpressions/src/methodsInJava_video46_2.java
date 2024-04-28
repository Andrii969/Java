public class methodsInJava_video46_2 {
    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 8;
        int bonus = 100;

        int highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("The highScore is " + highScore);

        score = 900;
        levelCompleted = 8;
        bonus = 100;

        System.out.println("The highScore is " +
                calculateScore(gameOver, score, levelCompleted, bonus));
    }

        public static int calculateScore (boolean gameOver, int score, int levelCompleted, int bonus) {
            int finalScore = score;

            if (gameOver == true) { // or 'if (gameOver)'
                finalScore += (levelCompleted * bonus);
                finalScore += 1000;
            }
            return finalScore;
        }
    }
