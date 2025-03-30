package Randomization.MyChallenge;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MyChallenge {

    public static void main(String[] args) {

        int diceCount = 5;
        boolean isPlayingGame = true;

        Scanner scanner = new Scanner(System.in);
        List<Integer> userOutput = rollTheDice(5);
        printOptions(userOutput);

        while (isPlayingGame) {
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("all")) {
                userOutput = rollTheDice(diceCount);
                printOptions(userOutput);
            }
            else if (input.isEmpty()) {
                isPlayingGame = false;
                System.out.println("Game Over. Real game would score and continue.");
            } else {
                List<Integer> reDice = Arrays.stream(input.split(" ")).map(Integer::parseInt).toList();
                reDice.forEach(userOutput::remove);
                System.out.println("Keeping " + userOutput);
                int dicesLeft = diceCount - userOutput.size();
                List<Integer> missingDices = rollTheDice(dicesLeft);
                userOutput.addAll(missingDices);
                printOptions(userOutput);
            }
        }
    }

    public static List<Integer> rollTheDice(int size) {
        Random random = new Random();
        return random.ints(size, 1, 7).boxed().collect(Collectors.toList());
    }

    public static void printOptions(List<Integer> userOutput) {
        System.out.println("Your dice are: " + userOutput);
        System.out.println("Press Enter to Score. \nType 'ALL' to re-roll the dice. \nList numbers (separated by spaces) to re-roll selected dice. \n---> ");
    }
}
