package LinkedHashSetAndTreeSet;

import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class test {

    public static void main(String[] args) {

        NavigableSet<Integer> ints = new TreeSet<>();
        ints.addAll(List.of(1,2,3,4,5,6));
        ints.forEach(System.out::println);
        System.out.println();
        System.out.println("ceiling = " + ints.ceiling(1));
        System.out.println("higher = " + ints.higher(1));
        System.out.println("floor = " + ints.floor(1));
        System.out.println("lower = " + ints.lower(1));

    }
}
