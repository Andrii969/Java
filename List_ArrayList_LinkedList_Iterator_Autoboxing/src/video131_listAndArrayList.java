import java.util.ArrayList;
import java.util.Arrays;

public class video131_listAndArrayList {

    record GroceryItem(String name, String type, int count) {

        public GroceryItem(String name) {
            this(name, "DAIRY", 1);
        }
    }

    public static void main(String[] args) {

        Object[] groceryArray = new Object[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apples", "PRODUCT", 6);
        groceryArray[2] = "5 oranges";
        System.out.println(Arrays.toString(groceryArray)); // [GroceryItem[name=milk, type=DAIRY, count=1], GroceryItem[name=apples, type=PRODUCT, count=6], 5 oranges]

        GroceryItem[] groceryItem = new GroceryItem[3]; // // Creating an array specifically for GroceryItem objects
        groceryItem[0] = new GroceryItem("milk");
        groceryItem[1] = new GroceryItem("apples", "PRODUCT", 6);
        groceryItem[2] = new GroceryItem("oranges", "PRODUCT", 5);
        System.out.println(Arrays.toString(groceryItem));


        ArrayList objectList = new ArrayList(); // Creating an ArrayList without specifying the type, so it can hold any object
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yogurt");
        System.out.println(objectList.toString()); // [GroceryItem[name=Butter, type=DAIRY, count=1], Yogurt]

        ArrayList<GroceryItem> groceryItems = new ArrayList<>(); // Creating a type-safe ArrayList that can only hold GroceryItem objects
        groceryItems.add(new GroceryItem("milk"));
        groceryItems.add(new GroceryItem("apples", "PRODUCT", 6));
        groceryItems.add(new GroceryItem("oranges", "PRODUCT", 5));
        System.out.println(groceryItems); // [GroceryItem[name=milk, type=DAIRY, count=1], GroceryItem[name=apples, type=PRODUCT, count=6], GroceryItem[name=oranges, type=PRODUCT, count=5]]
    }
}
