package MapsViewCollectionsKeySetValuesEntrySet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapViewsMain {

    public static void main(String[] args) {

        Map<String, Contact> contacts = new HashMap<>();
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));

        Set<String> keysView = contacts.keySet();
        System.out.println(keysView);

        Set<String> copyOfKeys = new TreeSet<>(contacts.keySet());
        System.out.println(copyOfKeys); // keys are now in alphabetical order

        if (contacts.containsKey("Linus Van Pelt")) {
// that's a lot easier than previous attempts I made, where I created a contact instance with a matching name, to try to find a match.
            System.out.println("Linus Van Pelt is present");
        }

        System.out.println("-".repeat(30));
        keysView.remove("Daffy Duck");
        // I can use this key Set view, to remove elements from the map (call the remove method on the keysView)
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println(v));

    }
}
