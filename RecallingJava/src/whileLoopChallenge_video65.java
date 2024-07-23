public class whileLoopChallenge_video65 {

    public static void main(String[] args) {
        printEven(15, 35);
    }

    public static boolean isEvenNumber (int number) {
        if (number < 2) {
            return false;
        }
        if (number % 2 == 0) {
            return true;
        }
        return false;
    }

    public static void printEven (int start, int end) {
        if (start > end) {
            System.out.println("Invalid value");
            return;
        }

        int j = start;
        int countEven = 0;
        int countOdd = 0;
        while (j <= end) {
            if (countEven >= 5) {
                break;
            }
            if (isEvenNumber(j)) {
                countEven++;
                System.out.println("Even: " + j);
            } else {
                countOdd++;
                System.out.println("Odd: " + j);
            }
            j++;
        }
        System.out.println("Even numbers found = "+ countEven);
        System.out.println("Odd numbers found = "+ countOdd);
    }

}
