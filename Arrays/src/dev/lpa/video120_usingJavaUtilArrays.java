package dev.lpa;

import java.util.Arrays;
import java.util.Random;

public class video120_usingJavaUtilArrays {

    public static void main(String[] args) {
        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));
        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = new int[10];
        System.out.println(Arrays.toString(secondArray)); // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        Arrays.fill(secondArray, 5);
        System.out.println(Arrays.toString(secondArray)); // [5, 5, 5, 5, 5, 5, 5, 5, 5, 5]

        int[] thirdArray = getRandomArray(10);
//        Arrays.sort(thirdArray);
        System.out.println(Arrays.toString(thirdArray));

        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        System.out.println(Arrays.toString(fourthArray));

        int[] smallerArray = Arrays.copyOf(thirdArray, 5);
        System.out.println(Arrays.toString(smallerArray)); // array with the first 5 numbers

        int[] largerArray = Arrays.copyOf(thirdArray, 15);
        System.out.println(Arrays.toString(largerArray)); // array with the additional 5 numbers set to 0
    }

    public static int[] getRandomArray(int len) {
        Random random = new Random(); // variable of type random, from java.util library, Random class has methods to return random numbers
        int[] newInt = new int[len]; // creating an array with the 'len' length
        for (int i = 0; i < len; i++) {
            newInt[i] = random.nextInt(100); // assigns random number that ranges from 0 to 99
        }
        return newInt; // returns an array the 'len' length, and assigned random numbers
    }
}
