package MapFunctionalityComputeReplaceRemove;

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
//        fullList.forEach(System.out::println);

        // REPEATING PREVIOUS INFORMATION
        Map<String, Contact> contacts = new HashMap<>();
        for (Contact contact : fullList) {
            contacts.put(contact.getName(), contact);
        }
//        contacts.forEach((k, v) -> System.out.println("key = " + k + " value = " + v));

        System.out.println("-".repeat(30) + " Merged");
        contacts.clear();
        for (Contact contact : fullList) {
            Contact duplicate = contacts.put(contact.getName(), contact);
            if (duplicate != null) {
                Contact merged = contact.mergeContactData(duplicate);
                contacts.put(contact.getName(), merged); // alternatively = contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v) -> System.out.println("key = " + k + "; value = " + v));
        // // // // // // // // // // // // // // // //

//        System.out.println("-".repeat(30));
//        for (String contactName : new String[] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}) {
//            contacts.compute(contactName, (k,v) -> new Contact(k)); // replaces existing one
//        }
//        contacts.forEach((k, v) -> System.out.println("key = " + k + "; value = " + v));
        // You can see I've got two new contacts, Daisy Duck and Scrooge McDuck, with no emails or phone numbers.
        // But now look at Daffy Duck, I've also erased his previous information and replaced it with a brand-new contact record.


        System.out.println("-".repeat(30));
        for (String contactName : new String[] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}) {
            contacts.computeIfAbsent(contactName, k -> new Contact(k)); // adds a new contact if not present
        }
        contacts.forEach((k, v) -> System.out.println("key = " + k + " value = " + v));
        // You can see Daisy and Scrooge still have new records, same as before, but Daffy Duck now
        // shows the original information that existed at the start of the video. Because the entry already
        // existed, it did not get overwritten.

        System.out.println("-".repeat(30));
        for (String contactName : new String[] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}) {
            contacts.computeIfPresent(contactName, (k,v) -> {v.addEmail("Fun Place"); return v;}); // adds a new email if contact present
        }
        contacts.forEach((k, v) -> System.out.println("key = " + k + " value = " + v));
        // You can see that all of my duck contacts have a new email added,
        //but my email logic's not very good, since Daisy and Daffy have the same email address.

        
    }
}
