import java.util.LinkedList;
import java.util.ListIterator;

public class video137_linkedList {

    public static void main(String[] args) {

//        LinkedList<String> placesToVisit = new LinkedList<>();
        var placesToVisit = new LinkedList<String>();
        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra");
        System.out.println(placesToVisit);
        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);
//
//        retrieveElements(placesToVisit);

//        printItinerary(placesToVisit);
//        printItinerary2(placesToVisit);
        printItinerary3(placesToVisit);
    }


    public static void addMoreElements(LinkedList<String> list) {
        list.addFirst("Kyiv"); // add as a first element
        list.offerFirst("Lutsk"); // add as a first element
        list.push("Paris"); // add as a first element
        list.push("Berlin"); // add as a first element


        list.addLast("Lviv"); // add as a last element
        list.offer("Ternopil"); // add as a last element
        list.offerLast("Odessa"); // add as a last element
    }

    public static void removeElements(LinkedList<String> list) {
        list.remove(4);
        list.remove("Odessa");
        list.remove(); // removes first element
        list.poll(); // removes first element
        list.pollFirst(); // removes first element
        list.removeFirst(); // removes first element
        list.removeLast(); // removes last element
    }

    public static void retrieveElements(LinkedList<String> list) {
        System.out.println("Retrieved Element = " + list.get(0));

        System.out.println("Retrieved First Element = " + list.getFirst());
        System.out.println("Retrieved Last Element = " + list.getLast());

        System.out.println("Sydney is at position: " + list.indexOf("Sydney"));
        System.out.println("Lviv is at position: " + list.lastIndexOf("Lviv"));

        System.out.println("Element from element() = " + list.element()); // get first element

        System.out.println("Element from peek() = " + list.peek()); // get first element
        System.out.println("Element from peekFirst() = " + list.peekFirst()); // get first element
        System.out.println("Element from peekLast() = " + list.peekLast()); // get last element
    }

    public static void printItinerary(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        for (int i = 1; i < list.size(); i++) {
            System.out.println("--> From: " + list.get(i - 1) + " to " + list.get(i));
        }
        System.out.println("Trip ends at " + list.getLast());

    }

    public static void printItinerary2(LinkedList<String> list) { // more limited in comparison to traditional for loop
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        for (String town : list) {
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItinerary3(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1); // this creates a ListIterator that starts at the second element in the LinkedList.
        while (iterator.hasNext()) {
            var town = iterator.next();
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }


}
