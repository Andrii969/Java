package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class codingExercise9_42 {

    public static void main(String[] args) {
        int returnedArrayLength = readInteger();
//        System.out.println("The returnedArrayLength = " + returnedArrayLength);
        int[] returnedArray = readElements(returnedArrayLength);
//        System.out.println(Arrays.toString(returnedArray));
        int minValueFromTheArray = findMin(returnedArray);
//        System.out.println("The minValueFromTheArray = " + minValueFromTheArray);
    }

    private static int readInteger() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the length of the array:");
        return s.nextInt();
    }

    private static int[] readElements(int len) {

        Scanner s = new Scanner(System.in);
        int[] array = new int[len];

        for (int i = 0; i < len; i++){
            System.out.println("Enter the number for array on the position " + i + ":");
            array[i] = s.nextInt();
        }
        return array;
    }

    private static int findMin (int[] array) {
        Arrays.sort(array);
        return array[0];

        // another way
//        int min = Integer.MAX_VALUE;
//        for (int el : array) {
//            if (el < min) {
//                min = el;
//            }
//        }
//        return min;

    }
}
