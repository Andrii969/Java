package dev.lpa;

import java.util.Arrays;

public class video124_references {

    public static void main(String[] args) {
        int[] myIntArray = new int[5];
        int[] myAnotherArray = myIntArray;

        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("myAnotherArray = " + Arrays.toString(myAnotherArray));

        myAnotherArray[0] = 1;

        System.out.println("after change myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("after change myAnotherArray = " + Arrays.toString(myAnotherArray));

        modifyArray(myIntArray);
        System.out.println("after second change myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("after second change myAnotherArray = " + Arrays.toString(myAnotherArray));
    }

    public static void modifyArray(int[] array) {
        array[1] = 2;
    }
}
