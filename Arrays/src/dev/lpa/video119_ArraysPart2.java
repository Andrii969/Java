package dev.lpa;

import java.util.Arrays;

public class video119_ArraysPart2 {

    public static void main(String[] args) {

        int[] newArray1 = new int[5];
        for (int i = 0; i < newArray1.length; i++) {
            newArray1[i] = newArray1.length - i; // newArray[0] = 5 (5-0), newArray[1] = 4 (5-1), ...
            System.out.print(newArray1[i] + " "); // 5 4 3 2 1
        }
        System.out.println();

        int[] newArray2 = new int[] {1,2,3,4,5};
        for(int element: newArray2) { // enhanced 'for' loop
            System.out.print(element + " "); // 1 2 3 4 5
        }
        System.out.println();
        System.out.println(Arrays.toString(newArray2)); // [1, 2, 3, 4, 5]
        if (newArray2 instanceof int[]) {
            System.out.println("the newArray2 is an int array");
        }
        System.out.println();

        Object[] objectArray = new Object[3];
        objectArray[0] = "Hello";
        objectArray[1] = new StringBuilder("Hello");
        objectArray[2] = newArray2;
    }
}
