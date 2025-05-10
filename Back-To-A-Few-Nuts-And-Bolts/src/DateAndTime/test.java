package DateAndTime;

import java.util.Random;
import java.util.function.BiFunction;

public class test {
    public static void main(String[] args) {

        Random random = new Random();

        int number = random.nextInt(1, 3);
        System.out.println(numberToWord(number));

//        String[] strings = new String[] {"One", "Two"};

        int a = 5;
        int b = 8;
        BiFunction<Integer, Integer, int[]> swap = (x, y) -> new int[]{y, x};
        int[] swappedValues = swap.apply(a, b);
        a = swappedValues[0];
        b = swappedValues[1];
        System.out.println("After swap: a = " + a + ", b = " + b);


    }

    public static String numberToWord(int number) {
        return switch (number) {
            case 1 -> "One";
            case 2 -> "Two";
            default -> "NaN";
        };
    }
}
