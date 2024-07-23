public class forStatementChallenge_video61 {
    public static void main(String[] args) {
//        System.out.println("0 is" + (isPrime(0) ? "" : " NOT") + " a prime number");
//        System.out.println("1 is" + (isPrime(1) ? "" : " NOT") + " a prime number");
//        System.out.println("2 is" + (isPrime(2) ? "" : " NOT") + " a prime number");
//        System.out.println("3 is" + (isPrime(3) ? "" : " NOT") + " a prime number");
//        System.out.println("8 is" + (isPrime(8) ? "" : " NOT") + " a prime number");
//        System.out.println("17 is" + (isPrime(17) ? "" : " NOT") + " a prime number");
          primeNumberCounter(100);
    }

    public static void primeNumberCounter (int number) {
        int foundPrimeNumbers = 0;
        for (int i = 0; i <= number; i++) {
            if (isPrime(i)) {
                System.out.println("number " + i + " is a prime number");
                foundPrimeNumbers++;
            }
            if (foundPrimeNumbers == 3) {
                System.out.println("Found 3 - Exiting the loop");
                break;
            }
        }
    }

    public static boolean isPrime(int wholeNumber) {
        if (wholeNumber < 2) {
            return false;
        }
        for (int devisor = 2; devisor < wholeNumber / 2; devisor++) {
            if (wholeNumber % devisor == 0) {
                return false;
            }
        }
        return true;
    }

}
