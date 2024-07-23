public class codingExercise6_26 {

    public static void main(String[] args) {
        System.out.println(getLargestPrime(217));
    }

//    public static boolean isPrime(int wholeNumber) {
//        if (wholeNumber < 2) {
//            return false;
//        }
//        for (int devisor = 2; devisor < wholeNumber / 2; devisor++) {
//            if (wholeNumber % devisor == 0) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static int getLargestPrime (int number) {
        if (number < 2) {
            return -1;
        }
        int largestPrime = 0;
        for (int divisor = 2; divisor <= number; divisor++) {
            boolean isPrime = true;
            for (int j = 2; j < divisor; j++) { // check if the number is Prime (for each divisor)
                if (divisor % j == 0) {
                    isPrime = false;
                    break; // no reason to continue if isPrime == false
                }
            }
            if (isPrime && number % divisor == 0 ) { // if divisor is prime & number is divisible by divisor -> keep going
                largestPrime = divisor;
            }
        }
        return largestPrime;
    }
}


//////// TASK DESCRIPTION
//Largest Prime
//Write a method named getLargestPrime with one parameter of type int named number.
//If the number is negative or does not have any prime numbers, the method should return -1 to indicate an invalid value.
//The method should calculate the largest prime factor of a given number and return it.