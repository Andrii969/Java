package dev.lpa;

import java.util.Arrays;

public class video128_twoDimensionalArrays {

    public static void main(String[] args) {

        int[][] myDoubleArray = new int[4][4];
        System.out.println(Arrays.toString(myDoubleArray)); // [[I@36baf30c, [I@7a81197d, [I@5ca881b5, [I@24d46ca6]
        System.out.println("myDoubleArray.length = " + myDoubleArray.length); // myDoubleArray.length = 4

        for (int[] outer : myDoubleArray) {
            System.out.println(Arrays.toString(outer)); // [0, 0, 0, 0]
                                                        // [0, 0, 0, 0]
                                                        // [0, 0, 0, 0]
                                                        // [0, 0, 0, 0]
        }

//        for (int i = 0; i < myDoubleArray.length; i++) {
//            var innerArray = myDoubleArray[i];
//            for (int j = 0; j < myDoubleArray[i].length; j++) {
////                System.out.println(myDoubleArray[i][j]);
//                System.out.println("innerArray " + i + " element " + j + " = " + myDoubleArray[i][j]);
//
//            }
//        }
//
//        for (var outer : myDoubleArray) {
//            for (var element : outer) {
//                System.out.print(element + " ");
//            }
//            System.out.println();
//        }

        System.out.println(Arrays.deepToString(myDoubleArray)); // [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]

        for (int i = 0; i < myDoubleArray.length; i++) {
            var innerArray = myDoubleArray[i];
            for (int j = 0; j < innerArray.length; j++) {
                myDoubleArray[i][j] = (i * 10) + (j + 1);
            }
        }
        System.out.println(Arrays.deepToString(myDoubleArray)); // [[1, 2, 3, 4], [11, 12, 13, 14], [21, 22, 23, 24], [31, 32, 33, 34]]

        myDoubleArray[1] = new int[] {10,20,30};
        System.out.println(Arrays.deepToString(myDoubleArray)); // [[1, 2, 3, 4], [10, 20, 30], [21, 22, 23, 24], [31, 32, 33, 34]]

    }
}
