public class codingExercise_18a {

    public static void main(String[] args) {

        int number = 6;
        System.out.println(getEvenDigitSum(number));
    }

    public static int getEvenDigitSum (int number) {
        if (number < 0) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
