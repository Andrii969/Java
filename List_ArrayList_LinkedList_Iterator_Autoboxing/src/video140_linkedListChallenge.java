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
        boolean forward = true; // Tracks the direction of iteration

        printOptions();

        while (notQuit) {
            System.out.println("Enter value: ");
            String input = scanner.nextLine().toUpperCase().substring(0,1);

            if (!iterator.hasPrevious()) { // If at the beginning of the list
                System.out.println("Originating : " + iterator.next());
                forward = true;
            }
            if (!iterator.hasNext()) { // If at the end of the list
                System.out.println("Final : " + iterator.previous());
                forward = false;
            }

            switch (input) {
                case "F" -> {
                    if (!forward) {            // Reversing Direction from backward to forward
                        forward = true;         // Set direction to forward
                        if (iterator.hasNext()) {
                            iterator.next();  // Adjust position forward to avoid repetition
                        }
                    }
                    if (iterator.hasNext()) {
                        System.out.println(iterator.next()); // Move forward and print the place
                    }
                }
                case "B" -> {
                    if (forward) {           // Reversing Direction from forward to backward
                        forward = false;        // Set direction to backward
                        if (iterator.hasPrevious()) {
                            iterator.previous();  // Adjust position backward to avoid repetition
                        }
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println(iterator.previous()); // Move backward and print the place
                    }
                }
                case "L" -> System.out.println(placesToVisit);
                case "M" -> printOptions();
                case "Q" -> {
                    notQuit = false;
                    break;
                }
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
