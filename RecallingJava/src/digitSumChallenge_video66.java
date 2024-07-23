public class digitSumChallenge_video66 {

    public static void main(String[] args) {
        System.out.println(sumDigits(1));
    }

    public static int sumDigits (int number) {
        if (number < 0) {
            return -1;
        }
        int numbersLeft = 0;
        int sumNumbers = 0;
        for (int j = number; j > 0; j /= 10) {
            numbersLeft = j % 10;
            sumNumbers += numbersLeft;
        }
        return sumNumbers;
    }
}


//// IMPROVED VERSION
//public static int sumDigits (int number) {
//    if (number < 0) {
//        return -1;
//    }
//    int sum = 0;
//    while (number > 9) {
//        sum += number % 10;
//        number = number / 10;
//    }
//    sum += number;
//    return sum;
//}

////// TASK DESCRIPTION
// Sum the single digits of the number
