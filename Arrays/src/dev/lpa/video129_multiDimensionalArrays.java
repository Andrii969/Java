package dev.lpa;

import java.util.Arrays;

public class video129_multiDimensionalArrays {

    public static void main(String[] args) {

        int[][] myDoubleArray = new int[4][4];
        myDoubleArray[1] = new int[] {1,2,3,4};
        System.out.println(Arrays.deepToString(myDoubleArray)); // [[0, 0, 0, 0], [1, 2, 3, 4], [0, 0, 0, 0], [0, 0, 0, 0]]
        myDoubleArray[2] = new int[] {11,12,13};
        System.out.println(Arrays.deepToString(myDoubleArray)); // [[0, 0, 0, 0], [1, 2, 3, 4], [11, 12, 13], [0, 0, 0, 0]]
        myDoubleArray[3] = new int[] {21,22,23,24,25};
        System.out.println(Arrays.deepToString(myDoubleArray)); // [[0, 0, 0, 0], [1, 2, 3, 4], [11, 12, 13], [21, 22, 23, 24, 25]]

        Object[] anyArray = new Object[3];
        System.out.println(Arrays.toString(anyArray)); // [null, null, null]

        anyArray[0] = new String[] {"a", "b", "c"};
        System.out.println(Arrays.deepToString(anyArray)); // [[a, b, c], null, null]

        anyArray[1] = new String[][] {
                {"1","2","3","4"},
                {"5", "6", "7"},
                {"8", "9"}
        };
        System.out.println(Arrays.deepToString(anyArray)); // [[a, b, c], [[1, 2, 3, 4], [5, 6, 7], [8, 9]], null]

        anyArray[2] = new int[2][2][2];
        System.out.println(Arrays.deepToString(anyArray));

        for (Object nestedArray : anyArray) {
            System.out.println(nestedArray.getClass().getSimpleName());
            System.out.println(Arrays.deepToString((Object[])nestedArray)); // casting here, Java compiler doesn't know that each element
            // is an array. The arrays dot deep to string method takes an array, so I need to cast my element to an array of object

        }








    }
}
