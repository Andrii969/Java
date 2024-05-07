public class codingExercise_20 {

    public static void main(String[] args) {

        System.out.println(hasSameLastDigit(23, 32, 996));

    }

    public static boolean hasSameLastDigit (int firstNumber, int secondNumber, int thirdNumber) {

        if (!isValid(firstNumber) || !isValid(secondNumber) || !isValid(thirdNumber)) {
            return false;
        }

        int lastDigitOfFirstNumber = firstNumber % 10;
        int lastDigitOfSecondNumber = secondNumber % 10;
        int lastDigitOfThirdNumber = thirdNumber % 10;

        if (lastDigitOfFirstNumber == lastDigitOfSecondNumber || lastDigitOfSecondNumber == lastDigitOfThirdNumber
                || lastDigitOfThirdNumber == lastDigitOfFirstNumber) {
            return true;
        }

        return false;
    }

    public static boolean isValid (int number) {
        return number >= 10 && number <= 1000;
    }

}
