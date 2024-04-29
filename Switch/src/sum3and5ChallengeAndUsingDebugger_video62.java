public class sum3and5ChallengeAndUsingDebugger_video62 {

    public static void main(String[] args) {

        int sumOfMatches = 0;
        int countOfMatches = 0;

        for (int i = 1; i <= 1000; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("This number meets conditions: " + i);
                countOfMatches++;
                sumOfMatches += i;
            }
                if (countOfMatches == 5) {
                    System.out.println("Total Sum is " + sumOfMatches);
                    break;
                }
            }
        }
    }
