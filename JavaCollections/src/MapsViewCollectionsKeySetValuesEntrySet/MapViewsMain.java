package MapsViewCollectionsKeySetValuesEntrySet;

import java.util.*;

public class MapViewsMain {

    public static void main(String[] args) {

        Map<String, Contact> contacts = new HashMap<>();
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));

        Set<String> keysView = contacts.keySet();
        // The Set returned from the keySet method, is backed by the Map.
        // This means changes to the Map are reflected in the Set, and vice-versa.
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
        // this removed the key and value pair in the map as well, so Daffy Duck isn't printed below
        contacts.forEach((k,v) -> System.out.println(v));

        System.out.println("-".repeat(30));
        copyOfKeys.remove("Linus Van Pelt");
        System.out.println(copyOfKeys); // Linus is removed from copyOfKeys.
        contacts.forEach((k,v) -> System.out.println(v));
        // Since this is a copy though, it had no effect on the original map, so Linus is still in that map.

        System.out.println("-".repeat(30));
        keysView.retainAll(List.of("Linus Van Pelt", "Charlie Brown", "Robin Hood", "Mickey Mouse"));
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println(v));
        // And I've got four names in my key set, and 4 contacts in my map.

        System.out.println("-".repeat(30));
        keysView.clear();
        System.out.println(contacts);

        System.out.println("-".repeat(30));
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));
        System.out.println(keysView);
        // I didn't have to execute the keySet method again to get the refreshed data. My view was refreshed automatically.

        System.out.println("-".repeat(30));
        var values = contacts.values();
        values.forEach(System.out::println);

        System.out.println("-".repeat(30));
        values.retainAll(ContactData.getData("email"));
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println(v));

        System.out.println("-".repeat(30));
        HashSet<Contact> set = new HashSet<>(values);
        set.forEach(System.out::println);

        System.out.println("-".repeat(30));
        var nodeSet = contacts.entrySet();
        for (var node : nodeSet) {
            System.out.println(node.getKey() + " : " + node.getValue().getName());
        }




    }
}
