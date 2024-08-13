import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class video140_linkedListChallenge {

    record Place(String town, int distanceFromSydney) {}
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        LinkedList<Place> placesToVisit = new LinkedList<>();
        placesToVisit.add(new Place("Melbourne", 1374));
        placesToVisit.add(new Place("Brisbane", 917));
        placesToVisit.add(new Place("Adelaide", 1374));
        placesToVisit.add(new Place("Alice Springs", 2771));
        placesToVisit.add(new Place("Perth", 3923));

        System.out.println("Here is the list of places to visit :" + placesToVisit);
//        printOptions();

        ListIterator<Place> iterator = placesToVisit.listIterator();
        boolean notQuit = true;
        while (notQuit) {
            printOptions();
            String input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "f" -> {
                    if (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    } else {
                        System.out.println("You are at the end of the list.");
                    }
                }
                case "b" -> {
                    if (iterator.hasPrevious()) {
                        System.out.println(iterator.previous());
                    } else {
                        System.out.println("You are at the start of the list.");
                    }
                }
                case "l" -> System.out.println(placesToVisit);
                case "m" -> printOptions();
                case "q" -> notQuit = false;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void printOptions() {
        System.out.println("""
                Available actions (select letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit
                """);
    }
}
