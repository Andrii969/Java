package dev.lpa;

import java.util.Arrays;

public class video121_searchingInArrays {

    public static void main(String[] args) {

        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));
        if (Arrays.binarySearch(sArray, "Mark") >= 0) { // to make the binarySearch search properly, the array should be sorted
            System.out.println("Mark found");
        }

        int[] s1 = {1,2,3,4,5};
        int[] s2 = {1,2,3,4,5};
        if (Arrays.equals(s1, s2)) { // works if arrays contain sorted items on same positions
            System.out.println("The s1 and s2 arrays are equal");
        } else {
            System.out.println("The s1 and s2 arrays are not equal");
        }
    }
}
