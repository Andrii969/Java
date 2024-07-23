public class codingExercise6_20 {

    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(22, 2, 42));
    }

    public static boolean hasSameLastDigit(int a, int b, int c) {
//        boolean validA = a >= 10 && a <= 1000;
//        boolean validB = b >= 10 && b <= 1000;
//        boolean validC = c >= 10 && c <= 1000;

        if (!isValid(a) || !isValid(b) || !isValid(c)) {
            return false;
        }

        int lastDigitA = a % 10;
        int lastDigitB = b % 10;
        int lastDigitC = c % 10;

        boolean sameAB = lastDigitA == lastDigitB;
        boolean sameBC = lastDigitB == lastDigitC;
        boolean sameCA = lastDigitC == lastDigitA;

        return sameAB || sameBC || sameCA;
    }

    public static boolean isValid (int number) {
        return number >= 10 && number <= 1000;
    }

}

//////// TASK DESCRIPTION
//Last Digit Checker
//Write a method named hasSameLastDigit with three parameters of type int.
//Each number should be within the range of 10 (inclusive) - 1000 (inclusive). If one of the numbers is not within the range, the method should return false.
//The method should return true if at least two of the numbers share the same rightmost digit; otherwise, it should return false.
//Write another method named isValid with one parameter of type int.
//The method needs to return true if the number parameter is in range of 10(inclusive) - 1000(inclusive), otherwise return false.