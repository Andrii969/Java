package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class video126_minimumElementChallenge {

    public static void main(String[] args) {
        int[] returnedArray = readIntegers();
        System.out.println(Arrays.toString(returnedArray));
        int returnedMin = findMin(returnedArray);
        System.out.println(returnedMin);
    }

    public static int[] readIntegers() {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter numbers separated by comma");
        String input = s.nextLine();

        String[] array = input.split(",");
        int[] intArray = new int[array.length];

        for(int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i].trim()); // trim() to remove spaces
        }

        return intArray;
    }

    public static int findMin (int[] array) {
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
