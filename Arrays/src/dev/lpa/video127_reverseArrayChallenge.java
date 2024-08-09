package dev.lpa;

import java.util.Arrays;

public class video127_reverseArrayChallenge {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(array));
        reverseArray(array); // using the reverseArray(int[] array) method that doesn't return anything
        System.out.println("Final: " + Arrays.toString(array));

        int[] reversedArray = reverseArrayCopy(array); // using the reverseArrayCopy(int[] array) method that returns reversed array
        System.out.println("Reversed array: " + Arrays.toString(array));
    }

    public static void reverseArray(int[] array) {
        int maxIndex = array.length - 1;
        int halfLength = maxIndex / 2;

        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
            // System.out.println("Iteration " + i + ": " + Arrays.toString(array));
            // firstly we change places for 1 and 5 [1,2,3,4,5] -> [5,2,3,4,1]
            // then we change places for 2 and 4 [5,2,3,4,1] -> [5,4,3,2,1]
        };
    }

    public static int[] reverseArrayCopy(int[] array) {
        int[] reversedArray = new int[array.length];
        int maxIndex = array.length - 1;
        for (int j : array) {
            reversedArray[maxIndex--] = j;
        }
        return reversedArray;
    }

    // Alternative 1
//    public static int[] reverseArrayCopy(int[] array) {
//        int[] reversedArray = new int[array.length];
//        int maxIndex = array.length - 1;
//        for (int i = 0; i < array.length; i++) {
//            reversedArray[maxIndex--] = array[i];
//        }
//        return reversedArray;
//    }

    // Alternative 2
//       public static int[] reverseArray(int[] array) {
//        int[] reversedArray = new int[array.length];
//        int j = 0;
//        for (int i = array.length - 1; i >= 0; i--) {
//            reversedArray[j] = array[i];
//            j++;
//        }
//       return reversedArray;
//    }

}
