public class methodOverloading_video51 {
    public static void main(String[] args) {
        calculateScore("Tim", 500);
        calculateScore(500);
        calculateScore();
    }

    public static void calculateScore (String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points.");
    }

    public static void calculateScore (int score) {
        System.out.println("Unnamed Player scored " + score + " points.");
    }

    public static void calculateScore () {
        System.out.println("No player name, no player score");
    }
}