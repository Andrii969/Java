package dev.lpa;

import java.util.Arrays;
import java.util.Random;

public class video122_ArraysChallenge {

    public static void main(String[] args) {

        int[] myArray = getRandomArray(10);
        System.out.println(Arrays.toString(myArray)); // print unsorted array
        Arrays.sort(myArray); // array sorted ASC
        System.out.println(Arrays.toString(myArray)); // print array sorted ASC

        int[] myArrayDesc = getArraySortedByDesc(myArray);
        System.out.println(Arrays.toString(myArrayDesc)); // print array sorted DESC
    }

    public static int[] getRandomArray (int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static int[] getArraySortedByDesc (int[] array) {
        int[] theArray = Arrays.copyOf(array, array.length);
        Arrays.sort(theArray); // array is sorted
        int j = 0;
        for (int i = theArray.length - 1; i >= 0; i--) {
            theArray[j] = array[i];
            j++;
            if (j == theArray.length) {
                break;
            }
        }
        return theArray;
    }
}
