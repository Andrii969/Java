public class forStatementChallenge_video62 {

    public static void main(String[] args) {
        int sumOfMatches = 0;
        int countOfMatches = 0;
        for (int i = 1; i <= 1000; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                countOfMatches++;
                sumOfMatches += i;
                System.out.println("The number that met conditions is " + i);
            }
            if (countOfMatches == 5) {
                System.out.println("Exiting the loop, the number of found numbers that met conditions is 5.");
                System.out.println("The sum of the numbers that met conditions above is " + sumOfMatches);
                break;
            }
        }
    }
}
