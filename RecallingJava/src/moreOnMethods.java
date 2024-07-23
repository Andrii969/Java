public class moreOnMethods {
    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        System.out.println("Your final score is " + calculateScore(gameOver, score, levelCompleted, bonus));
        System.out.println("Your final score is " + calculateScore(true, 10000, 8, 200));

        int finalScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("Your final score is " + finalScore);
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        int finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
        }
        return finalScore;
    }
}
