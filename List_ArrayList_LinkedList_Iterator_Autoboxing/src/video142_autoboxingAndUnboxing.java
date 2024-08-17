import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class video142_autoboxingAndUnboxing {

    public static void main(String[] args) {

        Integer boxedInteger = Integer.valueOf(15); // preferred but unnecessary
        System.out.println(boxedInteger);

        Integer deprecatedBoxing = new Integer(15); // deprecated since JDK 9
        System.out.println(deprecatedBoxing);

        int unboxedInt = boxedInteger.intValue(); // Unnecessary unboxing
        System.out.println(unboxedInt);

        // Automatic
        Integer autoBoxed = 15;
        int autoUnboxed = autoBoxed;
        System.out.println(autoBoxed.getClass().getName()); // java.lang.Integer
//        System.out.println(autoUnboxed.getClass().getName());

        Double resultBoxed = getLiteralDoublePrimitive(); // auto boxing occurred
        double resultUnboxed = getDoubleObject(); // auto unboxing occurred

        Integer[] wrapperArray = new Integer[5];
        wrapperArray[0] = 50;
        System.out.println(Arrays.toString(wrapperArray)); // [50, null, null, null, null]
        System.out.println(wrapperArray[0].getClass().getName()); // java.lang.Integer

        Character[] characterArray = {'a', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(characterArray)); // [a, b, c, d]

        var ourList = getList(1,2,3,4,5); // or "ArrayList<Integer> ourList = getList(1,2,3,4,5);"
        System.out.println(ourList); // [1, 2, 3, 4, 5]

        var anotherList = List.of(1, 2, 3, 4, 5);
        System.out.println(anotherList); // [1, 2, 3, 4, 5]
    }

    private static ArrayList<Integer> getList(int... varargs) { // works fine if getList(Integer... varargs)
        ArrayList<Integer> aList = new ArrayList<>();
        for (int i : varargs) {
            aList.add(i);
        }
        return aList;
    }

    private static int returnAnInt(Integer i) {
        return i;
    }

    private static Integer returnAnInteger(int i) {
        return i;
    }

    private static Double getDoubleObject() {
        return Double.valueOf(100.00);
    }

    private static double getLiteralDoublePrimitive() {
        return 100.00;
    }
}
