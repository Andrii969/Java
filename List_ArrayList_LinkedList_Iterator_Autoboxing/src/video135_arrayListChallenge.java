import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class video135_arrayListChallenge {

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        ArrayList<String> groceries = new ArrayList<>();

        boolean flag = true;
        while (flag) {
            printActions();

            try {
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1 -> addItems(groceries);
                    case 2 -> removeItems(groceries);
                    default -> flag = false;
                }

                groceries.sort(Comparator.naturalOrder());
                System.out.println(groceries);

            } catch (NumberFormatException e) {
                System.out.println("There is no such an option");
            }
        }
    }

    private static void addItems(ArrayList<String> groceries) {
        System.out.println("Add item(s) separated by comma:");
        String[] items = scanner.nextLine().split(",");

        for(String i : items) {
            String trimmed = i.trim();
            if (!groceries.contains(i)) { // groceries.indexOf(i) < 0
                groceries.add(trimmed);
            }
        }
    }

    private static void removeItems(ArrayList<String> groceries) {
        System.out.println("Remove item(s) separated by comma:");
        String[] items = scanner.nextLine().split(",");

        for(String i : items) {
            String trimmed = i.trim();
            if (groceries.contains(trimmed)) { // groceries.indexOf(i) > -1 // this check is optional, and can be removed
                groceries.remove(trimmed);
            }
        }
    }

    private static void printActions() {
        String textBlock = """
                Available actions:

                0 - to shutdown

                1 - to add item(s) to list (comma delimited list)

                2 - to remove any items (comma delimited list)

                Enter a number for which action you want to do:""";

        System.out.println(textBlock + " ");
    }
}
