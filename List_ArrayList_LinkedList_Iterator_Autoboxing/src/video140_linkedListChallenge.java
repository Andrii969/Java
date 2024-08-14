import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class video140_linkedListChallenge {

    record Place(String town, int distanceFromSydney) {
        @Override
        public String toString() {
            return String.format("%s (%d)", town, distanceFromSydney);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        LinkedList<Place> placesToVisit = new LinkedList<>();
        placesToVisit.add(new Place("Brisbane", 500));
        placesToVisit.add(new Place("Adelaide", 1000));
        placesToVisit.add(new Place("Alice Springs", 1100));
        placesToVisit.add(new Place("Perth", 1300));
        Place melbourne = new Place("Melbourne", 1400);
        addPlace(placesToVisit, melbourne);
//        addPlace(placesToVisit, new Place("Melbourne", 1233));// duplicate (isn't added)
        addPlace(placesToVisit, new Place("Lviv", 1232));

        System.out.println(placesToVisit);

        System.out.println("Here is the list of places to visit :" + placesToVisit);
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

    private static void printOptions() {
        System.out.println("""
                Available actions (select letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit
                """);
    }

    public static void addPlace(LinkedList<Place> myList, Place place) {

        // This option just checks the name of the Place type
        if (myList.contains(place)) {
            System.out.println("Found duplicate. There is such a place.");
            return;
        }


        // This option is good (it's working)
//        ListIterator<Place> iterator = myList.listIterator();
//        while (iterator.hasNext()) {
//            if (iterator.next().town().equalsIgnoreCase(place.town())) {
//                System.out.println("Found duplicate. There is such a place.");
//                return;
//            }
//        }
//        myList.add(place);

        // Enhanced version
        for (Place value : myList) {
            if (value.town().equalsIgnoreCase(place.town())) {
                System.out.println("Found duplicate. There is such a place.");
                return;
            }
        }
//        myList.add(place);

        int currentIndex = 0;
        for (var value : myList) {
            if (place.distanceFromSydney() < value.distanceFromSydney) {
                myList.add(currentIndex, place); // adding the place that has less distance than the compared place,
                                                // and adding a new place on the same index (so old place is pushed)
                return;
            }
            currentIndex++;
        }
        myList.add(place);

    }
}
