package revisitingComparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class test {

    public static void main(String[] args) {


        ArrayList<Integer> integers = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
        integers.sort(Comparator.reverseOrder());
        System.out.println(integers);
        integers.sort(Comparator.naturalOrder());
        System.out.println(integers);

        int[] ints = new int[]{5,4,3,1,2};
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        sortDesc(ints);


    }

    public static void sortDesc(int[] array) {
        int[] arrayDesc = new int[array.length];
        Arrays.sort(array);
        int j = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            arrayDesc[j--] = array[i];
        }
        System.out.println(Arrays.toString(arrayDesc));
    }
}
