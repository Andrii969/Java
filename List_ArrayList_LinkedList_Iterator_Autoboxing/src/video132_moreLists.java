import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class video132_moreLists {

    public static void main(String[] args) {
        String[] items = {"apples", "bananas", "milk", "eggs"};
        System.out.println(items.getClass().getSimpleName()); // String[]
        System.out.println(Arrays.toString(items)); // [apples, bananas, milk, eggs]

        List<String> list = List.of(items);
        System.out.println(list.getClass().getSimpleName()); // ListN
        System.out.println(list); // [apples, bananas, milk, eggs]
//        list.add("cheese"); // why can't I add an item?

        ArrayList<String> groceries = new ArrayList<>(list); // creates a new ArrayList named groceries initialized with the elements
                                                            // from the immutable list
        groceries.add("yogurt");
        System.out.println(groceries); // [apples, bananas, milk, eggs, yogurt]

        ArrayList<String> nextList = new ArrayList<>( // creates a new ArrayList named nextList initialized with elements
                List.of("pickles", "mustard", "cheese") // from the immutable list created by List.of()
        );
        System.out.println(nextList); // [pickles, mustard, cheese]

        groceries.addAll(nextList);
        System.out.println(groceries); // [apples, bananas, milk, eggs, yogurt, pickles, mustard, cheese]


    }
}
