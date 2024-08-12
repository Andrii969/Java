import java.util.LinkedList;
import java.util.List;

public class video139_iterators {

    public static void main(String[] args) {

        LinkedList<String> placesToVisit = new LinkedList<>(List.of("Lviv", "Kyiv", "Lutsk", "Ternopil", "Poltava"));
        iterateElements(placesToVisit);

    }


    public static void iterateElements(LinkedList<String> list) {
        var iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            if (iterator.next().equals("Kyiv")) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
