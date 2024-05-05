public class codingExercise_18 {

    public static void main(String[] args) {

        int number = 20;
        System.out.println(getEvenDigitSum(number));
    }

    public static int getEvenDigitSum (int number) {
        if (number < 0) {
            return -1;
        }
        int sum = 0;
        int i = 0;
        while (i <= number) {
            i++;
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
