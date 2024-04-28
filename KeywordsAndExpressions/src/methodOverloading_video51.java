public class methodOverloading_video51 {

    public static void main(String[] args) {

    calculateScore("Andrii", 500);
    calculateScore(600);
    calculateScore();

    }

    public static int calculateScore(String playerName, int score) {

        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 2;
    }

    public static int calculateScore(int score) {

        calculateScore("Anonymous", score);
        return score * 2;
    }

    public static int calculateScore() {

        System.out.println("No player name, no player score");
        return 0;
    }

}
