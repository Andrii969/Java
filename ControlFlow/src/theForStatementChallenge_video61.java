public class theForStatementChallenge_video61 {

    public static void main(String[] args) {

        int testNumber = 55;
        System.out.println(countPrimeNumbers(101));
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

    public static int countPrimeNumbers(int wholeNumber) {
        int foundPrimeNumbers = 0;
        for (int i = 2; i <= wholeNumber; i++) {
            foundPrimeNumbers += isPrime(i) ? 1 : 0;
            if (isPrime(i)) {
                System.out.println("prime number is " + i);
            }
//            if (foundPrimeNumbers == 3) { break; }
        }
        return foundPrimeNumbers;
    }
}


