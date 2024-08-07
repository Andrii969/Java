package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class codingExercise9_41 {


    public static void main(String[] args) {
        int[] myArray = getIntegers(5);
        printArray(myArray);
        myArray = sortIntegers(myArray);
        printArray(myArray);
    }

    public static int[] getIntegers(int capacity) {
        Scanner scanner = new Scanner(System.in);
        int[] theArray = new int[capacity];
        System.out.println("Enter " + capacity + " integer values:\r");
        for (int i = 0; i < theArray.length; i++) {
//            System.out.println("Please, enter the number for position " + i + ": ");
            theArray[i] = scanner.nextInt();
        }
        return theArray;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array) { // DESC sorting
        int[] sortedArrayAsc = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArrayAsc);
        int[] sortedArrayDesc = new int[array.length];
        int iterator = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            sortedArrayDesc[iterator] = sortedArrayAsc[i];
            iterator++;
        }
        return sortedArrayDesc;
    }
}
