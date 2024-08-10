import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class video133_arrayList {

    public static void main(String[] args) {


        List<String> list = List.of("apples", "bananas", "milk", "eggs", "yogurt", "pickles", "mustard", "cheese");
        System.out.println(list);
        System.out.println("Third item from list = " + list.get(2));

        List<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println(groceries);
        System.out.println("First index of yogurt = " + groceries.indexOf("yogurt"));
        System.out.println("Last index of yogurt = " + groceries.lastIndexOf("yogurt"));

        groceries.remove(1);
        System.out.println(groceries);
        groceries.remove("yogurt"); // only first yogurt item is removed
        System.out.println(groceries);

        groceries.removeAll(List.of("apples", "eggs")); // remove items
        System.out.println(groceries);

        groceries.retainAll(List.of("milk", "pickles", "mustard")); // remove all except these items
        System.out.println(groceries);

        groceries.clear(); // remove all
        System.out.println(groceries);
        System.out.println("isEmpty = " +groceries.isEmpty());

        groceries.addAll(List.of("apples","milk","mustard","cheese"));
        System.out.println(groceries);
        groceries.addAll(Arrays.asList("eggs","pickles","ham"));
        System.out.println(groceries);

        groceries.sort(Comparator.naturalOrder()); // sorting items in the list ASC (A-Z, from lowest to highest)
        System.out.println(groceries);

        groceries.sort(Comparator.reverseOrder()); // sorting items in the list DESC
        System.out.println(groceries);

        var groceryArray = groceries.toArray(new String[groceries.size()]); // toArray() method is used to convert a list into an array.
                                                                    // new String[groceries.size()] creates a new array of type String with a length equal to the
                                                                    // size of the groceries list. This array is passed as an argument to the toArray() method.
                                                                    // The resulting array of strings from the list groceries is stored in this variable.
                                                                    // Since var is used, the type of groceryArray is inferred as String[].
                System.out.println(Arrays.toString(groceryArray));

    }
}
