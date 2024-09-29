package MapInterfaceAndFunctionality;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        List<Contact> fullList = new ArrayList<>();
        fullList.addAll(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        // I get a list with duplicate records, one for each phone number and email record, each individual record in other words.

        Map<String, Contact> contacts = new HashMap<>();

        System.out.println("-".repeat(30) + " Put replaces with the last copy");
        for (Contact contact : fullList) {
            contacts.put(contact.getName(), contact);
        }
        //  If the key is in the map, the value is replaced and the previous value is returned from the put method (the last one duplicate is saved)
        contacts.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));

        System.out.println("-".repeat(30));
        System.out.println(contacts.get("Mickey Mouse")); // I can simply use the key value to look up my contact.

        Contact defaultContact = new Contact("Chuck Brown");
        System.out.println(contacts.getOrDefault("Chuck Brown", defaultContact));

        System.out.println("-".repeat(30));
        contacts.clear();
        for (Contact contact : fullList) {
            Contact duplicate = contacts.put(contact.getName(), contact);
            if (duplicate != null) {
                System.out.println("duplicate = " + duplicate);
                System.out.println("current = " + contact);
            }
        }
        // If there is already a contact with the name "John Doe" in the map,
        //      the existing contact is replaced by the new one (contact), and the old contact is assigned to the duplicate variable.
        // If there is no contact with the name "John Doe" in the map,
        //      the put() method inserts the new contact into the map and assigns null to the duplicate variable (since there was nothing to replace).

        System.out.println("<".repeat(30) + " Merged");
        contacts.clear();
        for (Contact contact : fullList) {
            Contact duplicate = contacts.put(contact.getName(), contact);
            if (duplicate != null) {
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
            // If a duplicate is found, this line calls the mergeContactData method to combine the information from the current contact and the duplicate (the old contact that was in the map).
            //The mergeContactData method merges the emails and phone numbers of the two contacts and creates a new Contact object with the combined data.
            //The merged contact is then placed back into the map under the same name (contact.getName()), replacing the original entry with the merged information.
        }
        contacts.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));

        System.out.println("-".repeat(30) + " putIfAbsent doesn't replace with the copy");
        contacts.clear();
        for (Contact contact : fullList) {
            contacts.putIfAbsent(contact.getName(), contact);
        }
        // The putIfAbsent method won't put an updated value in the map, it just ignores the element, if it already finds something in the map for the key.
        contacts.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));

        System.out.println("<".repeat(30) + " Merged");
        contacts.clear();
        for (Contact contact : fullList) {
            Contact duplicate = contacts.putIfAbsent(contact.getName(), contact);
            if (duplicate != null) {
                contacts.put(contact.getName(), contact.mergeContactData(duplicate)); // putting the merged contact to the contacts
            }
        }
        contacts.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));

        System.out.println("-".repeat(30));
        contacts.clear();
        fullList.forEach(contact -> contacts.merge(
                contact.getName(),       // Key (the contact's name)
                contact,                 // Value (the current contact)
                (previous, current) -> { // BiFunction to merge two contacts if a duplicate is found
                    System.out.println("prev: " + previous + " ; current: " + current);
                    Contact merged = previous.mergeContactData(current);
                    System.out.println("merged: " + merged);
                    return merged;       // Return the merged contact to be stored in the map
                }
        ));
        System.out.println("Results:");
        contacts.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));

        // another (simplified) version for the above
        System.out.println("-".repeat(30));
        contacts.clear();
        fullList.forEach(contact -> contacts.merge(
                contact.getName(),       // Key (the contact's name)
                contact,                 // Value (the current contact)
                Contact::mergeContactData // (previous, current) -> previous.mergeContactData(current)
        ));
        System.out.println("Results:");
        contacts.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));


    }
}
