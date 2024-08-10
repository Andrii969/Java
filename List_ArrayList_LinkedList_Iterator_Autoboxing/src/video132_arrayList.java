import java.util.ArrayList;

public class video132_arrayList {

    record GroceryItem (String name, String type, int count) {

        public GroceryItem(String name) {
            this(name, "DAIRY", 1);
        }

        @Override
        public String toString() {
            return String.format("%d %s in %s", count, name.toUpperCase(), type);
        }
    }


    public static void main(String[] args) {

        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("milk"));
        groceryList.add(new GroceryItem("cheese"));
        groceryList.add(new GroceryItem("apples", "PRODUCT", 6));
        groceryList.add(0, new GroceryItem("yogurt")); // shifted items after
        groceryList.set(0, new GroceryItem("cream cheese")); // replaced item at index 0
        groceryList.remove(0); // removed item at index 0

        System.out.println(groceryList);

    }

}
