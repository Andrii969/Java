import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class video134_arraysVsArrayLists {

    public static void main(String[] args) {
        String[] originalArray = new String[] {"first", "second", "third"};
        System.out.println(originalArray.getClass().getSimpleName());
        System.out.println(Arrays.toString(originalArray));

        List<String> list = List.of(originalArray);
        System.out.println(list.getClass().getSimpleName());
        System.out.println(list);

        List<String> anotherList = new ArrayList<>(list);
//        List<String> anotherList = new ArrayList<>(List.of(array));
        System.out.println(anotherList.getClass().getSimpleName());
        System.out.println(anotherList);

        var originalList = Arrays.asList(originalArray);
//        var originalList = Arrays.asList(List.of(array));
        System.out.println(originalList.getClass().getSimpleName());
        System.out.println(originalList);

        originalList.set(0, "one");
        System.out.println(originalList); // changed item from originalList
        System.out.println(Arrays.toString(originalArray)); // also changed item from originalArray

        originalList.sort(Comparator.reverseOrder());
        System.out.println(originalList); // changed order of the originalList
        System.out.println(Arrays.toString(originalArray)); // changed order of the originalList

//        originalList.add("forth"); // UnsupportedOperationException
//        originalList.remove("forth"); // UnsupportedOperationException

        List<String> newList = Arrays.asList("Sunday", "Monday", "Tuesday");
        System.out.println(newList);

    }
}
