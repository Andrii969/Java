import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class video139_iterators {

    public static void main(String[] args) {

        LinkedList<String> placesToVisit = new LinkedList<>(List.of("Lviv", "Kyiv", "Lutsk", "Ternopil", "Poltava"));
        iterateElements2(placesToVisit);

    }


    public static void iterateElements(LinkedList<String> list) {
        var iterator = list.iterator(); // iterator() is a method available in the Collection interface, which List and its implementing classes (like LinkedList) inherit
        // list can't be modified
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
            if (iterator.next().equals("Kyiv")) {
                iterator.remove(); // for iterator only remove method is supported
                // when list.remove(); -> returned ConcurrentModificationException
            }
        }
        System.out.println(list);
    }

    public static void iterateElements2(LinkedList<String> list) {
        ListIterator<String> iterator = list.listIterator(); // iterator() is a method available in the Collection interface, which List and its implementing classes (like LinkedList) inherit
        // list can't be modified
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
            if (iterator.next().equals("Kyiv")) {
                iterator.add("Lake Wivenhoe"); // adding element after Kyiv
            }
        }
        while(iterator.hasNext()) { // no output as the cursor is at the end
            System.out.println(iterator.next());
        }
        while(iterator.hasPrevious()) { // printed places from the last to the first
            System.out.println(iterator.previous());
        }

        System.out.println(list);

        var iterator2 = list.listIterator(3);
//        System.out.println(iterator2.next()); // printed element at index 3
        System.out.println(iterator2.previous()); // printed element at index 2

    }
}
