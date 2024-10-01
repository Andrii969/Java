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
//            contacts.compute(contactName, (k,v) -> new Contact(k)); // adds new ones or replaces existing ones
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

        System.out.println("-".repeat(30));
        contacts.replaceAll((k,v) -> {
            String newEmail = k.replaceAll(" ", "") + "@funplace.com";
            v.replaceEmailIfExists("DDuck@funplace.com", newEmail);
            return v;
        });
        contacts.forEach((k, v) -> System.out.println("key = " + k + " value = " + v));

        System.out.println("-".repeat(30));
        Contact daisy = new Contact("Daisy Jane Duck", "daisyj@duck.com");
        Contact replacedContact = contacts.replace("Daisy Duck", daisy); // updates if the key matches
        System.out.println("daisy = " + daisy);
        System.out.println("replacedContact = " + replacedContact);
        contacts.forEach((k, v) -> System.out.println("key = " + k + " value = " + v));

        // !!! The replace method has an overloaded version, which lets you specify that
        // you only want to replace the value in the map, if both the keys and values match.

        System.out.println("-".repeat(30));
        Contact updatedDaisy = replacedContact.mergeContactData(daisy);
        System.out.println("updatedDaisy = " + updatedDaisy);
        boolean success = contacts.replace("Daisy Duck", daisy, updatedDaisy); // updates if the key and value match
        if (success) {
            System.out.println("Succesfully replaced element");
        } else {
            System.out.printf("Did not match on both key: %s and value %s %n", "Daisy Duck", updatedDaisy);
        }
        contacts.forEach((k, v) -> System.out.println("key = " + k + " value = " + v));

        System.out.println("-".repeat(30));
        success = contacts.remove("Daisy Duck", daisy);
        if (success) {
            System.out.println("Successfully removed element");
        } else {
            System.out.printf("Did not match on both key: %s and value: %s %n", "Daisy Duck", daisy);
        }
        contacts.forEach((k, v) -> System.out.println("key = " + k + " value = " + v));

        System.out.println("-".repeat(30));
        Contact contactA = contacts.get("Daisy Duck");
        System.out.println(contactA);
    }
}
