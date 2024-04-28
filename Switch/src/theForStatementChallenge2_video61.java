public class theForStatementChallenge2_video61 {

    public static void main(String[] args) {

        int count = 0;
        for (int i = 10; i <= 50; i++) {
            if (isPrime(i)) {
                System.out.println("number " + i + " is a prime number");
                count++;
                if (count == 3) {
                    System.out.println("Found 3 - Exiting for loop");
                    break;
                }
            }
        }
        System.out.println("Total number of prime numbers found is " + count);
    }

    public static boolean isPrime(int wholeNumber) {

        if (wholeNumber <= 2) {
            return wholeNumber <= 2;
        }

        for (int devisor = 2; devisor < wholeNumber; devisor++) {
            if (wholeNumber % devisor == 0) {
                return false;
            }
        }

        return true;
    }
}


