package extra.Part3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        testList(new ArrayList<>(List.of("one", "two", "three")));
        testList(new ArrayList<>(List.of(1,2,3)));


    }

    public static void testList(List<?> list) {
        for (var element : list) {
            if (element instanceof String s) {
                System.out.println("Integer: " + s.toUpperCase());
            } else if (element instanceof Integer i) {
                System.out.println("Integer: " + i.floatValue());
            }
        }
    }


//    public static void testList(List<String> list) { // ERROR: 'testList(List<String>)' clashes with 'testList(List<Integer>)';
//                                                        // both methods have same erasure
//        for (var element : list) {
//            System.out.println("String: " + element.toUpperCase());
//        }
//    }
//
//    public static void testList(List<Integer> list) {
//        for (var element : list) {
//            System.out.println("Integer: " + element.floatValue());
//        }
//    }
    }
