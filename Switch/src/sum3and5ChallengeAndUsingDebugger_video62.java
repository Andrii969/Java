public class sum3and5ChallengeAndUsingDebugger_video62 {

    public static void main(String[] args) {

        int totalSum = 0;
        int numbersMetConditions = 0;

        for (int i = 1; i <= 1000; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("This number meets conditions: " + i);
                numbersMetConditions++;
                totalSum = totalSum + i;
                if (numbersMetConditions == 5) {
                    System.out.println("Total Sum is " + totalSum);
                    break;
                }
            }
        }
    }

}
