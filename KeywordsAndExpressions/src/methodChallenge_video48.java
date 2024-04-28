public class methodChallenge_video48 {

    public static void main(String[] args) {

        String playerName = "Andrii";
        int playerScore = 1500;
        System.out.println(displayHighScorePosition(playerName, calculateHighScorePosition(playerScore)));

        playerName = "Dina";
        playerScore = 1000;
        System.out.println(displayHighScorePosition(playerName, calculateHighScorePosition(playerScore)));

        playerName = "Yevgeniy";
        playerScore = 500;
        System.out.println(displayHighScorePosition(playerName, calculateHighScorePosition(playerScore)));

        playerName = "Viktor";
        playerScore = 100;
        System.out.println(displayHighScorePosition(playerName, calculateHighScorePosition(playerScore)));

        playerName = "Yurii";
        playerScore = 25;
        System.out.println(displayHighScorePosition(playerName, calculateHighScorePosition(playerScore)));

    }

    public static String displayHighScorePosition(String playerName, int playerPosition) {
        return (playerName + " managed to get into position " + playerPosition + " on the high score list.");
    }

    public static int calculateHighScorePosition(int playerScore) {
        int position = 4;
        if (playerScore >= 1000) {
            position = 1;
        } else if ((playerScore >= 500) && (playerScore < 1000)) {
            position = 2;
        } else if ((playerScore >= 100) && (playerScore < 500)) {
            position = 3;
        }
            return position;
        }
    }